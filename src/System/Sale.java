package System;

import java.time.LocalDate;

public class Sale {

    private Customer customer;
    private Flight flight;
    private LocalDate timeOfPurchase;

    public Sale(Customer customer, Flight flight) {
        this.timeOfPurchase = LocalDate.now();
        this.customer = customer;
        this.flight = flight;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public LocalDate getTimeOfPurchase() {
        return timeOfPurchase;
    }
}
