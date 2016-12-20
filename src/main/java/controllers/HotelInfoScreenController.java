package main.java.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.DataBase.HotelDB;
import main.java.models.Hotel;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sardor on 12/18/16.
 */
public class HotelInfoScreenController implements Initializable {

    HotelDB db;

    @FXML
    AnchorPane mainRoot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db  = new HotelDB();
        Hotel hotel = db.getHotel();
        mCEOField.setText(hotel.getCeo());
        mHotelNameField.setText(hotel.getHotelName());
        mAddressField.setText(hotel.getAddress());
        mPhoneField.setText(hotel.getPhoneNumber());
        mSiteField.setText(hotel.getWebsite());
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
        db.updateHotel(getHotel());
        Stage stage  = (Stage) mainRoot.getScene().getWindow();
        stage.close();
    }

    private Hotel getHotel(){
        Hotel hotel = new Hotel();
        hotel.setCeo(mCEOField.getText());
        hotel.setAddress(mAddressField.getText());
        hotel.setWebsite(mSiteField.getText());
        hotel.setPhoneNumber(mPhoneField.getText());
        hotel.setHotelName(mHotelNameField.getText());
        return hotel;

    }
}
