package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Bernardo on 06/06/2017.
 */

public class DBConnect {

    private static String url = "jdbc:postgresql://localhost:5432/AirfareDB";
    private static String user = "postgres";
    private static String pass = "123456";

    public static Connection connectToDB() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);

            if(connection == null) System.out.println("Failed to connect to database.");
            else System.out.println("Database connection successful.");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}