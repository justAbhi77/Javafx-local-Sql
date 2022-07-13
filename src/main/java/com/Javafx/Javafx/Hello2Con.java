package com.Javafx.Javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.sql.Connection;
import java.sql.ResultSet;

public class Hello2Con {
    @FXML
    ListView<String> databases;

    @FXML
    Button btn;

    @FXML
    Button sBtn;

    Connection dblink;

    @FXML
    void initialize(){
        sBtn.setVisible(false);
        dblink=UserData.self.con;

        String query="show databases;";

        try {
            ResultSet output = dblink.createStatement().executeQuery(query);

            while(output.next()){
                databases.getItems().add(output.getString(1));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onChose(){
        String choice=databases.getSelectionModel().getSelectedItem();
        if(choice == null)
            return;
        System.out.println("Chose "+ databases.getSelectionModel().getSelectedItem()+" as database to use.");
        UserData.self.dbname=choice;
        String query="show tables from "+choice;
        databases.getItems().clear();
        try{
            ResultSet output = dblink.createStatement().executeQuery(query);

            while(output.next()){
                databases.getItems().add(output.getString(1));
            }

            btn.setOnAction(event -> onChoseSec());
            sBtn.setVisible(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    void onChoseSec() {
        String choice=databases.getSelectionModel().getSelectedItem();
        if(choice == null)
            return;
        System.out.println("Chose "+ databases.getSelectionModel().getSelectedItem()+" as table to use.");
        UserData.self.tablenm=choice;
        try{
            UserData.self.changeScene("third");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onChosesBtn(){
        try{
            UserData.self.changeScene("second");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        btn.setOnAction(event -> onChoseSec());
    }

}
