
package com.example.group_project_autumn_26;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    public void openDeliveryOfficer(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/example/group_project_autumn_26/DeliveryOfficer/delivery-officer-dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Delivery Officer Dashboard");
        stage.show();
    }

    @FXML
    public void openStoreManager(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/example/group_project_autumn_26/StoreManager/store-manager-dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Store Manager Dashboard");
        stage.show();
    }
}
