package main.java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.java.models.Receptionist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sardor on 12/15/16.
 */
public class ReceptionistScreenController implements Initializable{

    Receptionist receptionist;


    @FXML
    Parent root;

    @FXML
    private TextField mGNameField;

    @FXML
    private DatePicker mArrivalData;

    @FXML
    private Text mReceptUserNameField;

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
    private ChoiceBox<?> mRoomNoChoiceBox;


    @FXML
    private Text mReceptGenderField;



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
    void onShowRoomsClicked(ActionEvent event) {

    }


    @FXML
    void onReceptProfileClicked(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        Parent adminRoot = FXMLLoader.load(getClass().getResource("/main/layout/receptionist_profile_screen.fxml"));
        Scene scene = new Scene(adminRoot);
        newStage.setScene(scene);
        newStage.setResizable(false);
        newStage.show();
    }

    @FXML
    void onExitClicked(ActionEvent event) throws IOException {
        Stage stage  = (Stage) root.getScene().getWindow();
        stage.close();

        Stage newStage = new Stage();
        Parent adminRoot = FXMLLoader.load(getClass().getResource("/main/layout/login_screen.fxml"));
        Scene scene = new Scene(adminRoot);
        newStage.setScene(scene);
        newStage.setResizable(false);
        newStage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        receptionist = LoginScreenController.receptionist;
    }
}
