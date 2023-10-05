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
    private Button searchBtn;

    @FXML
    private Button cleanBtn;

    @FXML
    private Button copyBtn;

    @FXML
    private Button getIpBtn;

    @FXML
    private Button ipTrackerBtn;

    @FXML
    private Button backBtn;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView copiedImg;

    public void searchIp(ActionEvent event) {
        GeoIp geoip = new GeoIp();

        if (!geoip.checkIp(txtField.getText())) {
            txtArea.setText("You must enter a valid IP Adress.");
        } else {
            geoip.ipAdress(txtField.getText(), txtArea);
        }
    }

    public void getIp(ActionEvent event) {
        GeoIp geoip = new GeoIp();

        geoip.getIp(txtField.getText(), txtArea);
    }

    public void cleanArea() {
        txtArea.clear();
        txtField.clear();
    }

    public void copyInfo() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();

        GeoIp geoip = new GeoIp();

        content.putString(txtArea.getText());
        clipboard.setContent(content);
        copied();

    }

    public void getterButton() {
        App app = new App();

        try {
            app.goGetIp("getter.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void trackerButton() {
        App app = new App();

        try {
            app.goTrackIp("tracker.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void backButton() {
        App app = new App();

        try {
            app.goBack("enter.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void copied() {
        Delay delay = new Delay();

        copiedImg.setVisible(true);

        delay.copiedDelay(3000, copiedImg);
    }

}