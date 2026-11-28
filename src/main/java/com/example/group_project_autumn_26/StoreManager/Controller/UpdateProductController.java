
package com.example.group_project_autumn_26.StoreManager.Controller;

import com.example.group_project_autumn_26.StoreManager.Model.Product;
import com.example.group_project_autumn_26.StoreManager.Model.StoreManager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateProductController {

    @FXML private TextField productIdField;
    @FXML private TextField sizeField;
    @FXML private TextField priceField;
    @FXML private TextField quantityField;

    @FXML private Label productNameLabel;
    @FXML private Label messageLabel;

    private Product selectedProduct;

    @FXML
    public void findProduct() {

        try {
            int productId = Integer.parseInt(
                    productIdField.getText().trim());

            selectedProduct = StoreManager.findProductById(productId);

            if (selectedProduct == null) {
                productNameLabel.setText("-");
                messageLabel.setText("Product Not Found.");
                return;
            }

            productNameLabel.setText(selectedProduct.getProductName());

            sizeField.setText(selectedProduct.getSize());
            priceField.setText(String.valueOf(selectedProduct.getPrice()));
            quantityField.setText(String.valueOf(selectedProduct.getQuantity()));

            messageLabel.setText("Product found. You can update its information.");

        } catch (NumberFormatException e) {
            messageLabel.setText("Enter a valid Product ID.");
        }
    }

    @FXML
    public void updateProduct() {

        if (selectedProduct == null) {
            messageLabel.setText("Find a product first.");
            return;
        }

        try {
            String size = sizeField.getText().trim();

            double price = Double.parseDouble(
                    priceField.getText().trim());

            int quantity = Integer.parseInt(
                    quantityField.getText().trim());

            if (size.isEmpty()) {
                messageLabel.setText("Please enter product size.");
                return;
            }

            if (price <= 0 || quantity < 0) {
                messageLabel.setText(
                        "Price must be positive and quantity cannot be negative.");
                return;
            }

            selectedProduct.setSize(size);
            selectedProduct.setPrice(price);
            selectedProduct.setQuantity(quantity);

            StoreManager.saveProducts();

            messageLabel.setText("Product Updated Successfully.");

        } catch (NumberFormatException e) {
            messageLabel.setText("Enter valid Price and Quantity.");
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
