package System;

public class Customer {

    private int customerKey;
    private String name;
    private String id;
    private String phone;

    public Customer(String n, String i, String p) {
        name = n;
        id = i;
        phone = p;
    }

    public Customer(int cK, String n, String i, String p){
        customerKey = cK;
        name = n;
        id = i;
        phone = p;
    }

    // ========== getters e setters ==========

    public int getCustomerKey() {
        return customerKey;
    }

    public void setCustomerKey(int customerID) {
        this.customerKey = customerID;
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
