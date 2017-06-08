package System;

/**
 * Created by Debora on 08/06/2017.
 */
public class Printer {

//  ==================== Customer
    private static int spacerCA = 20;
    private static int spacerCB = 15;
    private static int spacerCC = 18;

    public static void printCustomerHeader() {
        System.out.println(String.format("%-" + spacerCA + "s", "Name") + "\t" +
                String.format("%-" + spacerCB + "s", "ID") + "\t" +
                String.format("%-" + spacerCC + "s", "Telephone"));
    }

    public static void printCustomer(Customer c) {
        System.out.println(String.format("%-" + spacerCA + "s", c.getName()) + "\t" +
                String.format("%-" + spacerCB + "s", c.getId()) + "\t" +
                String.format("%-" + spacerCC + "s", c.getPhone())
        );
    }

//  ==================== Airplane
    private static int spacerAA = 12;
    private static int spacerAB = 12;
    private static int spacerAC = 10;

    public static void printAirplaneHeader() {
        System.out.println(String.format("%-" + spacerAA + "s", "Code") + "\t" +
                String.format("%-" + spacerAB + "s", "Designation") + "\t" +
                String.format("%-" + spacerAC + "s", "Quantity"));
    }

    public static void printAirplane(Airplane a) {
        System.out.println(String.format("%-" + spacerAA + "s", a.getCode()) + "\t" +
                String.format("%-" + spacerAB + "s", a.getPlaneName()) + "\t" +
                String.format("%-" + spacerAC + "s", a.getQntSeats())
        );
    }
}
