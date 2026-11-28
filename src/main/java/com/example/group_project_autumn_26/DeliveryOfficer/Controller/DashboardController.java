
package com.example.group_project_autumn_26.DeliveryOfficer.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    private void openScreen(ActionEvent event, String file, String title)
            throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/com/example/group_project_autumn_26/DeliveryOfficer/" + file));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    @FXML
    public void viewAssignedDeliveries(ActionEvent event) throws IOException {
        openScreen(event, "assigned-deliveries.fxml", "View Assigned Deliveries");
    }

    @FXML
    public void viewDeliveryDetails(ActionEvent event) throws IOException {
        openScreen(event, "delivery-details.fxml", "View Delivery Details");
    }

    @FXML
    public void updateDeliveryStatus(ActionEvent event) throws IOException {
        openScreen(event, "update-delivery-status.fxml", "Update Delivery Status");
    }

    @FXML
    public void confirmDelivery(ActionEvent event) throws IOException {
        openScreen(event, "confirm-delivery.fxml", "Confirm Delivery");
    }

    @FXML
    public void reportFailedDelivery(ActionEvent event) throws IOException {
        openScreen(event, "report-failed-delivery.fxml", "Report Failed Delivery");
    }
}
