package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/AirLink?useSSL=false&serverTimezone=America/Santiago";
    private static final String USER = "root";  // tu usuario MySQL
    private static final String PASSWORD = "root";  // tu contraseña MySQL

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos Airlink.");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: no se encontró el driver JDBC de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}
