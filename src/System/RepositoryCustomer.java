package System;

import java.util.ArrayList;

public class RepositoryCustomer {

    ArrayList<Customer> customers = new ArrayList<Customer>();

    public void startAddCustomers() {
        appendCustomer("Bernardo Araujo", "4489325", "98764-8688");
        appendCustomer("Giuseppe Battaglino", "9635459", "98576-8669");
        appendCustomer("Moses Broadhead", "6946884", "98742-2726");
        appendCustomer("Klara Bynoe", "9948648", "98664-8833");
        appendCustomer("Neal Hanselman", "8927744", "98333-6426");
        appendCustomer("Chantel Boyko", "3744397", "98743-3324");
        appendCustomer("Chase Roberge", "7967397", "98368-3727");
    }

    private int spacerA = 20;
    private int spacerB = 15;
    private int spacerC = 18;

    public void appendCustomer(String name, String id, String phone) {
        Customer c = new Customer(name, id, phone);
        customers.add(c);
    }

    private void printCustomerHeader() {
        System.out.println(String.format("%-" + spacerA + "s", "Name") + "\t" +
                String.format("%-" + spacerB + "s", "ID") + "\t" +
                String.format("%-" + spacerC + "s", "Telephone"));
    }

    private void printCustomer(Customer c) {
        System.out.println(String.format("%-" + spacerA + "s", c.getName()) + "\t" +
                String.format("%-" + spacerB + "s", c.getId()) + "\t" +
                String.format("%-" + spacerC + "s", c.getPhone())
        );
    }

    public void listCustomers() {
        printCustomerHeader();
        for (Customer c : customers) {
            printCustomer(c);
        }
    }

    public void searchCustomer(int opt, String toSearch) {
        boolean success = false;
        for (Customer c : customers) {
            switch (opt) {
                case 1: // Search by name
                    if (toSearch.equals(c.getName())) success = true;
                    break;
                case 2: // Search by ID
                    if (toSearch.equals(c.getId())) success = true;
                    break;
                case 3: // Search by telephone
                    if (toSearch.equals(c.getPhone())) success = true;
                    break;
                default:
                    break;
            }
            if (success == true) {
                printCustomerHeader();
                printCustomer(c);
            }
        }
        if (success == false) {
            System.out.println("This search did not produce results.");
        }
    }

    public boolean validID(String toSearch) {
        boolean success = false;
        for (Customer c : customers) {
            if (toSearch.equals(c.getId())) success = true;
        }
        return success;
    }

    public boolean customerExists(String customerName){
        boolean success = false;
        for (Customer c : customers) {
            if (customerName.equals(c.getName())){
                success = true;
            }
        }
        return success;
    }

    public Customer getACustomer(String customerName){
        Customer customer = null;
        for (Customer c : customers) {
            if (customerName.equals(c.getName())){
                customer = c;
            }
        }
        return customer;
    }

    public Customer getACustomerByID(String custID){
        Customer customer = null;
        for (Customer c : customers) {
            if (custID.equals(c.getId())){
                customer = c;
            }
        }
        return customer;
    }

}