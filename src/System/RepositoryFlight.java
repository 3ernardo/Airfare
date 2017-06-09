package System;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RepositoryFlight {

    ArrayList<Flight> flights = new ArrayList<Flight>();

    private int flightCounter = 238;

    private int spacerA = 8;
    private int spacerB = 17;
    private int spacerC = 17;
    private int spacerD = 19;
    private int spacerE = 10;
    private int spacerF = 10;

    public void appendFlight(String origin, String destination, LocalDateTime departureTime, Airplane plane) {
        flightCounter++;
        String code = "FLG7"+Integer.toString(flightCounter);
        //Flight f = new Flight(code, origin, destination, departureTime, plane);
        //flights.add(f);
    }

    private void printFlightHeader() {
        System.out.println(String.format("%-" + spacerA + "s", "Code") + "\t" +
                String.format("%-" + spacerB + "s", "From") + "\t" +
                String.format("%-" + spacerC + "s", "To") + "\t" +
                String.format("%-" + spacerD + "s", "Departure") + "\t" +
                String.format("%-" + spacerE + "s", "Plane") + "\t" +
                String.format("%-" + spacerF + "s", "Seats left"));
    }

    DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private void printFlights(Flight f) {
        String formattedTime = f.getDepartureTime().format(dateForm);
        System.out.println(String.format("%-" + spacerA + "s", f.getCode()) + "\t" +
                String.format("%-" + spacerB + "s", f.getOrigin()) + "\t" +
                String.format("%-" + spacerC + "s", f.getDestination()) + "\t" +
                String.format("%-" + spacerD + "s", formattedTime) + "\t" +
                String.format("%-" + spacerE + "s", f.getPlaneName()) + "\t" +
                String.format("%-" + spacerF + "s", f.getAvailableSeats()));
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

    public boolean flightValid(String flightCode){
        boolean success = false;
        for (Flight f : flights) {
            if (flightCode.equals(f.getCode())){
                success = true;
            }
        }
        return success;
    }

    public Flight getAFlight(String flightCode){
        Flight flight = null;
        for (Flight f : flights) {
            if (flightCode.equals(f.getCode())){
                flight = f;
            }
        }
        return flight;
    }
}