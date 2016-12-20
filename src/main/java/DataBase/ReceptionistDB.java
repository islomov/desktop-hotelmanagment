package main.java.DataBase;

import main.java.models.Receptionist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by by_dingo on 19.12.2016.
 */
public class ReceptionistDB extends DB {

    private PreparedStatement insertReceptionistSt = null;
    private PreparedStatement updateReceptionistSt = null;
    private PreparedStatement deleteReceptionistSt = null;
    private PreparedStatement getAllReceptionistSt = null;
    private PreparedStatement getReceptionistSt = null;
    private PreparedStatement checkReceptionistSt = null;

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

            getReceptionistSt = this.getConnection().prepareStatement("SELECT * FROM receptionist WHERE hash_id = ?");

            checkReceptionistSt = this.getConnection().prepareStatement("SELECT * FROM receptionist WHERE username = ?");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addReceptionist(Receptionist receptionist) {
        try {
            setValues(insertReceptionistSt,receptionist);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Receptionist updateReceptionist(Receptionist receptionist) {
        Receptionist newReceptionist = null;
        try {
            setValues(updateReceptionistSt,receptionist);
            newReceptionist = getReceptionist(receptionist.getHash_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newReceptionist;
    }

    public void deleteReceptionist(String hash){
        try {
            deleteReceptionistSt.setString(1,hash);
            deleteReceptionistSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Receptionist> getAllReceptionists(){

        ResultSet resultSet = null;
        List<Receptionist> receptionists = new ArrayList<>();
        try {
            resultSet = getAllReceptionistSt.executeQuery();

            while (resultSet.next()){
                Receptionist receptionist = createReceptionist(resultSet);

                receptionists.add(receptionist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receptionists;
    }

    private Receptionist createReceptionist(ResultSet resultSet) throws SQLException {
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
        return receptionist;
    }

    public Receptionist getReceptionist(String hash){
        ResultSet resultSet = null;
        Receptionist receptionist = null;
        try {
            getReceptionistSt.setString(1,hash);
            resultSet = getReceptionistSt.executeQuery();
            while (resultSet.next()){
                receptionist = createReceptionist(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receptionist;
    }

    public String checkReceptionist(String userName,String password){
        ResultSet resultSet = null;
        String mHashId = null;
        String mUserName = null;
        String mPassword =null;
        try {
            checkReceptionistSt.setString(1,userName);
            resultSet = checkReceptionistSt.executeQuery();

            while (resultSet.next()){
                mHashId = resultSet.getString("hash_id");
                mUserName = resultSet.getString("username");
                mPassword = resultSet.getString("password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error";
        }
        if (password.equals(mPassword))
            return mHashId;
        else
            return "Error";
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
