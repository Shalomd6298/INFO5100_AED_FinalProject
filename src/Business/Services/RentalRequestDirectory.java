/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Services;


import Business.Customer.Customer;
import Business.RealEstate.Lease;
import Business.RealEstate.Property;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author shalomdaniel
 */

public class RentalRequestDirectory {

    ArrayList<RentalRequest> rentalList;

    
    public RentalRequestDirectory() {
        
        this.rentalList = new ArrayList<RentalRequest>();
        
    }
    
    // create a new order
    public RentalRequest createOrder(Customer customer, Property property, Lease lease) {
        UUID uuid = UUID.randomUUID();
        String application_id = "RentR_" + uuid.toString();
        
        RentalRequest r = new RentalRequest(application_id, customer, property, lease);
        r.setApplication_id(application_id);
        r.setCustomer(customer);
        r.setProperty(property);
        r.setLease(lease);

        this.rentalList.add(r);
        return r;
    }
    
    
    public ArrayList<RentalRequest> getRentalList() {
        return rentalList;
    }

    public void setRentalList(ArrayList<RentalRequest> rentalList) {
        this.rentalList = rentalList;
    }
    
    public RentalRequest findById(Customer c) {
        for(RentalRequest r: this.rentalList) {
            if(r.getCustomer().getUserId().equals(c.getUserId())) {
                return r;
            }
        }
        
        return null;
    }
       
    
}
