/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerVoraces;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Santitigaga
 */
public class Primm {

    private final LinkedList<String> visitados;


    public Primm() {
        visitados = new LinkedList<>();
  
    }

    public void primm(HashMap<String, LinkedList<String>> mapa, String nodoinicial) {
        LinkedList<String> solucion = new LinkedList<>();
        visitados.add(nodoinicial);
        while (!solucion(solucion,mapa) ) {
            String siguiente = factible(seleccion(mapa, visitados), solucion);
            solucion.add(siguiente);
        }
        if (solucion(solucion,mapa)) {
            System.out.println("se encontro una solucion");
            for (int i = 0; i < solucion.size(); i++) {
                System.out.println(solucion.get(i));
            }
        } else {
            System.out.println("no se encontro solucion");

        }
    }

    public String factible(LinkedList<String> p, LinkedList<String> solucion) {
        int cm = 100;
        String sol = null;
        if (solucion.isEmpty()) {
            for (int i = 0; i < p.size(); i++) {
                if (Integer.parseInt(p.get(i).split(",")[2]) < cm) {
                    cm = Integer.parseInt(p.get(i).split(",")[2]);
                    sol = p.get(i);
                }

            }
        } else {
            for (int i = 0; i < p.size(); i++) {
                  if (visitado(p.get(i).split(",")[1])) {

                    }  else {
                if (Integer.parseInt(p.get(i).split(",")[2]) < cm) {
                 
                        cm = Integer.parseInt(p.get(i).split(",")[2]);
                        sol = p.get(i);
                    }
                }
            }
        }

        visitados.add(sol.split(",")[1]);

        return sol;
    }

    public boolean visitado(String p) {
        boolean visitado = false;
        for (int j = 0; j < visitados.size(); j++) {
            if (visitados.get(j).contains(p)) {
                visitado = true;
                break;
            }

        }
        return visitado;
    }

    public LinkedList<String> seleccion(HashMap<String, LinkedList<String>> c, LinkedList<String> nodos) {
        LinkedList<String> s = new LinkedList<>();
        if (!c.isEmpty()) {
            for (int j = 0; j < nodos.size(); j++) {
                if (c.containsKey(nodos.get(j))) {
                    String m;
                    for (int k = 0; k < c.get(nodos.get(j)).size(); k++) {
                          if (visitado(c.get(nodos.get(j)).get(k).split(",")[0])) {

                        } else {
                            m = nodos.get(j) + "," + c.get(nodos.get(j)).get(k);
                             s.add(m);
                          
                          
                        }
                    }

                }
            }

        }

        return s;
    }

    public boolean solucion(LinkedList<String> s,HashMap m) {
        boolean so=false;
        if (s.isEmpty()) {
            so= false;
        } else {

            if (s.size()==m.size()-1) {
            so= true;
            }
        }
return so;
    }

}
