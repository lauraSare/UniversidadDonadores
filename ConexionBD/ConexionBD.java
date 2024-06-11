package ConexionBD;

import java.sql.*;

public class ConexionBD {
    // Atributo estático para almacenar la única instancia de la clase (Singleton)
    private static ConexionBD instance;
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;

    // Constructor privado para evitar la creación de instancias desde fuera de la clase (Singleton)
    private ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/UniversidadDonadores";
            conexion = DriverManager.getConnection(URL, "laura", "laura");
            System.out.println("YEEEEI casi soy ISC =)");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el controlador de conexión a MySQL");
        } catch (SQLException e) {
            System.out.println("Error en la ruta de conexión");
        }
    }

    // Método estático para obtener la única instancia de la clase (Singleton)
    public static ConexionBD getInstance() {
        if (instance == null) {
            instance = new ConexionBD();
        }
        return instance;
    }

    public Connection getConnection() {
        return conexion;
    }

    // Método que utiliza Prepared Statements para ejecutar instrucciones DML
    public boolean ejecutarInstruccionDML(String instruccionDML, Object... parametros) {
        boolean result = false;
        try {
            // Crear un Prepared Statement a partir de la instrucción DML
            pstm = conexion.prepareStatement(instruccionDML);
            // Establecer los valores de los parámetros en el Prepared Statement
            for (int i = 0; i < parametros.length; i++) {
                pstm.setObject(i + 1, parametros[i]);
            }
            // Ejecutar la instrucción DML utilizando el Prepared Statement
            if (pstm.executeUpdate() >= 1)
                result = true;
        } catch (SQLException e) {
            System.out.println("Error en instruccion SQL");
        }
        return result;
    }

    // Método que utiliza Prepared Statements para ejecutar consultas SQL
    public ResultSet ejecutarConsultaSQL(String consultaSQL, Object... parametros) {
        rs = null;
        try {
            // Crear un Prepared Statement a partir de la consulta SQL
            pstm = conexion.prepareStatement(consultaSQL);
            // Establecer los valores de los parámetros en el Prepared Statement
            for (int i = 0; i < parametros.length; i++) {
                pstm.setObject(i + 1, parametros[i]);
            }
            // Ejecutar la consulta utilizando el Prepared Statement
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error en instruccion SQL");
        }
        return rs;
    }

    public void cerrarConexion() {
        try {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conexion != null) conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}