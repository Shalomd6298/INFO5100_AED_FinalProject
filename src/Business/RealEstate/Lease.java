/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.RealEstate;


public class Lease {

    String type;
    Boolean isLeaseSigned = false;
    String start_date;
    String leaseDoc;
    
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsLeaseSigned() {
        return isLeaseSigned;
    }

    public void setIsLeaseSigned(Boolean isLeaseSigned) {
        this.isLeaseSigned = isLeaseSigned;
    }
        
    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getLeaseDoc() {
        return leaseDoc;
    }

    public void setLeaseDoc(String leaseDoc) {
        this.leaseDoc = leaseDoc;
    }
    
    
}
