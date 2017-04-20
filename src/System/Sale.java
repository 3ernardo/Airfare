package System;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Sale {

    private Customer customer;
    private Flight flight;
    private LocalDateTime timeOfPurchase;

    public Sale(Customer customer, Flight flight) {
        this.timeOfPurchase = LocalDateTime.now();
        this.customer = customer;
        this.flight = flight;
    }

    public String getCustomer() {
        return customer.getName();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getFlight() {
        return flight.getOrigin();
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public LocalDateTime getTimeOfPurchase() {
        return timeOfPurchase;
    }
}
