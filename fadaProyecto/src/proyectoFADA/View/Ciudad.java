package proyectoFADA.View;

import proyectoFADA.Model.Logica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ciudad extends javax.swing.JInternalFrame implements ActionListener {

    //Menus
    JMenuBar barraMenu = new JMenuBar();
    JMenu menuOpciones = new JMenu("Opciones");
    JMenuItem ItemSalir = new JMenuItem("Salir");
   

    Logica logi;
    
    Entrada ent;

    //interfaz
    public Ciudad() {
 
      
        
        logi = new Logica();
    //    ent = new Entrada();

        //Agregar Informacion ala barra de menu
        menuOpciones.addSeparator();
        ItemSalir.addActionListener(this);
        menuOpciones.add(ItemSalir);
        barraMenu.add(menuOpciones);
        setJMenuBar(barraMenu);

        //Panel Principal 
        JPanel Principal = new JPanel();
        Principal.setLayout(new GridLayout(logi.alto, logi.ancho));

        //Colocar Matriz Botones

        for (int i = 0; i < logi.alto; i++) {
            for (int j = 0; j < logi.ancho; j++) {

                logi.matrizBoton[i][j] = new JButton();
                logi.matrizBoton[i][j].addActionListener(this);
                logi.matrizBoton[i][j].setBackground(Color.GRAY);
             //   logi.matrizBoton[i][j].setIcon(logi.img3);
                Principal.add(logi.matrizBoton[i][j]);
            }
            add(Principal, "Center");
        }
   /*
            logi.matrizBoton[1][3].setIcon(logi.img2);
            logi.matrizBoton[0][4].setIcon(logi.img1);
            logi.matrizBoton[2][0].setIcon(logi.img1);
            logi.matrizBoton[2][2].setIcon(logi.img1);
            logi.matrizBoton[4][1].setIcon(logi.img1);
            logi.matrizBoton[5][0].setIcon(logi.img1);
            logi.matrizBoton[5][4].setIcon(logi.img1);
        
        */     


        //Tamaño jframe
        setLocation(250, 40);
        setSize(600, 600);
        setResizable(false);
        setTitle("Proyecto FADA");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ItemSalir) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Esta seguro que Desea \nabandonar?", "FADA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            switch (opcion) {
                case JOptionPane.YES_OPTION:
                    dispose();
                    break;
                case JOptionPane.NO_OPTION:
                default:
            }
        }

        int x = 0;
        int y = 0;

        logi.LogicaProyecto(x, y);


      
    }
}
