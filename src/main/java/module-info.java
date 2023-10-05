module com.geospotter.geospotter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.geospotter.geospotter to javafx.fxml;
    exports com.geospotter.geospotter;
}