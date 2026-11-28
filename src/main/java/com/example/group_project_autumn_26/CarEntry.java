package com.example.group_project_autumn_26;

public class CarEntry {
    private String id;
    private String shoeName;
    private String category;
    private int size;
    private int quantity;
    private float price;

    public CarEntry(String id, String shoeName, String category, int size, int quantity, float price) {
        this.id = id;
        this.shoeName = shoeName;
        this.category = category;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarEntry{" +
                "id='" + id + '\'' +
                ", shoeName='" + shoeName + '\'' +
                ", category='" + category + '\'' +
                ", size=" + size +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

