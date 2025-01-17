package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SSM01
 */
public class ProcesosDB {

    //connection connect
    Statement DataRequest;
    ResultSet Results;
    Connection conect = null;

//------------------------------------Conexion a la base de datos-------------------------------------------------------------------
    public Connection Conectar(int base) {
        String url = "";
        String user = "";
        String password = "";
        String driver = "";

        switch (base) {
            case 1://REGLECHUE
                url = "jdbc:mysql://101.86.100.241:3306/reglechue";
                user = "huella";
                password = "huella1";
                //driver = "com.mysql.jdbc.Driver";
                break;

            case 2://PLANTILLA
                url = "jdbc:sqlserver://101.86.100.246;databaseName=plantilla;encrypt = false;";
                user = "plan_usu";
                password = "planti";
                driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                break;
            case 3: //platilla local
                url = "jdbc:sqlserver://localhost:1433;databaseName=plantilla;encrypt=false";
                user = "sa";
                password = "@Dmin1";
                driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                break;
        }
        try {
            Class.forName(driver);
            conect = DriverManager.getConnection(url, user, password);

            if (conect != null) {
                //System.out.println("Conexión a base de datos ["+url+"] listo...");
            } else if (conect == null) {
                throw new SQLException();
            }
        } catch (ClassNotFoundException error) {
            System.err.println("No se puede cargar el puente JDBC/ODBC Conectar 1" + error);
            System.exit(1);
        } catch (SQLException error) {
            System.err.println("No se puede conectar con la base de conectar 2 " + error);
            System.exit(2);
        } finally {
            return conect;
        }
    }

//------------------------------------------Desconexion de la DB---------------------------------------------------------------------
    public void Desconectar() throws SQLException {
        conect.close();
        //System.out.println("Desconexion a base de datos listo...");
    }

    //---------------------------------------Consultas a la DB -------------------------------------------------------------------------
    public ResultSet Consultar(String sql) throws SQLException {
        DataRequest = conect.createStatement();
        Results = DataRequest.executeQuery(sql);

        return Results;
    }

    public int Cuantos(String sql) throws SQLException {
        int num = 0;
        DataRequest = conect.createStatement();
        Results = DataRequest.executeQuery(sql);
        while (Results.next()) {
            num++;
        }

        return num;
    }

}
