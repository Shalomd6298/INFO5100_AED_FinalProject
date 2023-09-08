/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.User;

import java.util.ArrayList;
import Business.User.User;
import javax.swing.JOptionPane;

/**
 *
 * @author Shalom Daniel
 */
public class UserDirectory {
    private ArrayList<User> users;
    
    public UserDirectory() {
        this.users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    public Boolean CheckIfIDExists(String id) {

        for (User u : users) {
            if (u.getUserId().equals(id))
                return true;
        }
        return false;
    }
    
    public User getUserById(String userId) {
        
        //User selectedUser = new User();
        for(User user : users) {
            if(user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
    

    public User findById(String id) {
        for(User u: this.users) {
            if(u.getUserId().equals(id)) {
                return u;
            }
        }
        return null;
    }
    
    public ArrayList<User> getUsersByRole(String userRole) {
        
        ArrayList<User> selectedUsers = new ArrayList<User>();
        for(User user : users) {
            if(user.getRoleType().equals(userRole)) {
                selectedUsers.add(user);
            }
        }
        return selectedUsers;
    }
    
    public Boolean accountExists(String username, String password, String role) {
        for(User u: this.users) {
            if(u.getUserName().equals(username) && u.getPassword().equals(password) && u.getRoleType().equals(role)) {
                return true;
            }
        }
        
        return false;
    }  
    
    public User getUserAccount(String username, String password, String role) {
        for(User u: this.users) {
            if(u.getUserName().equals(username) && u.getPassword().equals(password) && u.getRoleType().equals(role)) {
                return u;
            }
        }
        
        return null;
    } 
    
     public User createUserAccount(String username, String password, String role, String ID) {
        User user = new User(username, password, role, ID);
        
        if(CheckIfIDExists(ID).equals(true)){
            JOptionPane.showMessageDialog(null, "Sorry! This ID already exists. Create a new ID. ");           
        }else{
            users.add(user);
        }
        return user; 
    }   
    
//    public void updateUser (User user) {
//        User newUser = new User();
//        
//        int position = 0;
//        for (int iter = 0; iter < users.size(); iter++) {
//            if((users.get(iter).getUserId()).equals(user.getUserId())) {
//                position = iter;
//                break;
//            }
//        }
//        
//        newUser.setUserId(user.getUserId());
//        newUser.setFirstName(user.getFirstName());
//        newUser.setLastName(user.getLastName());
//        newUser.setUserName(user.getUserName());
//        newUser.setPassword(user.getPassword());
//        newUser.setRoleType(user.getRoleType());
//        newUser.setAddress(user.getAddress());
//        newUser.setPhoneNumber(user.getPhoneNumber());
//        newUser.setEmailId(user.getEmailId());
//        newUser.setAge(user.getAge());
//        
//        users.set(position, newUser);
//    }
}
