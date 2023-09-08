/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Employer;

/**
 *
 */
public class EmployerProfile{

    String id;
    String fullname;
    String Role;
    Float experience;

    public EmployerProfile(String id, String fullname, String Role, Float exp) {
        this.id = id;
        this.fullname = fullname;
        this.Role = Role;
        this.experience = exp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public Float getExperience() {
        return experience;
    }

    public void setExperience(Float experience) {
        this.experience = experience;
    }    
    
  
    
    @Override
    public String toString(){
        return String.valueOf(this.id);
    }
    
}
