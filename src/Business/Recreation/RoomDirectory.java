/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Recreation;

import Business.Customer.*;
import Business.RealEstate.Property;
import Business.Services.RentalRequest;
import Business.User.User;
import java.util.ArrayList;


public class RoomDirectory {
    
    Room room;
    ArrayList<Room> rooms;


    public RoomDirectory() {
        rooms = new ArrayList<Room>();
    }
        
    public Room createRoom(String ID, Boolean availability) {

        Room r = new Room();
        r.setRoomID(ID);
        r.setAvailability(availability);
        
        rooms.add(r);
        return r;
    }
    
    public Room findRoomByID(String id) {

        for (Room r : rooms) {
            if (r.getRoomID().equals(id)) {
                return r;
            }
        }
            return null; //not found after going through the whole list
    }

    
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    
//    public Boolean userIDExists(String userID) {
//        for(Customer c : customerlist) {
//            if (c.getUserId().equals(userID)) {
//                return true;
//            }
//        }
//        
//        return false;
//    }
//    
//    public Boolean userNameExists(String userNmae) {
//        for(Customer c : customerlist) {
//            if (c.getUserName().equals(userNmae)) {
//                return true;
//            }
//        }
//        
//        return false;
//    }
//    
//    public Boolean accountExists(String username, String password, String role) {
//        for(Customer c: this.customerlist) {
//            if(c.getUserName().equals(username) && c.getPassword().equals(password) && c.getRole().equals(role)) {
//                return true;
//            }
//        }
//        
//        return false;
//    }     
    
 
    

 
}
