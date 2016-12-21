package main.java.DataBase;

import main.java.models.Guest;
import main.java.models.Receptionist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by by_dingo on 20.12.2016.
 */
public class GuestsDB extends DB{

    private PreparedStatement insertGuestSt = null;
    private PreparedStatement getGuestsByReceptionistSt = null;

    public GuestsDB() {
        super();

        try {
            insertGuestSt = this.getConnection().prepareStatement("INSERT INTO guests" +
                    "(hash_id,receptionist_hash_id, name, gender, birthday, room_type, arrival_day, count_day, total_price,room_number) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?)");
            getGuestsByReceptionistSt = this.getConnection().prepareStatement("SELECT *FROM guests WHERE receptionist_hash_id = ? ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertGuest(Guest guest){
        try {
            setValues(insertGuestSt,guest);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Guest> getGuestsByReceptionist(String has_id){
        ResultSet resultSet = null;
        List<Guest> guests = new ArrayList<>();
        try {
            getGuestsByReceptionistSt.setString(1,has_id);
            resultSet = getGuestsByReceptionistSt.executeQuery();

            while (resultSet.next()){
                Guest guest = createGuest(resultSet);
                guests.add(guest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guests;
    }

    private Guest createGuest(ResultSet resultSet) throws SQLException {
        Guest guest = new Guest();
        guest.setReceptionistHasId(resultSet.getString("receptionist_hash_id"));
        guest.setRoomNumber(resultSet.getInt("room_number"));
        guest.setRoomType(resultSet.getString("room_type"));
        guest.setName(resultSet.getString("name"));
        guest.setGender(resultSet.getString("gender"));
        guest.setBirthday(resultSet.getString("birthday"));
        guest.setArrivalDay(resultSet.getString("arrival_day"));
        guest.setCountDay(resultSet.getInt("count_day"));
        guest.setTotalPrice(resultSet.getInt("total_price"));
        guest.setHashId(resultSet.getString("hash_id"));
        return guest;
    }

    private void setValues(PreparedStatement statement, Guest guest) throws SQLException {
        statement.setString(1,guest.getHashId());
        statement.setString(2,guest.getReceptionistHasId());
        statement.setString(3,guest.getName());
        statement.setString(4,guest.getGender());
        statement.setString(5,guest.getBirthday());
        statement.setString(6,guest.getRoomType());
        statement.setString(7,guest.getArrivalDay());
        statement.setInt(8,guest.getCountDay());
        statement.setInt(9,guest.getTotalPrice());
        statement.setInt(10,guest.getRoomNumber());
        statement.executeUpdate();
    }

}
