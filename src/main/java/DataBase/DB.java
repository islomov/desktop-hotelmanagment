package main.java.DataBase;

import main.java.Utils;

import java.sql.*;


/**
 * Created by by_dingo on 18.12.2016.
 */
public class DB {


    private String user = Utils.USER;
    private String password = Utils.PASSWORD;

    private Connection connection;

    private boolean isConnected = false;

    public DB() {
        this.connect();
    }

    private void connect(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hotel",user,password);

            if (connection != null){
                System.out.print("Database connected");
                setConnected(true);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            setConnected(false);
        }
    }

    public void close(){
        if (connection != null){
            try {
                connection.close();
                setConnected(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connceted) {
        isConnected = connceted;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
