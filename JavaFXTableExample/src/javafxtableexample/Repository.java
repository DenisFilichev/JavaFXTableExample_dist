/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtableexample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author denis
 */
public class Repository {
    
    private String url = "jdbc:derby://localhost:1527/TrainingDatabase";
    private String user = "root";
    private String psw = "root";
    
    public List<Person> getAllPersonWithEducation(){
        List<Person> persons = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url, user, psw);
                Statement stm = con.createStatement()){
            try (ResultSet rs = stm.executeQuery("SELECT * FROM PERSON LEFT JOIN EDUCATION ON PERSON.ID=EDUCATION.PERSONID");){
                while(rs.next()){
                    int personid = rs.getInt(1);
                    Person person = persons.stream().filter(per -> per.getId()==personid).findFirst().orElse(null);
                    if(person==null){
                        String firstname = rs.getString(2);
                        String lastname = rs.getString(3);
                        String gender = rs.getString(4);
                        person = new Person(personid, firstname, lastname, gender);
                        persons.add(person);
                    }
                    int educationid = rs.getInt(5);
                    String universityname = rs.getString(6);
                    if(universityname!=null){
                        Date dateFinish = rs.getDate(7);
                        String city = rs.getString(8);
                        Education education = new Education(educationid, universityname, dateFinish, city);
                        person.addEducation(education);
                        education.setPerson(person);
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return persons;
    }
    
    public List<Person> getAllPerson(){
        List<Person> persons = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url, user, psw);
                Statement stm = con.createStatement()){
            try (ResultSet rs = stm.executeQuery("SELECT * FROM PERSON");){
                while(rs.next()){
                    int id = rs.getInt(1);
                    String firstname = rs.getString(2);
                    String lastname = rs.getString(3);
                    String gender = rs.getString(4);
                    persons.add(new Person(id, firstname, lastname, gender));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return persons;
    }
    
    public List<Education> getEducationByPersonid(int personid){
        List<Education> educations = new ArrayList<>();
        
        try(Connection con = DriverManager.getConnection(url, user, psw);
                Statement stm = con.createStatement()){
            try (ResultSet rs = stm.executeQuery("SELECT * FROM EDUCATION WHERE PERSONID=" + personid)){
                while(rs.next()){
                    int id = rs.getInt(1);
                    String universityname = rs.getString(2);
                    Date dateFinish = rs.getDate(3);
                    String city = rs.getString(4);
                    educations.add(new Education(id, universityname, dateFinish, city));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        return educations;
    }
    
}
