/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.PropertyManagement;

import java.util.ArrayList;


public class LaundaryDirectory {
    ArrayList<Laundary> laundryDirectory;
    
    public LaundaryDirectory(){
        this.laundryDirectory = new ArrayList<>();
    }

    public ArrayList<Laundary> getLaundryDirectory() {
        return laundryDirectory;
    }

    public void setLaundryDirectory(ArrayList<Laundary> laundryDirectory) {
        this.laundryDirectory = laundryDirectory;
    }
    
    public Laundary getLaundries(int index){
        Laundary newLaundry = new Laundary();
        newLaundry = laundryDirectory.get(index);
        return newLaundry;
    }
    
    public Laundary addLaundryDetails(){
        Laundary newLaundry = new Laundary();
        laundryDirectory.add(newLaundry);
        
        return newLaundry;
    }
    
    public Laundary getLaundryByName(String laundryName) {
        
        Laundary selectedLaundry = new Laundary();
        for(Laundary laundry : laundryDirectory) {
            if(laundry.getCategory().equals(laundryName)) {
                selectedLaundry = laundry;
                break;
            }
        }
        return selectedLaundry;
    }
    
    public void deleteLaundry(Laundary laundry){
        laundryDirectory.remove(laundry);
    }

}

