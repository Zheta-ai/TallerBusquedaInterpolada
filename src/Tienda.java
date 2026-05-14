public class Tienda implements OperacionesTienda {

    // IDs ordenados uniformemente para que la interpolación funcione perfecto
    private int[] idsProductos = {101, 202, 303};
    private String[] nombresProductos = {"Laptop", "Monitor", "Teclado"};
    private double[] preciosProductos = {800.50, 150.00, 25.99};

    // Matriz de ventas: 3 productos (filas) x 3 meses (columnas)
    private int[][] ventasMensuales = new int[3][3];

    // ==========================================
    // MÉTODO 1: BÚSQUEDA INTERPOLADA
    // ==========================================
    @Override
    public int buscarPorId(int[] array, int valor) {
        int inicio = 0; // Límite inferior del arreglo
        int fin = array.length - 1; // Límite superior del arreglo

        // El ciclo se repite mientras el valor esté dentro del rango actual
        while (inicio <= fin && valor >= array[inicio] && valor <= array[fin]) {

            // FÓRMULA DE INTERPOLACIÓN: Calcula la posición estimada matemáticamente
            // en lugar de simplemente dividir por la mitad (como haría la binaria).
            int posicion = inicio + ((valor - array[inicio]) * (fin - inicio)) / (array[fin] - array[inicio]);

            // Si encuentra el valor en la posición calculada, retorna esa posición
            if (array[posicion] == valor) {
                return posicion;
            }
            // Si el valor en esa posición es menor al buscado, descarta la mitad izquierda
            else if (array[posicion] < valor) {
                inicio = posicion + 1;
            }
            // Si el valor en esa posición es mayor, descarta la mitad derecha
            else {
                fin = posicion - 1;
            }
        }
        return -1; // Retorna -1 si el producto no existe
    }

    // ==========================================
    // MÉTODO 2: BÚSQUEDA POR NOMBRE
    // ==========================================
    @Override
    public int buscarPorNombre(String[] array, String valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(valor)) {
                return i;
            }
        }
        return -1;
    }

    // ==========================================
    // MÉTODOS DE NEGOCIO (Ventas y Precios)
    // ==========================================
    public void registrarVenta(int idProducto, int mes, int cantidad) {
        int indice = buscarPorId(this.idsProductos, idProducto); // Llama a la búsqueda interpolada

        if (indice != -1 && mes >= 1 && mes <= 3) {
            ventasMensuales[indice][mes - 1] += cantidad;
            System.out.println("✅ Venta registrada: " + cantidad + " unidades de '" + nombresProductos[indice] + "' en el mes " + mes + ".");
        } else {
            System.out.println("❌ Error: Producto no encontrado o mes inválido.");
        }
    }

    public void actualizarPrecio(int idProducto, double nuevoPrecio) {
        int indice = buscarPorId(this.idsProductos, idProducto); // Llama a la búsqueda interpolada

        if (indice != -1) {
            preciosProductos[indice] = nuevoPrecio;
            System.out.println("✅ Precio de '" + nombresProductos[indice] + "' actualizado a $" + nuevoPrecio);
        } else {
            System.out.println("❌ Error: Producto no encontrado.");
        }
    }

    public void mostrarReporteVentas() {
        System.out.println("\n--- REPORTE DE VENTAS (Últimos 3 meses) ---");
        for (int i = 0; i < nombresProductos.length; i++) {
            System.out.println(nombresProductos[i] + " (ID: " + idsProductos[i] + ") - Precio: $" + preciosProductos[i]);
            System.out.println("   Ventas -> Mes 1: " + ventasMensuales[i][0] + " | Mes 2: " + ventasMensuales[i][1] + " | Mes 3: " + ventasMensuales[i][2]);
        }
        System.out.println("-------------------------------------------\n");
    }

    public int[] getIdsProductos() { return idsProductos; }
    public String[] getNombresProductos() { return nombresProductos; }
}