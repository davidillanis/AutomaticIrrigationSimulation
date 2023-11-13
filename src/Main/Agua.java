
package Main;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/*@author LENOVO::DAVID ABEL*/
public class Agua extends JPanel implements Runnable{
    private Main main;
    private int pos_x, pos_y, lado=5;
    private boolean cae_agua;
    public Agua(Main main) {
        this.main = main;
        this.pos_x=410;
        this.pos_y=440;
        this.cae_agua=false;
    }
    
    public void Paint(Graphics2D g){
        g.setColor(new Color(0, 255, 255));
        
        for(int i=0; i<10 && cae_agua; i++){
            lado=(int)(Math.random()*7+2);
            pos_x=410+i*((int)((Math.random()*-8+4)));
            pos_y=440+i*((int)((Math.random()*-8+4)));
            g.fillOval(pos_x, pos_y, lado, lado);
        }
    }
    
    @Override public void run(){
        int i=0, cont=0;
        while(cae_agua){
            try {
                Thread.sleep(180);
                main.repaint();
                if(i%10==0 && i>20){
                    int val_humedad=(int)Humedad.slider_humedad.getValue();
                    Humedad.slider_humedad.setValue(val_humedad+1+((cont*cont)/3000));
                    if(val_humedad>=65){
                        Parar();
                    }
                }
                main.pant_led.ActualizarHumedad();
            } catch (Exception e) {}
            i++; cont++;
        }
    }
    public void Iniciar(){
        cae_agua=true;
        Sonido.clip_agua.setFramePosition(0);//poner en una posicion especifica el inicio del clip
        Sonido.clip_agua.start();
        
    }
    public void Parar(){
        cae_agua=false;
        Sonido.clip_agua.stop();
    }
    public boolean CaeAgua(){
        return cae_agua;
    }
}
