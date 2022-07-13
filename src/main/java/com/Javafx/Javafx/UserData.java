package com.Javafx.Javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class UserData {
    public static UserData self;

    public String dbname,tablenm;

    public Connection con;

    public Stage stage;

    UserData(Connection dblink){
        con=dblink;
        self=this;
    }

    void changeScene(String sceneName) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(sceneName+".fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.centerOnScreen();
    }

}
