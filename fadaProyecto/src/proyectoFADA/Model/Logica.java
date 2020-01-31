package proyectoFADA.Model;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import proyectoFADA.View.Entrada;


public class Logica {
    Entrada ent ;
    
    public JFrame container;

    //botones
    public JButton[][] matrizBoton;
    //imagenes
    public ImageIcon img1; //entrega
    public ImageIcon img2; //oficina
    public ImageIcon img3; //


    public Logica() {
        matrizBoton = new JButton[alto][ancho];
        img1 = new ImageIcon("foto1.png");
        img2 = new ImageIcon("foto2.png");
        img3 = new ImageIcon("foto3.png");
        
       //ent = new Entrada();
        
    }

   
    public int alto = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese alto"));
    public int ancho =Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese ancho"));

    //==========  determinar menor tiempo de entrega  ==========
    public void LogicaProyecto(int x, int y) {

    }

}
