
package Main;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class MotorHelice implements Runnable{
    private int pos_x, pos_y, angulo, lado;
    private Main main;
    public boolean mover_helice=false;
    
    public MotorHelice(Main main) {
        this.pos_x=0;
        this.pos_y=200;
        this.angulo=10;
        this.lado=200;
        this.main=main;
    }
    
    public void Paint(Graphics2D g){
        ImageIcon icon_helice=new ImageIcon("src/Images/helice.png");
        icon_helice.setImage(icon_helice.getImage().getScaledInstance(lado, lado, Image.SCALE_SMOOTH));
        g.fillRect(pos_x+50, pos_y+50, lado-100, main.getHeight()-(pos_y+200));
        g.rotate(Math.toRadians(angulo), (lado/2)+pos_x,(lado/2)+pos_y);
        g.drawImage(icon_helice.getImage(), pos_x, pos_y, null);
    }
    public void Mover(){
        int i, j=3;
        while(mover_helice || j>3){
            i=(int)(5*Math.log(j/3));
            try {
                main.repaint();
                Thread.sleep(30);
                angulo+=i;
            } catch (Exception e) {}
            if(mover_helice){
                j++;
            }if(!mover_helice){
                j-=4;
            }if(i>20){
                if(j%100==0){
                    double temp=(double)Temperatura.spiner_temp.getValue()-(i/100f);
                    Temperatura.spiner_temp.setValue(temp);
                }
            }
        }
    }
    
    public void Parar(){
        mover_helice=false;
        Sonido.clip_motor.stop();
    }
    public void Iniciar(){
        mover_helice=true;
        Sonido.clip_motor.setFramePosition(0);//poner en una posicion especifica el inicio del clip
        Sonido.clip_motor.start();
    }
    public boolean IsMove(){
        return mover_helice;
    }
    
    @Override public void run(){
        Mover();
    }
}
