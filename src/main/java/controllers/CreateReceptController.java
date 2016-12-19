package main.java.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import main.java.DataBase.ReceptionistDB;
import main.java.models.Receptionist;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sardor on 12/18/16.
 */
public class CreateReceptController implements Initializable {


    @FXML
    private TextField mUserNameField;

    @FXML
    private TableColumn<Receptionist, String> mColumnLastName;

    @FXML
    private TableColumn<Receptionist, String> mColumnBirthday;

    @FXML
    private TableColumn<Receptionist, Boolean> mColumnMarried;

    @FXML
    private ChoiceBox<?> mMarriedChoice;

    @FXML
    private TextField mSearchField;

    @FXML
    private TableColumn<Receptionist, String> mColumnGender;

    @FXML
    private DatePicker mBirthdayDate;

    @FXML
    private TextField mLastNameField;

    @FXML
    private TextField mPassword;

    @FXML
    private TableColumn<?, ?> mColumnNo;

    @FXML
    private Button mDeleteBtn;

    @FXML
    private Button mCreateBtn;

    @FXML
    private Button mSearchBtn;

    @FXML
    private Button mEditBtn;

    @FXML
    private ChoiceBox<?> mExperienceChoice;

    @FXML
    private TableView<Receptionist> mTableView;

    @FXML
    private TableColumn<Receptionist, String> mColumnExperience;

    @FXML
    private ChoiceBox<?> mGenderChoice;

    @FXML
    private TableColumn<Receptionist, String> mColumnName;

    @FXML
    private TextField mNameField;

    ReceptionistDB db;
    static ObservableList<Receptionist> receptionists;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new ReceptionistDB();
        receptionists = FXCollections.observableList(db.getAllReceptionists());
        mColumnName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        mColumnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        mColumnGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        mColumnBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        mColumnExperience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        mColumnMarried.setCellValueFactory(new PropertyValueFactory<>("married"));
        mTableView.setItems(receptionists);
    }

    @FXML
    void onCreateClicked(ActionEvent event) {
        Receptionist receptionist = new Receptionist();
        receptionist.setUserName(mUserNameField.getText());
        receptionist.setPassword(mPassword.getText());
        receptionist.setFirstName(mNameField.getText());
        receptionist.setLastName(mLastNameField.getText());
        receptionist.setGender(mGenderChoice.getSelectionModel().getSelectedItem().toString());
        receptionist.setExperience(mExperienceChoice.getSelectionModel().getSelectedItem().toString());
        boolean isMarried = mMarriedChoice.getSelectionModel().getSelectedIndex() == 0;
        receptionist.setMarried(isMarried);
        receptionist.setBirthday(mBirthdayDate.getValue().toString());
        db.addReceptionist(receptionist);
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

}
