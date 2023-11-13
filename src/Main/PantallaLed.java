
package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*@author LENOVO::DAVID ABEL*/
public class PantallaLed extends JPanel{
    private JLabel label_led, label_txt, label_simbolo, label_humedad, label_temperatura;
    private Main main;

    public PantallaLed(Main main) {
        this.main = main;
        this.setLayout(null);
        JLabelIniciar();
    }
    private void JLabelIniciar(){
        label_txt=new JLabel("Humedad:");
        label_txt.setBounds(30, 40, 150, 30);
        label_txt.setForeground(Color.WHITE);
        label_txt.setFont(new Font("Courier New",0,20));
        add(label_txt);
        
        label_simbolo=new JLabel("%");
        label_simbolo.setBounds(230, 40, 150, 30);
        label_simbolo.setForeground(Color.WHITE);
        label_simbolo.setFont(new Font("Courier New",0,20));
        add(label_simbolo);
        
        label_txt=new JLabel("Temperatura:");
        label_txt.setBounds(30, 70, 150, 30);
        label_txt.setForeground(Color.WHITE);
        label_txt.setFont(new Font("Courier New",0,20));
        add(label_txt);
        
        label_simbolo=new JLabel("°C");
        label_simbolo.setBounds(250, 70, 150, 30);
        label_simbolo.setForeground(Color.WHITE);
        label_simbolo.setFont(new Font("Courier New",0,20));
        add(label_simbolo);
        
        label_humedad=new JLabel(Integer.toString(main.humedad.getHumedad()));
        label_humedad.setBounds(190, 40, 90, 30);
        label_humedad.setForeground(Color.WHITE);
        label_humedad.setFont(new Font("Courier New",0,20));
        add(label_humedad);
        
        label_temperatura=new JLabel(Double.toString(main.temp.getTemperatura()));
        label_temperatura.setBounds(190, 70, 90, 30);
        label_temperatura.setForeground(Color.WHITE);
        label_temperatura.setFont(new Font("Courier New",0,20));
        add(label_temperatura);
        
        ImageIcon icon=new ImageIcon("src/Images/pantalla_led.png");
        label_led=new JLabel();
        label_led.setIcon(new ImageIcon(icon.getImage().getScaledInstance(300, 140, Image.SCALE_SMOOTH)));
        label_led.setBounds(0,0,300,140);
        add(label_led);
    }
    
    public void ActualizarTemperatura(){
        BigDecimal number = new BigDecimal(Double.toString(main.temp.getTemperatura()));
        BigDecimal roundedNumber = number.setScale(2, RoundingMode.HALF_UP);
        double p_total = roundedNumber.doubleValue();
        label_temperatura.setText(Double.toString(p_total));
    }
    public void ActualizarHumedad(){
        label_humedad.setText(Integer.toString(main.humedad.getHumedad()));
    }
}
