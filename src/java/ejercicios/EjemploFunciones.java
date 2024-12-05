package ejercicios;

/**
 *
 * @author holmer
 */
public class EjemploFunciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // acciones repetitivas que se puede invocar desde cualquier parte del codigo, se crea un objeto para hacer uso de las funciones 
        int num = 1;

        if (mayorCero(num)) {
            System.out.println("El número " + num + " es mayor a cero");
        } else {
            System.out.println("El número " + num + " no es mayor a cero");
        }
    }

    public static boolean mayorCero(int num) {
        return num > 0;
    }
}
