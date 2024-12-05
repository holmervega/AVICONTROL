package Pruebas;

import Controlador.ProductosDAO;
import Modelo.Productos;
import java.util.Scanner;

public class PruebaAdicionarPrecioProducto {

    public static void main(String[] args) {

        ProductosDAO misproductosDAO = new ProductosDAO();
        Productos misproductos = new Productos();

        Scanner dato = new Scanner(System.in);

        double precio = 0.0;
        System.out.println("Por favor digite el precio del producto");
        precio = dato.nextDouble();
        misproductos.setPrecio(precio);
        String respuesta = misproductosDAO.adicionarPrecioProductos(misproductos);
        if (respuesta.length() == 0) {
            System.out.println("Precio registrado con exito");
        } else {
            System.out.println("Error al registrar el Precio" + respuesta);
        }
    }
}
