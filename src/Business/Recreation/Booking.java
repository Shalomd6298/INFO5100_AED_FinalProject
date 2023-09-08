/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Recreation;

import Business.Customer.Customer;

/**
 *
 * @author Shalom Daniel <your.name at your.org>
 */
public class Booking {

    
    String date;
    String start_time;
    String end_time;
    Customer customer;
    String id;
    
    
    public Booking(String id, String date, String start_time, String end_time, Customer customer) {
        this.id = id;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.customer = customer;  
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }   
    
    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }
    
    
    @Override
    public String toString(){
        return String.valueOf(this.id);
    }    
    

}
