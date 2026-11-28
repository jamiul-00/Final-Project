package com.example.group_project_autumn_26;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerCartController
{
    @javafx.fxml.FXML
    private TableView<Customer> myCartTableView;
    @javafx.fxml.FXML
    private TableColumn<Customer,Integer> idTC;
    @javafx.fxml.FXML
    private TableColumn<Customer,Float> priceTC;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> shoeNameTC;
    @javafx.fxml.FXML
    private TableColumn<Customer,String> categoryTC;
    @javafx.fxml.FXML
    private TableColumn<Customer,Integer> quantityTC;
    @javafx.fxml.FXML
    private TableColumn<Customer,Integer> sizeTC;
    @javafx.fxml.FXML
    private Text shippingAddresssText;
    @javafx.fxml.FXML
    private Text totalAmountText;
    @javafx.fxml.FXML
    private Text phoneNumberText;

    @javafx.fxml.FXML
    public void initialize() {

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        shoeNameTC.setCellValueFactory(new PropertyValueFactory<>("shoeName"));
        categoryTC.setCellValueFactory(new PropertyValueFactory<>("category"));
        sizeTC.setCellValueFactory(new PropertyValueFactory<>("size"));
        quantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));


        shippingAddresssText.setText("Dhanmondi, Dhaka");
        phoneNumberText.setText("0171111111");




    }

    @javafx.fxml.FXML
    public void removeSelectedItemsOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("CustomerDashboard.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();


    @javafx.fxml.FXML
    public void confirmOrderButtonOA(ActionEvent actionEvent) {
    }
