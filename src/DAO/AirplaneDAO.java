package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connector.DBConnect;

/**
 * Created by Bernardo on 07/06/2017.
 */
public class AirplaneDAO {

    //private Connection connection;
    //private PreparedStatement command;

    public Connection connect (String sql) throws SQLException {
        Connection connection = DBConnect.connectToDB();
        connection.prepareStatement(sql);
        return connection;
    }

    public void registerPlane(){
        try {
            String sqlCommand = "INSERT INTO AIRPLANE(code, planeName, qntSeats) VALUES (?, ?, ?)";
            connect(sqlCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
