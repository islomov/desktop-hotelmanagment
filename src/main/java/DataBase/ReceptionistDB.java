package main.java.DataBase;

import main.java.models.Receptionist;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by by_dingo on 19.12.2016.
 */
public class ReceptionistDB extends DB {

    PreparedStatement insertReceptionistSt = null;
    PreparedStatement updateReceptionistSt = null;
    PreparedStatement deleteReceptionistSt = null;

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

    public void updateReceptionist(Receptionist receptionist) {
        try {
            setValues(updateReceptionistSt,receptionist);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteReceptionist(int hash){
        try {
            updateReceptionistSt.setInt(1,hash);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setValues(PreparedStatement statement, Receptionist receptionist) throws SQLException {
        statement.setString(1, receptionist.getUserName());
        statement.setString(2, receptionist.getPassword());
        statement.setString(3, receptionist.getFirstName());
        statement.setString(4, receptionist.getLastName());
        statement.setString(5, receptionist.getGender());
        statement.setString(6, receptionist.getExperience());
        statement.setBoolean(7, receptionist.isMarried());
        statement.setDate(8, receptionist.getBirthday());
        statement.setString(9, receptionist.getHash_id());
        statement.executeUpdate();
    }

}
