package main.java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sardor on 12/16/16.
 */
public class ManagerScreenController implements Initializable{

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
    private TableColumn mColumnGender;

    @FXML
    private DatePicker mBirthdayDate;

    @FXML
    private TextField mLastNameField;

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


    @FXML
    void onCreateBtnClicked(ActionEvent event) {

    }

    @FXML
    void onSearchBtnClicked(ActionEvent event) {

    }

    @FXML
    void onEditBtnClicked(ActionEvent event) {

    }

    @FXML
    void onDeleteBtnClicked(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
