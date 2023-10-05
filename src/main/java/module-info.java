module com.geospotter.geospotter {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.maxmind.geoip2;


    opens com.geospotter.fx to javafx.fxml;
    exports com.geospotter.fx;
}