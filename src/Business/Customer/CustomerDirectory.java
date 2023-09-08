/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.RealEstate.Property;
import Business.Services.RentalRequest;
import Business.User.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Shalom Daniel
 */
public class CustomerDirectory {
    
    Customer customer;
    ArrayList<Customer> customerlist;
    Float totalRent = 0.0f;


    public CustomerDirectory() {
        customerlist = new ArrayList<Customer>();
    }
        
     
    public Boolean CheckIfIDExists(String id) {

        for (Customer c : customerlist) {
            if (c.getUserId().equals(id))
                return true;
        }
        return false;
    }
   
    
    public Customer createCustomerProfile(String userId, String firstName, String lastName, String userName, String password, int age, String emailId, Long phoneNumber) {
        Customer c = new Customer(userId, firstName, lastName, userName, password, age, emailId, phoneNumber);
        
        if(CheckIfIDExists(userId).equals(true)){
            JOptionPane.showMessageDialog(null, "Sorry! This ID already exists. Create a new ID. ");
        }else{
            c.setUserId(userId);
            c.setFirstName(firstName);
            c.setLastName(lastName);
            c.setUserName(userName);
            c.setPassword(password);
            c.setAge(age);
            c.setEmailId(emailId);
            c.setPhoneNumber(phoneNumber);

            customerlist.add(c);            
        }
        return c;
    }

    public Customer prePopulate(String userId, String firstName, String lastName, String userName, String password, int age, String emailId, Long phoneNumber) {

        Customer c = new Customer(userId, firstName, lastName, userName, password, age, emailId, phoneNumber);
        c.setUserId(userId);
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setUserName(userName);
        c.setPassword(password);
        c.setAge(age);
        c.setEmailId(emailId);
        c.setPhoneNumber(phoneNumber);
        
        customerlist.add(c);
        return c;
    }
    
    public Customer findCustomer(String id) {

        for (Customer c : customerlist) {
            if (c.getUserId().equals(id)) {
                return c;
            }
        }
            return null; //not found after going through the whole list
    }
    
    public Boolean userIDExists(String userID) {
        for(Customer c : customerlist) {
            if (c.getUserId().equals(userID)) {
                return true;
            }
        }
        
        return false;
    }
    
    public Boolean userNameExists(String userNmae) {
        for(Customer c : customerlist) {
            if (c.getUserName().equals(userNmae)) {
                return true;
            }
        }
        
        return false;
    }
    
    public Boolean accountExists(String username, String password, String role) {
        for(Customer c: this.customerlist) {
            if(c.getUserName().equals(username) && c.getPassword().equals(password) && c.getRole().equals(role)) {
                return true;
            }
        }
        
        return false;
    }     
    
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Customer> getCustomerlist() {
        return customerlist;
    }

    public void setCustomerlist(ArrayList<Customer> customerlist) {
        this.customerlist = customerlist;
    }

    public Float getTotalRent() {
        return totalRent;
    }

    public void setTotalRent(Float totalRent) {
        this.totalRent = totalRent;
    }
      
    
    public Customer findCustomerByPropertyId(Property p) {
        for(Customer c: this.customerlist) {
            for(RentalRequest r : c.getCustomerRentalList()){
                if(r.getProperty().getID().equals(p.getID())){
                    return c;
                }
            }
        }
        
        return null;
    }
    
    public int getNumberOfActiveCustomers(){
        int count = 0;
        for(Customer c: this.customerlist) {
            if(c.getActvity_status().equals(true)){
                count ++;
            }
        }  
        return count;          
    }
    
    public void GetTotalRentRevenue(){
        totalRent = 0.0f;
        for(Customer c : this.customerlist){
            totalRent = totalRent + c.getRentPrice();
        }
        System.out.println("Z: " + totalRent);
    }
    
 
}
