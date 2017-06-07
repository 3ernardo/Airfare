package Connector;

import DAO.CustomerDAO;
import System.Customer;

import javax.swing.table.DefaultTableModel;

/**
 * Created by Bernardo on 07/06/2017.
 */
public class ConnectionTester {
    public static void main(String[] args) {

        Customer c1 = new Customer("Bernardo Araujo", "4489325", "98764-8688");
        Customer c2 = new Customer("Giuseppe Bat", "9635459", "98576-8669");
        createCustomer(c1);
        createCustomer(c2);
        readCustomer();
        Customer c3 = findCustomer(2, "Giuseppe Bat");
        c3.setName("Giuseppe Battaglino");
        updateCustomer(c3);
        readCustomer();
        deleteCustomer(c3);
        readCustomer();
    }

    private static int spacerA = 20;
    private static int spacerB = 15;
    private static int spacerC = 18;

    private static void printCustomerHeader() {
        System.out.println(String.format("%-" + spacerB + "s", "CID") + "\t" +
                String.format("%-" + spacerA + "s", "Name") + "\t" +
                String.format("%-" + spacerB + "s", "ID") + "\t" +
                String.format("%-" + spacerC + "s", "Telephone"));
    }

    private static void printCustomer(Customer c) {
        System.out.println(String.format("%-" + spacerB + "s", c.getCustomerID()) + "\t" +
                String.format("%-" + spacerA + "s", c.getName()) + "\t" +
                String.format("%-" + spacerB + "s", c.getId()) + "\t" +
                String.format("%-" + spacerC + "s", c.getPhone())
        );
    }

    private static void createCustomer(Customer c){
        CustomerDAO cDAO = new CustomerDAO();
        cDAO.create(c);
    }

    private static void readCustomer() {
        CustomerDAO cDAO = new CustomerDAO();
        printCustomerHeader();
        for (Customer c : cDAO.read()) {
            printCustomer(c);
        }
    }

    private static void updateCustomer(Customer c){
        CustomerDAO cDAO = new CustomerDAO();
        cDAO.update(c);
    }

    private static void deleteCustomer(Customer c){
        CustomerDAO cDAO = new CustomerDAO();
        cDAO.delete(c);
    }

    private static Customer findCustomer(int tipe, String value){
        CustomerDAO cDAO = new CustomerDAO();
        Customer c = null;
        switch (tipe) {
            case 1: c = cDAO.findByKey(value);
                break;
            case 2: c = cDAO.findByName(value);
                break;
            case 3: c = cDAO.findById(value);
                break;
            case 4: c = cDAO.findByPhone(value);
                break;
            default:
                break;
        }
        return c;
    }

}
