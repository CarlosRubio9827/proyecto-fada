/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Model.Encomienda;
import com.sun.deploy.uitoolkit.impl.fx.ui.FXUIFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.naming.InsufficientResourcesException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Ejercicio1 {

    public static int w[];

    public int entregarE(int actual, ArrayList<Encomienda> entregas, int[][] D) {

        if (entregas.size() == 1) {
            return D[actual][entregas.get(0).getIndex()];
        }else{
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < entregas.size(); i++) { 
            Encomienda e = entregas.get(i); 

            ArrayList<Encomienda> copy = (ArrayList<Encomienda>) entregas.clone();
            copy.remove(i);

            int val = (D[actual][e.getIndex()]) + (entregarE(e.getIndex(), copy, D));
            //min = (val < min) ? val : min;
            if (val < min) {
                min = val;
                w[i] = e.getIndex();

            }
        } 

        return min;
    }}

    public void recorrido() {
        //  w[0] =0;
        System.out.println("Recorrido- \n");
        for (int i = 0; i < w.length; i++) {
            System.out.print("-" + w[i]);
        }
    }

    public int[][] encomiendas(ArrayList<Encomienda> entregas, int[][] D) {
        
        HashMap<String, ArrayList> tabla = new HashMap<>();
        
        String data = (String) tabla.toString();
        System.out.println("HASH TABLE"+data);
        //  int n = entregas.size();
        int S[][] = new int[D.length][D.length];
        int E[][] = new int[D.length][D.length];

        for (int i = 0; i < entregas.size(); i++) {
            S[i][i] = D[i][i];
            for (int j = 0; j < entregas.size(); j++) {
                S[i][j] = Integer.MAX_VALUE;
                if (S[i][j] > D[i][j] + S[j][entregas.size() - 1]) {
                    S[i][j] = D[i][j] + S[j][entregas.size() - 1];
                    E[i][j] = j;
                }
            }
            //  S[4][4]=S[4][entregas.size()-1]+S[4-1][entregas.size()-1];
        }
        elecion(E);
        return S;
    }

    public int[][] elecion(int[][] E) {
        for (int i = 0; i < E.length; i++) {
            for (int j = 0; j < E.length; j++) {
                System.out.print(" " + E[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\n");
        return E;
    }
}
