
package com.example.group_project_autumn_26.DeliveryOfficer.Controller;

import com.example.group_project_autumn_26.DeliveryOfficer.Model.Delivery;
import com.example.group_project_autumn_26.DeliveryOfficer.Model.DeliveryOfficer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DeliveryDetailsController {

    @FXML private TextField searchDeliveryIdField;
    @FXML private Label deliveryIdLabel;
    @FXML private Label orderIdLabel;
    @FXML private Label officerIdLabel;
    @FXML private Label receiverNameLabel;
    @FXML private Label deliveryDateLabel;
    @FXML private Label deliveryStatusLabel;
    @FXML private Label failureReasonLabel;

    @FXML
    public void findDelivery() {
        try {
            int id = Integer.parseInt(searchDeliveryIdField.getText().trim());
            Delivery delivery = DeliveryOfficer.findDeliveryById(id);

            if (delivery == null) {
                showMessage("Delivery not found.");
                return;
            }

            deliveryIdLabel.setText(String.valueOf(delivery.getDeliveryId()));
            orderIdLabel.setText(String.valueOf(delivery.getOrderId()));
            officerIdLabel.setText(String.valueOf(delivery.getUserId()));
            receiverNameLabel.setText(delivery.getReceiverName());
            deliveryDateLabel.setText(String.valueOf(delivery.getDeliveryDate()));
            deliveryStatusLabel.setText(delivery.getDeliveryStatus());
            failureReasonLabel.setText(delivery.getFailureReason());

        } catch (NumberFormatException e) {
            showMessage("Enter a valid Delivery ID.");
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
