package View;

import Logic.EntradaDatos;
import Logic.MatrizDistancia;
import Model.Encomienda;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ciudad extends javax.swing.JFrame implements ActionListener {

    //Menus
    JMenuBar barraMenu = new JMenuBar();
    JMenu menuOpciones = new JMenu("Opciones");
    JMenuItem mdi = new JMenuItem("Matriz Distancia");
    JMenuItem ItemSalir = new JMenuItem("Salir");

    int alto;
    int ancho;

    //botones
    public JButton[][] matrizBoton;
    //imagenes
    public ImageIcon img1; //entrega
    public ImageIcon img2; //oficina
    String m;

    public void dinujar(int alto, int ancho) {
    }

    //interfaz
    public Ciudad(int alto, int ancho, ArrayList<Encomienda> enco) {
        int x = alto + 1;
        int y = ancho + 1;

        matrizBoton = new JButton[x][y];
        img1 = new ImageIcon("foto1.png");
        img2 = new ImageIcon("foto2.png");

        Color azul = Color.decode("#3465A4");
        Color amarillo = Color.decode("#FFF200");
        Font fuente = new Font("Calibri", 1, 15);

        //    ent = new Entrada();
        //Agregar Informacion ala barra de menu
        menuOpciones.addSeparator();
        ItemSalir.addActionListener(this);
        menuOpciones.add(ItemSalir);
        menuOpciones.add(mdi);
        barraMenu.add(menuOpciones);
        setJMenuBar(barraMenu);

        //Panel Principal 
        JPanel Principal = new JPanel();

        Principal.setLayout(new GridLayout(alto, ancho));

        //Colocar Matriz Botones
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {

                matrizBoton[i][j] = new JButton();
                matrizBoton[i][j].addActionListener(this);
                matrizBoton[i][j].setBackground(Color.GRAY);
                // matrizBoton[i][j].setEnabled(false);
                matrizBoton[i][j].setFont(fuente);
                matrizBoton[i][j].setText(String.valueOf(i + " " + j));

                for (int e = 1; e < enco.size(); e++) {
                    if (i == enco.get(e).getX() && j == enco.get(e).getY() && e != 0) {
                        matrizBoton[i][j].setBackground(amarillo);
                        matrizBoton[i][j].setText(String.valueOf(enco.get(e).getIndex()));

                    } else if (i == enco.get(0).getX() && j == enco.get(0).getY()) {
                        matrizBoton[i][j].setBackground(azul);
                        /*
                matrizBoton[enco.get(0).getX()][enco.get(0).getY()].setBackground(azul);
                         */
                    }
                }
                Principal.add(matrizBoton[i][j]);
            }
            add(Principal, "Center");
        }

        //Tamaño jframe
        setLocation(250, 40);
        setSize(600, 600);
        setResizable(true);
        setTitle("Proyecto FADA");
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ItemSalir) {
            int opcion = JOptionPane.showConfirmDialog(this,
                    "¿Esta seguro que Desea \nabandonar?", "FADA",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            switch (opcion) {
                case JOptionPane.YES_OPTION:
                    this.dispose();
                    break;
                case JOptionPane.NO_OPTION:
                default:
            }
        } else if (ae.getSource() == mdi) {
            //   EntradaDatos ed = new EntradaDatos();

        }

    }

}
