package com.example.group_project_autumn_26;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerDashboardController
{
    @javafx.fxml.FXML
    private TableColumn<Customer,Float> priceTC;
    @javafx.fxml.FXML
    private ComboBox<String> genderCB;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> genderTC;
    @javafx.fxml.FXML
    private TextField searchShoesTF;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> categoryTC;
    @javafx.fxml.FXML
    private Label customerDashboardLabel;
    @javafx.fxml.FXML
    private TableColumn<Customer,Integer> idTC;
    @javafx.fxml.FXML
    private TableView<Customer> shoesTableView;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private ComboBox<Integer> sizeCB;
    @javafx.fxml.FXML
    private ComboBox<String> categoryCB;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> shoeNameTC;

    @javafx.fxml.FXML
    public void initialize() {


        categoryCB.getItems().addAll("All", "Formal", "Sneakers", "Casual", "Sandals");

        genderCB.getItems().addAll("All", "Men", "Women", "Kids", "Unisex");
        sizeCB.getItems().addAll(6, 7, 8, 9, 10, 11);

        // 2. Connect table columns to getters in Customer.java
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        shoeNameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryTC.setCellValueFactory(new PropertyValueFactory<>("category"));
        genderTC.setCellValueFactory(new PropertyValueFactory<>("gender"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));

        // 3. Load shoes into the table

    }

    @javafx.fxml.FXML
    public void returnAndReviewButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logoutButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void myCartButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void myOrdersButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addToCartButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchFilterButtonOA(ActionEvent actionEvent) {
    }
}