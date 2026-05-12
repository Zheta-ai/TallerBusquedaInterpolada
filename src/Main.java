public class Main {
    public static void main(String[] args) {
        Tienda miTienda = new Tienda();

        System.out.println("=== INICIANDO SISTEMA DE TIENDA EN LÍNEA ===\n");

        System.out.println(">> BUSCANDO PRODUCTO POR ID (Búsqueda Interpolada):");
        int indiceId = miTienda.buscarPorId(miTienda.getIdsProductos(), 202);
        if (indiceId != -1) System.out.println("Producto encontrado: " + miTienda.getNombresProductos()[indiceId]);

        System.out.println("\n>> BUSCANDO PRODUCTO POR NOMBRE:");
        int indiceNombre = miTienda.buscarPorNombre(miTienda.getNombresProductos(), "Teclado");
        if (indiceNombre != -1) System.out.println("Producto encontrado (ID: " + miTienda.getIdsProductos()[indiceNombre] + ")");

        System.out.println("\n>> ACTUALIZANDO PRECIOS:");
        miTienda.actualizarPrecio(101, 850.99);
        miTienda.actualizarPrecio(999, 10.00);

        System.out.println("\n>> REGISTRANDO VENTAS:");
        miTienda.registrarVenta(101, 1, 5);
        miTienda.registrarVenta(101, 2, 8);
        miTienda.registrarVenta(202, 3, 15);
        miTienda.registrarVenta(303, 1, 20);

        miTienda.mostrarReporteVentas();
    }
}