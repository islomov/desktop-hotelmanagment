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
import javafx.stage.Stage;
import main.java.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sardor on 12/16/16.
 */
public abstract class ManagerScreenController implements Initializable{



    @FXML
    private AnchorPane root;


    @FXML
    private MenuItem hotelSubMenu;

    @FXML
    private MenuItem roomsSubItem;

    @FXML
    private MenuItem receptionistSubMenu;

    @FXML
    void onRoomsClicked(ActionEvent event) throws IOException {
        Stage stage  = (Stage) root.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/main/layout/create_room_screen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onReceptionistClicked(ActionEvent event) throws IOException {
        Stage stage  = (Stage) root.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/main/layout/create_recept_screen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onHotelClicked(ActionEvent event) throws IOException {
        Stage stage  = new Stage();
        Parent rootHotel = FXMLLoader.load(getClass().getResource("/main/layout/hotel_screen.fxml"));
        Scene scene = new Scene(rootHotel);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


}
