import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tienda miTienda = new Tienda();
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        System.out.println("=== INICIANDO SISTEMA DE TIENDA EN LÍNEA ===");

        while (opcion != 6) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar Venta");
            System.out.println("2. Actualizar Precio");
            System.out.println("3. Buscar Producto por ID (Interpolada)");
            System.out.println("4. Buscar Producto por Nombre (Lineal)");
            System.out.println("5. Mostrar Reporte de Ventas");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            opcion = entrada.nextInt();
            entrada.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el ID del producto (ej. 101, 202, 303): ");
                    int idVenta = entrada.nextInt();
                    System.out.print("Ingresa el mes (1, 2 o 3): ");
                    int mes = entrada.nextInt();
                    System.out.print("Ingresa la cantidad vendida: ");
                    int cantidad = entrada.nextInt();
                    miTienda.registrarVenta(idVenta, mes, cantidad);
                    break;
                case 2:
                    System.out.print("Ingresa el ID del producto: ");
                    int idPrecio = entrada.nextInt();
                    System.out.print("Ingresa el nuevo precio: $");
                    double nuevoPrecio = entrada.nextDouble();
                    miTienda.actualizarPrecio(idPrecio, nuevoPrecio);
                    break;
                case 3:
                    System.out.print("Ingresa el ID a buscar: ");
                    int idBuscar = entrada.nextInt();
                    int indiceId = miTienda.buscarPorId(miTienda.getIdsProductos(), idBuscar);
                    if (indiceId != -1) {
                        System.out.println("✅ Producto encontrado: " + miTienda.getNombresProductos()[indiceId]);
                    } else {
                        System.out.println("❌ Producto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingresa el nombre a buscar: ");
                    String nombreBuscar = entrada.nextLine();
                    int indiceNombre = miTienda.buscarPorNombre(miTienda.getNombresProductos(), nombreBuscar);
                    if (indiceNombre != -1) {
                        System.out.println("✅ Producto encontrado (ID: " + miTienda.getIdsProductos()[indiceNombre] + ")");
                    } else {
                        System.out.println("❌ Producto no encontrado.");
                    }
                    break;
                case 5:
                    miTienda.mostrarReporteVentas();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        entrada.close();
    }
}