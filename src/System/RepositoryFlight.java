package System;

import java.time.LocalDate;
import java.util.ArrayList;

public class RepositoryFlight {

    ArrayList<Flight> flights = new ArrayList<Flight>();

    private int spacerA = 20;
    private int spacerB = 20;
    private int spacerC = 12;
    private int spacerD = 12;
    private int spacerE = 10;

    public void appendFlight(String origin, String destination, LocalDate departureTime, Airplane designatedPlane){
        Flight f = new Flight(origin, destination, departureTime, designatedPlane);
        flights.add(f);
    }

    private void printFlightHeader() {
        System.out.println(String.format("%-" + spacerA + "s", "From") + "\t" +
                String.format("%-" + spacerB + "s", "To") + "\t" +
                String.format("%-" + spacerC + "s", "Departure") + "\t" +
                String.format("%-" + spacerD + "s", "Plane") + "\t" +
                String.format("%-" + spacerE + "s", "Seats left"));
    }

    private void printFlights(Flight f) {
        System.out.println(String.format("%-" + spacerA + "s", f.getOrigin()) + "\t" +
                String.format("%-" + spacerB + "s", f.getDestination()) + "\t" +
                String.format("%-" + spacerC + "s", f.getDepartureTime()) + "\t" +
                String.format("%-" + spacerD + "s", f.getDesignatedPlane()) + "\t" +
                String.format("%-" + spacerE + "s", f.getAvailableSeats()));
    }

    public void listFlights() {
        printFlightHeader();
        for (Flight f : flights){
            printFlights(f);
        }
    }

    public void searchFlight(int opt, String toSearch) {
        boolean success = false;
        for (Flight f : flights) {
            switch (opt) {
                case 1: // Search by origin
                    if (toSearch.equals(f.getOrigin())) success = true;
                    break;
                case 2: // Search by destination
                    if (toSearch.equals(f.getDestination())) success = true;
                    break;
                case 3: // Search by time
                    if (toSearch.equals(f.getDepartureTime())) success = true;
                    break;
                case 4: // Search by plane
                    if (toSearch.equals(f.getDesignatedPlane())) success = true;
                    break;
                case 5: // Search by seats available (at least)
                    if (Integer.parseInt(toSearch) <= f.getAvailableSeats()) success = true;
                    break;
                default:
                    break;
            }
            if (success == true) {
                printFlightHeader();
                printFlights(f);
            }
        }
        if (success == false) {
            System.out.println("This search did not produce results.");
        }
    }

}