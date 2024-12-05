package ejercicios;

public class OperacionesBasicas {

    //ejercicios operaciones basicas
    public static void main(String[] args) {

        System.out.println("Practica Operaciones Basicas");
        System.out.println("--------------");
        System.out.println("SUMA");
        int valor = 50;
        int valor2 = 15;
        int resultado = 0;

        resultado = valor + valor2;
        System.out.println("los valores sumados son: " + valor + " mas " + valor2);
        System.out.println("y el valor de la suma es :" + resultado);
        System.out.println("--------------");
        
        
        System.out.println("MULTIPLICACION");
        resultado = valor * valor2;
        System.out.println("los valores multiplicados son: " + valor + " por " + valor2);
        System.out.println("y el valor de la multiplicaion es :" + resultado);
        System.out.println("--------------");
        
        
        System.out.println("RESTA");
        resultado = valor - valor2;
        System.out.println("los valores restados son: " + valor + " menos " + valor2);
        System.out.println("y el valor de la resta es :" + resultado);
        System.out.println("--------------");
        
        
        System.out.println("DIVISION");
        resultado = valor / valor2;
        System.out.println("los valores divididios son: " + valor + " dividido " + valor2);
        System.out.println("y el valor de la division es :" + resultado);

    }

}
