
package com.example.group_project_autumn_26.StoreManager.Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class StoreManager {

    private static ArrayList<Product> productList = loadProducts();

    public StoreManager() {
    }

    public static ArrayList<Product> getProductList() {
        return productList;
    }

    public static Product findProductById(int productId) {
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public static Product findProductByName(String productName) {
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public static void addProduct(Product product) {
        productList.add(product);
        saveProducts();
    }

    public static void addStock(Product product, int receivedQuantity) {
        product.setQuantity(product.getQuantity() + receivedQuantity);
        saveProducts();
    }

    public static void saveProducts() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream("products.dat"));

            output.writeObject(productList);
            output.close();

        } catch (IOException e) {
            System.out.println("Could not save product records.");
        }
    }

    private static ArrayList<Product> loadProducts() {
        try {
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream("products.dat"));

            ArrayList<Product> savedList =
                    (ArrayList<Product>) input.readObject();

            input.close();
            return savedList;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
