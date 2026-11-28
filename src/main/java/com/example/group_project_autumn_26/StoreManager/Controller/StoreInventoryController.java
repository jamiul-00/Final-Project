
package com.example.group_project_autumn_26.StoreManager.Controller;

import com.example.group_project_autumn_26.StoreManager.Model.Product;
import com.example.group_project_autumn_26.StoreManager.Model.StoreManager;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StoreInventoryController {

    @FXML private TableView<Product> productTable;

    @FXML private TableColumn<Product, Integer> productIdColumn;
    @FXML private TableColumn<Product, String> productNameColumn;
    @FXML private TableColumn<Product, String> sizeColumn;
    @FXML private TableColumn<Product, Double> priceColumn;
    @FXML private TableColumn<Product, Integer> quantityColumn;

    @FXML
    public void initialize() {

        productIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("productId"));

        productNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("productName"));

        sizeColumn.setCellValueFactory(
                new PropertyValueFactory<>("size"));

        priceColumn.setCellValueFactory(
                new PropertyValueFactory<>("price"));

        quantityColumn.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));

        loadInventory();
    }

    public void loadInventory() {
        productTable.setItems(
                FXCollections.observableArrayList(
                        StoreManager.getProductList()));
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
