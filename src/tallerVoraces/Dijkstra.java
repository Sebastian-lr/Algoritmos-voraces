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
        LinkedList<String> solucion = new LinkedList<>();
        System.out.println("-" + cad);
        matriz = new String[mapa.size()][mapa.size() + 1];
        //----------------llendo la matriz
        Iterator it = mapa.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            String key = (String) it.next();
            matriz[0][i] = key;
            i++;
        }
        int cont = 1; // Numero del a columna sobre la que voy iterando  
        //while (cont < mapa.size()) {
        for (int j = 0; j < matriz[0].length - 1; j++) {
            if (matriz[0][j].equals(cad)) {
                matriz[cont][j] = 0 + "," + cad + "," + "*";
            }
            for (String get1 : adyacentes(mapa, cad)) {
                if (matriz[0][j].equals(get1.split(",")[0]) && matriz[cont][j] == null) {
                    matriz[cont][j] = get1.split(",")[1] + "," + cad;
                }
            }
        }
        String sel = seleccion(matriz, cont);
        for (int j = 0; j < matriz[0].length - 1; j++) {
            for (int k = 0; k < matriz[1].length - 1; k++) {
                System.out.print(matriz[k][j] + "|    ");
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

    public boolean factible(HashMap<String, LinkedList<String>> mapa, String x) {
        return false;
    }

    public String seleccion(String matriz[][], int cont) {
        //System.out.println("+++++++ "+matriz.length);
        String sel = "100";
        int x = 100;
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("´´´´´´´´´´´" + matriz[cont][i]);
            if (!matriz[cont][i].split(",")[2].equals("*")) {
                if (Integer.parseInt(matriz[cont][i].split(",")[0]) < x) {
                    x = Integer.parseInt(matriz[cont][i].split(",")[0]);
                }
            }
        }

        return null;
    }

    public boolean solucion(HashMap s) {
        return false;
    }

}
