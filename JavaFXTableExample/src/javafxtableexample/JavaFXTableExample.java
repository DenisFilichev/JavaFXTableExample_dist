/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtableexample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author denis
 */
public class JavaFXTableExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Repository repository = new Repository();
        System.out.println("repository.getAllPerson().size() = " + repository.getAllPerson().size());
        ObservableList list = FXCollections.observableArrayList(repository.getAllPerson());
        
        TableView<Person> table = new TableView<>(list);
        
        TableColumn<Person, Integer> idCol = new TableColumn<>("ИД");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.getColumns().add(idCol);
        
        TableColumn<Person, String> firstCol = new TableColumn<>("Имя");
        firstCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        table.getColumns().add(firstCol);
        
        TableColumn<Person, String> lastCol = new TableColumn<>("Фамилия");
        lastCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        table.getColumns().add(lastCol);
        
        TableColumn<Person, String> genderCol = new TableColumn<>("Пол");
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        table.getColumns().add(genderCol);
        
        StackPane root = new StackPane();
        root.getChildren().add(table);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
