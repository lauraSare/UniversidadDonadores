package ConexionBD;

public class Main {
    public static void main(String[] args) {
        // Obtener la instancia de ConexionBD
        ConexionBD conexion = ConexionBD.getInstance();

        // Cerrar la conexión cuando ya no se necesite
        conexion.cerrarConexion();
    }
}