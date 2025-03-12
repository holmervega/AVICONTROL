package Pruebas;

import Controlador.PedidoCabeceraDAO;
import Modelo.PedidoCabecera;
import java.util.ArrayList;
import java.util.Scanner;

public class PruebaPedidoCabecera {

    public static void main(String[] args) {
        PedidoCabeceraDAO pedidocabeceraDAO = new PedidoCabeceraDAO();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n==== Menú de Opciones ====");
            System.out.println("1. Agregar nuevo pedido");
            System.out.println("2. Consultar por numero de pedido");
            System.out.println("3. Listar todos los pedidos");
            System.out.println("4. Actualizar pedido");
            System.out.println("5. Eliminar pedido");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    adicionarPedido(pedidocabeceraDAO, scanner);
                    break;
                case 2:
                    consultarPedidoCabecera(pedidocabeceraDAO, scanner);
                    break;
                case 3:
                    listarPedidoCabecera(pedidocabeceraDAO);
                    break;
                case 4:
                    actualizarPedidoCabecera(pedidocabeceraDAO, scanner);
                    break;
                case 5:
                    eliminarPedido(pedidocabeceraDAO, scanner);
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

    private static void adicionarPedido(PedidoCabeceraDAO pedidoccabeceraDAO, Scanner scanner) {
        PedidoCabecera pedidocabecera = new PedidoCabecera();
        System.out.print("Ingrese el número de pedido: ");
        int numeroPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.print("Ingrese la fecha del pedido (YYYY-MM-DD): ");
        String fechaPedido = scanner.nextLine();

        System.out.print("Ingrese el ID de la persona que realizó el pedido: ");
        int personaId = scanner.nextInt();

        pedidocabecera.setNumeroPedido(numeroPedido);
        pedidocabecera.setFechaPedido(fechaPedido);
        pedidocabecera.setPersona_idPersona(personaId);

        String respuesta = pedidoccabeceraDAO.adicionarPedidoCabecera(pedidocabecera);
        if (respuesta.isEmpty()) {
            System.out.println("✅ Pedido agregado con éxito.");
        } else {
            System.out.println("❌ Error al agregar pedido: " + respuesta);
        }
    }

    private static void consultarPedidoCabecera(PedidoCabeceraDAO pedidocabeceraDAO, Scanner scanner) {
        System.out.print("Ingrese el numero del pedido a consultar: ");
        int idPedidoCabecera = scanner.nextInt();

        PedidoCabecera pedidocabecera = pedidocabeceraDAO.ConsultarPedidoCabecera(idPedidoCabecera);
        if (pedidocabecera != null) {
            System.out.println("\n📌 Producto Encontrado:");
            System.out.println("ID: " + pedidocabecera.getIdPedidoCabecera());
            System.out.println("Numero pedido: " + pedidocabecera.getNumeroPedido());
            System.out.println("Fecha: " + pedidocabecera.getFechaPedido());
            System.out.println("Identificacion cliente: " + pedidocabecera.getPersona_idPersona());
        } else {
            System.out.println("❌ No se encontró un producto con el ID ingresado.");
        }
    }

    private static void listarPedidoCabecera(PedidoCabeceraDAO pedidocabeceraDAO) {
        ArrayList<PedidoCabecera> listarPedido = pedidocabeceraDAO.ConsultarPedidoCabecera("");
        if (listarPedido.isEmpty()) {
            System.out.println("❌ No se encontraron productos.");
        } else {
            System.out.println("\n📌 Lista de Productos y Fecha");
            System.out.println("----------------------------------");
            System.out.printf("%-10s | %-10s\n", "ID", "Fecha");
            System.out.println("----------------------------------");

            for (PedidoCabecera producto : listarPedido) {
                System.out.printf("%-10d | %-10s\n", producto.getIdPedidoCabecera(), producto.getFechaPedido());

            }
        }
    }

    private static void actualizarPedidoCabecera(PedidoCabeceraDAO pedidoCabeceraDAO, Scanner scanner) {
        System.out.print("Ingrese el ID del pedido a actualizar: ");
        int idPedido = scanner.nextInt();
        System.out.print("Ingrese el nuevo número de pedido: ");
        int nuevoNumeroPedido = scanner.nextInt();
        scanner.nextLine();  // Consumir la línea pendiente
        System.out.print("Ingrese la nueva fecha del pedido (YYYY-MM-DD): ");
        String nuevaFecha = scanner.nextLine();

        PedidoCabecera pedido = new PedidoCabecera();
        pedido.setIdPedidoCabecera(idPedido);
        pedido.setNumeroPedido(nuevoNumeroPedido);
        pedido.setFechaPedido(nuevaFecha);

        String respuesta = pedidoCabeceraDAO.actualizarPedidoCabecera(pedido);
        if (respuesta.length() == 0) {
            System.out.println("✅ Pedido actualizado con éxito.");
        } else {
            System.out.println("❌ Error al actualizar el pedido: " + respuesta);
        }
    }
    
     private static void eliminarPedido(PedidoCabeceraDAO pedidocabeceraDAO, Scanner scanner) {
        System.out.print("Ingrese el numero del pedido a eliminar: ");
        int idProducto = scanner.nextInt();

        PedidoCabecera pedidocabecera = new PedidoCabecera();
        pedidocabecera.setNumeroPedido(idProducto);

        String respuesta = pedidocabeceraDAO.EliminararPedido(pedidocabecera);
        if (respuesta.length() == 0) {
            System.out.println("✅ Producto eliminado con éxito.");
        } else {
            System.out.println("❌ Error al eliminar producto: " + respuesta);
        }
    }

}
