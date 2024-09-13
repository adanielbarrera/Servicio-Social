/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Exceptions.FotoException;
import Exceptions.HuellaException;
import com.digitalpersona.onetouch.DPFPGlobal;
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
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
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
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        } finally {
            cerrarRecursos(rs, pstmt, conn);
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
    }

    public void guardarBiometricos(byte[] foto) throws HuellaException, FotoException {
        if (foto != null) {
            if (huellasMap.size() >= 5) {
                Personal personal = Personal.getInstance();
                int id = personal.getId();

                String sql = "insert datosBiometricos values( "
                        + "?,"
                        + "?, "
                        + "?, "
                        + "?, "
                        + "?, "
                        + "?,"
                        + "?, "
                        + "null,"
                        + "null"
                        + ")";
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
                    System.out.println("ejecutado" + filasActualizadas);

                    if (filasActualizadas > 0) {
                        System.out.println("Huellas y foto guardadas correctamente para el RFC: " + personal.getrFC());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    //llimpiar el map despues de guardar
                    huellasMap.clear();
                    personal.setFoto(null);
                    cerrarRecursos(rs, pstmt, conn);
                }

            } else {
                throw new HuellaException("No se han leido todas las huellas");
            }
        } else {
            throw new FotoException("Falta registrar la foto");
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
        } finally {
            cerrarRecursos(rs, pstmt, conn);
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
        } finally {
            cerrarRecursos(rs, pstmt, conn);
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
            } finally {
                cerrarRecursos(rs, pstmt, conn);
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
            } finally {
                cerrarRecursos(rs, pstmt, conn);
            }

        }
    }

    public void getBiometria(Personal personal) {
        String sql = "SELECT db_huella1,db_huella2,db_huella3,db_huella4,db_huella5,db_foto "
                + "FROM datosBiometricos "
                + "INNER JOIN datosPersonal on datosPersonal.dpe_id = datosBiometricos.dpe_id "
                + "WHERE dpe_rfc = ?";

        try {
            conn = conexion.Conectar(3);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, personal.getrFC());

            rs = pstmt.executeQuery();

            if (rs.next()) {
                personal.setHuella1(rs.getBytes("db_huella1"));
                personal.setHuella2(rs.getBytes("db_huella2"));
                personal.setHuella3(rs.getBytes("db_huella3"));
                personal.setHuella4(rs.getBytes("db_huella4"));
                personal.setHuella5(rs.getBytes("db_huella5"));

                byte[] fotoBytes = rs.getBytes("db_foto");

                if (fotoBytes != null) {
                    Camara camara = new Camara();
                    BufferedImage foto = camara.convertirBytesABufferedImage(fotoBytes);
                    personal.setFoto(foto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(rs, pstmt, conn);
        }
    }

    public void reemplazarHuellas(Personal personal) throws HuellaException {

        if (huellasMap.size() >= 5) {
            String sql = "UPDATE datosBiometricos "
                    + "SET db_huella1 = ?,"
                    + "db_huella2 = ?,"
                    + "db_huella3 = ?,"
                    + "db_huella4 = ?,"
                    + "db_huella5 = ? "
                    + "WHERE dpe_id = ?";
            try {
                conn = conexion.Conectar(3);
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(6, personal.getId());
                pstmt.setBytes(1, huellasMap.get("pulgar derecho").serialize());
                pstmt.setBytes(2, huellasMap.get("indice derecho").serialize());
                pstmt.setBytes(3, huellasMap.get("medio").serialize());
                pstmt.setBytes(4, huellasMap.get("pulgar izquierdo").serialize());
                pstmt.setBytes(5, huellasMap.get("indice izquierdo").serialize());

                int filasActualizadas = pstmt.executeUpdate();
                if (filasActualizadas > 0) {
                    System.out.println(filasActualizadas + "remplazadas con exito para el personal: " + personal.getId());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                cerrarRecursos(rs, pstmt, conn);
            }
        } else {
            throw new HuellaException("No se han leido todas las huellas");
        }

    }

    public Map<Integer, DPFPTemplate> obtenerTodasLasPlatillas() {
        String sql = "select dpe_id, db_huella1,db_huella2,db_huella3,db_huella4,db_huella5 "
                + "from datosBiometricos";
        Map<Integer, DPFPTemplate> plantillas = new HashMap<>();
        try {
            conn = conexion.Conectar(3);
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("dpe_id");
                // Obtener las huellas como arrays de bytes
                byte[] huella1 = rs.getBytes("db_huella1");
                byte[] huella2 = rs.getBytes("db_huella2");
                byte[] huella3 = rs.getBytes("db_huella3");
                byte[] huella4 = rs.getBytes("db_huella4");
                byte[] huella5 = rs.getBytes("db_huella5");

                // Convertir los arrays de bytes a DPFPTemplate y agregar a la lista
                if (huella1 != null) {
                    DPFPTemplate template1 = DPFPGlobal.getTemplateFactory().createTemplate(huella1);
                    plantillas.put(id, template1);
                }
                if (huella2 != null) {
                    DPFPTemplate template2 = DPFPGlobal.getTemplateFactory().createTemplate(huella2);
                    plantillas.put(id, template2);
                }
                if (huella3 != null) {
                    DPFPTemplate template3 = DPFPGlobal.getTemplateFactory().createTemplate(huella3);
                    plantillas.put(id, template3);
                }
                if (huella4 != null) {
                    DPFPTemplate template4 = DPFPGlobal.getTemplateFactory().createTemplate(huella4);
                    plantillas.put(id, template4);
                }
                if (huella5 != null) {
                    DPFPTemplate template5 = DPFPGlobal.getTemplateFactory().createTemplate(huella5);
                    plantillas.put(id, template5);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(rs, pstmt, conn);
        }
        return plantillas;
    }

    public Personal getPersonalByID(int id) {
        String sql = "SELECT * "
                + "FROM datosPersonal "
                + "WHERE dpe_id = ?";
        Personal personal = null;

        try {
            conn = conexion.Conectar(3);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();
            if (rs.next()) {

                personal = Personal.getInstance();
                personal.setNombre(rs.getString("dpe_nombre"));
                personal.setApePaterno(rs.getString("dpe_appat"));
                personal.setApeMaterno(rs.getString("dpe_apmat"));
                personal.setrFC(rs.getString("dpe_rfc"));
                personal.setcURP(rs.getString("dpe_curp"));
                personal.setPuesto(rs.getString("dpe_puesto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(rs, pstmt, conn);
        }
        return personal;
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
}
