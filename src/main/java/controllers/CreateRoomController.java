package main.java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sardor on 12/18/16.
 */
public class CreateRoomController implements Initializable {


    @FXML
    private TableColumn<?, ?> mColumnRoomNo;

    @FXML
    private TableColumn<?, ?> mColumnKitchen;

    @FXML
    private Button mEditRoomBtn;


    @FXML
    private ChoiceBox<?> mKitchenRoomChoice;

    @FXML
    private TableColumn<?, ?> mColumnBad;

    @FXML
    private Button mSearchRoomBtn;

    @FXML
    private TableColumn<?, ?> mColumnRoomType;

    @FXML
    private DatePicker mCreationDate;

    @FXML
    private Button mCreateRoomBtn;

    @FXML
    private ChoiceBox<?> mBadRoomChoice;

    @FXML
    private Button mDeleteRoomBtn;

    @FXML
    private TableView<?> mTableRoom;

    @FXML
    private TextField mCostRoomField;

    @FXML
    private TextField mRoomNoField;

    @FXML
    private ChoiceBox<?> mRoomTypeChoice;

    @FXML
    private ChoiceBox<?> mBathRoomChoice;

    @FXML
    private TableColumn<?, ?> mColumnDate;



    @FXML
    private TableColumn<?, ?> mColumnCost;

    @FXML
    private TableColumn<?, ?> mColumnBath;

    @FXML
    private TextField mSearchRoomField;


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
