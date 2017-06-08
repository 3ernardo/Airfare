package Connector;

import java.sql.*;

/**
 * Created by Bernardo on 07/06/2017.
 */

public class ConnectionFactory {
// ==================== ConnectionFactory ====================
// Esta classe cria conexao com o BD e fornece os metodos necessarios
// para que as classes do pacote DAO acessem ao BD.

    private static String driver = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://localhost:5432/AirfareDB";
    private static String user = "postgres";
    private static String pass = "123456";

    public static Connection getConnection() {
    //  Esse metodo é encarregado de criar a conexao com o BD.
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Connection error: ", e);
        }
    }

    //  O metodo a seguir usa o criterio de sobrecarga, cada versao recebe parametros diferentes.
    //  Ele é encarredado de fechar a conexao com o BD.
    public static void closeConnection (Connection c) {
    //  versao 1.
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection (Connection c, PreparedStatement ps) {
    //  versao 2.
        closeConnection(c);
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection (Connection c, PreparedStatement ps, ResultSet rs) {
    //  versao 3.
        closeConnection(c, ps);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}