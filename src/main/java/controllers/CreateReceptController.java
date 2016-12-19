package main.java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sardor on 12/18/16.
 */
public class CreateReceptController implements Initializable {

    @FXML
    private TableColumn<?, ?> mColumnLastName;

    @FXML
    private TableColumn<?, ?> mColumnBirthday;

    @FXML
    private TableColumn<?, ?> mColumnMarried;

    @FXML
    private ChoiceBox<?> mMarriedChoice;

    @FXML
    private TextField mSearchField;

    @FXML
    private TableColumn<?, ?> mColumnGender;

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
    private TableView<?> mTableView;

    @FXML
    private TableColumn<?, ?> mColumnExperience;

    @FXML
    private ChoiceBox<?> mGenderChoice;

    @FXML
    private TableColumn<?, ?> mColumnName;

    @FXML
    private TextField mNameField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void onCreateClicked(ActionEvent event) {

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
