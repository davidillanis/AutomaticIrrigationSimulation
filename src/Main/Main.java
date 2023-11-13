
package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/*@author LENOVO::DAVID ABEL*/
public class Main extends JPanel implements ActionListener{
    private JFrame ventana;
    private JLabel label_fondo, label_led;
    private int base, altura;
    protected JToggleButton btn_tiempo;
    protected MotorHelice motor=new MotorHelice(this);
    protected Temperatura temp=new Temperatura(this);
    protected Planta planta=new Planta(this);
    protected Tanque tanque=new Tanque(this);
    protected Agua agua=new Agua(this);
    protected Humedad humedad=new Humedad(this);
    protected Sonido sonido=new Sonido();
    protected PantallaLed pant_led=new PantallaLed(this);
    
    public Main() {
        this.base=1000;
        this.altura=700;
        this.setLayout(null);
        JPanelIniciar();
        JToggleButtonIniciar();
        JLabelIniciar();
    }
    public void IniciarVentana(){
        ventana=new JFrame();
        ventana.add(Main.this);
        ventana.setSize(base,altura);
        ventana.setLocationRelativeTo(this);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
    private void JLabelIniciar(){
        ImageIcon icon_led=new ImageIcon("src/Images/led1.png");
        label_led=new JLabel("Label LED");
        label_led.setIcon(new ImageIcon(icon_led.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        label_led.setBounds(400,10,50,50);
        add(label_led);
        
        ImageIcon icon_fondo=new ImageIcon("src/Images/fondo.png");
        label_fondo=new JLabel();
        label_fondo.setIcon(new ImageIcon(icon_fondo.getImage().getScaledInstance(base, altura, Image.SCALE_SMOOTH)));
        label_fondo.setBounds(0,0,base,altura);
        add(label_fondo);
    }
    private void JPanelIniciar(){
        temp.setBounds(0, 0, 200, 200);
        temp.setLayout(null);
        temp.setOpaque(false);
        add(temp);
        
        humedad.setBounds(510, 450, 100, 80);
        humedad.setLayout(null);
        humedad.setOpaque(false);
        add(humedad);
        
        pant_led.setBounds(10, 500, 300, 140);
        pant_led.setLayout(null);
        pant_led.setOpaque(false);
        add(pant_led);
    }
    private void JToggleButtonIniciar(){
        ImageIcon icon=new ImageIcon("src/Images/dia.png");
        icon.setImage(icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        
        btn_tiempo=new JToggleButton("Dia",icon);
        btn_tiempo.setFont(new Font("Rockwell",0,20));
        btn_tiempo.setBorder(null);
        btn_tiempo.setOpaque(false);
        btn_tiempo.setContentAreaFilled(false);
        btn_tiempo.setBounds(200,50,180,70);
        btn_tiempo.addActionListener(this);
        add(btn_tiempo);
    }

    @Override public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_tiempo){
            ImageIcon icon_dia=new ImageIcon("src/Images/dia.png");
            icon_dia.setImage(icon_dia.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
            ImageIcon icon_noche=new ImageIcon("src/Images/noche.png");
            icon_noche.setImage(icon_noche.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
            
            if(btn_tiempo.isSelected()){
                btn_tiempo.setIcon(icon_noche);
                btn_tiempo.setForeground(Color.WHITE);
                btn_tiempo.setText("Noche");
                ImageIcon icon_fondo=new ImageIcon("src/Images/fondo3.png");
                icon_fondo.setImage(icon_fondo.getImage().getScaledInstance(base, altura, Image.SCALE_SMOOTH));
                label_fondo.setIcon(icon_fondo);
                SensorLuzActivado();
            }else{
                btn_tiempo.setIcon(icon_dia);
                btn_tiempo.setForeground(Color.BLACK);
                btn_tiempo.setText("Dia");
                ImageIcon icon_fondo=new ImageIcon("src/Images/fondo.png");
                icon_fondo.setImage(icon_fondo.getImage().getScaledInstance(base, altura, Image.SCALE_SMOOTH));
                label_fondo.setIcon(icon_fondo);
                SensorLuzDesactivado();
            }
        }
    }
    @Override public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d_general=(Graphics2D)g.create();
        Graphics2D g2d_motor=(Graphics2D)g.create();
        Graphics2D g2d_planta=(Graphics2D)g.create();
        Graphics2D g2d_agua=(Graphics2D)g.create();
        
        g2d_motor.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d_planta.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d_general.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d_agua.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        motor.Paint(g2d_motor);
        planta.Paint(g2d_planta);
        tanque.Paint(g2d_general);
        agua.Paint(g2d_agua);
        
        g2d_motor.dispose();
        g2d_planta.dispose();
        g2d_general.dispose();
        g2d_agua.dispose();
    }
    public void SensorLuzActivado(){
        //Protección contra heladas o Activación del riego durante el día
        ImageIcon icon_led=new ImageIcon("src/Images/led2.png");
        label_led.setIcon(new ImageIcon(icon_led.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
    }
    public void SensorLuzDesactivado(){
        ImageIcon icon_led=new ImageIcon("src/Images/led1.png");
        label_led.setIcon(new ImageIcon(icon_led.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
    }
    public static void main(String[] args) {
        Main main=new Main();
        main.IniciarVentana();
    }

}
