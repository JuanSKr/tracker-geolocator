package com.geospotter.fx;

import com.geospotter.functionality.Delay;
import com.geospotter.functionality.GeoIp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField txtField;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button searchBtn, cleanBtn, copyBtn, getIpBtn, ipTrackerBtn, backBtn;

    @FXML
    private ImageView copiedImg, logo;

    /**
     * Handles the action event for searching and displaying geolocation information for an IP address.
     *
     * @param event The ActionEvent associated with the search action.
     */

    public void searchIp(ActionEvent event) {
        GeoIp geoip = new GeoIp();

        if (!geoip.checkIp(txtField.getText())) {
            txtArea.setText("You must enter a valid IP Adress.");
        } else {
            geoip.ipAdress(txtField.getText(), txtArea);
        }
    }

    /**
     * Handles the action event for retrieving and displaying the IP address.
     *
     * @param event The ActionEvent associated with the retrieval action.
     */

    public void getIp(ActionEvent event) {
        GeoIp geoip = new GeoIp();

        geoip.getIp(txtField.getText(), txtArea);
    }

    /**
     * Clears the content of the TextArea and the input TextField.
     */

    public void cleanArea() {
        txtArea.clear();
        txtField.clear();
    }

    /**
     * Copies the content of the TextArea to the system clipboard and triggers a notification.
     */

    public void copyInfo() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();

        GeoIp geoip = new GeoIp();

        content.putString(txtArea.getText());
        clipboard.setContent(content);
        copied();

    }

    /**
     * Handles the action when the "Getter" button is clicked to navigate to the Getter scene.
     */

    public void getterButton() {
        App app = new App();

        try {
            app.goGetIp("getter.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handles the action when the "Tracker" button is clicked to navigate to the Tracker scene.
     */

    public void trackerButton() {
        App app = new App();

        try {
            app.goTrackIp("tracker.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handles the action when the "Back" button is clicked to navigate back to the Enter scene.
     */

    public void backButton() {
        App app = new App();

        try {
            app.goBack("enter.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handles the action when content is copied and displays a copied indicator for a brief duration.
     */

    public void copied() {
        Delay delay = new Delay();

        copiedImg.setVisible(true);

        delay.copiedDelay(3000, copiedImg);
    }

}