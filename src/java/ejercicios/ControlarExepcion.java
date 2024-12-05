package ejercicios;

import java.util.Scanner;

public class ControlarExepcion {

    private static int valor;
    private static boolean error;

    public static void main(String[] args) {
        // TODO code application logic here

        error = false;

        Scanner midato = new Scanner(System.in);
        do {
            try {
                System.out.println("Digite un valor ");
                valor = midato.nextByte();
                System.out.println("El valor digitado es correcto:" + valor);
            } catch (Exception ex) {
                error = true;
                System.out.println("ocurrio un error tipo:" + ex);
                midato.next();
            } finally {
                if (error == true) {
                    System.out.println("El valor digitado no es numerico, por favor vuelva a intentarlo");
                } else {
                    System.out.println("Datos ingresados correctamente");
                }
            }
        }while (error);
    }
}
