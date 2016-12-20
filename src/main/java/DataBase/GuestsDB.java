package main.java.DataBase;

import main.java.models.Guest;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    private void setValues(PreparedStatement statement, Guest guest) throws SQLException {
        statement.setString(1,guest.getHashId());
        statement.setString(2,guest.getReceptionistHasId());
        statement.setString(3,guest.getGender());
        statement.setString(4,guest.getBirthday());
        statement.setString(5,guest.getRoomType());
        statement.setString(6,guest.getArrivalDay());
        statement.setInt(7,guest.getCountDay());
        statement.setInt(8,guest.getTotalPrice());
        statement.executeUpdate();
    }

}
