public interface OperacionesTienda {
    // Método para buscar por ID usando interpolación
    int buscarPorId(int[] arrayIds, int idBuscado);

    // Método para buscar por nombre
    int buscarPorNombre(String[] arrayNombres, String nombreBuscado);
}