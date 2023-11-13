
package Main;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*@author LENOVO::DAVID ABEL*/
public class Temperatura extends JPanel implements ChangeListener{
    private JLabel label_txt;
    public static JSpinner spiner_temp;
    private Main main;

    public Temperatura(Main main) {
        this.main=main;
        JLabelIniciar();
        JSpinnerIniciar();
    }
    private void JLabelIniciar(){
        label_txt=new JLabel("Temperatura");
        label_txt.setBounds(0,50,150,30);
        label_txt.setFont(new Font("Rockwell",0,18));
        label_txt.setForeground(Color.WHITE);
        add(label_txt);
    }
    private void JSpinnerIniciar(){
        SpinnerModel model_spiner = new SpinnerNumberModel(0,0,50,0.1);

        spiner_temp = new JSpinner(model_spiner);
        spiner_temp.setBounds(120, 50, 70, 30);
        spiner_temp.setFont(new Font("Rockwell", 0, 19));
        spiner_temp.setForeground(Color.BLUE);
        spiner_temp.setBorder(null);
        spiner_temp.setValue(27.9);
        spiner_temp.addChangeListener(this);
        add(spiner_temp);
    }

    @Override public void stateChanged(ChangeEvent e) {
        if(e.getSource()==spiner_temp){
            LogicaTemperatura();
        }
    }
    private void LogicaTemperatura(){
        double temp=(double) spiner_temp.getValue();
        Thread hilo1=new Thread(main.motor);
        main.pant_led.ActualizarTemperatura();
        if(temp>=29 && !main.motor.IsMove()){
            main.motor.Iniciar();
            hilo1.start();
        }else if(temp<29){
            main.motor.Parar();
        }
    }
    public Double getTemperatura(){
        return (double) spiner_temp.getValue();
    }
}
