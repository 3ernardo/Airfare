package DAO;

import Connector.ConnectionFactory;
import System.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by Bernardo on 07/06/2017.
 */
public class CustomerDAO {

    // ||||||||||||||||||||||||||||||||  CRUD  ||||||||||||||||||||||||||||||||

    // ================================ CREATE ================================
    public void create(Customer c){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        try {
            ppst = conn.prepareCall("INSERT INTO customer (name, id, phone) VALUES (?, ?, ?)");
            ppst.setString(1, c.getName());
            ppst.setString(2, c.getId());
            ppst.setString(3, c.getPhone());
            ppst.executeUpdate();
            System.out.println("Customer created.");
        } catch (SQLException e) {
            throw new RuntimeException("Creation error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst);
        }
    } // Closes create customer

    // ================================  READ  ================================
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
                    rest.getInt("customer_key"),
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

    // ================================ UPDATE ================================
    public void update(Customer c){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        try {
            ppst = conn.prepareCall("UPDATE customer SET  name = ?, id = ?, phone = ? WHERE customer_key = ?");
            ppst.setString(1, c.getName());
            ppst.setString(2, c.getId());
            ppst.setString(3, c.getPhone());
            ppst.setInt(4, c.getCustomerKey());
            ppst.executeUpdate();
            System.out.println("Updated successfully.");
        } catch (SQLException e) {
            throw new RuntimeException("Update error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst);
        }
    } // Closes update customer

    // ================================ DELETE ================================
    public void delete(Customer c){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        try {
            ppst = conn.prepareCall("DELETE FROM customer WHERE customer_key = ?");
            ppst.setInt(1, c.getCustomerKey());
            ppst.executeUpdate();
            System.out.println("Successfully deleted.");
        } catch (SQLException e) {
            throw new RuntimeException("Delete error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst);
        }
    } // Closes delete customer

    // ||||||||||||||||||||||||||||||||  FIND  ||||||||||||||||||||||||||||||||

    // ================================ BY KEY ================================
    public Customer findByKey(String cid) {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        ResultSet rest = null;
        Customer c = null;

        try {
            ppst = conn.prepareStatement("SELECT * FROM customer WHERE customer_key = ?");
            ppst.setInt(1, parseInt(cid));
            rest = ppst.executeQuery();

            rest.next();
            c = new Customer(
                    rest.getInt("customer_key"),
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
    } // Closes find customer by key

    // ================================ BY NAME ===============================
    public List<Customer> findByName(String n) {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        ResultSet rest = null;
        List<Customer> customers = new ArrayList<>();

        try {
            ppst = conn.prepareStatement("SELECT * FROM customer WHERE LOWER(name) LIKE LOWER(?)");
            ppst.setString(1, "%" + n + "%");
            rest = ppst.executeQuery();

            while (rest.next()) {
                Customer c = new Customer(
                    rest.getInt("customer_key"),
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
    } // Closes find customer by name

    // ================================ BY ID =================================
    public List<Customer> findById(String i) {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        ResultSet rest = null;
        List<Customer> customers = new ArrayList<>();

        try {
            ppst = conn.prepareStatement("SELECT * FROM customer WHERE id = ?");
            ppst.setString(1, i);
            rest = ppst.executeQuery();

            while (rest.next()) {
                Customer c = new Customer(
                    rest.getInt("customer_key"),
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
    } // Closes find customer by id

    // ================================ BY PHONE ==============================
    public List<Customer> findByPhone(String p) {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        ResultSet rest = null;
        List<Customer> customers = new ArrayList<>();

        try {
            ppst = conn.prepareStatement("SELECT * FROM customer WHERE phone = ?");
            ppst.setString(1, p);
            rest = ppst.executeQuery();

            while (rest.next()) {
                Customer c = new Customer(
                    rest.getInt("customer_key"),
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
    } // Closes find customer by phone

}
