package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
    private ConexionBD conexion;

    public AlumnoDAO() {
        conexion = ConexionBD.getInstance();
    }

    public boolean agregarAlumno(String nombre, String apellidoPaterno, String calle, String numero,
                                 String colonia, String codigoPostal, String municipio, String estado,
                                 String pais, String fecha, String metodoPago, String categoria) {
        String query = "INSERT INTO Alumnos (nombre, apellido_paterno, calle, numero, colonia, codigo_postal, municipio, estado, pais, fecha, metodo_pago, categoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return conexion.ejecutarInstruccionDML(query, nombre, apellidoPaterno, calle, numero, colonia, codigoPostal, municipio, estado, pais, fecha, metodoPago, categoria);
    }

    public List<Alumno> obtenerAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String query = "SELECT * FROM Alumnos";
        try {
            Connection conn = conexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellido_paterno");
                String calle = rs.getString("calle");
                String numero = rs.getString("numero");
                String colonia = rs.getString("colonia");
                String codigoPostal = rs.getString("codigo_postal");
                String municipio = rs.getString("municipio");
                String estado = rs.getString("estado");
                String pais = rs.getString("pais");
                String fecha = rs.getString("fecha");
                String metodoPago = rs.getString("metodo_pago");
                String categoria = rs.getString("categoria");

                Alumno alumno = new Alumno(id, nombre, apellidoPaterno, calle, numero, colonia, codigoPostal, municipio, estado, pais, fecha, metodoPago, categoria);
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    public boolean actualizarAlumno(int id, String nombre, String apellidoPaterno, String calle, String numero,
                                    String colonia, String codigoPostal, String municipio, String estado,
                                    String pais, String fecha, String metodoPago, String categoria) {
        String query = "UPDATE Alumnos SET nombre = ?, apellido_paterno = ?, calle = ?, numero = ?, colonia = ?, codigo_postal = ?, municipio = ?, estado = ?, pais = ?, fecha = ?, metodo_pago = ?, categoria = ? WHERE id = ?";
        return conexion.ejecutarInstruccionDML(query, nombre, apellidoPaterno, calle, numero, colonia, codigoPostal, municipio, estado, pais, fecha, metodoPago, categoria, id);
    }

    public boolean eliminarAlumno(int id) {
        String query = "DELETE FROM Alumnos WHERE id = ?";
        return conexion.ejecutarInstruccionDML(query, id);
    }
}