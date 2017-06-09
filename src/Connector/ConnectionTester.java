package Connector;

import DAO.CustomerDAO;
import DAO.AirplaneDAO;
import DAO.FlightDAO;
import System.Customer;
import System.Airplane;
import System.Flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Bernardo on 07/06/2017.
 */
public class ConnectionTester {
    public static void main(String[] args) {

        DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        AirplaneDAO aDAO = new AirplaneDAO();
        CustomerDAO cDAO = new CustomerDAO();


//        Airplane a1 = new Airplane("FQQ-4843", "Embraer", 2);
//        Airplane a2 = new Airplane("HWH-5429", "Boeing", 64);
//        createPlane(a1);
//        createPlane(a2);
//        readPlanes();
//        a1.setPlaneName("Airbus");
//        a1.setAirplaneKey(3);
//        updatePlane(a1);
//        a2.setAirplaneKey(2);
//        deleteAirplane(a2);
//        readPlanes();
        //Flight f1 = new Flight("654-484", "Porto Alegre", "Curitiba", LocalDateTime.parse("2017-05-05 12:00", dateForm), aDAO.findByKey("5"));

        //createFlight(f1);

        //cDAO.findByKey("0");


    }


//    private static void createFlight(Flight f) {
//        FlightDAO fDAO = new FlightDAO();
//        fDAO.create(f);
//    }

    private static void printPlaneHeader() {
        System.out.println(String.format("%-" + spacerA + "s", "Key") + "\t" +
                String.format("%-" + spacerB + "s", "Code") + "\t" +
                String.format("%-" + spacerC + "s", "Designation") + "\t" +
                String.format("%-" + spacerD + "s", "Quantity"));
    }

    private static void printAirplane(Airplane a) {
        System.out.println(String.format("%-" + spacerA + "s", a.getAirplaneKey()) + "\t" +
                String.format("%-" + spacerB + "s", a.getCode()) + "\t" +
                String.format("%-" + spacerC + "s", a.getPlaneName()) + "\t" +
                String.format("%-" + spacerD + "s", a.getQntSeats())
        );
    }

    private static void createPlane(Airplane a){
        AirplaneDAO aDAO = new AirplaneDAO();
        aDAO.create(a);
    }

    private static void readPlanes() {
        AirplaneDAO aDAO = new AirplaneDAO();
        printPlaneHeader();
        for (Airplane a : aDAO.read()) {
            printAirplane(a);
        }
    }

    private static void updatePlane(Airplane a){
        AirplaneDAO aDAO = new AirplaneDAO();
        aDAO.update(a);
    }

    private static void deleteAirplane(Airplane a){
        AirplaneDAO aDAO = new AirplaneDAO();
        aDAO.delete(a);
    }




    private static int spacerA = 5;
    private static int spacerB = 20;
    private static int spacerC = 15;
    private static int spacerD = 18;

    private static void printCustomerHeader() {
        System.out.println(String.format("%-" + spacerA + "s", "Key") + "\t" +
                String.format("%-" + spacerB + "s", "Name") + "\t" +
                String.format("%-" + spacerC + "s", "ID") + "\t" +
                String.format("%-" + spacerD + "s", "Telephone"));
    }

    private static void printCustomer(Customer c) {
        System.out.println(String.format("%-" + spacerA + "s", c.getCustomerKey()) + "\t" +
                String.format("%-" + spacerB + "s", c.getName()) + "\t" +
                String.format("%-" + spacerC + "s", c.getId()) + "\t" +
                String.format("%-" + spacerD + "s", c.getPhone())
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

    private static void findCustomer(int tipe, String value){
        CustomerDAO cDAO = new CustomerDAO();
        Customer cust = null;
        printCustomerHeader();

        switch (tipe) {
            case 1: //printCustomer(cDAO.findByKey(value));
                break;
            case 2:
                for (Customer c : cDAO.findByName(value)) printCustomer(c);
                break;
            case 3:
                for (Customer c : cDAO.findById(value)) printCustomer(c);
                break;
            case 4:
                for (Customer c : cDAO.findByPhone(value)) printCustomer(c);
                break;
            default:
                break;
        }
    }

}
