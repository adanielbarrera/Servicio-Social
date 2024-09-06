/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.digitalpersona.onetouch.DPFPTemplate;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import controllers.Camara;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Personal;
import models.ProcesosDB;
import views.Guardado;

/**
 *
 * @author SSM01
 */
public class PersonalDAO {

    ProcesosDB conexion = new ProcesosDB();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    private static Map<String, DPFPTemplate> huellasMap = new HashMap<>();

    public Personal getPersonalByNombreCompleto(String nombreCompleto) throws IOException {
        Personal personal = null;
        String sql = "SELECT dpe_nombre,dpe_appat, dpe_apmat, dpe_rfc,dpe_curp, cpf_puesto, dpe_foto,dp.dpe_idpers  \n"
                + "FROM datosPersonal dp \n"
                + "INNER JOIN datosLaboral dl  ON dl.dpe_idpers = dp.dpe_idpers \n"
                + "INNER JOIN c_puestoFun cpf ON dl.cpf_idpuestofu = cpf.cpf_idpuestfu \n"
                + "WHERE CONCAT(dpe_nombre, ' ', dpe_appat, ' ', dpe_apmat) = ?";
        try {
            conn = conexion.Conectar(2);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombreCompleto);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                personal = Personal.getInstance();
                personal.setNombre(rs.getString("dpe_nombre"));
                personal.setApePaterno(rs.getString("dpe_appat"));
                personal.setApeMaterno(rs.getString("dpe_apmat"));
                personal.setrFC(rs.getString("dpe_rfc"));
                personal.setcURP(rs.getString("dpe_curp"));
                personal.setPuesto(rs.getString("cpf_puesto"));
                personal.setId(rs.getInt("dpe_idpers"));

                byte[] fotoBytes = rs.getBytes("dpe_foto");

                if (fotoBytes != null) {
                    Camara camara = new Camara();
                    BufferedImage foto = camara.convertirBytesABufferedImage(fotoBytes);
                    personal.setFoto(foto);
                } else {
                    BufferedImage foto = ImageIO.read(getClass().getResource("/resources/icon/defaultPhoto.jpg"));
                    personal.setFoto(foto);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return personal;
    }

    public List<String> buscarApellidos(String apellidoBuscado, JTable table) {
        List<String> nombresCompletos = new ArrayList<>();
        String apellidoBuscadoLower = apellidoBuscado.toLowerCase();

//obetener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        //iterar sobre la tabla
        for (int row = 0; row < model.getRowCount(); row++) {
            String nombre = (String) model.getValueAt(row, 0);
            String apellidoPaterno = (String) model.getValueAt(row, 1);
            String apellidoMaterno = (String) model.getValueAt(row, 2);

            //comparar con el apellido buscado
            if (apellidoPaterno != null && apellidoPaterno.toLowerCase().contains(apellidoBuscadoLower)) {
                String nombreCompleto = nombre + " " + apellidoPaterno + " " + apellidoMaterno;
                nombresCompletos.add(nombreCompleto);
            }

        }
        return nombresCompletos;
    }

    public void agregarHuella(String dedo, DPFPTemplate template) {
        huellasMap.put(dedo, template);
        System.out.println("guardado en map");
        System.out.println(huellasMap.size());
    }



    public void guardarBiometricos(byte[] foto) {
        if (huellasMap.size()>=5) {
            System.out.println("guardando");
            Personal personal = Personal.getInstance();
            int id = personal.getId();

            String sql = "insert datosBiometricos values( "
                    +"default,"
                    + "?"
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?,"
                    + "? "
                    + "null"
                    + "null";
            try {
                conn = conexion.Conectar(3);
                pstmt = conn.prepareStatement(sql);
                pstmt.setBytes(2, huellasMap.get("pulgar derecho").serialize());
                pstmt.setBytes(3, huellasMap.get("indice derecho").serialize());
                pstmt.setBytes(4, huellasMap.get("medio").serialize());
                pstmt.setBytes(5, huellasMap.get("pulgar izquierdo").serialize());
                pstmt.setBytes(6, huellasMap.get("indice izquierdo").serialize());
                pstmt.setBytes(7, foto);
                pstmt.setInt(1, id);

                int filasActualizadas = pstmt.executeUpdate();
                System.out.println("ejecutado" +filasActualizadas);
                if (filasActualizadas > 0) {
                    System.out.println("Huellas y foto guardadas correctamente para el RFC: " + personal.getrFC());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                //llimpiar el map despues de guardar
                huellasMap.clear();
            }
        } else {
            System.out.println("Aun no se han capturado todas las huellas");
        }
    }

    public void guardarFoto(byte[] imagen) {
        Personal personal = Personal.getInstance();
        String rFC = personal.getrFC();

        String sql = "UPDATE datosPersonal "
                + "SET dpe_foto = ?"
                + "WHERE dpe_rfc = ?";
        try {
            conn = conexion.Conectar(2);
            pstmt = conn.prepareStatement(sql);
            pstmt.setBytes(1, imagen);
            pstmt.setString(2, rFC);
            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                Guardado guardado = new Guardado();
                guardado.setVisible(true);
                System.out.println("foto guardada para: " + rFC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean tieneRegistro(String rfc) {
        String sql = "select *  "
                + "from datosPersonal "
                + "where dpe_rfc = ?";

        try {
            conn = conexion.Conectar(3);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, rfc);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("El personal ya esta registrado");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL: ");
            e.printStackTrace();
        }
        return false;
    }

    public boolean tieneBiometria(String rfc) {
        String sql = "select *"
                + "from datosBiometricos "
                + "inner join datosPersonal on datosPersonal.dpe_id = datosBiometricos.dpe_id "
                + "where dpe_rfc= ?";

        if (tieneRegistro(rfc)) {
            try {
                conn = conexion.Conectar(3);
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, rfc);

                rs = pstmt.executeQuery();
                if (rs.next()) {
                    return true;
                }
            } catch (SQLException e) {
                System.err.println("Error de SQl");
                e.printStackTrace();
            }
        }
        return false;
    }

    public void registrarPersonal(Personal personal) {
        String rfc = personal.getrFC();
        String sql = "Insert into datosPersonal values("
                + "?,?,?,?,?,?,?)";
        if (!tieneRegistro(rfc)) {
            try {
                conn = conexion.Conectar(3);
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, personal.getNombre());
                pstmt.setString(2, personal.getApePaterno());
                pstmt.setString(3, personal.getApeMaterno());
                pstmt.setString(4, personal.getrFC());
                pstmt.setString(5, personal.getcURP());
                pstmt.setString(6, personal.getPuesto());
                pstmt.setInt(7, personal.getId());

                int filasActualizadas = pstmt.executeUpdate();

                if (filasActualizadas > 0) {
                    System.out.println("Personal registrado con exito");
                }
            } catch (SQLException e) {
                System.err.println("Error registrando personal");
                e.printStackTrace();
            }

        }
    }

    public void getBiometria(Personal personal) {
        String sql = "SELECT db_huella1,db_huella2,db_huella3,db_huella4,db_huella5"
                + "FROM datosBiometricos"
                + "INNER JOIN datosPersonal on datosPersonal.dpe_id = datosBiometricos.dpe_id"
                + "WHERE RFC = ?";
        
        try{
            conn =conexion.Conectar(3);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, personal.getrFC());
            
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                personal.setHuella1(rs.getBytes("db_huellas1"));
                personal.setHuella2(rs.getBytes("db_huellas2"));
                personal.setHuella3(rs.getBytes("db_huellas3"));
                personal.setHuella4(rs.getBytes("db_huellas4"));
                personal.setHuella5(rs.getBytes("db_huellas5"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<DPFPTemplate> obtenerTodasLasPlatillas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
