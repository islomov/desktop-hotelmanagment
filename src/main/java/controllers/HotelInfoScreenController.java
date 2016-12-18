package main.java.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sardor on 12/18/16.
 */
public class HotelInfoScreenController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private TextField mCEO;

    @FXML
    private TextField mStaffNumber;

    @FXML
    private TextField mHotelName;

    @FXML
    private Button mSaveBtn;

    @FXML
    void onSaveBtnClicked(ActionEvent event) {

    }

}
