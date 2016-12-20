package main.java.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import main.java.DataBase.RoomDB;
import main.java.models.Room;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by sardor on 12/18/16.
 */
public class CreateRoomController implements Initializable {


    private ObservableList<Room> rooms;

    private RoomDB db;

    int selectedItem;
    int editItem;

    Room room;

    @FXML
    private TableColumn<Room, Integer> mColumnRoomNo;

    @FXML
    private TableColumn<Room, Integer> mColumnKitchen;

    @FXML
    private Button mEditRoomBtn;


    @FXML
    private ChoiceBox<String> mKitchenRoomChoice;

    @FXML
    private TableColumn<Room, Integer> mColumnBad;

    @FXML
    private Button mSearchRoomBtn;

    @FXML
    private TableColumn<Room, String> mColumnRoomType;

    @FXML
    private DatePicker mCreationDate;

    @FXML
    private Button mCreateRoomBtn;

    @FXML
    private ChoiceBox<String> mBadRoomChoice;

    @FXML
    private Button mDeleteRoomBtn;

    @FXML
    private TableView<Room> mTableRoom;

    @FXML
    private TextField mCostRoomField;

    @FXML
    private TextField mRoomNoField;

    @FXML
    private ChoiceBox<String> mRoomTypeChoice;

    @FXML
    private ChoiceBox<String> mBathRoomChoice;

    @FXML
    private TableColumn<Room, String> mColumnDate;

    @FXML
    private TableColumn<Room, Integer> mColumnCost;

    @FXML
    private TableColumn<Room, Integer> mColumnBath;

    @FXML
    private TextField mSearchRoomField;

    @FXML
    void onRoomRowClicked(MouseEvent event) {
        selectedItem = mTableRoom.getSelectionModel().getSelectedIndex();
    }

    @FXML
    void onCreateBtnClicked(ActionEvent event) {
        if (mCreateRoomBtn.getText().equals("Save")){
            Room room = createRoom();
            rooms.remove(editItem);
            rooms.add(editItem,db.updateRoom(room));
            mCreateRoomBtn.setText("Create");
        }else {

            rooms.add(createRoom());
            db.insertRoom(room);
            refreshFields();
        }
    }

    private Room createRoom() {
        Room room = new Room();
        room.setNumber(Integer.parseInt(mRoomNoField.getText()));
        room.setType(mRoomTypeChoice.getSelectionModel().getSelectedItem());
        room.setNumberOfBadRoom(Integer.parseInt(mBadRoomChoice.getSelectionModel().getSelectedItem()));
        room.setNumberOfKitchen(Integer.parseInt(mKitchenRoomChoice.getSelectionModel().getSelectedItem()));
        room.setNumberOfBathRoom(Integer.parseInt(mBathRoomChoice.getSelectionModel().getSelectedItem()));
        room.setDayOfCreation(String.valueOf(mCreationDate.getValue()));
        room.setCost(Integer.parseInt(mCostRoomField.getText()));
        return room;
    }

    @FXML
    void onSearchBtnClicked(ActionEvent event) {

    }

    @FXML
    void onEditBtnClicked(ActionEvent event) {
        editItem = selectedItem;
        room = rooms.get(editItem);
        setValues(room);
    }

    private void setValues(Room room) {
        mRoomNoField.setText(String.valueOf(room.getNumber()));
        mRoomTypeChoice.setValue(room.getType());
        mBadRoomChoice.setValue(String.valueOf(room.getNumberOfBadRoom()));
        mKitchenRoomChoice.setValue(String.valueOf(room.getNumberOfKitchen()));
        mBathRoomChoice.setValue(String.valueOf(room.getNumberOfBathRoom()));
        mCreationDate.setValue(LocalDate.parse(room.getDayOfCreation()));
        mCostRoomField.setText(String.valueOf(room.getCost()));
        mCreateRoomBtn.setText("Save");
    }

    @FXML
    void onDeleteBtnClicked(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new RoomDB();
        rooms = FXCollections.observableList(db.getAllRooms());
        mColumnRoomNo.setCellValueFactory(new PropertyValueFactory<>("number"));
        mColumnRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        mColumnBad.setCellValueFactory(new PropertyValueFactory<>("numberOfBadRoom"));
        mColumnKitchen.setCellValueFactory(new PropertyValueFactory<>("numberOfKitchen"));
        mColumnBath.setCellValueFactory(new PropertyValueFactory<>("numberOfBathRoom"));
        mColumnDate.setCellValueFactory(new PropertyValueFactory<>("dayOfCreation"));
        mColumnCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        mTableRoom.setItems(rooms);
    }

    private void refreshFields(){
        mRoomNoField.setText(null);
        mRoomTypeChoice.setValue(null);
        mBadRoomChoice.setValue(null);
        mKitchenRoomChoice.setValue(null);
        mBathRoomChoice.setValue(null);
        mCreationDate.setValue(null);
        mCostRoomField.setText(null);
    }
}
