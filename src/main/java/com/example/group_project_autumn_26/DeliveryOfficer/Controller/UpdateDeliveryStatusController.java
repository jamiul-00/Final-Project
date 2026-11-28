
package com.example.group_project_autumn_26.DeliveryOfficer.Controller;

import com.example.group_project_autumn_26.DeliveryOfficer.Model.Delivery;
import com.example.group_project_autumn_26.DeliveryOfficer.Model.DeliveryOfficer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateDeliveryStatusController {

    @FXML private TextField deliveryIdField;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private Label currentStatusLabel;
    @FXML private Label messageLabel;

    private Delivery selectedDelivery;

    @FXML
    public void initialize() {
        statusComboBox.setItems(FXCollections.observableArrayList(
                "Pending",
                "Out for Delivery",
                "Delivered",
                "Failed"
        ));
    }

    @FXML
    public void findDelivery() {
        try {
            int id = Integer.parseInt(deliveryIdField.getText().trim());
            selectedDelivery = DeliveryOfficer.findDeliveryById(id);

            if (selectedDelivery == null) {
                currentStatusLabel.setText("Not found");
                messageLabel.setText("Delivery not found.");
                return;
            }

            currentStatusLabel.setText(selectedDelivery.getDeliveryStatus());
            messageLabel.setText("Delivery found.");

        } catch (NumberFormatException e) {
            messageLabel.setText("Enter a valid Delivery ID.");
        }
    }

    @FXML
    public void updateStatus() {
        if (selectedDelivery == null) {
            messageLabel.setText("Find a delivery first.");
            return;
        }

        String newStatus = statusComboBox.getValue();

        if (newStatus == null) {
            messageLabel.setText("Please select a status.");
            return;
        }

        selectedDelivery.setDeliveryStatus(newStatus);
        DeliveryOfficer.saveDeliveries();

        currentStatusLabel.setText(newStatus);
        messageLabel.setText("Delivery status updated successfully.");
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
}
