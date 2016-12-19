package main.java.models;

/**
 * Created by by_dingo on 18.12.2016.
 */
public class Manager {

    private String userName = "admin";
    private String password = "admin";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
