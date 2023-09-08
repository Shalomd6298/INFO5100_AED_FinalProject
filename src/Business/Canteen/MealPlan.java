/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Canteen;

/**
 *
 * @author narot
 */
public class MealPlan {
    String MealId;
    String category;
    String MealName;
    String MealDescription;
    Double price;
    
    public MealPlan(){
        
    }
    
    public MealPlan(String mealId, String category, String mealname, String mealDesc, Double price){
            this.setMealId(mealId);
            this.setCategory(category);
            this.setMealName(mealname);
            this.setMealDescription(mealDesc);
            this.setPrice(price);
    }

    public String getMealId() {
        return MealId;
    }

    public void setMealId(String MealId) {
        this.MealId = MealId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMealName() {
        return MealName;
    }

    public void setMealName(String MealName) {
        this.MealName = MealName;
    }

    public String getMealDescription() {
        return MealDescription;
    }

    public void setMealDescription(String MealDescription) {
        this.MealDescription = MealDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    
    @Override
    public String toString() {
        return MealId;
    }
    
}
