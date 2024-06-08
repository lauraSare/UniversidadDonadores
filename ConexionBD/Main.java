package ConexionBD;

public class Main {
    public static void main(String[] args) {
        // Obtener la instancia de ConexionBD
        ConexionBD conexion = ConexionBD.getInstance();



        // Utilizar la conexión para ejecutar consultas o instrucciones DML
        // ...

        // Cerrar la conexión cuando ya no se necesite
        conexion.cerrarConexion();
    }
}