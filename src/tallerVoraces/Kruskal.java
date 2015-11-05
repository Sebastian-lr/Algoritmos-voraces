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
 * @author Santitigaga
 */
public class Kruskal {

    LinkedList<String> nodos;

    public Kruskal() {
        nodos = new LinkedList<>();
    }

    public void kruskal(HashMap mapa) {
        LinkedList<String> s = new LinkedList<>();
        nodos = new LinkedList<>();
        while (!solucion(mapa, nodos)) {
            String siguiente = seleccion(mapa);
            if (nodos.isEmpty()) {
                nodos.add(siguiente.split(",")[0]);
                nodos.add(siguiente.split(",")[1]);
                s.add(siguiente);

            } else if (factible(siguiente, s)) {
                if (!nodos.contains(siguiente.split(",")[0])) {
                    nodos.add(siguiente.split(",")[0]);
                }
                if (!nodos.contains(siguiente.split(",")[1])) {
                    nodos.add(siguiente.split(",")[1]);
                }
                s.add(siguiente);
            }
        }
        if (solucion(mapa, nodos)) {
            for (int i = 0; i < nodos.size(); i++) {
            }
            System.out.println("se encontro una solucion");
            for (int i = 0; i < s.size(); i++) {
                System.out.println(s.get(i));

            }
        } else {
            System.out.println("no se encontro solucion");

        }
    }

    public boolean factible(String x, LinkedList<String> solucion) {
        boolean fa = true;
        if (solucion.isEmpty()) {
            return fa;
        } else {

            for (int i = 0; i < nodos.size(); i++) {
                if (nodos.get(i).contains(x.split(",")[0])) {
                    for (int j = 0; j < nodos.size(); j++) {
                        if (nodos.get(j).contains(x.split(",")[1])) {
                            fa = false;
                        }
                    }
                }
            }

        }
        return fa;
    }

    public String seleccion(HashMap<String, LinkedList<String>> c) {
        String seleccion = null;
        int cm = 100;
        Iterator it = c.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            for (int i = 0; i < c.get(key).size(); i++) {
                if (Integer.parseInt(c.get(key).get(i).split(",")[1]) < cm) {

                    cm = Integer.parseInt(c.get(key).get(i).split(",")[1]);
                    seleccion = key + "," + c.get(key).get(i);
                }
            }
        }
        if (seleccion != null) {
            String valor = seleccion.substring(2);

            String valor2 = seleccion.split(",")[0] + "," + seleccion.split(",")[2];

            c.get(seleccion.split(",")[0]).remove(valor);
            c.get(seleccion.split(",")[1]).remove(valor2);

        }
        return seleccion;
    }

    public boolean solucion(HashMap mapa, LinkedList<String> s) {
        boolean sol = false;
//        System.out.println("mapa" + mapa.size());
//        System.out.println("sol: " + s.size());
        if (mapa.size() == s.size()) {
            sol = true;
        }
        return sol;
    }
}
