/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkRequest;

import Business.PropertyManagement.Laundary;

/**
 *
 * @author narot
 */
public class LaundryWorkRequest {
    
    String userId;
    Laundary laundryDetails;
    int numberOfClothes;
    String status;

    public int getNumberOfClothes() {
        return numberOfClothes;
    }

    public void setNumberOfClothes(int numberOfClothes) {
        this.numberOfClothes = numberOfClothes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Laundary getLaundryDetails() {
        return laundryDetails;
    }

    public void setLaundryDetails(Laundary laundryDetails) {
        this.laundryDetails = laundryDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return userId;
    }
    
}
