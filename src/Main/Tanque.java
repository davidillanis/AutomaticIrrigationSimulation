
package Main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/*@author LENOVO::DAVID ABEL*/
public class Tanque {
    private Main main;
    private int pos_x, pos_y;
    
    public Tanque(Main main) {
        this.main = main;
        this.pos_x=50;
        this.pos_y=50;
    }
    
    public void Paint(Graphics2D g){
        g.setColor(new Color(138,149,156));
        g.fillRoundRect(pos_x*16, pos_y+(50/2), 15, 100, 10, 10);
        g.fillRoundRect(pos_x*8, pos_y+(50/2), 410, 15, 10, 10);
        g.fillRoundRect(pos_x*8, pos_y+(50/2), 15, 350, 10, 10);
        //g.fillOval(pos_x*10, pos_y-20, 106, 100);
        
        ImageIcon icon_bomba_agua=new ImageIcon("src/Images/bomba_agua.png");
        icon_bomba_agua.setImage(icon_bomba_agua.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
        g.drawImage(icon_bomba_agua.getImage(), pos_x*10, pos_y-20, null);
        
        ImageIcon icon_tangue=new ImageIcon("src/Images/tanque.png");
        icon_tangue.setImage(icon_tangue.getImage().getScaledInstance(300, 450, Image.SCALE_SMOOTH));
        g.drawImage(icon_tangue.getImage(), pos_x*13, pos_y*3, null);
        
        ImageIcon icon_sensor_humedad=new ImageIcon("src/Images/sensor.png");
        icon_sensor_humedad.setImage(icon_sensor_humedad.getImage().getScaledInstance(30, 77, Image.SCALE_SMOOTH));
        g.rotate(Math.toRadians(45), (pos_x*9)+20, pos_y*9);//ROtacion--------------------------------------------------------
        g.drawImage(icon_sensor_humedad.getImage(), pos_x*9, pos_y*8, null);
    }
}
