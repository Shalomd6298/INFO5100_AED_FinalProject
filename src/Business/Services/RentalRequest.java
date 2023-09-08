/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Services;

import Business.Customer.Customer;
import Business.RealEstate.Lease;
import Business.RealEstate.Property;


public class RentalRequest {
    
    Customer customer;
    Property property;
    Lease lease;
    private static int count = 0;
    String application_id;
    String application_status;  

    public RentalRequest(String application_id, Customer customer, Property property, Lease lease) {
        this.application_id = application_id;
        this.customer = customer;
        this.property = property;
        this.lease = lease;
    }

    
    public static int getCount() {
        return count;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getApplication_status() {
        return application_status;
    }

    public void setApplication_status(String application_status) {
        this.application_status = application_status;
    }
    

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }    
    
    
    @Override
    public String toString() {
       return this.application_id;
    }    
    
}
