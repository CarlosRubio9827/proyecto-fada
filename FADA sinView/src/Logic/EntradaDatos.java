package Logic;

import Model.Encomienda;
import View.Ciudad;
import java.awt.HeadlessException;
import javax.swing.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EntradaDatos {

    ArrayList<String> data = new ArrayList<>();
    int paquetes[][];
    ArrayList<Encomienda> enco;

//    ArrayList<Encomienda> entregas = (ArrayList<Encomienda>) enco.clone();
    public EntradaDatos() {

        enco = new ArrayList<>();
        JFileChooser jFileChooser1 = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("FADA FILES", "fada");
        jFileChooser1.setFileFilter(filter);
        try {
            jFileChooser1.setCurrentDirectory(new File("..\\fadaProyecto\\Test"));
            jFileChooser1.showOpenDialog(jFileChooser1);

            String patch = jFileChooser1.getSelectedFile().getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(patch));

            String cadena;

            while ((cadena = br.readLine()) != null) {
                data.add(cadena);
            }
        } catch (HeadlessException | IOException e) {
            System.out.println("er" + e);
        }

        try {

            //Primer Linea
            String[] primerLinea = data.get(0).split(",");
            int ciudadx = Integer.parseInt(primerLinea[0]);
            int ciudady = Integer.parseInt(primerLinea[1]);
            int timerecorrer = Integer.parseInt(primerLinea[2]);
            //Segunda Linea
            String[] segundaLinea = data.get(1).split(",");
            int paquetes = Integer.parseInt(segundaLinea[0]);
            int tiempomensajero = Integer.parseInt(segundaLinea[1]);
            //Tercer Linea                 
            String[] terceraLinea = data.get(2).split(",");
            int ubicacionOficinax = Integer.parseInt(terceraLinea[0]);
            int ubicacionOficinay = Integer.parseInt(terceraLinea[1]);
            //Encomiendas
            System.out.println("OFICINA " + ubicacionOficinax + "," + ubicacionOficinay + " paquetes=" + paquetes);
            for (int j = 3; j < data.size(); j++) {
                String[] lineasSiguientes = data.get(j).split(",");
                int ubicacionx = Integer.parseInt(lineasSiguientes[0]);
                int ubicaciony = Integer.parseInt(lineasSiguientes[1]);
                Encomienda e = new Encomienda(j - 3, ubicacionx, ubicaciony);
                enco.add(e);
                System.out.println("encomineda " + (j - 2) + " - " + "[" + data.get(j) + "]");
            }
            //Matriz de distancia
          
            System.out.println("Matriz distancia= " );
            MatrizDistancia md1 = new MatrizDistancia();
            md1.Matriz(ciudadx, ciudady, paquetes, enco);
            System.out.println("\nCIUDAD \n\n");
            md1.DibujoMatriz(ciudadx, ciudady, enco);

            Ejercicio1 e = new Ejercicio1();
            e.w = new int[paquetes + 1];

            //dibujo
            Ciudad c = new Ciudad(ciudadx, ciudady, enco);
            c.setVisible(true);
            //Recursivo
            int min = e.entregarE(0, enco, md1.matrizC);

            System.out.println("MINIMO= " + min);
            //JOptionPane.showMessageDialog(null, "El costo de la ruta mas optima es: "+min);

            //Iterativo
            /*
            int[][] S = new int[md1.matrizC.length][md1.matrizC.length];
            S = e.encomiendas(enco, md1.matrizC);
            for (int j = 0; j < S.length; j++) {
                for (int k = 0; k < S.length; k++) {
                    System.out.print(" " + S[k][j]);
                }
                System.out.println("");
            }
            */
            //e.recorrido();

        } catch (ExceptionInInitializerError e) {
            // System.out.println("err" + e);
        }
    }

}
