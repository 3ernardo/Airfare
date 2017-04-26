package System;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RepositorySales {

    ArrayList<Sale> salesHistory = new ArrayList<Sale>();

    DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private int spacerA = 20;
    private int spacerB = 20;
    private int spacerC = 12;

    public boolean appendSale(Customer customer, Flight flight){
        if (flight.getAvailableSeats() > 0){
            flight.sellOneSeat();
            Sale s = new Sale(customer, flight);
            salesHistory.add(s);
            return true;
        } else {
            return false;
        }
    }

    private void printSalesHeader() {
        System.out.println(String.format("%-" + spacerA + "s", "Customer") + "\t" +
                String.format("%-" + spacerB + "s", "Flight") + "\t" +
                String.format("%-" + spacerC + "s", "Time"));
    }

    private void printSales(Sale s) {
        System.out.println(String.format("%-" + spacerA + "s", s.getCustomer()) + "\t" +
                String.format("%-" + spacerB + "s", s.getFlight()) + "\t" +
                String.format("%-" + spacerC + "s", s.getTimeOfPurchase().format(dateForm))
        );
    }

    public void listSales() {
        printSalesHeader();
        for (Sale s : salesHistory) {
            printSales(s);
        }
    }

}
