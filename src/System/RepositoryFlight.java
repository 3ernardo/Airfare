package System;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RepositoryFlight {

    ArrayList<Flight> flights = new ArrayList<Flight>();

    private int spacerA = 17;
    private int spacerB = 17;
    private int spacerC = 19;
    private int spacerD = 10;
    private int spacerE = 10;

    public void appendFlight(String origin, String destination, LocalDateTime departureTime, Airplane plane) {
        Flight f = new Flight(origin, destination, departureTime, plane);
        flights.add(f);
    }

    private void printFlightHeader() {
        System.out.println(String.format("%-" + spacerA + "s", "From") + "\t" +
                String.format("%-" + spacerB + "s", "To") + "\t" +
                String.format("%-" + spacerC + "s", "Departure") + "\t" +
                String.format("%-" + spacerD + "s", "Plane") + "\t" +
                String.format("%-" + spacerE + "s", "Seats left"));
    }

    DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private void printFlights(Flight f) {
        String formattedTime = f.getDepartureTime().format(dateForm);
        System.out.println(String.format("%-" + spacerA + "s", f.getOrigin()) + "\t" +
                String.format("%-" + spacerB + "s", f.getDestination()) + "\t" +
                String.format("%-" + spacerC + "s", formattedTime) + "\t" +
                String.format("%-" + spacerD + "s", f.getPlaneName()) + "\t" +
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