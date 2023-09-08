/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;


public class EcoSystem {

    public static EcoSystem ecosystem;

    ArrayList<Network> networkList;
    
    Network network;
    
    
    public EcoSystem(){    
        this.network = new Network();  
    }
    
    public static EcoSystem getInstance() {
        if (ecosystem == null) {
            ecosystem = new EcoSystem();
            return ecosystem;
        }
        return ecosystem;
    }
    
    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
    
    public static EcoSystem getEcosystem() {
        return ecosystem;
    }

    public static void setEcosystem(EcoSystem ecosystem) {
        EcoSystem.ecosystem = ecosystem;
    }    
    
    // create network and add to the list
}
