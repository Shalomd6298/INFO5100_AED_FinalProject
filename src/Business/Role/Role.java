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

public abstract class Role {
    static String[] roles = {"SysAdmin", "Real Estate Manager", "Customer", "Recreation Manager", "Electrician" };

    public static String[] getRoles() {
        return roles;
    }
    
    
    public abstract JFrame getWorkArea(EcoSystem ecoSystem, User user);
    
}
