/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.PropertyManagement;

import Business.Customer.Customer;
import Business.RealEstate.Lease;
import Business.RealEstate.Property;

/**
 *
 * @author narot
 */
public class ServiceRequest {
    
    Customer customer;
    ServiceProvider serviceprovider;
    Property property;
    private static int count = 0;
    String service_id;
    String service_type;
    String service_subject;
    String service_desc;
    String service_status;
    String serviceProvider_comment;
    Integer service_price;
    
    public ServiceRequest(String service_id, Customer customer, String service_type, String service_subject, String service_desc, String service_status, Integer service_price){
        this.customer = customer;
        this.service_id = service_id;
        this.service_type = service_type;
        this.service_subject = service_subject;
        this.service_desc = service_desc;
        this.service_status = service_status;
        this.service_price = service_price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ServiceProvider getServiceprovider() {
        return serviceprovider;
    }

    public void setServiceprovider(ServiceProvider serviceprovider) {
        this.serviceprovider = serviceprovider;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        ServiceRequest.count = count;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getService_desc() {
        return service_desc;
    }

    public void setService_desc(String service_desc) {
        this.service_desc = service_desc;
    }

    public String getService_subject() {
        return service_subject;
    }

    public void setService_subject(String service_subject) {
        this.service_subject = service_subject;
    }

    public String getService_status() {
        return service_status;
    }

    public void setService_status(String service_status) {
        this.service_status = service_status;
    }

    public String getServiceProvider_comment() {
        return serviceProvider_comment;
    }

    public void setServiceProvider_comment(String serviceProvider_comment) {
        this.serviceProvider_comment = serviceProvider_comment;
    }

    public Integer getService_price() {
        return service_price;
    }

    public void setService_price(Integer service_price) {
        this.service_price = service_price;
    }
    
    @Override
    public String toString() {
       return this.service_id;
    }
    
}
