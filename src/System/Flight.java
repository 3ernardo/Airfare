package System;

import java.time.LocalDate;

public class Flight {

    private String origin;
    private String destination;
    private LocalDate departureTime;
    private Airplane designatedPlane;
    private int availableSeats;

    public Flight(String origin, String destination, LocalDate departureTime, Airplane designatedPlane) {
        this.availableSeats = designatedPlane.getQntSeats()
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.designatedPlane = designatedPlane;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDate departureTime) {
        this.departureTime = departureTime;
    }

    public Airplane getDesignatedPlane() {
        return designatedPlane;
    }

    public void setDesignatedPlane(Airplane designatedPlane) {
        this.designatedPlane = designatedPlane;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}