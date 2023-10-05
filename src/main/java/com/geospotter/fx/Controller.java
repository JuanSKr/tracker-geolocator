package com.geospotter.fx;

import com.geospotter.functionality.GeoIp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

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
    public void searchIp(ActionEvent event) {
        GeoIp geoip = new GeoIp();

        if (!geoip.checkIp(txtField.getText())) {
            txtArea.setText("You must enter a valid IP Adress.");
        } else {
            geoip.ipAdress(txtField.getText(), txtArea);
        }
    }

    public void cleanArea() {
        txtArea.clear();
        txtField.clear();
    }

    public void copyInfo() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();

        GeoIp geoip = new GeoIp();

        if (geoip.checkIp(txtField.getText())) {
            content.putString(txtArea.getText());
            clipboard.setContent(content);
        }


    }

}