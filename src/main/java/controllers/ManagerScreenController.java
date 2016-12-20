package main.java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sardor on 12/16/16.
 */

public class ManagerScreenController implements Initializable{

    @FXML
    private StackPane root;
    @FXML
    AnchorPane mainRoot;


    @FXML
    void onRoomsClicked(ActionEvent event) throws IOException {
        try {
            root.getChildren().clear();
            root.getChildren().add(FXMLLoader.load(getClass().getResource("/main/layout/create_room_screen.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onReceptionistClicked(ActionEvent event) throws IOException {
        try {
            root.getChildren().clear();
            root.getChildren().add(FXMLLoader.load(getClass().getResource("/main/layout/create_recept_screen.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onHotelInfoClicked(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        Parent adminRoot = FXMLLoader.load(getClass().getResource("/main/layout/hotel_screen.fxml"));
        Scene scene = new Scene(adminRoot);
        newStage.setScene(scene);
        newStage.setResizable(false);
        newStage.show();
    }

    @FXML
    void onExitClicked(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        Parent adminRoot = FXMLLoader.load(getClass().getResource("/main/layout/login_screen.fxml"));
        Scene scene = new Scene(adminRoot);
        newStage.setScene(scene);
        newStage.setResizable(false);
        newStage.show();

        Stage stage  = (Stage) mainRoot.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            root.getChildren().clear();
            root.getChildren().add(FXMLLoader.load(getClass().getResource("/main/layout/create_recept_screen.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
