
package com.example.group_project_autumn_26.StoreManager.Model;

import java.io.Serializable;

public class Product implements Serializable {

    private int productId;
    private String productName;
    private String size;
    private double price;
    private int quantity;

    public Product(int productId, String productName, String size,
                   double price, int quantity) {

        this.productId = productId;
        this.productName = productName;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                ", Name: " + productName +
                ", Size: " + size +
                ", Price: " + price +
                ", Quantity: " + quantity;
    }
}
