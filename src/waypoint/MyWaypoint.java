package waypoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

public class MyWaypoint extends DefaultWaypoint {
    
    String image_type;
    String address;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public MyWaypoint(String name, EventWaypoint event, GeoPosition coord, String address, String image_type) {
        super(coord);
        this.address = address;
        this.button = button;
        this.name = name;
        
        if(image_type.equals("pin")){
           initButton(event);  
        }else {
            surroundingWaypoints(event, image_type);
        }
//        else if(image_type.equals("university")){
//            surroundingWaypoints(event, image_type);
//        }

    }

    public MyWaypoint() {
    }

    private String name;
    private JButton button;
    

    private void initButton(EventWaypoint event) {
        String image_type = "pin";
        button = new ButtonWaypoint(image_type);
//        button.addMouseListener(new MouseAdapter(){
//          public void mouseEntered(MouseEvent me) { 
//            JOptionPane.showMessageDialog(null, address);
//          }
//        });      
        
        button.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, address); 
            }
        });
    }
    
    private void surroundingWaypoints(EventWaypoint event, String image_type) {
        button = new ButtonWaypoint(image_type);    
        button.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, name); 
            }
        });
    }    
    
}
