package System;

import java.util.ArrayList;

public class Repository {
	
	ArrayList<Customer> customers = new ArrayList<Customer>();

    public void addCustomers() {
        appendCustomer("Moses Broadhead", "6946884", "98742-2726");
        appendCustomer("Klara Bynoe", "9948648", "98664-8833");
        appendCustomer("Neal Hanselman", "8927744", "98333-6426");
        appendCustomer("Chantel Boyko", "3744397", "98743-3324");
        appendCustomer("Chase Roberge", "7967397", "98368-3727");
    }

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
}
