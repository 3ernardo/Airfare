package System;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RepositorySales {

    ArrayList<Sale> salesHistory = new ArrayList<Sale>();

    DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private int spacerA = 20;
    private int spacerB = 20;
    private int spacerC = 12;

    public void appendSale(Customer customer, Flight flight){
        Sale s = new Sale(customer, flight);
        salesHistory.add(s);
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
