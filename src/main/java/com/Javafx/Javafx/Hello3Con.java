package com.Javafx.Javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.ResultSet;

public class Hello3Con {

    @FXML
    TableView table;

    @FXML
    void initialize(){
        Connection dblink=UserData.self.con;
        try {
            String query="select * from " + UserData.self.dbname+"."+UserData.self.tablenm+";";
            ResultSet output = dblink.createStatement().executeQuery(query);

            ObservableList data=FXCollections.observableArrayList();

            for(int i=0 ; i<output.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(output.getMetaData().getColumnName(i+1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> {
                    if(param.getValue().get(j) !=null)
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    return null;
                });

                table.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }
            int j=1;
            while(output.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=output.getMetaData().getColumnCount(); i++){
                    row.add(output.getString(i));
                }
                System.out.println("Row ["+j+"] added "+row );
                data.add(row);
                j++;
            }

            //FINALLY ADDED TO TableView
            table.setItems(data);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onBackBtn(){
        try{
            UserData.self.changeScene("second");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
