package waypoint;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonWaypoint extends JButton {

    String image_type;
    
    public ButtonWaypoint(String image_type) {
        this.image_type = image_type;
        setContentAreaFilled(false);
        setIcon(new ImageIcon(getClass().getResource("/images/" + image_type + ".png")));
//        System.out.println("/images/" + image_type + ".png");
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        if(image_type.equals("pin")){
            setSize(new Dimension(36, 36));          
        }else{
            setSize(new Dimension(28, 28));
        }

    }
}
