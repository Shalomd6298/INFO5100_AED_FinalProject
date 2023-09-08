/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.PropertyManagement;

import java.util.ArrayList;


public class ServiceProviderDirectory {
    
    ServiceProvider serviceprovider;
    
    ArrayList<ServiceProvider> ServiceProviderList;


    public ServiceProviderDirectory(){
        ServiceProviderList = new ArrayList<ServiceProvider>();
    }
    
    public ServiceProvider createServiceProvider(String userId, String firstName, String lastName, String userName, String password, int age, String emailId, Long phoneNumber, String role) {

        ServiceProvider sp = new ServiceProvider(userId, firstName, lastName, userName, password, age, emailId, phoneNumber, role);
        sp.setUserId(userId);
        sp.setFirstName(firstName);
        sp.setLastName(lastName);
        sp.setUserName(userName);
        sp.setPassword(password);
        sp.setAge(age);
        sp.setEmailId(emailId);
        sp.setPhoneNumber(phoneNumber);
        sp.setRole(role);
        
        ServiceProviderList.add(sp);
        return sp;
    }
    
    public ServiceProvider findServiceProvider(String id) {

        for (ServiceProvider e : ServiceProviderList) {
            if (e.getUserId().equals(id)) {
                return e;
            }
        }
            return null; //not found after going through the whole list
    }
    
    public ServiceProvider findServiceProviderbyName(String name) {

        for (ServiceProvider e : ServiceProviderList) {
            if (e.getFullName().equals(name)) {
                return e;
            }
        }
            return null; //not found after going through the whole list
    }
    
    public Boolean accountExistsServiceProvider(String username, String password, String role) {
        for(ServiceProvider e: this.ServiceProviderList) {
            if(e.getUserName().equals(username) && e.getPassword().equals(password) && e.getRole().equals(role)) {
                return true;
            }
        }
        return false;
    }

    public ServiceProvider getServiceprovider() {
        return serviceprovider;
    }

    public void setServiceprovider(ServiceProvider serviceprovider) {
        this.serviceprovider = serviceprovider;
    }

    public ArrayList<ServiceProvider> getServiceProviderList() {
        return ServiceProviderList;
    }

    public void setServiceProviderList(ArrayList<ServiceProvider> ServiceProviderList) {
        this.ServiceProviderList = ServiceProviderList;
    }

    
    
}
