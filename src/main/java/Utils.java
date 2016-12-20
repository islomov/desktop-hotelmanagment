package main.java;

import javafx.scene.control.Alert;

/**
 * Created by by_dingo on 18.12.2016.
 */
public class Utils {

    public static final String USER = "postgres";
    public static final String PASSWORD = "234asd";

    public static void showWarning(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Look, an Warning Dialog");
        alert.setContentText("Ooops, You didnt fill some field please make sure that you have filled all fields !!!");
        alert.showAndWait();
    }

}
