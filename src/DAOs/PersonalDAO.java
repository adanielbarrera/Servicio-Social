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
    private Map<String, DPFPTemplate> huellasMap = new HashMap<>();

    public Personal getPersonalByNombreCompleto(String nombreCompleto) throws IOException {
        Personal personal = null;
        String sql = "SELECT dpe_nombre,dpe_appat, dpe_apmat, dpe_rfc,dpe_curp, cpf_puesto, dpe_foto  \n"
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
        UserDAO userDAO = new UserDAO();
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
        System.out.println("Apellido buuscado: " + apellidoBuscado);
        return nombresCompletos;
    }

    public void agregarHuella(String dedo, DPFPTemplate template) {
        huellasMap.put(dedo, template);
    }

    public boolean estanTodasLasHuellas() {
        //verificar si ya estan todas las huellas necesarias
        return huellasMap.size() == 5;
    }

    public void guardarBiometricos(byte[] foto) {
        if (estanTodasLasHuellas()) {
            Personal personal = Personal.getInstance();
            String rFC = personal.getrFC();

            String sql = "UPDATE biometria SET "
                    + "b_huella1 = ?, "
                    + "b_huella2 = ?, "
                    + "b_huella3 = ?, "
                    + "b_huella4 = ?, "
                    + "b_huella5 = ?,"
                    + "b_foto = ? "
                    + "WHERE p_b_id = ?";
            try {
                conn = conexion.Conectar(2);
                pstmt = conn.prepareStatement(sql);
                pstmt.setBytes(1, huellasMap.get("pulgar derecho").serialize());
                pstmt.setBytes(2, huellasMap.get("indice derecho").serialize());
                pstmt.setBytes(3, huellasMap.get("medio derecho").serialize());
                pstmt.setBytes(4, huellasMap.get("pulgar izquierdo").serialize());
                pstmt.setBytes(5, huellasMap.get("inidce izquierdo").serialize());
                pstmt.setBytes(6, foto);
                pstmt.setString(7, rFC);

                int filasActualizadas = pstmt.executeUpdate();
                if (filasActualizadas > 0) {
                    System.out.println("Huellas y foto guardadas correctamente para el RFC: " + rFC);
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

    private String obtenerColumnaPorDedo(String dedo) {
        switch (dedo) {
            case "pulgar derecho":
                return "";
            case "indice derecho":
                return "";
            case "medio":
                return "";
            case "pulgar izquierdo":
                return "";
            case "indice izquierdo":
                return "";
            default:
                throw new IllegalArgumentException("Dedo no reconocido: " + dedo);
        }
    }

    public List<DPFPTemplate> obtenerTodasLasPlatillas() {
        return null;
    }
}
