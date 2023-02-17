/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtableexample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
        List<Person> persons = repository.getAllPersonWithEducation();
//        List<PersonDto> personDto = new ArrayList<>();
//        persons.forEach(per -> personDto.add(new PersonDto(per)));
        List<PersonDto> personDto = persons.stream().map(per -> new PersonDto(per)).collect(Collectors.toList());
        ObservableList list = FXCollections.observableArrayList(personDto);
        System.out.println("list " + list.size());
        TableView<PersonDto> table = new TableView<>(list);
        
//        table.setRowFactory(e -> { 
//            TableRow<Person> row = new TableRow<>();
//            row.setOnMouseClicked(mouse -> {
//                if(mouse.getClickCount()==2){
//                    new EducationStage(row.getItem()).init();
//                }
//            });
//            return row;
//        });
        
        table.setOnMouseClicked(e -> {
            if(e.getClickCount()==2){
                PersonDto person = table.getSelectionModel().getSelectedItem();
                System.out.println(person);
                //primaryStage.close();
                new EducationStage(person.getId()).init();
            }
        });
        
        TableColumn<PersonDto, Integer> idCol = new TableColumn<>("ИД");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setMinWidth(100);
        table.getColumns().add(idCol);
        
        TableColumn<PersonDto, String> firstCol = new TableColumn<>("Имя");
        firstCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        firstCol.setMinWidth(200);
        table.getColumns().add(firstCol);
        
        TableColumn<PersonDto, String> lastCol = new TableColumn<>("Фамилия");
        lastCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        lastCol.setMinWidth(200);
        table.getColumns().add(lastCol);
        
        TableColumn<PersonDto, String> genderCol = new TableColumn<>("Пол");
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        genderCol.setMinWidth(150);
        table.getColumns().add(genderCol);
        
        TableColumn<PersonDto, Integer> countCol = new TableColumn<>("Кол-во");
        countCol.setCellValueFactory(new PropertyValueFactory<>("educationCount"));
        countCol.setMinWidth(50);
        table.getColumns().add(countCol);
        
        StackPane root = new StackPane();
        root.getChildren().add(table);
        
        Scene scene = new Scene(root, 660, 500);
        
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
