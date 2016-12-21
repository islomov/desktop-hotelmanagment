package main.java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.java.DataBase.ReceptionistDB;
import main.java.models.Manager;
import main.java.models.Receptionist;

import java.io.IOException;

/**
 * Created by sardor on 12/15/16.
 */
public class LoginScreenController {

    Stage stage;
    public static Receptionist receptionist;
    String hash_id;
    ReceptionistDB db;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private TextField mUserName;

    @FXML
    private PasswordField mPassword;

    @FXML
    private ChoiceBox mChoiceBox;

    @FXML
    private Button mLoginButton;




    @FXML
    void onLoginClicked(ActionEvent event) throws IOException {
        Parent adminParent;

        Manager manager = new Manager();

        String userName = mUserName.getText();
        String password = mPassword.getText();

        if(mChoiceBox.getSelectionModel().getSelectedItem().toString().equals("Manager")){
            if (manager.getUserName().equals(userName) && manager.getPassword().equals(password)) {
                adminParent = FXMLLoader.load(getClass().getResource("/main/layout/manager_screen.fxml"));
                login(event, adminParent);
            }
        }else{
            if (loginReceptionist(userName,password)) {
                receptionist = db.getReceptionist(hash_id);
                adminParent = FXMLLoader.load(getClass().getResource("/main/layout/receptionist_screen.fxml"));
                login(event, adminParent);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, You write wrong password!");
                alert.showAndWait();
            }
        }

    }

    private void login(ActionEvent event, Parent adminParent) {
        Scene adminScene = new Scene(adminParent);
        Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        adminStage.setResizable(true);
        adminStage.hide();
        adminStage.setScene(adminScene);
        adminStage.show();
    }

    private boolean loginReceptionist(String userName, String password){

        db = new ReceptionistDB();
        hash_id = db.checkReceptionist(userName,password);

        return !hash_id.equals("Error");
    }
}
