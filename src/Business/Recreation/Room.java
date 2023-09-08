/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Recreation;

import Business.Customer.Customer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import net.miginfocom.layout.IDEUtil;


public class Room {
    
    String roomID;
    Boolean availability;
    Integer no_of_requests = 0;
    ArrayList<Booking> bookings;


    public Room() {
        this.roomID = roomID;
        this.availability = availability;
        this.bookings = new ArrayList<>();
        
    }  

    
    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public Integer getNo_of_requests() {
        return no_of_requests;
    }

    public void setNo_of_requests(Integer no_of_requests) {
        this.no_of_requests = no_of_requests;
    }    
      
    
    public void addBooking(String id, String date, String startTime, String endTime, Customer customer) {
        Booking booking = new Booking(id, date, startTime, endTime, customer);
        bookings.add(booking);
        no_of_requests = no_of_requests +1;
        
        JOptionPane.showMessageDialog(null, "Room Booked! You can find your booked room details in the Current Room Bookings Panel. ");
        
    }
    
    public Boolean checkTimeSlotAvailability(String date, String startTime, String endTime){
        
        for (Booking booking : bookings) {
            if (booking.getDate().equals(date) && endTime.equals(booking.getEnd_time())
                    && startTime.equals(booking.getStart_time())) {
                
                // there is a booking conflict, so don't add the new booking
                return false;
            }
        }
        // no conflicts, so add the new booking
        return true ;

    }
    
    public Booking findBookingByID(String id) {

        for (Booking b : bookings) {
            if (b.getID().equals(id)) {
                return b;
            }
        }
        return null; //not found after going through the whole list
    }
    
   
    @Override
    public String toString(){
        return String.valueOf(this.roomID);
    }   
    
}
