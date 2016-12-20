package main.java.DataBase;

import main.java.models.Hotel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sardor on 12/20/16.
 */
public class HotelDB extends DB {

    private PreparedStatement hotelSt = null;
    private PreparedStatement updateHotelSt = null;

    public HotelDB(){
        super();

        try {
            hotelSt = this.getConnection().prepareStatement("SELECT  * FROM hotel");

            updateHotelSt = this.getConnection().prepareStatement("UPDATE hotel SET " +
                    "hotel_name = ?," +
                    "ceo = ?," +
                    "phone_number = ?," +
                    "address = ?," + "website = ?");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Hotel getHotel(){
        List<Hotel> hotelList = new ArrayList<>();
        try {
            ResultSet resultSet  = hotelSt.executeQuery();
            while (resultSet.next()){
                Hotel hotel = new Hotel();
                hotel.setAddress(resultSet.getString("address"));
                hotel.setHotelName(resultSet.getString("hotel_name"));
                hotel.setCeo(resultSet.getString("ceo"));
                hotel.setPhoneNumber(resultSet.getString("phone_number"));
                hotel.setWebsite(resultSet.getString("website"));
                hotelList.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotelList.get(0);
    }

    public void updateHotel(Hotel hotel)  {
        try {
            updateHotelSt.setString(1,hotel.getHotelName());
            updateHotelSt.setString(2,hotel.getCeo());
            updateHotelSt.setString(3,hotel.getPhoneNumber());
            updateHotelSt.setString(4,hotel.getAddress());
            updateHotelSt.setString(5,hotel.getWebsite());
            updateHotelSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
