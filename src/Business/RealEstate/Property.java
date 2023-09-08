/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.RealEstate;

import java.util.Date;


public class Property {

    String ID;
    Float price;
    String address;
    String full_address;
    Integer no_of_rooms;
    Integer no_of_bathrooms;

    Boolean isAvailable = true;
    
    String city;
    String state;
    Double zip;

    Double latitude ;
    Double Longitude;
    
    Lease lease;
    
    
    public Property() {
        this.ID = ID;
        this.no_of_rooms = no_of_rooms; 
        this.no_of_bathrooms = no_of_bathrooms; 
        this.price = price;
        this.address = address;
        this.full_address = full_address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.latitude = latitude;
        this.Longitude = Longitude;
        this.isAvailable = isAvailable;
        this.lease = new Lease();
        
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double Longitude) {
        this.Longitude = Longitude;
    }
    
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
 

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getZip() {
        return zip;
    }

    public void setZip(Double zip) {
        this.zip = zip;
    }
    
    public String getFull_address() {
        return full_address;
    }

    public void setFull_address(String full_address) {
        this.full_address = full_address;
    }
  
    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }   
 
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getNo_of_rooms() {
        return no_of_rooms;
    }

    public void setNo_of_rooms(Integer no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }

    public Integer getNo_of_bathrooms() {
        return no_of_bathrooms;
    }

    public void setNo_of_bathrooms(Integer no_of_bathrooms) {
        this.no_of_bathrooms = no_of_bathrooms;
    }
    

    @Override
    public String toString(){
        return String.valueOf(this.ID);
    }    
    
}
