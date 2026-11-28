
package com.example.group_project_autumn_26.DeliveryOfficer.Controller;

import com.example.group_project_autumn_26.DeliveryOfficer.Model.Delivery;
import com.example.group_project_autumn_26.DeliveryOfficer.Model.DeliveryOfficer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfirmDeliveryController {

    @FXML private TextField deliveryIdField;
    @FXML private TextField receiverNameField;
    @FXML private Label orderIdLabel;
    @FXML private Label currentStatusLabel;
    @FXML private Label messageLabel;

    private Delivery selectedDelivery;

    @FXML
    public void findDelivery() {
        try {
            int id = Integer.parseInt(deliveryIdField.getText().trim());
            selectedDelivery = DeliveryOfficer.findDeliveryById(id);

            if (selectedDelivery == null) {
                messageLabel.setText("Delivery not found.");
                return;
            }

            orderIdLabel.setText(String.valueOf(selectedDelivery.getOrderId()));
            currentStatusLabel.setText(selectedDelivery.getDeliveryStatus());
            messageLabel.setText("Delivery found.");

        } catch (NumberFormatException e) {
            messageLabel.setText("Enter a valid Delivery ID.");
        }
    }

    @FXML
    public void confirmDelivery() {
        if (selectedDelivery == null) {
            messageLabel.setText("Find a delivery first.");
            return;
        }

        if (!"Out for Delivery".equalsIgnoreCase(
                selectedDelivery.getDeliveryStatus())) {
            messageLabel.setText(
                    "Only Out for Delivery orders can be confirmed.");
            return;
        }

        String receiver = receiverNameField.getText().trim();

        if (receiver.isEmpty()) {
            messageLabel.setText("Enter receiver name.");
            return;
        }

        selectedDelivery.setReceiverName(receiver);
        selectedDelivery.setDeliveryStatus("Delivered");
        DeliveryOfficer.saveDeliveries();

        currentStatusLabel.setText("Delivered");
        messageLabel.setText("Delivery Confirmed Successfully.");
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
