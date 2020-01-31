package Logic;

import Model.Encomienda;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class MatrizDistancia {

    int[][] matrizC;

    public void Matriz(int ciudadx, int ciudady, int paquetes, ArrayList<Encomienda> enco) {
        matrizC = new int[paquetes][paquetes];
        Encomienda en, en1;
        int d, x, y;
        for (int i = 0; i < matrizC.length; i++) {
            en = new Encomienda();
            en = enco.get(i);
            for (int j = 0; j < matrizC.length; j++) {
                en1 = new Encomienda();
                en1 = enco.get(j);
                x = Math.abs(en.getX() - en1.getX());
                y = Math.abs(en.getY() - en1.getY());
                d = x + y;
                matrizC[i][j] = d;
            }
        }

        JOptionPane.showMessageDialog(null, matrizC);

        for (int[] matrizC1 : matrizC) {
            for (int j = 0; j < matrizC.length; j++) {
                System.out.print(" " + matrizC1[j]);
            }
            System.out.println("");
        }

    }

    public void DibujoMatriz(int ciudadx, int ciudady, ArrayList<Encomienda> enco) {
        int x = ciudadx + 1;
        int y = ciudady + 1;
        String[][] dibujo = new String[x][y];

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dibujo[i][j] = "■";

                for (int e = 0; e < enco.size(); e++) {
                    if (i == enco.get(e).getX() && j == enco.get(e).getY()) {
                        dibujo[i][j] = String.valueOf(e);
                    }
                }

            }
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                System.out.print(" " + dibujo[i][j]);
            }
            System.out.println("");
        }

    }

    public int[][] getMatrizC() {
        return matrizC;
    }

}
