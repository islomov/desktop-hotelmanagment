package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by by_dingo on 18.12.2016.
 */
public class DBConnect {

    DBConnect() {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hotel","postgres","234asd");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
