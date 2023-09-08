/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Canteen;

import java.util.ArrayList;

/**
 *
 * @author narot
 */
public class MealPlanDirectory {
    private ArrayList<MealPlan> mealPlanDirectory;
    
    public MealPlanDirectory() {
        this.mealPlanDirectory = new ArrayList<MealPlan>();
    }
    
    public void addNewMenuData(MealPlan fb) {
        this.mealPlanDirectory.add(fb);
    }
    
    public void deleteMenuData(MealPlan fb) {
        this.mealPlanDirectory.remove(fb);
    }
    
    public void updateExistingMenuData(MealPlan fb, int index) {
        this.mealPlanDirectory.set(index, fb);
    }
    
    public MealPlan getItemByName(String itemName) {

        MealPlan selectedItem = new MealPlan();
        for (MealPlan item : mealPlanDirectory) {
            if (item.getMealName().equals(itemName)) {
                selectedItem = item;
                break;
            }
        }
        return selectedItem;
    }

    public ArrayList<MealPlan> getMealPlanDirectory() {
        return mealPlanDirectory;
    }

    public void setMealPlanDirectory(ArrayList<MealPlan> mealPlanDirectory) {
        this.mealPlanDirectory = mealPlanDirectory;
    }
    
}
