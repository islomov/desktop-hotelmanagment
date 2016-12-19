package main.java.DataBase;

import main.java.models.Receptionist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by by_dingo on 19.12.2016.
 */
public class ReceptionistDB extends DB {

    PreparedStatement insertReceptionistSt = null;
    PreparedStatement updateReceptionistSt = null;
    PreparedStatement deleteReceptionistSt = null;
    PreparedStatement getAllReceptionistSt = null;

    public ReceptionistDB() {
        super();

        try {
            insertReceptionistSt = this.getConnection().prepareStatement("INSERT INTO receptionist"
                    + "(username, password, first_name, last_name, gender, experience, married, birthday, hash_id)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)");

            updateReceptionistSt = this.getConnection().prepareStatement("UPDATE receptionist SET " +
                    "username = ?," + "password = ?," + "first_name = ?," + "last_name = ?," + "" +
                    "gender = ?," + "experience = ?," + "married = ?," + "birthday = ? WHERE hash_id = ?");

            deleteReceptionistSt = this.getConnection().prepareStatement("DELETE FROM receptionist WHERE " +
                    "hash_id = ?");

            getAllReceptionistSt = this.getConnection().prepareStatement("SELECT * FROM receptionist");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addReceptionist(Receptionist receptionist) {
        if (!isConnected())
            this.connect();
        try {
            setValues(insertReceptionistSt,receptionist);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }

    public void updateReceptionist(Receptionist receptionist) {
        if (!isConnected())
            this.connect();
        try {
            setValues(updateReceptionistSt,receptionist);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.close();
    }

    public void deleteReceptionist(int hash){
        if (!isConnected())
            this.connect();
        try {
            deleteReceptionistSt.setInt(1,hash);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }

    public List<Receptionist> getAllReceptionists(){
        if (!isConnected())
            this.connect();
        ResultSet resultSet = null;
        List<Receptionist> receptionists = new ArrayList<>();
        try {
            resultSet = getAllReceptionistSt.executeQuery();

            while (resultSet.next()){
                Receptionist receptionist = new Receptionist();
                receptionist.setUserName(resultSet.getString("username"));
                receptionist.setPassword(resultSet.getString("password"));
                receptionist.setFirstName(resultSet.getString("first_name"));
                receptionist.setLastName(resultSet.getString("last_name"));
                receptionist.setGender(resultSet.getString("gender"));
                receptionist.setExperience(resultSet.getString("experience"));
                receptionist.setMarried(resultSet.getBoolean("married"));
                receptionist.setBirthday(resultSet.getString("birthday"));
                receptionist.setHash_id(resultSet.getString("hash_id"));

                receptionists.add(receptionist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
        return receptionists;
    }

    private void setValues(PreparedStatement statement, Receptionist receptionist) throws SQLException {
        statement.setString(1, receptionist.getUserName());
        statement.setString(2, receptionist.getPassword());
        statement.setString(3, receptionist.getFirstName());
        statement.setString(4, receptionist.getLastName());
        statement.setString(5, receptionist.getGender());
        statement.setString(6, receptionist.getExperience());
        statement.setBoolean(7, receptionist.isMarried());
        statement.setString(8, receptionist.getBirthday());
        statement.setString(9, receptionist.getHash_id());
        statement.executeUpdate();
    }



}
