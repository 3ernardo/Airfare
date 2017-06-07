package Connector;

import DAO.CustomerDAO;
import System.Customer;

/**
 * Created by Bernardo on 07/06/2017.
 */
public class ConnectionTester {
    public static void main(String[] args) {
        new DAO.AirplaneDAO().registerPlane();

        Customer c1 = new Customer("Bernardo Araujo", "4489325", "98764-8688");
        Customer c2 = new Customer("Giuseppe Battaglino", "9635459", "98576-8669");
        CustomerDAO cDAO = new CustomerDAO();
        cDAO.create(c1);
        cDAO.create(c2);
    }
}
