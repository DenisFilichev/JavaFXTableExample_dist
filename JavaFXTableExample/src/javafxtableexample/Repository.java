/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtableexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author denis
 */
public class Repository {
    
    private String url = "jdbc:derby://localhost:1527/TrainingDatabase";
    private String user = "root";
    private String psw = "root";
    
    public Set<Person> getAllPerson(){
        Set<Person> persons = new HashSet<>();
        try(Connection con = DriverManager.getConnection(url, user, psw);
                Statement stm = con.createStatement()){
            ResultSet rs = stm.executeQuery("SELECT * FROM PERSON");
            while(rs.next()){
                int id = rs.getInt(1);
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                String gender = rs.getString(4);
                persons.add(new Person(id, firstname, lastname, gender));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return persons;
    }
    
}
