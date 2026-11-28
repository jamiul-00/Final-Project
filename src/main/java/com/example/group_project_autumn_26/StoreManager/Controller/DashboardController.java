
package com.example.group_project_autumn_26.StoreManager.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    private void openScreen(ActionEvent event, String file, String title)
            throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/com/example/group_project_autumn_26/StoreManager/" + file));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    @FXML
    public void viewStoreInventory(ActionEvent event) throws IOException {
        openScreen(event, "store-inventory.fxml", "Store Inventory");
    }

    @FXML
    public void searchProduct(ActionEvent event) throws IOException {
        openScreen(event, "search-product.fxml", "Search Product");
    }

    @FXML
    public void addProduct(ActionEvent event) throws IOException {
        openScreen(event, "add-product.fxml", "Add Product");
    }

    @FXML
    public void updateProduct(ActionEvent event) throws IOException {
        openScreen(event, "update-product.fxml", "Update Product");
    }

    @FXML
    public void addStock(ActionEvent event) throws IOException {
        openScreen(event, "add-stock.fxml", "Add Stock");
    }
}
