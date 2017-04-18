package System;

import java.util.ArrayList;

public class RepositoryAirplane {

    ArrayList<Airplane> airplanes = new ArrayList<Airplane>();

    public void addPlanes() {
        appendAirplane("FQQ-4843", "Embraer", 20);
        appendAirplane("HWH-5429", "Boeing", 64);
        appendAirplane("GZH-8386", "Airbus", 76);
        appendAirplane("BKP-3294", "Cessna", 12);
    }

    private int spacerA = 12;
    private int spacerB = 12;
    private int spacerC = 10;

    public void appendAirplane(String code, String planeName, int qntSeats) {
        Airplane a = new Airplane(code, planeName, qntSeats);
        airplanes.add(a);
    }

    private void printPlaneHeader() {
        System.out.println(String.format("%-" + spacerA + "s", "Code") + "\t" +
                String.format("%-" + spacerB + "s", "Designation") + "\t" +
                String.format("%-" + spacerC + "s", "Quantity"));
    }

    private void printAirplane(Airplane a) {
        System.out.println(String.format("%-" + spacerA + "s", a.getCode()) + "\t" +
                String.format("%-" + spacerB + "s", a.getPlaneName()) + "\t" +
                String.format("%-" + spacerC + "s", a.getQntSeats())
        );
    }

    public void listAirplanes() {
        printPlaneHeader();
        for (Airplane a : airplanes) {
            printAirplane(a);
        }
    }

    public void searchAirplane(int opt, String toSearch) {
        boolean success = false;
        for (Airplane a : airplanes) {
            switch (opt) {
                case 1: // Search by code
                    if (toSearch.equals(a.getCode())) success = true;
                    break;
                case 2: // Search by airplane name
                    if (toSearch.equals(a.getPlaneName())) success = true;
                    break;
                case 3: // Search by quantity of seats
                    if (Integer.parseInt(toSearch) == a.getQntSeats()) success = true;
                    break;
                default:
                    break;
            }
            if (success == true) {
                printPlaneHeader();
                printAirplane(a);
            }
        }
        if (success == false) {
            System.out.println("This search did not produce results.");
        }
    }

}