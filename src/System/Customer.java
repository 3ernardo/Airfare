package System;

public class Customer {

    private int customerID;
    private String name;
    private String id;
    private String phone;

    public Customer(String n, String i, String p) {
        name = n;
        id = i;
        phone = p;
    }

    public Customer(int cID, String n, String i, String p){
        customerID = cID;
        name = n;
        id = i;
        phone = p;
    }

    // ========== getters e setters ==========

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
