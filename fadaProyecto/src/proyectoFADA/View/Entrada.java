/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoFADA.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Entrada extends javax.swing.JInternalFrame {

    ArrayList<String> data = new ArrayList<>();
     public int ciudadx =6;

    public Entrada() {

        initComponents();

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
            System.out.println("er"+e);
        }
//====================================================================
            String[] primerLinea = data.get(0).split(",");
             ciudadx = Integer.parseInt(primerLinea[0]);
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

            JOptionPane.showMessageDialog(null, ciudadx+","+ciudady+","+timerecorrer);

            for (int j = 3; j < data.size(); j++) {
                System.out.println("epa" + data.get(j));
            }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed

    }//GEN-LAST:event_jFileChooser1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables

public int  Pasardatos(){
    
return ciudadx;
}

}
