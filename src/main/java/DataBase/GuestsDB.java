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
                    "(hash_id,receptionist_hash_id, name, gender, birthday, room_type, arrival_day, count_day, total_price) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)");
            getGuestsByReceptionistSt = this.getConnection().prepareStatement("SELECT *FROM guests WHERE receptionist_hash_id = ? ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addGuest(Guest guest){
        try {
            insertGuestSt.setString(1,guest.getHashId());
            insertGuestSt.setString(2,guest.getReceptionistHasId());
            insertGuestSt.setString(3,guest.getGender());
            insertGuestSt.setString(4,guest.getBirthday());
            insertGuestSt.setString(5,"Type1");
            insertGuestSt.setString(6,guest.getArrivalDay());
            insertGuestSt.setInt(7,guest.getCountDay());
            insertGuestSt.setInt(8,guest.getTotalPrice());
            insertGuestSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
