
package ejercicios;

import java.util.Scanner;


public class ManejoTryCatch {

  
    public static void main(String[] args) {
       
        Scanner midato = new Scanner (System.in);
        
        int valor;
        
        System.out.println("Digite un valor numerico");
        
        valor = midato.nextInt();
        
        System.out.println("El valor digitado es correcto"+ valor);
        
        
    }
  
}
