package main.java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by sardor on 12/15/16.
 */
public class ReceptionistScreenController {
    @FXML
    private TextField mGNameField;

    @FXML
    private DatePicker mArrivalData;

    @FXML
    private TextField mSearchField;

    @FXML
    private TextField mPriceField;

    @FXML
    private TextField mCountDayField;

    @FXML
    private DatePicker mBirthdayDate;

    @FXML
    private Button mDeleteBtn;

    @FXML
    private Button mSearchBtn;

    @FXML
    private TextField mRoomNoField;

    @FXML
    private Button mEditBtn;

    @FXML
    private ChoiceBox<?> mRoomTypeChoice;

    @FXML
    private TextField mCountPeopleField;

    @FXML
    private ChoiceBox<?> mGenderChoice;

    @FXML
    private Button mCreatBtn;

    @FXML
    void onCreatBtnClicked(ActionEvent event) {

    }

    @FXML
    void onSearchClicked(ActionEvent event) {

    }

    @FXML
    void onEditClicked(ActionEvent event) {

    }

    @FXML
    void onDeleteClicked(ActionEvent event) {

    }

    @FXML
    void onExitClicked(ActionEvent event) throws IOException {
        Stage stage  = new Stage();
        Parent rootHotel = FXMLLoader.load(getClass().getResource("/main/layout/login_screen.fxml"));
        Scene scene = new Scene(rootHotel);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
