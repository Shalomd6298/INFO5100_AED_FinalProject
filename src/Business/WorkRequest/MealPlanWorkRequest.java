/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkRequest;

import Business.Canteen.MealPlan;
import java.util.ArrayList;

/**
 *
 * @author narot
 */
public class MealPlanWorkRequest {
    
    String userId;
    ArrayList<MealPlan> MealPlanDetails;
    String status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<MealPlan> getMealPlanDetails() {
        return MealPlanDetails;
    }

    public void setMealPlanDetails(ArrayList<MealPlan> MealPlanDetails) {
        this.MealPlanDetails = MealPlanDetails;
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
