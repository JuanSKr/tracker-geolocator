package com.geospotter.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fx/enter.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stg.setTitle("GeoSpotter");
        stg.setScene(scene);
        stg.show();
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * Loads and navigates to a new scene represented by the specified FXML file.
     *
     * @param fxml The path to the FXML file representing the new scene.
     * @throws IOException If an error occurs while loading the FXML file.
     */

    public void goGetIp(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fx/getter.fxml")));
        stg.getScene().setRoot(pane);
    }

    /**
     * Loads and navigates to a new scene represented by the specified FXML file for IP tracking.
     *
     * @param fxml The path to the FXML file representing the IP tracking scene.
     * @throws IOException If an error occurs while loading the FXML file.
     */

    public void goTrackIp(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fx/tracker.fxml")));
        stg.getScene().setRoot(pane);
    }

    /**
     * Loads and navigates back to a previous scene represented by the specified FXML file.
     *
     * @param fxml The path to the FXML file representing the previous scene.
     * @throws IOException If an error occurs while loading the FXML file.
     */

    public void goBack(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fx/enter.fxml")));
        stg.getScene().setRoot(pane);
    }
}