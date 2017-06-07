package DAO;

import Connector.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import System.Customer;

/**
 * Created by Bernardo on 07/06/2017.
 */
public class CustomerDAO {

    public void create(Customer c){

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;

        try {
            ppst = conn.prepareCall("INSERT INTO customer (name, id, phone) VALUES (?, ?, ?)");
            ppst.setString(1, c.getName());
            ppst.setString(2, c.getId());
            ppst.setString(3, c.getPhone());

            ppst.executeUpdate();

            System.out.println("Created successfully.");
        } catch (SQLException e) {
            throw new RuntimeException("Creation error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst);
        }
    }
}
