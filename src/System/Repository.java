package System;

import java.util.ArrayList;

public class Repository {
	
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Airplane> airplanes = new ArrayList<Airplane>();

    public void addCustomers() {
        appendCustomer("Moses Broadhead", "6946884", "98742-2726");
        appendCustomer("Klara Bynoe", "9948648", "98664-8833");
        appendCustomer("Neal Hanselman", "8927744", "98333-6426");
        appendCustomer("Chantel Boyko", "3744397", "98743-3324");
        appendCustomer("Chase Roberge", "7967397", "98368-3727");
    }

    public void addPlanes() {
        appendAirplane("FQQ-4843", "Embraer", 20);
        appendAirplane("HWH-5429", "Boeing", 64);
        appendAirplane("GZH-8386", "Airbus", 76);
        appendAirplane("BKP-3294", "Cessna", 12);
    }

    /* CUSTOMER */
	public void appendCustomer(String name, String id, String phone){
	    Customer c = new Customer(name, id, phone);
	    customers.add(c);
    }

    public void listCustomers(){
        System.out.println(String.format("%-20s", "Name") + "\t" +
                String.format("%-15s", "ID") + "\t" +
                String.format("%-18s", "Telephone"));

        for (Customer c : customers) {
            System.out.println(String.format("%-20s", c.getName()) + "\t" +
                    String.format("%-15s", c.getId()) + "\t" +
                    String.format("%-18s", c.getPhone())
            );
        }
    }

    public void searchCustName(String name){
        int success = 0;
        for (Customer c : customers) {
            if (name.equals(c.getName())){
                System.out.println(String.format("%-20s", "Name") + "\t" +
                        String.format("%-15s", "ID") + "\t" +
                        String.format("%-18s", "Telephone"));
                System.out.println(String.format("%-20s", c.getName()) + "\t" +
                        String.format("%-15s", c.getId()) + "\t" +
                        String.format("%-18s", c.getPhone()));
                success = 1;
            }
        }
        if (success == 0) {
            System.out.println("Customer not found");
        }
    }

    public void searchCustId(String id) {
        int success = 0;
        for (Customer c : customers) {
            if (id.equals(c.getId())) {
                System.out.println(String.format("%-20s", "Name") + "\t" +
                        String.format("%-15s", "ID") + "\t" +
                        String.format("%-18s", "Telephone"));
                System.out.println(String.format("%-20s", c.getName()) + "\t" +
                        String.format("%-15s", c.getId()) + "\t" +
                        String.format("%-18s", c.getPhone()));
                success = 1;
            }
        }
        if (success == 0) {
            System.out.println("Customer not found");
        }
    }

    public void searchCustPhone(String phone){
        int success = 0;
        for (Customer c : customers) {
            if (phone.equals(c.getPhone())){
                System.out.println(String.format("%-20s", "Name") + "\t" +
                        String.format("%-15s", "ID") + "\t" +
                        String.format("%-18s", "Telephone"));
                System.out.println(String.format("%-20s", c.getName()) + "\t" +
                        String.format("%-15s", c.getId()) + "\t" +
                        String.format("%-18s", c.getPhone()));
                success = 1;
            }
        }
        if (success == 0) {
            System.out.println("Customer not found");
        }
    }

    /* AIRPLANE */
    public void appendAirplane(String code, String planeName, int qntSeats){
        Airplane a = new Airplane(code, planeName, qntSeats);
        airplanes.add(a);
    }

    public void listAirplanes(){
        System.out.println(String.format("%-12s", "Code") + "\t" +
                String.format("%-12s", "Designation") + "\t" +
                String.format("%-10s", "Quantity"));

        for (Airplane a : airplanes) {
            System.out.println(String.format("%-12s", a.getCode()) + "\t" +
                    String.format("%-12s", a.getPlaneName()) + "\t" +
                    String.format("%-10s", a.getQntSeats())
            );
        }
    }


}
