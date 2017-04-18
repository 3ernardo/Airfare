package System;
import Menu.Menu;

public class Application {

    Repository rep = new Repository();

    public void exe(){
        rep.addCustomers();
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
            Menu mainMenu = new Menu();
            mainMenu.addOption("Customers");
            mainMenu.addOption("Flight");
            mainMenu.addOption("Planes");
            mainMenu.addOption("Quit the application");
            mainMenu.showMenu();
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
                customerMenu();
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

    public void customerMenu(){
        int option = 0;
        do {
            System.out.println("\n" +
                    "________________________________\n" +
                    "         CUSTOMER MENU          ");
            Menu customerMenu = new Menu();
            customerMenu.addOption("Add a customer");
            customerMenu.addOption("Find a customer");
            customerMenu.addOption("List all customers");
            customerMenu.addOption("Back to main menu");
            customerMenu.showMenu();
            option = intValidator(Console.scanString(""));
            if (option != 0) {
                customerMenuChoice(option);
            } else {
                System.out.println("Invalid option.");
            }
        } while (option != 4);
    }

    public void customerMenuChoice(int opt){
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
        rep.appendCustomer(name, id, phone);
    }

    public void listCustomers() {
        System.out.println("\n" +
                "________________________________\n" +
                "         LIST CUSTOMERS         ");
        rep.listCustomers();
    }

    public void findCustName(){
        rep.searchCustName(Console.scanString("Customer's name:"));
    }

    public void findCustId(){
        rep.searchCustId(Console.scanString("Customer's ID:"));
    }

    public void findCustPhone(){
        rep.searchCustPhone(Console.scanString("Customer's Telephone:"));
    }
}