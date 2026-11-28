
package com.example.group_project_autumn_26.DeliveryOfficer.Controller;

import com.example.group_project_autumn_26.DeliveryOfficer.Model.Delivery;
import com.example.group_project_autumn_26.DeliveryOfficer.Model.DeliveryOfficer;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class AssignedDeliveriesController {

    @FXML private TableView<Delivery> deliveryTable;
    @FXML private TableColumn<Delivery, Integer> deliveryIdColumn;
    @FXML private TableColumn<Delivery, Integer> orderIdColumn;
    @FXML private TableColumn<Delivery, String> deliveryStatusColumn;

    @FXML private TextField deliveryIdField;
    @FXML private TextField orderIdField;
    @FXML private TextField deliveryStatusField;
    @FXML private TextField receiverNameField;
    @FXML private TextField deliveryDateField;

    private int loggedInOfficerId = 101;

    @FXML
    public void initialize() {
        deliveryIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("deliveryId"));
        orderIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("orderId"));
        deliveryStatusColumn.setCellValueFactory(
                new PropertyValueFactory<>("deliveryStatus"));

        loadAssignedDeliveries();
    }

    public void loadAssignedDeliveries() {
        deliveryTable.setItems(
                FXCollections.observableArrayList(
                        DeliveryOfficer.getDeliveryList()));

        deliveryTable.getItems().removeIf(
                delivery -> delivery.getUserId() != loggedInOfficerId);
    }

    @FXML
    public void addDelivery() {
        try {
            int deliveryId = Integer.parseInt(deliveryIdField.getText().trim());
            int orderId = Integer.parseInt(orderIdField.getText().trim());

            String status = deliveryStatusField.getText().trim();
            String receiver = receiverNameField.getText().trim();
            LocalDate date = LocalDate.parse(deliveryDateField.getText().trim());

            if (status.isEmpty()) {
                showMessage("Please enter delivery status.");
                return;
            }

            if (DeliveryOfficer.findDeliveryById(deliveryId) != null) {
                showMessage("Delivery ID already exists.");
                return;
            }

            Delivery delivery = new Delivery(
                    deliveryId, orderId, loggedInOfficerId,
                    status, receiver, date);

            DeliveryOfficer.addDelivery(delivery);
            loadAssignedDeliveries();

            deliveryIdField.clear();
            orderIdField.clear();
            deliveryStatusField.clear();
            receiverNameField.clear();
            deliveryDateField.clear();

            showMessage("Delivery added successfully.");

        } catch (NumberFormatException e) {
            showMessage("Delivery ID and Order ID must be numbers.");
        } catch (Exception e) {
            showMessage("Enter the date in YYYY-MM-DD format.");
        }
    }

    @FXML
    public void backToDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/com/example/group_project_autumn_26/DeliveryOfficer/delivery-officer-dashboard.fxml"));

        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Delivery Officer Dashboard");
        stage.show();
    }

    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
