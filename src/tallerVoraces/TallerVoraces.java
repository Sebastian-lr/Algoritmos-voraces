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
public class TallerVoraces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        HashMap<String, LinkedList<String>> grafo = new HashMap<>();
        LinkedList<String> nodos = new LinkedList<>();
        LinkedList<String> nodos2 = new LinkedList<>();
        LinkedList<String> nodos3 = new LinkedList<>();
        LinkedList<String> nodos4 = new LinkedList<>();
        LinkedList<String> nodos5 = new LinkedList<>();
        LinkedList<String> nodos6 = new LinkedList<>();
        nodos.add("b,1");
        nodos.add("c,2");
        grafo.put("a", nodos);
        nodos2.add("d,5");
        nodos2.add("a,1");
        grafo.put("b", nodos2);
        nodos3.add("d,1");
        nodos3.add("e,1");
        nodos3.add("a,2");
        grafo.put("c", nodos3);
        nodos4.add("f,2");
        nodos4.add("c,1");
        grafo.put("e", nodos4);
        nodos5.add("f,5");
        nodos5.add("b,5");
        nodos5.add("c,1");
        grafo.put("d", nodos5);
        nodos6.add("e,2");
        nodos6.add("d,5");
        grafo.put("f", nodos6);
        System.out.println("--PRIM--");
        Primm prim = new Primm();
        //prim.primm(grafo,"a");
        System.out.println("-----------------");
        System.out.println("--Kruskal--");
        Kruskal kru = new Kruskal();
        //kru.kruskal(grafo);
        Dijkstra dk = new Dijkstra();
        dk.dijkstra(grafo,"a");
    }

}
