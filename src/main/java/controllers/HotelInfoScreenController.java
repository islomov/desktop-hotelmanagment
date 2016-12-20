package main.java.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sardor on 12/18/16.
 */
public class HotelInfoScreenController implements Initializable {

    @FXML
    AnchorPane mainRoot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private TextField mCEOField;

    @FXML
    private TextField mHotelNameField;

    @FXML
    private TextField mAddressField;


    @FXML
    private TextField mPhoneField;

    @FXML
    private TextField mSiteField;

    @FXML
    private Button mSaveBtn;


    @FXML
    void onSaveBtnClicked(ActionEvent event) {
        Stage stage  = (Stage) mainRoot.getScene().getWindow();
        stage.close();
    }

}
