package main.java.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by sardor on 12/20/16.
 */

public class ReceptProfileScreenController {

    @FXML
    private AnchorPane mainRoot;

    @FXML
    private ChoiceBox<?> mGenderChoiceBox;

    @FXML
    private TextField mPasswordField;

    @FXML
    private TextField mUserNameField;

    @FXML
    private ChoiceBox<?> mMarriedChoiceBox;



    @FXML
    private DatePicker mBirthDate;

    @FXML
    private ChoiceBox<?> mExperienceChoiceBox;

    @FXML
    private TextField mLastNameField;

    @FXML
    private TextField mNameField;

    @FXML
    void onSaveBtnClicked(ActionEvent event) {
        Stage stage  = (Stage) mainRoot.getScene().getWindow();
        stage.close();
    }

}
