/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author narot
 */
public class CustomerBillingDirectory {
    
    Float rent_total, services_total;
    
    ArrayList<CustomerBilling> customerBillingList;

    public CustomerBillingDirectory() {
        this.customerBillingList = new ArrayList<CustomerBilling>();
    }

    public ArrayList<CustomerBilling> getCustomerBillingList() {
        return customerBillingList;
    }

    public void setCustomerBillingList(ArrayList<CustomerBilling> customerBillingList) {
        this.customerBillingList = customerBillingList;
    }
    
    public void addCustomerBilling(CustomerBilling cb) {
        this.customerBillingList.add(cb);
    }
    
    public Float getTotalRentRevenue(){
        rent_total = 0.0f; 
        for(CustomerBilling cb : customerBillingList){
            if(cb.getFacilityUsed().equals("Total Rent Amount")){
                rent_total = rent_total + cb.getPrice();
            }
        }
//        System.out.println("Business.Customer.CustomerBillingDirectory.getTotalRentRevenue() " + rent_total );
        return rent_total;
    }
    
    public Float getTotalServicesRevenue(){
        services_total = 0.0f; 
        for(CustomerBilling cb : customerBillingList){
            if(!cb.getFacilityUsed().equals("Total Rent Amount")){
                services_total = services_total + cb.getPrice();
            }
        }
//        System.out.println("Business.Customer.CustomerBillingDirectory.getTotalRentRevenue() " + services_total );
        return services_total;
    }
    
    
}
