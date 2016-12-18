package main.java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by sardor on 12/15/16.
 */
public class LoginScreenController {
    Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private ChoiceBox mChoiceBox;

    @FXML
    private Button mLoginButton;

    @FXML
    private TextField mUserName;

    @FXML
    private PasswordField mPassword;


    @FXML
    void onLoginClicked(ActionEvent event) throws IOException {
        Parent adminParent;
        if(mChoiceBox.getSelectionModel().getSelectedItem().toString().equals("Manager")){
            adminParent = FXMLLoader.load(getClass().getResource("/main/layout/create_recept_screen.fxml"));
        }else{
            adminParent = FXMLLoader.load(getClass().getResource("/main/layout/receptionist_screen.fxml"));
        }
        Scene adminScene = new Scene(adminParent);
        Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        adminStage.setResizable(true);
        adminStage.hide();
        adminStage.setScene(adminScene);
        adminStage.show();
    }
}
