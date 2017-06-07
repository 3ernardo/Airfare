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

    private String url = "jdbc:postgresql://localhost:5432/lp2_banco";
    private String user = "postgres";
    private String pass = "123456";

    public Connection connectToDB() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection(url, user, pass);

            if(conexao == null) System.out.println("Failed to connect to database.");
            else System.out.println("Database connection successful.");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}