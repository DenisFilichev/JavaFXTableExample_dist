/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtableexample;

import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author denis
 */
public class EducationStage extends Stage{
    
    private int personid;

    public EducationStage(int personid) {
        this.personid = personid;
    }
    
    public void init(){
        ObservableList<Education> educations = FXCollections.observableArrayList(new Repository().getEducationByPersonid(personid));
        TableView<Education> table = new TableView<>(educations);
        
        TableColumn<Education, Integer> idCol = new TableColumn<>("ИД");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setMinWidth(100);
        table.getColumns().add(idCol);
        
        TableColumn<Education, String> universityCol = new TableColumn<>("Университет");
        universityCol.setCellValueFactory(new PropertyValueFactory<>("universityname"));
        universityCol.setMinWidth(100);
        table.getColumns().add(universityCol);
        
        TableColumn<Education, Date> dateCol = new TableColumn<>("Дата");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateFinish"));
        dateCol.setMinWidth(100);
        table.getColumns().add(dateCol);
        
        TableColumn<Education, String> cityCol = new TableColumn<>("Город");
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        cityCol.setMinWidth(100);
        table.getColumns().add(cityCol);
        
        StackPane root = new StackPane();
        root.getChildren().add(table);
        
        Scene scene = new Scene(root, 660, 500);
        
        setTitle("Hello World!");
        setScene(scene);
        initModality(Modality.APPLICATION_MODAL);
        showAndWait();
    }
}
