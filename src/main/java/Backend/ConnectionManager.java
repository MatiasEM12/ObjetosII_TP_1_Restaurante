package Backend;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL_DB = "jdbc:mysql://localhost:3306/";
    protected static String DB = "Objetos_II_Restaurante";
    protected static String user = "root";
    protected static String pass = "";
    protected static Connection conn = null;

    public static void connect() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL_DB + DB + "?useSSL=false&serverTimezone=UTC", user, pass);
        } catch (SQLException sqlEx) {
            System.out.println("No se ha podido conectar a " + URL_DB + DB + ". " + sqlEx.getMessage());
            System.out.println("Error al cargar el driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado: " + e.getMessage());
        }
    }

    public static void disconnect() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void reconnect() {
        disconnect();
        connect();
    }

    public static Connection getConnection() {
        if (conn == null) {
            connect();
        }
        return conn;
    }

}