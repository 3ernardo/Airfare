package DAO;

import Connector.ConnectionFactory;
import System.Airplane;

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
public class AirplaneDAO {

    // ||||||||||||||||||||||||||||||||  CRUD  ||||||||||||||||||||||||||||||||

    // ================================ CREATE ================================
    public void create(Airplane a){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        try {
            ppst = conn.prepareCall("INSERT INTO airplane (code, planename, qntseats) VALUES (?, ?, ?)");
            ppst.setString(1, a.getCode());
            ppst.setString(2, a.getPlaneName());
            ppst.setInt(3, a.getQntSeats());
            ppst.executeUpdate();
            System.out.println("Plane created.");
        } catch (SQLException e) {
            throw new RuntimeException("Creation error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst);
        }
    } // Closes create airplane

    // ================================  READ  ================================
    public List<Airplane> read() {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        ResultSet rest = null;
        List<Airplane> airplanes = new ArrayList<>();
        try {
            ppst = conn.prepareStatement("SELECT * FROM airplane");
            rest = ppst.executeQuery();
            while (rest.next()) {
                Airplane a = new Airplane(
                        rest.getInt("airplane_key"),
                        rest.getString("code"),
                        rest.getString("planename"),
                        rest.getInt("qntseats")
                );
                airplanes.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst, rest);
        }
        return airplanes;
    } // Closes read airplanes

    // ================================ UPDATE ================================
    public void update(Airplane a){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        try {
            ppst = conn.prepareCall("UPDATE airplane SET  code = ?, planename = ?, qntseats = ? WHERE airplane_key = ?");
            ppst.setString(1, a.getCode());
            ppst.setString(2, a.getPlaneName());
            ppst.setInt(3, a.getQntSeats());
            ppst.setInt(4, a.getAirplaneKey());
            ppst.executeUpdate();
            System.out.println("Updated successfully.");
        } catch (SQLException e) {
            throw new RuntimeException("Update error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst);
        }
    } // Closes update airplane

    // ================================ DELETE ================================
    public void delete(Airplane a){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        try {
            ppst = conn.prepareCall("DELETE FROM airplane WHERE airplane_key = ?");
            ppst.setInt(1, a.getAirplaneKey());
            ppst.executeUpdate();
            System.out.println("Successfully deleted.");
        } catch (SQLException e) {
            throw new RuntimeException("Delete error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst);
        }
    } // Closes delete airplane

    // ||||||||||||||||||||||||||||||||  FIND  ||||||||||||||||||||||||||||||||

    //  ================================ BY KEY ================================
    public List<Airplane> findByKey(String aid) {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        ResultSet rest = null;
        List<Airplane> airplanes = new ArrayList<>();

        try {
            ppst = conn.prepareStatement("SELECT * FROM airplane WHERE airplane_key = ?");
            ppst.setInt(1, parseInt(aid));
            rest = ppst.executeQuery();

            while (rest.next()) {
                Airplane a = new Airplane(
                        rest.getInt("airplane_key"),
                        rest.getString("code"),
                        rest.getString("planename"),
                        rest.getInt("qntseats")
                );
                airplanes.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst, rest);
        }
        return airplanes;
    } // Closes find airplane by code

    // ================================ BY CODE ===============================
    public List<Airplane> findByCode(String c) {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        ResultSet rest = null;
        List<Airplane> airplanes = new ArrayList<>();

        try {
            ppst = conn.prepareStatement("SELECT * FROM airplane WHERE code = ?");
            ppst.setString(1, c);
            rest = ppst.executeQuery();

            while (rest.next()) {
                Airplane a = new Airplane(
                        rest.getInt("airplane_key"),
                        rest.getString("code"),
                        rest.getString("planename"),
                        rest.getInt("qntseats")
                );
                airplanes.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst, rest);
        }
        return airplanes;
    } // Closes find airplane by code

    // ================================ BY NAME ===============================
    public List<Airplane> findByName(String n) {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        ResultSet rest = null;
        List<Airplane> airplanes = new ArrayList<>();

        try {
            ppst = conn.prepareStatement("SELECT * FROM airplane WHERE LOWER(planename) LIKE LOWER(?)");
            ppst.setString(1, "%" + n + "%");
            rest = ppst.executeQuery();

            while (rest.next()) {
                Airplane a = new Airplane(
                        rest.getInt("airplane_key"),
                        rest.getString("code"),
                        rest.getString("planename"),
                        rest.getInt("qntseats")
                );
                airplanes.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst, rest);
        }
        return airplanes;
    } // Closes find airplane by name

    // ================================ BY SEATS ==============================
    public List<Airplane> findBySeats(String s) {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        ResultSet rest = null;
        List<Airplane> airplanes = new ArrayList<>();

        try {
            ppst = conn.prepareStatement("SELECT * FROM airplane WHERE qntseats >= ?");
            ppst.setInt(1, parseInt(s));
            rest = ppst.executeQuery();

            while (rest.next()) {
                Airplane a = new Airplane(
                        rest.getInt("airplane_key"),
                        rest.getString("code"),
                        rest.getString("planename"),
                        rest.getInt("qntseats")
                );
                airplanes.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst, rest);
        }
        return airplanes;
    } // Closes find airplane by seats
}
