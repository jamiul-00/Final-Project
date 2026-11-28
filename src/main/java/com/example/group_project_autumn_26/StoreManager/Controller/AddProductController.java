
package com.example.group_project_autumn_26.StoreManager.Controller;

import com.example.group_project_autumn_26.StoreManager.Model.Product;
import com.example.group_project_autumn_26.StoreManager.Model.StoreManager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AddProductController {

    @FXML private TextField productIdField;
    @FXML private TextField productNameField;
    @FXML private TextField sizeField;
    @FXML private TextField priceField;
    @FXML private TextField quantityField;

    @FXML private Label messageLabel;

    @FXML
    public void addProduct() {

        try {
            int productId = Integer.parseInt(
                    productIdField.getText().trim());

            String productName = productNameField.getText().trim();
            String size = sizeField.getText().trim();

            double price = Double.parseDouble(
                    priceField.getText().trim());

            int quantity = Integer.parseInt(
                    quantityField.getText().trim());

            if (productName.isEmpty() || size.isEmpty()) {
                messageLabel.setText("Please complete all product information.");
                return;
            }

            if (price <= 0 || quantity < 0) {
                messageLabel.setText(
                        "Price must be positive and quantity cannot be negative.");
                return;
            }

            if (StoreManager.findProductById(productId) != null) {
                messageLabel.setText("Product Already Exists.");
                return;
            }

            Product product = new Product(
                    productId, productName, size, price, quantity);

            StoreManager.addProduct(product);

            messageLabel.setText("Product Added Successfully.");

            productIdField.clear();
            productNameField.clear();
            sizeField.clear();
            priceField.clear();
            quantityField.clear();

        } catch (NumberFormatException e) {
            messageLabel.setText(
                    "Product ID, Price and Quantity must be valid numbers.");
        }
    }

    @FXML
    public void backToDashboard(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/com/example/group_project_autumn_26/StoreManager/store-manager-dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Store Manager Dashboard");
        stage.show();
    }
}
