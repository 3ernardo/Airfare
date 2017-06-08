package System;

/**
 * Created by Debora on 08/06/2017.
 */
public class Printer {
    private static int spacerA = 20;
    private static int spacerB = 15;
    private static int spacerC = 18;

    public static void printCustomerHeader() {
        System.out.println(String.format("%-" + spacerA + "s", "Name") + "\t" +
                String.format("%-" + spacerB + "s", "ID") + "\t" +
                String.format("%-" + spacerC + "s", "Telephone"));
    }

    public static void printCustomer(Customer c) {
        System.out.println(String.format("%-" + spacerA + "s", c.getName()) + "\t" +
                String.format("%-" + spacerB + "s", c.getId()) + "\t" +
                String.format("%-" + spacerC + "s", c.getPhone())
        );
    }
}
