/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.User;

import Business.EcoSystem;
import Business.Role.RealEstateManagerRole;
//import Business.Role.SysAdminRole;
import Business.Role.SysAdminRole;
import UI.Customer.CustomerJFrame;
import UI.Recreation.RecreationManagerJFrame;
import UI.Canteen.CanteenManagerJFrame;
import UI.Customer.CustomerJFrame;
import UI.LaundaryServices.LaundaryManagerJFrame;
import UI.PropertyManager.PropertyManagerJFrame;
import UI.ServiceProvider.electrcian.ElectricianJFrame;
import UI.ServiceProvider.plumber.PlumberJFrame;
import javax.swing.JFrame;

/**
 *
 * @author Shalom Daniel
 */
public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int age;
    private String address;
    private String emailId;
    private Long phoneNumber;
    private String roleType;
    private static int count = 0;

    public User(String userName, String password, String roleType, String userId) {
//        this.userId = "ACC00" + count++;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.roleType = roleType;
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

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }  
    
    public JFrame getWorkArea(String role, EcoSystem ecosystem, User user) {
        // the abstract class way
        if (role.equals("System Admin")) {
            return new SysAdminRole().getWorkArea(ecosystem, user);
        }
        if (role.equals("Real Estate Manager")) {
            return new RealEstateManagerRole().getWorkArea(ecosystem, user);

        }
        if (role.equals("Customer")) {
            return new CustomerJFrame(ecosystem, user);
        }

        if (role.equals("Recreation Manager")) {
            return new RecreationManagerJFrame(ecosystem, user);
        }
        
        if (role.equals("Electrician")) {
            return new ElectricianJFrame(ecosystem, user);
        }
        
        if (role.equals("Plumber")) {
            return new PlumberJFrame(ecosystem, user);
        }
        
        if (role.equals("Property Manager")) {
            return new PropertyManagerJFrame(ecosystem, user);
        }
        
        if (role.equals("Canteen Manager")) {
            return new CanteenManagerJFrame(ecosystem, user);
        }
        
        if (role.equals("Laundary Manager")) {
            return new LaundaryManagerJFrame(ecosystem, user);

        }
//        if (role.equals("Employer")) {
//            return new EmployerJFrame(business, useraccount);
//        }
        return null;
    }    
    
}
