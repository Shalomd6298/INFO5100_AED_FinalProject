/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.User.User;
import javax.swing.JFrame;

/**
 *
 */

public class RealEstateManagerRole extends Role {

    public RealEstateManagerRole() {
        
    }

    
    @Override
    public JFrame getWorkArea(EcoSystem ecoSystem, User user) {
        return new UI.RealEstate.ManagerJFrame(ecoSystem, user);
    }
    
}