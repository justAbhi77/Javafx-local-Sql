package com.Javafx.Javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;

public class HelloController {
    @FXML
    Button btn;

    @FXML
    TextField username;

    @FXML
    PasswordField password;

    @FXML
    Text usrnm_mt;

    @FXML
    Text pass_mt;

    @FXML
    Text notLogin;

    @FXML
    void onButtonClicked(){
        String usr=username.getText().trim(),pass=password.getText().trim();
        int f=0;
        if(usr.equals("")) {
            usrnm_mt.setVisible(true);
            f=1;
        }
        if(pass.equals("")){
            pass_mt.setVisible(true);
            f=1;
        }
        if(f==1) {
            return;
        }
        String url="jdbc:mysql://localhost/";
        Connection dblink;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            dblink= DriverManager.getConnection(url,usr,pass);
            System.out.println("Successfully Connected to local mysql server !");
            new UserData(dblink);
            Stage stage=(Stage)btn.getScene().getWindow();
            UserData.self.stage=stage;
            UserData.self.stage.setTitle("Chose Database");
            UserData.self.changeScene("second");
        }
        catch (Exception e){
            notLogin.setVisible(true);
            System.out.println("Could not Login");
            e.printStackTrace();
        }
    }

    @FXML
    void clearScreen(KeyEvent key){
        if(key.getCode() == KeyCode.ENTER)
            return;
        usrnm_mt.setVisible(false);
        pass_mt.setVisible(false);
        notLogin.setVisible(false);
    }

    @FXML
    void EnterOnPass(){
        btn.fire();
    }

    void initialize(){
        //Platform.runLater(()->btn.requestFocus());
    }
}