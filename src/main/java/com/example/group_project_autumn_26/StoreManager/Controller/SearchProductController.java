
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

public class SearchProductController {

    @FXML private TextField searchField;

    @FXML private Label productIdLabel;
    @FXML private Label productNameLabel;
    @FXML private Label sizeLabel;
    @FXML private Label priceLabel;
    @FXML private Label quantityLabel;
    @FXML private Label messageLabel;

    @FXML
    public void searchProduct() {

        String searchValue = searchField.getText().trim();

        if (searchValue.isEmpty()) {
            messageLabel.setText("Please enter Product ID or Product Name.");
            return;
        }

        Product product = null;

        try {
            int productId = Integer.parseInt(searchValue);
            product = StoreManager.findProductById(productId);

        } catch (NumberFormatException e) {
            product = StoreManager.findProductByName(searchValue);
        }

        if (product == null) {
            clearDetails();
            messageLabel.setText("Product Not Found.");
            return;
        }

        productIdLabel.setText(String.valueOf(product.getProductId()));
        productNameLabel.setText(product.getProductName());
        sizeLabel.setText(product.getSize());
        priceLabel.setText(String.valueOf(product.getPrice()));
        quantityLabel.setText(String.valueOf(product.getQuantity()));

        messageLabel.setText("Product found successfully.");
    }

    private void clearDetails() {
        productIdLabel.setText("-");
        productNameLabel.setText("-");
        sizeLabel.setText("-");
        priceLabel.setText("-");
        quantityLabel.setText("-");
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
