
module com.example.group_project_autumn_26 {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.group_project_autumn_26 to javafx.fxml;

    opens com.example.group_project_autumn_26.DeliveryOfficer.Controller
            to javafx.fxml;

    opens com.example.group_project_autumn_26.DeliveryOfficer.Model
            to javafx.base;

    opens com.example.group_project_autumn_26.StoreManager.Controller
            to javafx.fxml;

    opens com.example.group_project_autumn_26.StoreManager.Model
            to javafx.base;

    exports com.example.group_project_autumn_26;
}
