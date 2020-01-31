/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fada.views.include;

import fada.models.Animation;
import fada.controllers.Controller;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Map extends javax.swing.JInternalFrame {

    /**
     * Creates new form Map
     */
    private Animation animation;

    public Map() {
        initComponents();
        setFrameIcon(Controller.map_icon);
        container.setLayout(new BorderLayout());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        btn_calcular = new javax.swing.JButton();
        btn_iniciar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mapa");

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 51), 3, true));
        container.setToolTipText("Mapa");

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );

        btn_calcular.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        btn_calcular.setForeground(new java.awt.Color(204, 0, 51));
        btn_calcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fada/views/resources/Route.png"))); // NOI18N
        btn_calcular.setText("Calcular Ruta");
        btn_calcular.setToolTipText("Calcular la ruta mas optima.");
        btn_calcular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        btn_iniciar.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        btn_iniciar.setForeground(new java.awt.Color(204, 0, 51));
        btn_iniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fada/views/resources/Map.png"))); // NOI18N
        btn_iniciar.setText("Iniciar");
        btn_iniciar.setToolTipText("Mostrar la ruta");
        btn_iniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_iniciar.setEnabled(false);
        btn_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_calcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(87, 87, 87)
                        .addComponent(btn_iniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_calcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_iniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed
        try {
            String[] options = {
                "Sin limite",
                "Limite tiempo",
                "Voraz"
            };
            String response = (String) JOptionPane.showInputDialog(this,
                    "Seleccione un algoritmo", "Algoritmo",
                    JOptionPane.DEFAULT_OPTION,
                    Controller.route_icon, options, options[0]);
            if (response != null) {
                if (response.equals("Limite tiempo")) {
                    JOptionPane.showMessageDialog(this, "Limite: "
                            + Controller.config.getLimit()
                            + "\nTiempo por calle: "
                            + Controller.config.getTime(), "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                long start = System.currentTimeMillis();

                switch (response) {
                    case "Sin limite":
                        Controller.result.
                                A1(Controller.config.getList());
                        Controller.config.setRoute(
                                Controller.result.
                                        A1_R(Controller.config.getPlaces(),
                                                Controller.config.getOffice()));
                        break;
                    case "Limite tiempo":
                        Controller.config.setRoute(
                                Controller.result.
                                        A2_R(Controller.config.getPlaces(),
                                                Controller.config.getOffice()));
                        break;
                    case "Voraz":
                        Controller.config.setRoute(
                                Controller.result.
                                        A3_R(Controller.config.getPlaces(),
                                                Controller.config.getOffice()));
                        break;
                }
                long end = System.currentTimeMillis() - start;

                JOptionPane.showMessageDialog(this,
                        "Operacion terminada\nTiempo: "
                        + end + " milisegundos", "Exito", -1,
                        Controller.check_icon);
                animation = new Animation(btn_calcular, btn_iniciar);
                container.removeAll();
                container.add(animation, BorderLayout.CENTER);
                container.updateUI();
                btn_iniciar.setEnabled(true);
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }//GEN-LAST:event_btn_calcularActionPerformed

    private void btn_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarActionPerformed
        // TODO add your handling code here:
        animation.start();
    }//GEN-LAST:event_btn_iniciarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_iniciar;
    private javax.swing.JPanel container;
    // End of variables declaration//GEN-END:variables
}