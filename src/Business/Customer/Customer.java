/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.RealEstate.Property;
import Business.Services.RentalRequest;
import java.util.ArrayList;

/**
 *
 * @author Shalom Daniel
 */
public class Customer {
    
    private String userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int age;
    private String address;
    private String emailId;
    private Long phoneNumber;
    private String fullName ;
    private String role = "Customer";
    private Boolean actvity_status = false;
    float rentPrice = 0.0f;
    
    private float rentalsTotal;
    private ArrayList<RentalRequest> customerRentalList;
    
    private Property property;

    
    public Customer(String userId, String firstName, String lastName, String userName, String password, int age, String emailId, Long phoneNumber){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.fullName = firstName + " " + lastName;
        this.age = age;
        this.address = address;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.actvity_status = actvity_status;

        this.customerRentalList = new ArrayList<RentalRequest>();
        this.rentalsTotal = 0;  
        
        this.property = new Property();

    }
   

    public float getRentalsTotal() {
        return rentalsTotal;
    }

    public void setRentalsTotal(float rentalsTotal) {
        this.rentalsTotal = rentalsTotal;
    }  


    public ArrayList<RentalRequest> getCustomerRentalList() {
        return customerRentalList;
    }

    public void setCustomerRentalList(ArrayList<RentalRequest> customerRentalList) {
        this.customerRentalList = customerRentalList;
    }

    
    public void addOrder(RentalRequest RentalRequest) {
        this.customerRentalList.add(RentalRequest);
    }
    
    public float calculateRentPrice(String lease_Type, float dailyRate) {
        int rentPeriod = 0;
        if(lease_Type.equals("6 months")){
            rentPeriod = 6;
        }else{
            rentPeriod = 12;
        }
        rentPrice = rentPeriod * dailyRate;
        
        return rentPrice;
    }
    
    public float calculateTotalPrice(float rentPrice) {
        rentalsTotal = rentalsTotal + rentPrice;
        return rentalsTotal;
    }
    
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    } 
    
    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    } 
    
    public Boolean getActvity_status() {
        return actvity_status;
    }

    public void setActvity_status(Boolean actvity_status) {
        this.actvity_status = actvity_status;
    }
    
    public float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(float rentPrice) {
        this.rentPrice = rentPrice;
    }   

      

    @Override
    public String toString(){
        return String.valueOf(userId);
    }      
  
}
