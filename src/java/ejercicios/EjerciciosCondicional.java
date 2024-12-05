package ejercicios;

import java.util.Scanner;

public class EjerciciosCondicional {

    public static void main(String[] args) {
        // ejercicios condicional

        Scanner midato = new Scanner(System.in);

        int numero = 0;
        System.out.println("adivina el numero entre 3 y 4");
        
        while (numero !=3) {            
            System.out.println("Digita un numero");
        
        numero = midato.nextInt();
        if (numero == 3) {
            System.out.println("adivinaste");
        } else {
            System.out.println("sigue intentando");
            
        }
        }

       
       System.out.println("numeros pares e impares");
        System.out.println("Digita un numero para saber si es par o impar:7");
        numero = midato.nextInt();
        if (numero % 2 == 0) {
            System.out.println("el numero es par");
        } else {
            System.out.println("el numero es impar");
        }

    }

}
