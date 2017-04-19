package System;
import Menu.Menu;

public class Application {

    RepositoryCustomer repC = new RepositoryCustomer();

    public void exe(){
        repC.startAddCustomers();
        mainMenu();
    }

    public int intValidator(String opt) {
        try {
            int i = Integer.parseInt(opt);
            return i;
        } catch (java.lang.NumberFormatException e) {
            return 0;
        }
    }

    public void mainMenu() {
        int option = 0;
        do {
            System.out.println("\n" +
                    "________________________________\n" +
                    "           MAIN MENU            ");
            Menu mMenu = new Menu();
            mMenu.addOption("Customers");
            mMenu.addOption("Flight");
            mMenu.addOption("Planes");
            mMenu.addOption("Quit the application");
            mMenu.showMenu();
            option = intValidator(Console.scanString(""));
            if (option != 0) {
                mainMenuChoice(option);
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 4);
    }

    public void mainMenuChoice(int opt){
        switch (opt){
            case 1:
                printCustomerMenu();
                break;
            case 2:
                System.out.println("Flight menu");
                System.out.println("Under construction");
                break;
            case 3:
                System.out.println("Planes menu");
                System.out.println("Under construction");
                break;
            case 4:
                System.out.println("Closing the application.");
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

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
    }

    public void choiceCustomerMenu(int opt){
        switch (opt){
            case 1:
                addCustomer();
                break;
            case 2:
                findCustomerMenu();
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
    }

    public void findCustomerMenu(){
        int option = 0;
        do {
            System.out.println("\n" +
                    "________________________________\n" +
                    "         FIND A CUSTOMER        ");
            Menu findCustomerMenu = new Menu();
            findCustomerMenu.addOption("Search by name");
            findCustomerMenu.addOption("Search by ID");
            findCustomerMenu.addOption("Search by telephone");
            findCustomerMenu.addOption("Back to customer menu");
            findCustomerMenu.showMenu();
            option = intValidator(Console.scanString(""));
            if (option != 0) {
                findCustomerMenuChoice(option);
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 4);
    }

    public void findCustomerMenuChoice(int opt){
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
    }

    public void addCustomer() {
        System.out.println("\n" +
                "________________________________\n" +
                "          ADD CUSTOMER          ");
        String name = Console.scanString("Customer's name:");
        String id = Console.scanString("Customer's ID:");
        String phone = Console.scanString("Customer's phone number:");
        repC.appendCustomer(name, id, phone);
    }

    public void listCustomers() {
        System.out.println("\n" +
                "________________________________\n" +
                "         LIST CUSTOMERS         ");
        repC.listCustomers();
    }

    public void findCustName(){
        repC.searchCustomer(Console.scanString("Customer's name:"));
    }

    public void findCustId(){
        repC.searchCustomer(Console.scanString("Customer's ID:"));
    }

    public void findCustPhone(){
        repC.searchCustomer(Console.scanString("Customer's Telephone:"));
    }
}