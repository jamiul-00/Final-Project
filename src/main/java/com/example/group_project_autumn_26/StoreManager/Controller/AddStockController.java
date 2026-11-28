
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

public class AddStockController {

    @FXML private TextField productIdField;
    @FXML private TextField receivedQuantityField;

    @FXML private Label productNameLabel;
    @FXML private Label currentQuantityLabel;
    @FXML private Label updatedQuantityLabel;
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
                currentQuantityLabel.setText("-");
                updatedQuantityLabel.setText("-");
                messageLabel.setText("Product Not Found.");
                return;
            }

            productNameLabel.setText(selectedProduct.getProductName());

            currentQuantityLabel.setText(
                    String.valueOf(selectedProduct.getQuantity()));

            updatedQuantityLabel.setText("-");

            messageLabel.setText("Product found.");

        } catch (NumberFormatException e) {
            messageLabel.setText("Enter a valid Product ID.");
        }
    }

    @FXML
    public void addStock() {

        if (selectedProduct == null) {
            messageLabel.setText("Find a product first.");
            return;
        }

        try {
            int receivedQuantity = Integer.parseInt(
                    receivedQuantityField.getText().trim());

            if (receivedQuantity <= 0) {
                messageLabel.setText(
                        "Received quantity must be a positive number.");
                return;
            }

            StoreManager.addStock(selectedProduct, receivedQuantity);

            currentQuantityLabel.setText(
                    String.valueOf(selectedProduct.getQuantity()));

            updatedQuantityLabel.setText(
                    String.valueOf(selectedProduct.getQuantity()));

            messageLabel.setText("Stock Added Successfully.");

            receivedQuantityField.clear();

        } catch (NumberFormatException e) {
            messageLabel.setText("Enter a valid received quantity.");
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
