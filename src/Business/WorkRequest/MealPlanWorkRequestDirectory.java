/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkRequest;

import java.util.ArrayList;

/**
 *
 * @author narot
 */
public class MealPlanWorkRequestDirectory {
    
    ArrayList<MealPlanWorkRequest> mealPlanWorkRequestList;
    
    public MealPlanWorkRequestDirectory(){
        this.mealPlanWorkRequestList = new ArrayList<MealPlanWorkRequest>();
    }

    public ArrayList<MealPlanWorkRequest> getMealPlanWorkRequestList() {
        return mealPlanWorkRequestList;
    }

    public void setMealPlanWorkRequestList(ArrayList<MealPlanWorkRequest> mealPlanWorkRequestList) {
        this.mealPlanWorkRequestList = mealPlanWorkRequestList;
    }
    
    public void updateMealWorkRequest(MealPlanWorkRequest fbr, int index) {
        this.mealPlanWorkRequestList.set(index, fbr);
    }
}
