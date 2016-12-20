package main.java.DataBase;

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

    public RoomDB() {
        super();

        try {
            insertRoomSt = this.getConnection().prepareStatement("INSERT INTO rooms " +
                    "(number, type, number_of_bad_room, number_of_kitchen, number_of_bath_room, day_of_creation, cost) " +
                    "VALUES (?,?,?,?,?,?,?)");
            getAllRoomsSt = this.getConnection().prepareStatement("SELECT  * FROM rooms");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createRoom(Room room){
        try {
            insertRoomSt.setInt(1,room.getNumber());
            insertRoomSt.setString(2,room.getType());
            insertRoomSt.setInt(3,room.getNumberOfBadRoom());
            insertRoomSt.setInt(4,room.getNumberOfKitchen());
            insertRoomSt.setInt(5,room.getNumberOfBathRoom());
            insertRoomSt.setString(6,room.getDayOfCreation());
            insertRoomSt.setInt(7,room.getCost());
            insertRoomSt.executeUpdate();
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
}
