package DAO;

import Connector.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    } // Closes create customer

    public List<Customer> read() {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        ResultSet rest = null;
        List<Customer> customers = new ArrayList<>();

        try {
            ppst = conn.prepareStatement("SELECT * FROM customer");
            rest = ppst.executeQuery();

            while (rest.next()) {
                Customer c = new Customer(
                    rest.getInt("customer_id"),
                    rest.getString("name"),
                    rest.getString("id"),
                    rest.getString("phone")
                );

                customers.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst, rest);
        }
        return customers;
    } // Closes read customer

    public Customer findByName(String n) {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        ResultSet rest = null;
        Customer c = null;

        try {
            ppst = conn.prepareStatement("SELECT * FROM customer WHERE name = ?");
            ppst.setString(1, n);
            rest = ppst.executeQuery();

            rest.next();
            c = new Customer(
                    rest.getInt("customer_id"),
                    rest.getString("name"),
                    rest.getString("id"),
                    rest.getString("phone")
            );

        } catch (SQLException e) {
            throw new RuntimeException("Query error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst, rest);
        }
        return c;
    } // Closes find customer

    public void update(Customer c){

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;

        try {
            ppst = conn.prepareCall("UPDATE customer SET  name = ?, id = ?, phone = ? WHERE customer_id = ?");
            ppst.setString(1, c.getName());
            ppst.setString(2, c.getId());
            ppst.setString(3, c.getPhone());
            ppst.setInt(4, c.getCustomerID());

            ppst.executeUpdate();

            System.out.println("Updated successfully.");
        } catch (SQLException e) {
            throw new RuntimeException("Update error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst);
        }
    } // Closes update customer

    public void delete(Customer c){

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;

        try {
            ppst = conn.prepareCall("DELETE FROM customer WHERE customer_id = ?");
            ppst.setInt(1, c.getCustomerID());

            ppst.executeUpdate();

            System.out.println("Successfully deleted.");
        } catch (SQLException e) {
            throw new RuntimeException("Delete error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst);
        }
    } // Closes delete customer
}
