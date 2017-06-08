package DAO;

import Connector.ConnectionFactory;
import System.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Bernardo on 08/06/2017.
 */
public class FlightDAO {

    // ||||||||||||||||||||||||||||||||  CRUD  ||||||||||||||||||||||||||||||||

    // ================================ CREATE ================================
    public void create(Flight f){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ppst = null;
        java.sql.Time timetest = java.sql.Time.valueOf("2017-05-05 12:00");
        try {
            ppst = conn.prepareCall("INSERT INTO airplane (code, origin, destination, departuretime, designatedplane, seatsleft) VALUES (?, ?, ?, ?, ?, ?)");
            ppst.setString(1, f.getCode());
            ppst.setString(2, f.getOrigin());
            ppst.setString(3, f.getDestination());
            ppst.setTime(4, timetest);
            ppst.setInt(5, f.getDesignatedPlane().getAirplaneKey());
            ppst.setInt(6, f.getDesignatedPlane().getQntSeats());
            ppst.executeUpdate();
            System.out.println("Plane created.");
        } catch (SQLException e) {
            throw new RuntimeException("Creation error: ", e);
        } finally {
            ConnectionFactory.closeConnection(conn, ppst);
        }
    } // Closes create airplane
    // ================================  READ  ================================
    // ================================ UPDATE ================================
    // ================================ DELETE ================================

    // ||||||||||||||||||||||||||||||||  FIND  ||||||||||||||||||||||||||||||||
    // ================================ BY KEY ================================
    // ================================ BY CODE ===============================
    // ================================ BY ORIGIN =============================
    // ================================ BY DESTINATION ========================
    // ================================ BY DEPARTURE ==========================
    // ================================ BY PLANE ==============================
}
