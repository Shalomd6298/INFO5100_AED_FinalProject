/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Employer;


import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 */
public class EmployerDirectory {
    
    EmployerProfile EP;

    ArrayList<EmployerProfile> employerlist;

    public EmployerDirectory() {

        employerlist = new ArrayList<EmployerProfile>();


    }

    public EmployerProfile newEmployerProfile(String ID, String fullname, String role, Float experience) {

        EmployerProfile ep = new EmployerProfile(ID, fullname, role, experience);
        
        if(CheckIfIDExists(ID).equals(true)){
            JOptionPane.showMessageDialog(null, "Sorry! This ID already exists. Create a new ID. ");
        }else{
            ep.setId(ID);
            ep.setFullname(fullname);
            ep.setRole(role);
            ep.setExperience(experience);
            employerlist.add(ep);         
        }
        return ep;  

    }
    
    public Boolean CheckIfIDExists(String id) {

        for (EmployerProfile e : employerlist) {
            if (e.getId().equals(id))
                return true;
        }
        return false;
    }
    

    public EmployerProfile findEmployer(String id) {

        for (EmployerProfile ep : employerlist) {

            if (ep.equals(id)) {
                return ep;
            }
        }
            return null; //not found after going through the whole list
    }

    public ArrayList<EmployerProfile> getEmployerlist() {
        return employerlist;
    }

    public void setEmployerlist(ArrayList<EmployerProfile> employerlist) {
        this.employerlist = employerlist;
    }

    
    public EmployerProfile getEP() {
        return EP;
    }

    public void setEP(EmployerProfile EP) {
        this.EP = EP;
    }

    
}
