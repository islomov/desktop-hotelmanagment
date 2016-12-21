package main.java.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.java.DataBase.GuestsDB;
import main.java.DataBase.RoomDB;
import main.java.models.Guest;
import main.java.models.Receptionist;
import main.java.models.Room;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by sardor on 12/15/16.
 */
public class ReceptionistScreenController implements Initializable{


    ObservableList<Guest> guests;

    RoomDB roomDB;
    GuestsDB guestsDB;

    @FXML
    private TextField mGNameField;

    @FXML
    private DatePicker mArrivalData;

    @FXML
    private TableColumn<Guest, String> mRoomTypeColumn;

    @FXML
    private TextField mSearchField;

    @FXML
    private TextField mPriceField;

    @FXML
    private TableColumn<Guest, String> mArrivalDayColumn;

    @FXML
    private TextField mCountDayField;

    @FXML
    private TableColumn<Guest, String> mCountDayColumn;

    @FXML
    private DatePicker mBirthdayDate;


    @FXML
    private Button mDeleteBtn;

    @FXML
    private Button mSearchBtn;

    @FXML
    private Button mEditBtn;

    @FXML
    private TableColumn<Guest, String> mGuestNameColumn;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<Guest> mTableView;

    @FXML
    private TableColumn<Guest, String> mGenderColumn;

    @FXML
    private TableColumn<Guest, String> mRoomNoColumn;

    @FXML
    private ChoiceBox<String> mRoomTypeChoice;

    @FXML
    private TableColumn<Guest, String> mPriceColumn;

    @FXML
    private ChoiceBox<String> mGenderChoice;

    @FXML
    private Button mCreatBtn;

    @FXML
    private ChoiceBox<String> mRoomNoChoiceBox;

    @FXML
    private TableColumn<Guest, String> mAgeColumn;

    @FXML
    void onShowRoomsClicked(ActionEvent event) {

    }

    @FXML
    void onCreatBtnClicked(ActionEvent event) {
        Guest guest = createGuest();
        guestsDB.insertGuest(guest);
        roomDB.changeRoomStatus(Integer.parseInt(mRoomNoChoiceBox.getSelectionModel().getSelectedItem()),"reserved");
        guests.add(guest);
    }

    private Guest createGuest() {
        Guest guest = new Guest();
        String receptionistHash_id = LoginScreenController.receptionist.getHash_id();
        guest.setReceptionistHasId(receptionistHash_id);
        guest.setRoomNumber(Integer.parseInt(mRoomNoChoiceBox.getSelectionModel().getSelectedItem()));
        guest.setRoomType(mRoomTypeChoice.getSelectionModel().getSelectedItem());
        guest.setName(mGNameField.getText());
        guest.setGender(mGenderChoice.getSelectionModel().getSelectedItem());
        guest.setBirthday(mBirthdayDate.getValue().toString());
        guest.setArrivalDay(mArrivalData.getValue().toString());
        guest.setCountDay(Integer.parseInt(mCountDayField.getText()));
        guest.setTotalPrice(Integer.parseInt(mPriceField.getText()));
        return guest;
    }


    @FXML
    void onRowGuestClicked(ActionEvent event) {

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
        roomDB = new RoomDB();
        guestsDB = new GuestsDB();
        mRoomTypeChoice.getSelectionModel().selectedIndexProperty().addListener(changeListener);
        String hash = LoginScreenController.receptionist.getHash_id();
        guests = FXCollections.observableList(guestsDB.getGuestsByReceptionist(hash));

        mGuestNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        mGenderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        mAgeColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        mRoomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        mRoomNoColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        mArrivalDayColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDay"));
        mPriceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        mCountDayColumn.setCellValueFactory(new PropertyValueFactory<>("countDay"));
        mTableView.setItems(guests);

    }

    ChangeListener changeListener = (observable, oldValue, newValue) -> {

        List<String> numbers;
        switch (mRoomTypeChoice.getSelectionModel().getSelectedIndex()){
            case 0:
                numbers = roomDB.getEmptyRoomsNumber("Double room");
                break;
            case 1:
                numbers = roomDB.getEmptyRoomsNumber("Suit room");
                break;
            case 2:
                numbers = roomDB.getEmptyRoomsNumber("King room");
                break;
            default:
                numbers = new ArrayList<>();
                break;
        }
        ObservableList<String> strings = FXCollections.observableList(numbers);
        mRoomNoChoiceBox.setItems(strings);
    };

}
