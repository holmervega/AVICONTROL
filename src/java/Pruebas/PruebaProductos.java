package Pruebas;

import Controlador.ProductosDAO;
import Modelo.Productos;
import java.util.ArrayList;
import java.util.Scanner;

public class PruebaProductos {

    public static void main(String[] args) {
        ProductosDAO productosDAO = new ProductosDAO();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n==== Menú de Opciones ====");
            System.out.println("1. Agregar precio del producto");
            System.out.println("2. Consultar producto por ID");
            System.out.println("3. Listar productos con precios");
            System.out.println("4. Actualizar precio del producto");
            System.out.println("5. Eliminar precio del producto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    adicionarProducto(productosDAO, scanner);
                    break;
                case 2:
                    consultarProductoPorID(productosDAO, scanner);
                    break;
                case 3:
                    listarProductos(productosDAO);
                    break;
                case 4:
                    actualizarProducto(productosDAO, scanner);
                    break;
                case 5:
                    eliminarProducto(productosDAO, scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("❌ Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private static void adicionarProducto(ProductosDAO productosDAO, Scanner scanner) {
        Productos producto = new Productos();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        producto.setPrecio(precio);

        String respuesta = productosDAO.adicionarPrecioProductos(producto);
        if (respuesta.length() == 0) {
            System.out.println("✅ Precio agregado con éxito.");
        } else {
            System.out.println("❌ Error al agregar producto: " + respuesta);
        }
    }

    private static void consultarProductoPorID(ProductosDAO productosDAO, Scanner scanner) {
        System.out.print("Ingrese el ID del producto a consultar: ");
        int idProducto = scanner.nextInt();

        Productos producto = productosDAO.ConsultarProductos(idProducto);
        if (producto != null) {
            System.out.println("\n📌 Producto Encontrado:");
            System.out.println("ID: " + producto.getIdProductos());
            System.out.println("Precio: " + producto.getPrecio());
        } else {
            System.out.println("❌ No se encontró un producto con el ID ingresado.");
        }
    }

    private static void listarProductos(ProductosDAO productosDAO) {
        ArrayList<Productos> listaProductos = productosDAO.ConsultarListaPrecios("");

        if (listaProductos.isEmpty()) {
            System.out.println("❌ No se encontraron productos.");
        } else {
            System.out.println("\n📌 Lista de Productos y Precios:");
            System.out.println("----------------------------------");
            System.out.printf("%-10s | %-10s\n", "ID", "Precio");
            System.out.println("----------------------------------");

            for (Productos producto : listaProductos) {
                System.out.printf("%-10d | %-10.2f\n", producto.getIdProductos(), producto.getPrecio());
            }
        }
    }

    private static void actualizarProducto(ProductosDAO productosDAO, Scanner scanner) {
        System.out.print("Ingrese el ID del producto a actualizar: ");
        int idProducto = scanner.nextInt();
        System.out.print("Ingrese el nuevo precio: ");
        double nuevoPrecio = scanner.nextDouble();

        Productos producto = new Productos();
        producto.setIdProductos(idProducto);
        producto.setPrecio(nuevoPrecio);

        String respuesta = productosDAO.ActualizarProductos(producto);
        if (respuesta.length() == 0) {
            System.out.println("✅ Precio actualizado con éxito.");
        } else {
            System.out.println("❌ Error al actualizar precio: " + respuesta);
        }
    }

    private static void eliminarProducto(ProductosDAO productosDAO, Scanner scanner) {
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int idProducto = scanner.nextInt();

        Productos producto = new Productos();
        producto.setIdProductos(idProducto);

        String respuesta = productosDAO.EliminararPrecios(producto);
        if (respuesta.length() == 0) {
            System.out.println("✅ Producto eliminado con éxito.");
        } else {
            System.out.println("❌ Error al eliminar producto: " + respuesta);
        }
    }
}
