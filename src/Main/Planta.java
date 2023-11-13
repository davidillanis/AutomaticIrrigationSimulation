
package Main;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/*@author LENOVO::DAVID ABEL*/
public class Planta {
    private Main main;
    private int pos_x, pos_y;

    public Planta(Main main) {
        this.pos_x=300;
        this.pos_y=400;
        this.main = main;
    }
    
    public void Paint(Graphics2D g){
        ImageIcon icon_planta=new ImageIcon("src/Images/planta.png");
        ImageIcon icon_maceta=new ImageIcon("src/Images/maceta.png");
        icon_planta.setImage(icon_planta.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
        g.drawImage(icon_maceta.getImage(), pos_x, pos_y, null);
        g.drawImage(icon_planta.getImage(), pos_x-20, pos_y-210, null);
    }
}
