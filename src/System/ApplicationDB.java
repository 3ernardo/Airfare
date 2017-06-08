package System;

import Menu.Menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import DAO.CustomerDAO;
import System.Printer;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * Created by Giuseppe on 08/06/2017.
 */
public class ApplicationDB {


    RepositoryCustomer repC = new RepositoryCustomer();
    RepositoryFlight repF = new RepositoryFlight();
    RepositoryAirplane repA = new RepositoryAirplane();
    RepositorySales repS = new RepositorySales();

    DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void exe() {
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
        repF.appendFlight("Carapelle", "Eboli", LocalDateTime.parse("2017-07-10 22:00", dateForm), repA.getAnAirplane("Cirrus"));
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
            mMenu.addOption("Make a sale");
            mMenu.addOption("Sales report");
            mMenu.addOption("Quit the application");
            mMenu.showMenu();
            option = intValidator(Console.scanString(""));
            if (option != 0) {
                choiceMainMenu(option);
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 6);
    }//--------------------------------------------------------- printMainMenu

    public void choiceMainMenu(int opt) {
        switch (opt) {
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
                makeASale();
                break;
            case 5:
                //repS.listSales();
                printSalesMenu();
                break;
            case 6:
                System.out.println("Closing the application.");
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }//--------------------------------------------------------- choiceMainMenu

    //====================================================================================== 2º level

    public void printSalesMenu() {
        int option = 0;
        do {
            System.out.println("\n" +
                    "________________________________\n" +
                    "           SALES MENU           ");
            Menu sMenu = new Menu();
            sMenu.addOption("Sales report by customer");
            sMenu.addOption("Sales report by origin");
            sMenu.addOption("Sales report by destination");
            sMenu.addOption("Sales report by time period");
            sMenu.addOption("All sales report");
            sMenu.addOption("Back to main menu");
            sMenu.showMenu();
            option = intValidator(Console.scanString(""));
            if (option != 0) {
                choiceSalesMenu(option);
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 6);
    }//--------------------------------------------------------- printSalesMenu

    public void choiceSalesMenu(int opt) {
        switch (opt) {
            case 1:
                reportByCustomer();
                break;
            case 2:
                reportByOrigin();
                break;
            case 3:
                reportByDestination();
                break;
            case 4:
                reportByTime();
                break;
            case 5:
                repS.listSales();
            case 6:
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }//--------------------------------------------------------- choiceSalesMenu

    public void reportByCustomer() {
        String customerName = Console.scanString("Input customer's name:");
        repS.printSalesHeader();
        repS.printSalesByCustomer(customerName);
    }

    public void reportByOrigin() {
        String flightOrigin = Console.scanString("Input origin:");
        repS.printSalesHeader();
        repS.printSalesByOrigin(flightOrigin);
    }

    public void reportByDestination() {
        String flightDest = Console.scanString("Input destination:");
        repS.printSalesHeader();
        repS.printSalesByDestination(flightDest);
    }

    public void reportByTime() {
        String tempStart;
        String tempFinish;
        String error;

        do {
            tempStart = Console.scanString("Earlier date (YYYY-MM-DD hh:mm):");
            error = "Invalid date, please use the following format: 'YYYY-MM-DD hh:mm'.";
        } while (!validator(tempStart, Validators.flightDateTimeValidator, error));
        do {
            tempFinish = Console.scanString("Later date (YYYY-MM-DD hh:mm):");
            error = "Invalid date, please use the following format: 'YYYY-MM-DD hh:mm'.";
        } while (!validator(tempFinish, Validators.flightDateTimeValidator, error));

        repS.printSalesHeader();
        repS.printSalesByDate(tempStart, tempFinish);
    }


    public void printCustomerMenu() {
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

    public void choiceCustomerMenu(int opt) {
        switch (opt) {
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
        switch (opt) {
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
        switch (opt) {
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
        String name;
        String id;
        String phone;
        String error;

        outerbreak:
        for (int i = 0; i < 1; i++) {
            System.out.println("\n" +
                    "________________________________\n" +
                    "          ADD CUSTOMER          ");
            // Customer name
            do {
                name = Console.scanString("Customer's name:");
                if (name.equalsIgnoreCase("exit")) break outerbreak;
                error = "Invalid name, must contain only letters and spaces.";
            } while (!validator(name, Validators.customerNameValidator, error));
            // Customer ID
            do {
                id = Console.scanString("Customer's ID:");
                if (id.equalsIgnoreCase("exit")) break outerbreak;
                if (repC.validID(id)) {
                    System.out.println("This ID already exists.");
                    break outerbreak;
                }
                error = "Invalid ID, must contain from six to nine digits, only numbers allowed.";
            } while (!validator(id, Validators.customerIdValidator, error));
            // Customer phone
            do {
                phone = Console.scanString("Customer's phone number:");
                if (phone.equalsIgnoreCase("exit")) break outerbreak;
                error = "Invalid phone, must contain only numbers and dashes.";
            } while (!validator(phone, Validators.customerPhoneValidator, error));

            Customer c = new Customer(name, id, phone);
            CustomerDAO cDAO = new CustomerDAO();
            cDAO.create(c);
        }
    }//--------------------------------------------------------- addCustomer

    public boolean validator(String toTest, String testAgainst, String errorMessage) {
        if (toTest.matches(testAgainst)) {
            return true;
        } else {
            System.out.println(errorMessage);
            System.out.println("Type 'exit' to cancel the input.");
            return false;
        }
    }

    public boolean futureDateValidator(LocalDateTime toTest) {
        if (toTest.isAfter(LocalDateTime.now()) && toTest.isBefore(LocalDateTime.now().plusYears(10))) {
            return true;
        } else {
            System.out.println("Invalid period, the date must be in the future and 10 years at most.");
            return false;
        }
    }


    public void printFindCustomerMenu() {
        int option = 0;
        do {
            System.out.println("\n" +
                    "________________________________\n" +
                    "         FIND A CUSTOMER        ");
            Menu fCMenu = new Menu();
            fCMenu.addOption("Search by name");
            fCMenu.addOption("Search by ID");
            fCMenu.addOption("Search by telephone");
            fCMenu.addOption("Search by key");
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

    public void choiceFindCustomerMenu(int opt) {
        switch (opt) {
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
                findCustKey();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    public void checkIsEmpty(List<Customer> lst){
        if (lst.isEmpty()){
            System.out.println("This search did not produce results.");
        } else {
            Printer.printCustomerHeader();
            for(Customer c : lst) {
                Printer.printCustomer(c);
            }
        }
    }

    public void findCustName() {
        CustomerDAO cDAO = new CustomerDAO();
        List<Customer> customers = cDAO.findByName(Console.scanString("Customer's name:"));

       checkIsEmpty(customers);
    }

    public void findCustId() {
        CustomerDAO cDAO = new CustomerDAO();
        List<Customer> customers = cDAO.findById(Console.scanString("Customer's ID:"));

        checkIsEmpty(customers);
    }

    public void findCustPhone() {
        CustomerDAO cDAO = new CustomerDAO();
        List<Customer> customers = cDAO.findByPhone(Console.scanString("Customer's Telephone:"));

        checkIsEmpty(customers);
    }

    public void findCustKey() {
        CustomerDAO cDAO = new CustomerDAO();
        Customer customers = cDAO.findByKey(Console.scanString("Customer's key:"));

        if (customers == null){
            System.out.println("This search did not produce results.");
        } else {
            Printer.printCustomerHeader();
            Printer.printCustomer(customers);
        }

    }

    public void listCustomers() {
        System.out.println("\n" +
                "________________________________\n" +
                "        CUSTOMERS LIST          ");

        CustomerDAO cDAO = new CustomerDAO();
        Printer.printCustomerHeader();
        for (Customer c : cDAO.read()) {
            Printer.printCustomer(c);
        }
    }//--------------------------------------------------------- listCustomers

    public void makeASale() {
        listCustomers(); //optional listing
        listFlights(); //optional listing
        System.out.println("\n" +
                "________________________________\n" +
                "           MAKE A SALE          ");
        boolean valid = false;
        Customer cust = null;
        Flight flig = null;
        String id;
        String code;
        String error;

        outerbreak:
        for (int i = 0; i < 1; i++) {
            do {
                valid = false;
                id = Console.scanString("Customer's ID:");
                if (id.equalsIgnoreCase("exit")) break outerbreak;
                if (repC.getACustomerByID(id) != null) valid = true;
                else System.out.println("This ID does not exist.");
                error = "Invalid customer ID.";
            } while (!validator(id, Validators.customerIdValidator, error) || !valid);
            cust = repC.getACustomerByID(id);
            do {
                valid = false;
                code = Console.scanString("Flight code:");
                if (code.equalsIgnoreCase("exit")) break outerbreak;
                if (repF.getAFlight(code) != null) valid = true;
                else System.out.println("This code does not exist.");
                error = "Invalid flight code.";
            } while (!validator(code, Validators.flightCodeValidator, error) || !valid);
            flig = repF.getAFlight(code);

            if (repS.appendSale(cust, flig)) {
                System.out.println("Sale successful.");
            } else {
                System.out.println("WARNING:\nThe sale could not be completed.");
            }
        }
    }

    public void addFlight() {
        String origin;
        String destination;
        String tempTime;
        LocalDateTime departureTime = null;
        String tempPlane;
        Airplane designatedPlane = null;
        String error;
        boolean valid;

        outerbreak:
        for (int i = 0; i < 1; i++) {
            System.out.println("\n" +
                    "________________________________\n" +
                    "          ADD FLIGHT          ");
            // Flight origin
            do {
                origin = Console.scanString("Flight's origin:");
                if (origin.equalsIgnoreCase("exit")) break outerbreak;
                error = "Invalid origin, must contain only letters and spaces.";
            } while (!validator(origin, Validators.flightOrigDestValidator, error));
            // Flight destination
            do {
                destination = Console.scanString("Flight's destination:");
                if (destination.equalsIgnoreCase("exit")) break outerbreak;
                error = "Invalid destination, must contain only letters and spaces.";
            } while (!validator(destination, Validators.flightOrigDestValidator, error));
            // Flight time
            do {
                do {
                    tempTime = Console.scanString("Flight's date format(YYYY-MM-DD hh:mm):");
                    if (tempTime.equalsIgnoreCase("exit")) break outerbreak;
                    error = "Invalid date, please use the following format: 'YYYY-MM-DD hh:mm'.";
                } while (!validator(tempTime, Validators.flightDateTimeValidator, error));
                departureTime = LocalDateTime.parse(tempTime, dateForm);
            } while (!futureDateValidator(departureTime));
            // Flight plane
            do {
                tempPlane = Console.scanString("Flight's airplane:");
                if (repA.planeValid(tempPlane) == true) {
                    designatedPlane = repA.getAnAirplane(tempPlane);
                } else {
                    System.out.println("Invalid airplane, please check the available aircrafts.");
                }
                if (tempPlane.equalsIgnoreCase("exit")) break outerbreak;
            } while (!repA.planeValid(tempPlane));

            repF.appendFlight(origin, destination, departureTime, designatedPlane);
        }
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

    public void choiceFindFlightMenu(int opt) {
        switch (opt) {
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
        String code;
        String planeName;
        int qntSeats = 0;
        String error;

        outerbreak:
        for (int i = 0; i < 1; i++) {
            System.out.println("\n" +
                    "________________________________\n" +
                    "          ADD AIRPLANE          ");
            // Plane code
            do {
                code = Console.scanString("Airplane's code (AAA-0000):");
                if (code.equalsIgnoreCase("exit")) break outerbreak;
                if (repA.validCode(code)) {
                    System.out.println("This code already exists.");
                    break outerbreak;
                }
                error = "Invalid code, please use the following format: 'AAA-0000'.";
            } while (!validator(code, Validators.airplaneCodeValidator, error));
            // Plane name
            do {
                planeName = Console.scanString("Airplane's name:");
                if (planeName.equalsIgnoreCase("exit")) break outerbreak;
                error = "Invalid name, use only letters and numbers.";
            } while (!validator(planeName, Validators.airplaneNameValidator, error));
            // Plane seats
            do {
                try {
                    qntSeats = Console.scanInt("Airplane's seats:");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input, insert a round number.");
                }
            } while (qntSeats == 0);

            repA.appendAirplane(code, planeName, qntSeats);
        }
    }//--------------------------------------------------------- addAirplane

    public void printFindAirplaneMenu() {
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

    public void choiceFindAirplaneMenu(int opt) {
        switch (opt) {
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
