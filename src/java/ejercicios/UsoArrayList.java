/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios;

import java.util.ArrayList;

/**
 *
 * @author holmer
 */
public class UsoArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // este arreglo permite hacer listas, los metodos son dinamicos, add, remove,
        ArrayList<String> listanombres = new ArrayList<String>();

        // agregar elementos        
        listanombres.add("Holmer");
        listanombres.add("Alejandro");
        listanombres.add("Viviana");
        listanombres.add("Abby");
        listanombres.add("Hector");

        /*for (String A : listanombres){
            System.out.println("impresion lista de nombres " + A);
        
        }*/
 /*
        for (int i = 0; i < listanombres.size(); i++) {
            System.out.println("impresion lista de nombres " + listanombres.get(i));

        }

        // si queremos eliminar llamamos el nombre
        listanombres.remove(3);

        for (String A : listanombres) {
            System.out.println("impresion lista de nombres " + A);

        }*/
        System.out.println("Primer nombre en la lista: " + listanombres.get(0));

    }
}
