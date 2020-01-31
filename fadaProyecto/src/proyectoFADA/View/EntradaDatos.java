package proyectoFADA.View;

import proyectoFADA.Model.Logica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EntradaDatos extends javax.swing.JInternalFrame implements ActionListener {

    ArrayList<String> data = new ArrayList<>();
    //Menus
    JMenuBar barraMenu = new JMenuBar();
    JMenu menuOpciones = new JMenu("Opciones");
    JMenuItem ItemSalir = new JMenuItem("Salir");

    Logica logi;

    //interfaz
    public EntradaDatos() {

        logi = new Logica();

        //    ent = new Entrada();
        //Agregar Informacion ala barra de menu
        menuOpciones.addSeparator();
        ItemSalir.addActionListener(this);
        menuOpciones.add(ItemSalir);
        barraMenu.add(menuOpciones);
        setJMenuBar(barraMenu);

        //Panel Principal 
        JFileChooser jFileChooser1 = new JFileChooser();

        try {
            jFileChooser1.setCurrentDirectory(new File("C:\\Users\\Lenovo\\Google Drive\\UNIVERSIDAD\\8 OCTAVO SEMESTRE\\FADA\\PROYECTO"));
            jFileChooser1.showOpenDialog(jFileChooser1);

            String patch = jFileChooser1.getSelectedFile().getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(patch));

            String cadena;

            while ((cadena = br.readLine()) != null) {
                data.add(cadena);
            }
        } catch (Exception e) {
            System.out.println("er" + e);
        }
//====================================================================
        String[] primerLinea = data.get(0).split(",");
        int ciudadx = Integer.parseInt(primerLinea[0]);
        int ciudady = Integer.parseInt(primerLinea[1]);
        int timerecorrer = Integer.parseInt(primerLinea[2]);

//===================================================================
        String[] segundaLinea = data.get(1).split(",");
        int paquetes = Integer.parseInt(segundaLinea[0]);
        int tiempomensajero = Integer.parseInt(segundaLinea[1]);

//===================================================================                    
        String[] terceraLinea = data.get(1).split(",");
        int ubicacionOficinax = Integer.parseInt(terceraLinea[0]);
        int ubicacionOficinay = Integer.parseInt(terceraLinea[1]);

//==================================================================
        JOptionPane.showMessageDialog(null, ciudadx + "," + ciudady + "," + timerecorrer);

        for (int j = 0; j < data.size(); j++) {
            System.out.println("epa" + data.get(j));
        }


        //Tamaño jinternalframe
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

       }
}
