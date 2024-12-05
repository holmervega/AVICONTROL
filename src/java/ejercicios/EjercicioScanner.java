package ejercicios;

import java.util.Scanner;

public class EjercicioScanner {

    public static void main(String[] args) {
        // ejercicio scanner 

        Scanner midato = new Scanner(System.in);

        String ciudad;
        System.out.println("Por favor ingrese su ciudad de residencia:");
        ciudad = midato.nextLine();
        System.out.println("Su ciudad de residencia es: " + ciudad);
        System.out.println("------------");

        int num1, num2, operacion;

        System.out.println("SUMA");
        System.out.println("Por favor digite los valores que desea sumar:");
        System.out.println("Dijite el primer valor:");
        num1 = midato.nextInt();
        System.out.println("Dijite el segundo valor:");
        num2 = midato.nextInt();
        operacion = num1 + num2;
        System.out.println("El resultado de la suma es: " + operacion);

        System.out.println("------------------");
        System.out.println("RESTA");
        System.out.println("Por favor digite los valores que desea restar:");
        System.out.println("Dijite el primer valor:");
        num1 = midato.nextInt();
        System.out.println("Dijite el segundo valor:");
        num2 = midato.nextInt();
        operacion = num1 - num2;
        System.out.println("El resultado de la resta es: " + operacion);

        System.out.println("------------------");
        System.out.println("MULTIPLICACION");
        System.out.println("Por favor digite los valores que desea multipliclar:");
        System.out.println("Dijite el primer valor:");
        num1 = midato.nextInt();
        System.out.println("Dijite el segundo valor:");
        num2 = midato.nextInt();
        operacion = num1 * num2;
        System.out.println("El resultado de la  multiplicaion es: " + operacion);

        System.out.println("------------------");
        System.out.println("DIVISION");
        System.out.println("Por favor digite los valores que desea dividir:");
        System.out.println("Dijite el primer valor:");
        num1 = midato.nextInt();
        System.out.println("Dijite el segundo valor:");
        num2 = midato.nextInt();
        operacion = num1 / num2;
        System.out.println(" El resultado de la division es: " + operacion);

    }

}
