package System;

import java.time.LocalDateTime;
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

    public void printSalesHeader() {
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

    public void printSalesByCustomer(String c) {
        boolean found = false;
        for (Sale s : salesHistory) {
            if (c.equals(s.getCustomer())){
                found = true;
                System.out.println(String.format("%-" + spacerA + "s", s.getCustomer()) + "\t" +
                        String.format("%-" + spacerB + "s", s.getFlight()) + "\t" +
                        String.format("%-" + spacerC + "s", s.getTimeOfPurchase().format(dateForm)));
            }
        }
        if (found == false) {
            System.out.println("Your search yielded no results.");
        }
    }

    public void printSalesByOrigin(String o) {
        boolean found = false;
        for (Sale s : salesHistory) {
            if (o.equals(s.getOrigin())){
                found = true;
                System.out.println(String.format("%-" + spacerA + "s", s.getCustomer()) + "\t" +
                        String.format("%-" + spacerB + "s", s.getFlight()) + "\t" +
                        String.format("%-" + spacerC + "s", s.getTimeOfPurchase().format(dateForm)));
            }
        }
        if (found == false) {
            System.out.println("Your search yielded no results.");
        }
    }

    public void printSalesByDestination(String d) {
        boolean found = false;
        for (Sale s : salesHistory) {
            if (d.equals(s.getDestination())){
                found = true;
                System.out.println(String.format("%-" + spacerA + "s", s.getCustomer()) + "\t" +
                        String.format("%-" + spacerB + "s", s.getFlight()) + "\t" +
                        String.format("%-" + spacerC + "s", s.getTimeOfPurchase().format(dateForm)));
            }
        }
        if (found == false) {
            System.out.println("Your search yielded no results.");
        }
    }

    public void printSalesByDate(String start, String finish){
        LocalDateTime minimum = LocalDateTime.parse(start, dateForm);
        LocalDateTime maximum = LocalDateTime.parse(finish, dateForm);
        boolean found = false;
        for (Sale s : salesHistory) {
            if (s.getTimeOfPurchase().isAfter(minimum) && s.getTimeOfPurchase().isBefore(maximum)){
                found = true;
                System.out.println(String.format("%-" + spacerA + "s", s.getCustomer()) + "\t" +
                        String.format("%-" + spacerB + "s", s.getFlight()) + "\t" +
                        String.format("%-" + spacerC + "s", s.getTimeOfPurchase().format(dateForm)));
            }
        }
        if (found == false) {
            System.out.println("Your search yielded no results.");
        }
    }

    public void listSales() {
        printSalesHeader();
        for (Sale s : salesHistory) {
            printSales(s);
        }
    }

}
