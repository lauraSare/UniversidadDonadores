package ConexionBD;

import java.sql.*;

public class ConexionBD {
    private static ConexionBD instance;
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;

   /* private ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/UniversidadDonadores";
            conexion = DriverManager.getConnection(URL, "laura", "laura");
            System.out.println("YEEEEI casi soy ISC =)");
            System.out.println("Conexion establecida");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el controlador de conexion a MySQL");
        } catch (SQLException e) {
            System.out.println("Error en la ruta de conexión");
        }
    }*/
   private ConexionBD() {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           String URL = "jdbc:mysql://localhost:3306/UniversidadDonadores";
           conexion = DriverManager.getConnection(URL, "laura", "laura");
           System.out.println("YEEEEI casi soy ISC =)");
           System.out.println("Conexión establecida");
       } catch (ClassNotFoundException e) {
           System.out.println("Error en el controlador de conexión a MySQL");
       } catch (SQLException e) {
           System.out.println("Error en la ruta de conexión");
       }
   }

    public static ConexionBD getInstance() {
        if (instance == null) {
            instance = new ConexionBD();
        }
        return instance;
    }
    public Connection getConnection() {
        return conexion;
    }


    public boolean ejecutarInstruccionDML(String instruccionDML, Object... parametros) {
        boolean result = false;
        try {
            pstm = conexion.prepareStatement(instruccionDML);
            for (int i = 0; i < parametros.length; i++) {
                pstm.setObject(i + 1, parametros[i]);
            }
            if (pstm.executeUpdate() >= 1)
                result = true;
        } catch (SQLException e) {
            System.out.println("Error en instruccion SQL");
        }
        return result;
    }

    public ResultSet ejecutarConsultaSQL(String consultaSQL, Object... parametros) {
        rs = null;
        try {
            pstm = conexion.prepareStatement(consultaSQL);
            for (int i = 0; i < parametros.length; i++) {
                pstm.setObject(i + 1, parametros[i]);
            }
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