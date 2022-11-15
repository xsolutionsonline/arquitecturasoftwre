
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String HOST = "localhost";
    private static final String PUERTO = "3306";
    private static final String DB = "crudPersona";
    
    private static final String user = "root";
    private static final String password = "diego1291";
    
    private static String url;
    
    private static Connection conexion = null;
    
    public static Connection getConexion(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://"+HOST+":"+PUERTO+"/"+DB;
            conexion = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return conexion;
    }
    
    public static void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
