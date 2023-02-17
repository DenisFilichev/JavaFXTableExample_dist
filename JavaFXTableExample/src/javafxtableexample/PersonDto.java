/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtableexample;

import java.util.Objects;

/**
 *
 * @author denis
 */
public class PersonDto {
    
    private Integer id;
    private String firstname;
    private String lastname;
    private String gender;
    private Integer educationCount;

    public PersonDto(Person person) {
        id = person.getId();
        firstname = person.getFirstname();
        lastname = person.getLastname();
        gender = person.getGender();
        educationCount = person.getEducations().size();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getEducationCount() {
        return educationCount;
    }

    public void setEducationCount(Integer educationCount) {
        this.educationCount = educationCount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.firstname);
        hash = 73 * hash + Objects.hashCode(this.lastname);
        hash = 73 * hash + Objects.hashCode(this.gender);
        hash = 73 * hash + Objects.hashCode(this.educationCount);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonDto other = (PersonDto) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.educationCount, other.educationCount)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersonDto{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender + ", educationCount=" + educationCount + '}';
    }
    
    
    
    
}
