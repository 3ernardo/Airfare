package System;
import Menu.Menu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Application {

    RepositoryCustomer repC = new RepositoryCustomer();
    RepositoryFlight repF = new RepositoryFlight();
    RepositoryAirplane repA = new RepositoryAirplane();

    DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void exe(){
        repC.startAddCustomers();
        repA.addPlanes();
        repF.appendFlight("Porto Alegre", "Curitiba", LocalDateTime.parse("2017-05-05 12:00", dateForm), repA.getAnAirplane("Embraer"));
        repF.appendFlight("Foggia", "Roma", LocalDateTime.parse("2017-05-06 11:30", dateForm), repA.getAnAirplane("Boeing"));
        repF.appendFlight("Veneza", "Londres", LocalDateTime.parse("2017-05-07 14:12", dateForm), repA.getAnAirplane("Airbus"));
        repF.appendFlight("Rio de Janeiro", "Salvador", LocalDateTime.parse("2017-05-08 16:45", dateForm), repA.getAnAirplane("Embraer"));
        repF.appendFlight("Manaus", "Porto Velho", LocalDateTime.parse("2017-05-11 20:30", dateForm), repA.getAnAirplane("Airbus"));
        repF.appendFlight("Caxias do Sul", "Bari", LocalDateTime.parse("2017-06-12 17:00", dateForm), repA.getAnAirplane("Embraer"));
        repF.appendFlight("Miami", "Los Angeles", LocalDateTime.parse("2017-06-16 02:45", dateForm), repA.getAnAirplane("Cessna"));
        repF.appendFlight("Lecce", "Recife", LocalDateTime.parse("2017-06-18 09:30", dateForm), repA.getAnAirplane("Boeing"));
        repF.appendFlight("Berlim", "Bayern", LocalDateTime.parse("2017-07-03 19:00", dateForm), repA.getAnAirplane("Cessna"));
        repF.appendFlight("Carapelle", "Eboli", LocalDateTime.parse("2017-07-10 22:00", dateForm), repA.getAnAirplane("Airbus"));
        printMainMenu();
    }//--------------------------------------------------------- exe

    public int intValidator(String opt) {
        try {
            int i = Integer.parseInt(opt);
            return i;
        } catch (java.lang.NumberFormatException e) {
            return 0;
        }
    }

    //====================================================================================== 1º level

    public void printMainMenu() {
        int option = 0;
        do {
            System.out.println("\n" +
                    "________________________________\n" +
                    "           MAIN MENU            ");
            Menu mMenu = new Menu();
            mMenu.addOption("Customers");
            mMenu.addOption("Flight");
            mMenu.addOption("Airplane");
            mMenu.addOption("Quit the application");
            mMenu.showMenu();
            option = intValidator(Console.scanString(""));
            if (option != 0) {
                choiceMainMenu(option);
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 4);
    }//--------------------------------------------------------- printMainMenu

    public void choiceMainMenu(int opt){
        switch (opt){
            case 1:
                printCustomerMenu();
                break;
            case 2:
                printFlightMenu();
                break;
            case 3:
                printAirplaneMenu();
                break;
            case 4:
                System.out.println("Closing the application.");
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }//--------------------------------------------------------- choiceMainMenu

    //====================================================================================== 2º level

    public void printCustomerMenu(){
        int option = 0;
        do {
            System.out.println("\n" +
                    "________________________________\n" +
                    "         CUSTOMER MENU          ");
            Menu cMenu = new Menu();
            cMenu.addOption("Add a customer");
            cMenu.addOption("Find a customer");
            cMenu.addOption("List all customers");
            cMenu.addOption("Back to main menu");
            cMenu.showMenu();
            option = intValidator(Console.scanString(""));
            if (option != 0) {
                choiceCustomerMenu(option);
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 4);
    }//--------------------------------------------------------- printCustomerMenu

    public void choiceCustomerMenu(int opt){
        switch (opt){
            case 1:
                addCustomer();
                break;
            case 2:
                printFindCustomerMenu();
                break;
            case 3:
                listCustomers();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }//--------------------------------------------------------- choiceCustomerMenu

    public void printFlightMenu() {
        int option = 0;
        do {
            System.out.println("\n" +
                    "________________________________\n" +
                    "         FLIGHT MENU          ");
            Menu fMenu = new Menu();
            fMenu.addOption("Add a flight");
            fMenu.addOption("Find a flight");
            fMenu.addOption("List all flights");
            fMenu.addOption("Back to main menu");
            fMenu.showMenu();
            option = intValidator(Console.scanString(""));
            if (option != 0) {
                choiceFlightMenu(option);
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 4);
    }//--------------------------------------------------------- printFlightMenu

    public void choiceFlightMenu(int opt) {
        switch (opt){
            case 1:
                addFlight();
                break;
            case 2:
                printFindFlightMenu();
                break;
            case 3:
                listFlights();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }//--------------------------------------------------------- choiceFlightMenu

    public void printAirplaneMenu() {
        int option = 0;
        do {
            System.out.println("\n" +
                    "________________________________\n" +
                    "         AIRPLANE MENU          ");
            Menu aMenu = new Menu();
            aMenu.addOption("Add a airplane");
            aMenu.addOption("Find a airplane");
            aMenu.addOption("List all airplane");
            aMenu.addOption("Back to main menu");
            aMenu.showMenu();
            option = intValidator(Console.scanString(""));
            if (option != 0) {
                choiceAirplaneMenu(option);
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 4);
    }//--------------------------------------------------------- printAirplaneMenu

    public void choiceAirplaneMenu(int opt) {
        switch (opt){
            case 1:
                addAirplane();
                break;
            case 2:
                printFindAirplaneMenu();
                break;
            case 3:
                listAirplanes();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }//--------------------------------------------------------- choiceAirplaneMenu

    //====================================================================================== 3º level

    public void addCustomer() {
        System.out.println("\n" +
                "________________________________\n" +
                "          ADD CUSTOMER          ");
        String name = Console.scanString("Customer's name:");
        String id = Console.scanString("Customer's ID:");
        String phone = Console.scanString("Customer's phone number:");
        repC.appendCustomer(name, id, phone);
    }//--------------------------------------------------------- addCustomer

    public void printFindCustomerMenu(){
        int option = 0;
        do {
            System.out.println("\n" +
                    "________________________________\n" +
                    "         FIND A CUSTOMER        ");
            Menu fCMenu = new Menu();
            fCMenu.addOption("Search by name");
            fCMenu.addOption("Search by ID");
            fCMenu.addOption("Search by telephone");
            fCMenu.addOption("Back to customer menu");
            fCMenu.showMenu();
            option = intValidator(Console.scanString(""));
            if (option != 0) {
                choiceFindCustomerMenu(option);
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 4);
    }//--------------------------------------------------------- printFindCustomerMenu

    public void choiceFindCustomerMenu(int opt){
        switch (opt){
            case 1:
                findCustName();
                break;
            case 2:
                findCustId();
                break;
            case 3:
                findCustPhone();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }//--------------------------------------------------------- choiceFindCustomerMenu

    public void findCustName(){
        repC.searchCustomer(1, Console.scanString("Customer's name:"));
    }//--------------------------------------------------------- findCustName

    public void findCustId(){
        repC.searchCustomer(2, Console.scanString("Customer's ID:"));
    }//--------------------------------------------------------- findCustId

    public void findCustPhone(){
        repC.searchCustomer(3, Console.scanString("Customer's Telephone:"));
    }//--------------------------------------------------------- findCustPhone

    public void listCustomers() {
        System.out.println("\n" +
                "________________________________\n" +
                "         LIST CUSTOMERS         ");
        repC.listCustomers();
    }//--------------------------------------------------------- listCustomers


    public void addFlight() {
        System.out.println("\n" +
                "________________________________\n" +
                "          ADD FLIGHT          ");
        String origin = Console.scanString("Flight's origin:");
        String destination = Console.scanString("Flight's destination:");
        LocalDateTime departureTime = LocalDateTime.parse(Console.scanString("Flight's date format(YYYY-MM-DD hh:mm):"), dateForm);
        String tempPlane = Console.scanString("Flight's airplane:");
        Airplane designatedPlane = null;
        if (repA.planeValid(tempPlane) == true) {
            designatedPlane = repA.getAnAirplane(tempPlane);
        } else {
            System.out.println("Invalid plane.");
        }
        repF.appendFlight(origin, destination, departureTime, designatedPlane);
    }//--------------------------------------------------------- addFlight

    public void printFindFlightMenu() {
        int option = 0;
        do {
            System.out.println("\n" +
                    "________________________________\n" +
                    "         FIND A FLIGHT        ");
            Menu findCustomerMenu = new Menu();
            findCustomerMenu.addOption("Search by origin");
            findCustomerMenu.addOption("Search by destination");
            findCustomerMenu.addOption("Search by departure time");
            findCustomerMenu.addOption("Search by airplane");
            findCustomerMenu.addOption("Back to customer menu");
            findCustomerMenu.showMenu();
            option = intValidator(Console.scanString(""));
            if (option != 0) {
                choiceFindFlightMenu(option);
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 5);
    }//--------------------------------------------------------- printFindFlightMenu

    public void choiceFindFlightMenu(int opt){
        switch (opt){
            case 1:
                findFlightOrigin();
                break;
            case 2:
                findFlightDestination();
                break;
            case 3:
                findFlightDepartureTime();
                break;
            case 4:
                findFlightAirplane();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }//--------------------------------------------------------- choiceFindFlightMenu

    public void findFlightOrigin() {
        repF.searchFlight(1, Console.scanString("Flight's origin:"));
    }//--------------------------------------------------------- findFlightOrigin

    public void findFlightDestination() {
        repF.searchFlight(2, Console.scanString("Flight's destination:"));
    }//--------------------------------------------------------- findFlightDestination

    public void findFlightDepartureTime() {
        repF.searchFlight(3, Console.scanString("Flight's departure time:"));
    }//--------------------------------------------------------- findFlightDepartureTime

    public void findFlightAirplane() {
        repF.searchFlight(4, Console.scanString("Flight's airplane:"));
    }//--------------------------------------------------------- findFlightAirplane

    public void listFlights() {
        System.out.println("\n" +
                "________________________________\n" +
                "         LIST FLIGHTS        ");
        repF.listFlights();
    }//--------------------------------------------------------- listFlights



    public void addAirplane() {
        System.out.println("\n" +
                "________________________________\n" +
                "          ADD AIRPLANE          ");
        String code = Console.scanString("Airplane's code:");
        String planeName = Console.scanString("Airplane's name:");
        int qntSeats = Console.scanInt("Airplane's seats:");
        repA.appendAirplane(code, planeName, qntSeats);
    }//--------------------------------------------------------- addAirplane

    public void printFindAirplaneMenu(){
        int option = 0;
        do {
            System.out.println("\n" +
                    "________________________________\n" +
                    "         FIND A AIRPLANE          ");
            Menu fAMenu = new Menu();
            fAMenu.addOption("Search by code");
            fAMenu.addOption("Search by name");
            fAMenu.addOption("Search by seats");
            fAMenu.addOption("Back to customer menu");
            fAMenu.showMenu();
            option = intValidator(Console.scanString(""));
            if (option != 0) {
                choiceFindAirplaneMenu(option);
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 4);
    }//--------------------------------------------------------- printFindAirplaneMenu

    public void choiceFindAirplaneMenu(int opt){
        switch (opt){
            case 1:
                findAirplaneCode();
                break;
            case 2:
                findAirplaneName();
                break;
            case 3:
                findAirplaneSeat();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }//--------------------------------------------------------- choiceFindAirplaneMenu

    public void findAirplaneCode() {
        repA.searchAirplane(1, Console.scanString("Airplane's code:"));
    }//--------------------------------------------------------- findAirplaneCode

    public void findAirplaneName() {
        repA.searchAirplane(2, Console.scanString("Airplane's name:"));
    }//--------------------------------------------------------- findAirplaneName

    public void findAirplaneSeat() {
        repA.searchAirplane(3, Console.scanString("Airplane's seat:"));
    }//--------------------------------------------------------- findAirplaneSeat

    public void listAirplanes() {
        System.out.println("\n" +
                "________________________________\n" +
                "         LIST AIRPLANES        ");
        repA.listAirplanes();
    }//--------------------------------------------------------- listAirplanes

}