/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoFADA.Main;

import proyectoFADA.View.Ciudad;
import proyectoFADA.View.Frame;

/**
 *
 * @author Lenovo
 */
public class ProyectoFADA {

    public static void main(String[] args) {
        try {
           Frame f = new Frame();
           f.setVisible(true);
                   
        } catch (Exception error) {
            System.out.println(error);
            
        }

    }
}
