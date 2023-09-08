/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.RealEstate;

import java.util.ArrayList;


public class PropertyDirectory {
    
    private ArrayList<Property> properties ; 

    public PropertyDirectory(){
        this.properties = new ArrayList<Property>();
    }
    

    
    public Property createProperty(String ID, Integer no_of_rooms, Integer no_of_bathrooms, String address, String city, String state, Double zip, Float price, String leaseType, String start_date, Boolean isAvailable, Double latitude, Double longitude){
        Property property = new Property();
        
        property.setID(ID);
        property.setNo_of_rooms(no_of_rooms);
        property.setNo_of_bathrooms(no_of_bathrooms);
        property.setAddress(address);
        property.setCity(city);
        property.setState(state);
        property.setZip(zip);
        property.setPrice(price);
        property.getLease().setType(leaseType);
        property.getLease().setStart_date(start_date);        
        property.setIsAvailable(isAvailable);
        property.setFull_address(address + ", " + city + ", " + state + " - " + zip);
        property.setLatitude(latitude);
        property.setLongitude(longitude); 
    
        this.properties.add(property);
        
        return property;
        
    }
    
    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }
    
}
