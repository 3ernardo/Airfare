package System;

import java.time.LocalDateTime;

public class Flight {
    private String code;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private Airplane designatedPlane;
    private int availableSeats;

    public Flight(String code, String origin, String destination, LocalDateTime departureTime, Airplane designatedPlane) {
        this.availableSeats = designatedPlane.getQntSeats();
        this.code = code;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.designatedPlane = designatedPlane;
    }

    // ========== getters e setters ==========

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Airplane getDesignatedPlane() {
        return designatedPlane;
    }

    public String getPlaneName() {
        return designatedPlane.getPlaneName();
    }

    public void setDesignatedPlane(Airplane designatedPlane) {
        this.designatedPlane = designatedPlane;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void sellOneSeat() {         //decrementa de 1 os assentos totais
        this.availableSeats--;
    }
}