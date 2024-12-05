package ejercicios;

import java.util.Scanner;

public class EjerciciosMatriz {

    public static void main(String[] args) {
        Scanner midato = new Scanner(System.in);  // Crear el objeto Scanner
        int matriz[][] = new int[3][6];

        // Pedir al usuario que ingrese valores para cada celda de la matriz
        System.out.println("Ingresa los valores para una matriz de 2 filas y 2 columnas:");
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Introduce el valor para la fila [" + i + "] y la columna[" + j + "]: ");
                matriz[i][j] = midato.nextInt();  // Leer el valor del usuario y asignarlo a la celda
            }
        }

        // Imprimir la matriz
        System.out.println("La matriz ingresada es:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
