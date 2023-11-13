
package Main;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*@author LENOVO::DAVID ABEL*/
public class Humedad extends JPanel implements ChangeListener{
    private JLabel label_txt;
    //public static JSpinner spiner_humedad;
    public static JSlider slider_humedad;
    private Main main;

    public Humedad(Main main) {
        this.main=main;
        JLabelIniciar();
        JSpinnerIniciar();
    }
    private void JLabelIniciar(){
        label_txt=new JLabel("Humedad");
        label_txt.setBounds(0,10,150,30);
        label_txt.setFont(new Font("Rockwell",0,18));
        label_txt.setForeground(Color.WHITE);
        add(label_txt);
    }
    private void JSpinnerIniciar(){
        SpinnerModel model_spiner = new SpinnerNumberModel(0,0,100,1);

//        spiner_humedad = new JSpinner(model_spiner);
//        spiner_humedad.setBounds(0, 38, 50, 30);
//        spiner_humedad.setFont(new Font("Rockwell", 0, 19));
//        spiner_humedad.setForeground(Color.BLUE);
//        spiner_humedad.setBorder(null);
//        spiner_humedad.setValue(66);
//        spiner_humedad.addChangeListener(this);
//        add(spiner_humedad);
        
        slider_humedad = new JSlider(0,100,66);
        slider_humedad.setMajorTickSpacing(25);
        slider_humedad.setMinorTickSpacing(5);
        slider_humedad.setPaintTicks(true);
        slider_humedad.setPaintLabels(true);
        slider_humedad.setBounds(0,38,100,50);
        slider_humedad.setFont(new Font("serif", 0, 10));
        slider_humedad.setForeground(Color.BLUE);
        slider_humedad.addChangeListener(this);
        slider_humedad.setOpaque(false);
        //slider_humedad.setOrientation(SwingConstants.VERTICAL);
        add(slider_humedad);
    }
    
    @Override public void stateChanged(ChangeEvent e) {
        if(e.getSource()==slider_humedad && !main.agua.CaeAgua()){
            LogicaHumedad();
        }
    }
    private void LogicaHumedad(){
        int humedad=(int) slider_humedad.getValue();
        Thread hilo=new Thread(main.agua);
        main.pant_led.ActualizarHumedad();
        if(humedad<60){
            main.agua.Iniciar();
            hilo.start();
        }else{
            main.agua.Parar();
        }
    }
    public int getHumedad(){
        return (int) slider_humedad.getValue();
    }
}
