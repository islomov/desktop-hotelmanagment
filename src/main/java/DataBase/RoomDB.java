package main.java.DataBase;

import main.java.models.Receptionist;
import main.java.models.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by by_dingo on 20.12.2016.
 */
public class RoomDB extends DB {

    private PreparedStatement insertRoomSt = null;
    private PreparedStatement getAllRoomsSt = null;
    private PreparedStatement updateRoomsSt = null;
    private PreparedStatement getRoomByNumberSt = null;
    private PreparedStatement deleteRoomSt = null;
    private PreparedStatement getEmptyRoomsNumberSt = null;
    private PreparedStatement changeRoomStatusSt = null;

    public RoomDB() {

        super();

        try {
            insertRoomSt = this.getConnection().prepareStatement("INSERT INTO rooms " +
                    "(type, number_of_bad_room, number_of_kitchen, number_of_bath_room, day_of_creation, cost,status,number) " +
                    "VALUES (?,?,?,?,?,?,?,?)");

            getAllRoomsSt = this.getConnection().prepareStatement("SELECT  * FROM rooms");

            updateRoomsSt = this.getConnection().prepareStatement("UPDATE rooms SET " +
                    "type = ?," +
                    "number_of_bad_room = ?," +
                    "number_of_kitchen = ?," +
                    "number_of_bath_room = ?," +
                    "day_of_creation = ?," +
                    "cost = ? WHERE number = ?");

            getRoomByNumberSt = this.getConnection().prepareStatement("SELECT * FROM rooms " +
                    "WHERE number = ?");

            getEmptyRoomsNumberSt = this.getConnection().prepareStatement("SELECT * FROM rooms " +
                    "WHERE type = ? AND status = ?");

            deleteRoomSt = this.getConnection().prepareStatement("DELETE FROM rooms " +
                    "WHERE number = ?");


            changeRoomStatusSt = this.getConnection().prepareStatement("UPDATE rooms SET " +
                    "status = ? " +
                    "WHERE number = ?");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRoom(Room room){

        try {
            setValues(insertRoomSt,room);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Room> getAllRooms(){

        List<Room> rooms = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            resultSet = getAllRoomsSt.executeQuery();
            while (resultSet.next()){
                Room room = new Room();
                room.setNumber(resultSet.getInt("number"));
                room.setType(resultSet.getString("type"));
                room.setNumberOfBadRoom(resultSet.getInt("number_of_bad_room"));
                room.setNumberOfKitchen(resultSet.getInt("number_of_kitchen"));
                room.setNumberOfBathRoom(resultSet.getInt("number_of_bath_room"));
                room.setDayOfCreation(resultSet.getString("day_of_creation"));
                room.setCost(resultSet.getInt("cost"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public Room updateRoom(Room room){
        Room newRoom = null;
        try {
            setValues(updateRoomsSt,room);
            newRoom = getRoom(room.getNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newRoom;
    }

    public void deleteRoom(int number){
        try {
            deleteRoomSt.setInt(1,number);
            deleteRoomSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Room getRoom(int number){
        ResultSet resultSet = null;
        Room room = null;
        try {
            getRoomByNumberSt.setInt(1,number);
            resultSet = getRoomByNumberSt.executeQuery();

            while (resultSet.next()){
                room = createRoom(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    public List<String> getEmptyRoomsNumber(String type){
        ResultSet resultSet = null;
        String status = "empty";
        List<String> numbers = new ArrayList<>();
        try {
            getEmptyRoomsNumberSt.setString(1,type);
            getEmptyRoomsNumberSt.setString(2,status);
            resultSet = getEmptyRoomsNumberSt.executeQuery();
            while (resultSet.next()){
                numbers.add(String.valueOf(resultSet.getInt("number")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numbers;
    }

    public void changeRoomStatus(int number,String status){
        try {
            changeRoomStatusSt.setString(1,status);
            changeRoomStatusSt.setInt(2,number);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Room createRoom(ResultSet resultSet) throws SQLException {
        Room room = new Room();

        room.setNumber(resultSet.getInt("number"));
        room.setType(resultSet.getString("type"));
        room.setNumberOfBadRoom(resultSet.getInt("number_of_bad_room"));
        room.setNumberOfKitchen(resultSet.getInt("number_of_kitchen"));
        room.setNumberOfBathRoom(resultSet.getInt("number_of_bath_room"));
        room.setDayOfCreation(resultSet.getString("day_of_creation"));
        room.setCost(resultSet.getInt("cost"));

        return room;
    }

    private void setValues(PreparedStatement statement, Room room) throws SQLException {
        statement.setString(1,room.getType());
        statement.setInt(2,room.getNumberOfBadRoom());
        statement.setInt(3,room.getNumberOfKitchen());
        statement.setInt(4,room.getNumberOfBathRoom());
        statement.setString(5,room.getDayOfCreation());
        statement.setInt(6,room.getCost());
        statement.setString(7,"empty");
        statement.setInt(8,room.getNumber());
        statement.executeUpdate();
    }
}
