package ejercicios;

public class EjercicioEstructuraFor {

    public static void main(String[] args) {
        // el ejercico no se ejecuta si la condicion no se cumple 
         System.out.println("Ejemplo 1: Números del 20 al 40 de 2 en 2");
        for (int i = 20; i <=40; i+=2) {
            System.out.println(i);
        }
          System.out.println("Ejemplo 2: Números del 1 al 10");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
        
          System.out.println("Ejemplo 3: Números del 10 al 50 de 3 en 3");
        for (int i = 10; i <= 50; i+=3) {
            System.out.println(i);
        }
        
          System.out.println("Ejemplo 4: Números del 10 restando de 1 en 1");
        for (int i = 10; i >=0; i--) {
            System.out.println(i);
        }
    }
     
}

