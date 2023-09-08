/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.PropertyManagement;

import Business.Customer.Customer;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author narot
 */
public class ServiceRequestDirectory {
    
    ServiceProviderDirectory serviceporviderdirectory;
    ArrayList<ServiceRequest> servicerequestlist;
    
    public ServiceRequestDirectory(){
        this.servicerequestlist = new ArrayList<ServiceRequest>();
    }
    
    public ServiceRequest customerServicerequest(Customer customer, String service_type, String service_subject, String service_desc, String service_status, Integer service_price) {
        UUID uuid = UUID.randomUUID();
        String service_id = uuid.toString();
        
        ServiceRequest sr = new ServiceRequest(service_id, customer, service_type, service_subject, service_desc, service_status, service_price);
        sr.setService_id(service_id);
        sr.setService_type(service_type);
        sr.setService_subject(service_subject);
        sr.setService_status(service_status);
        sr.setService_price(service_price);
        sr.setService_desc(service_desc);
        
        this.servicerequestlist.add(sr);
        return sr;
    }
    
    public ServiceRequest findServiceReqByID(String serviceId){
        for (ServiceRequest s : servicerequestlist) {
            if (s.getService_id().equals(serviceId)) {
                return s;
            }
        }
            return null;
    }
    
    public void updatServiceStatus(ServiceRequest selectedservicerequest, String serviceprovidercomment, String status, Integer price){
        
        for (ServiceRequest serviceRequest : this.getServicerequestlist()) {
            if (serviceRequest.getService_id().equals(selectedservicerequest.getService_id())) {
                serviceRequest.setService_status(status);
                serviceRequest.setServiceProvider_comment(serviceprovidercomment);
                serviceRequest.setService_price(price);
            }
        }
    }

    public ArrayList<ServiceRequest> getServicerequestlist() {
        return servicerequestlist;
    }

    public void setServicerequestlist(ArrayList<ServiceRequest> servicerequestlist) {
        this.servicerequestlist = servicerequestlist;
    }

    public ServiceProviderDirectory getServiceporviderdirectory() {
        return serviceporviderdirectory;
    }

    public void setServiceporviderdirectory(ServiceProviderDirectory serviceporviderdirectory) {
        this.serviceporviderdirectory = serviceporviderdirectory;
    }
    
}
