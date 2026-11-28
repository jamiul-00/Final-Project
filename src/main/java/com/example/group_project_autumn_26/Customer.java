package com.example.group_project_autumn_26;

public class Customer extends User {
    private String shippingAddress;
    private String name;
    private String category;
    private String gender;
    private Float price;

    public Customer(String id, String password, String name, String shippingAddress, String category, String gender, Float price) {
        super(id, password);
        this.name = name;
        this.shippingAddress = shippingAddress;
        this.category = category;
        this.gender = gender;
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

    public String getGender() {
        return gender;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Customer(String id, String password, String shippingAddress) {
        super(id, password);
        this.shippingAddress = shippingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "shippingAddress='" + shippingAddress + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", gender='" + gender + '\'' +
                ", price=" + price +
                '}';
    }
}

