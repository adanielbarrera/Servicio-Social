/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.digitalpersona.onetouch.DPFPTemplate;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import controllers.Camara;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.ProcesosDB;
import models.Usuario;

/**
 *
 * @author SSM01
 */
public class UserDAO {

    ProcesosDB conexion = new ProcesosDB();
    boolean esValido = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public boolean validarCredenciales(String user, String password) {

        try {
            conn = conexion.Conectar(2);
            String sql = "Select * FROM usuario_apli WHERE uap_usuario=?  AND uap_contrase = ?;";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                esValido = true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(rs, pstmt, conn);
        }

        return esValido;
    }

    private void cerrarRecursos(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            conexion.Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario buscarUsuario(String user) {
        String sql = "select dpe_nombre,dpe_appat, dpe_apmat, cpf_puesto, dpe_foto, dl.deleg_clv, deleg_nombre from usuario_apli ua \n"
                + "inner join datosLaboral dl on ua.dla_iddatlab = dl.dla_iddatlab \n"
                + "inner join datosPersonal dp on dl.dpe_idpers = dp.dpe_idpers\n"
                + "inner join c_puestoFun cpf on dl.cpf_idpuestofu = cpf.cpf_idpuestfu\n"
                + "inner join c_delegacion cd on dl.deleg_clv = cd.deleg_clv\n"
                + "WHERE uap_usuario = ?";
        Usuario usuarioinfo = null;
        try {
            conn = conexion.Conectar(2);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user);
            rs = pstmt.executeQuery();

            if (rs.next()) {

                String nombre = rs.getString("dpe_nombre") + " " + rs.getString("dpe_appat") + " " + rs.getString("dpe_apmat");
                String puesto = rs.getString("cpf_puesto");
                String lugarTrabajo = rs.getString("deleg_nombre");
                int deleg_clv = rs.getInt("deleg_clv");
                BufferedImage fotoUser;

                byte[] fotoBytes = rs.getBytes("dpe_foto");
                usuarioinfo = Usuario.getInstance(nombre, puesto, lugarTrabajo, deleg_clv);
                if (fotoBytes != null) {
                    Camara camara = new Camara();
                    fotoUser = camara.convertirBytesABufferedImage(fotoBytes);
                    usuarioinfo.setFoto(fotoUser);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(rs, pstmt, conn);
        }
        return usuarioinfo;
    }

    public JTable tablaPersonalPorDelegacion(int deleg_clv) {

        String sql = "SELECT dpe_nombre,dpe_appat, dpe_apmat, dpe_rfc,dpe_curp, cpf_puesto, deleg_nombre\n"
                + "                FROM datosPersonal dp\n"
                + "                INNER JOIN datosLaboral dl  ON dl.dpe_idpers = dp.dpe_idpers\n"
                + "                INNER JOIN c_puestoFun cpf ON dl.cpf_idpuestofu = cpf.cpf_idpuestfu\n"
                + "                iNNER JOIN c_delegacion cd on dl.deleg_clv  = cd.deleg_clv \n"
                + "                WHERE dl.deleg_clv = ?";

        JTable table = new JTable();
        try {
            conn = conexion.Conectar(2);
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, deleg_clv);
            rs = pstmt.executeQuery();

            //obtener los metadatos del result set
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();

            //crear el defaultTableModel
            DefaultTableModel model = new DefaultTableModel();

            //agredgar las columnas al modelo
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metadata.getColumnName(i));
            }

            //agregar las filas al modelo
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }
            System.out.println("Tabla creada");

            table.setModel(model);
        } catch (SQLException e) {
            System.err.println("Error buscando personal: ");
            e.printStackTrace();
        } finally {
            cerrarRecursos(rs, pstmt, conn);
        }
        return table;
    }

}
