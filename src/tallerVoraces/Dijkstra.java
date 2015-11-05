/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerVoraces;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Santitigaga & Sebastian Lopez
 */
public class Dijkstra {

    String matriz[][];

    Dijkstra() {

    }

    public void dijkstra(HashMap<String, LinkedList<String>> mapa, String cadena) {
        String cad = cadena;
        String sel;
        LinkedList<String> solucion = new LinkedList<>();
        //System.out.println("-" + cad);
        matriz = new String[mapa.size()][mapa.size() + 1];
        //System.out.println("size: " + mapa.size() + " -- length " + matriz.length);

        //----------------llendo la matriz
        Iterator it = mapa.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            String key = (String) it.next();
            matriz[i][0] = key;
            i++;
        }

        int iter = 1; // Numero del a columna sobre la que voy iterando  
        while (iter < mapa.size()) {
            for (int j = 0; j < matriz[0].length - 1; j++) {
                if (cad.length() == 1) {
                    if (matriz[j][0].equals(cad)) {
                        matriz[j][iter] = 0 + "," + cad + "," + "*";
                    }

                    for (String get1 : adyacentes(mapa, cad)) {
                        if (matriz[j][0].equals(get1.split(",")[0]) && matriz[j][iter] == null) {
                            matriz[j][iter] = get1.split(",")[1] + "," + cad;
                        }
                    }

                } else {
                    if (matriz[j][0].equals(cad.split(",")[0])) {
                        matriz[j][iter] = cad.split(",")[1] + "," + cad.split(",")[0] + "," + "*";
                    }
                }

                for (String get1 : adyacentes(mapa, cad.split(",")[0])) {
                    if (matriz[j][0].equals(get1.split(",")[0]) && matriz[j][iter] == null) {
                        matriz[j][iter] = get1.split(",")[1] + "," + cad.split(",")[0];
                    }
                }
                marcar(matriz);
            }
            sel = seleccion(matriz, iter);
            cad = sel;
            System.out.println("seleccionado: " + sel);
            iter++;
        }
        for (int j = 0; j < matriz[0].length - 1; j++) {
            for (int k = 0; k < matriz[1].length; k++) {
                System.out.print(matriz[j][k] + "|    ");
            }
            System.out.println("");
        }
        //}
    }

    // obtengo los adyacentes de "cad(a)"
    public LinkedList<String> adyacentes(HashMap<String, LinkedList<String>> mapa, String cadena) {
        LinkedList<String> listAdyacentes = new LinkedList<>();
        if (mapa.containsKey(cadena)) {
            listAdyacentes = mapa.get(cadena);
        }
        return listAdyacentes;
    }

    public void marcar(String[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[i][j] != null && m[i][j].split(",").length > 2 && m[i][j].split(",")[2].equals("*")) {
                    for (int k = j + 1; k < m[0].length; k++) {
                        m[i][k] = "*";
                    }
                }
            }
        }
    }

    public boolean factible(HashMap<String, LinkedList<String>> mapa, String x) {
        return false;
    }

    public String seleccion(String matriz[][], int cont) {
        //System.out.println("+++++++ "+matriz.length);

        String sel = "";
        int x = 100;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][cont] != null && matriz[i][cont].split(",").length < 3) {
                if (Integer.parseInt(matriz[i][cont].split(",")[0]) < x) {
                    x = Integer.parseInt(matriz[i][cont].split(",")[0]);
                    sel = matriz[i][0] + "," + matriz[i][cont];
                }
            }
        }
        return sel;
    }

    public boolean solucion(HashMap s) {
        return false;
    }

}
