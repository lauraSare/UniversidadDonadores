package Vista;

import ConexionBD.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bajas extends JInternalFrame implements ActionListener {
    private DefaultTableModel tableModel;
    private JButton btnEliminar;
    private JButton btnCancelar;
    private JButton btnActualizar;
    private JTable table;

    public Bajas() {
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("BAJAS");
        setSize(800, 600);
        setClosable(true);
        setResizable(false);
        getContentPane().setBackground(new Color(0x7E2714));

        GridBagConstraints gbcCenter = new GridBagConstraints();
        gbcCenter.gridwidth = 2;
        gbcCenter.fill = GridBagConstraints.HORIZONTAL;
        gbcCenter.insets = new Insets(10, 10, 10, 10);

        JLabel lbl1 = new JLabel("ELIMINAR");
        lbl1.setFont(new Font("Arial", Font.BOLD, 30));
        lbl1.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lbl1, gbc);

        String[] columnNames = {"ID", "Nombre", "Apellido Paterno", "Calle", "Número", "Colonia", "Código Postal", "Municipio", "Estado", "País", "Fecha", "Método de Pago", "Categoría"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(scrollPane, gbc);

        // Botones en la parte inferior de la ventana (centrados)
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));

        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.addActionListener(this);
        panelBotones.add(btnEliminar);

        btnCancelar = new JButton("CANCELAR");
        btnCancelar.addActionListener(this);
        panelBotones.add(btnCancelar);

        btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.addActionListener(this);
        panelBotones.add(btnActualizar);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(panelBotones, gbc);

        cargarDatosTabla();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEliminar) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int idEliminar = (int) table.getValueAt(selectedRow, 0);
                eliminarRegistro(idEliminar);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.");
            }
        } else if (e.getSource() == btnCancelar) {
            dispose(); // Cierra la ventana
        } else if (e.getSource() == btnActualizar) {
            actualizarTabla();
        }
    }

    private void actualizarTabla() {
        tableModel.setRowCount(0);
        cargarDatosTabla();
    }

    private void cargarDatosTabla() {
        try {
            Connection conexion = ConexionBD.getInstance().getConnection();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Alumnos");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellidoPaterno = resultSet.getString("apellido_paterno");
                String calle = resultSet.getString("calle");
                String numero = resultSet.getString("numero");
                String colonia = resultSet.getString("colonia");
                String codigoPostal = resultSet.getString("codigo_postal");
                String municipio = resultSet.getString("municipio");
                String estado = resultSet.getString("estado");
                String pais = resultSet.getString("pais");
                String fecha = resultSet.getString("fecha");
                String metodoPago = resultSet.getString("metodo_pago");
                String categoria = resultSet.getString("categoria");

                Object[] fila = {id, nombre, apellidoPaterno, calle, numero, colonia, codigoPostal, municipio, estado, pais, fecha, metodoPago, categoria};
                tableModel.addRow(fila);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla.");
        }
    }

    private void eliminarRegistro(int idEliminar) {
        try {
            Connection conexion = ConexionBD.getInstance().getConnection();
            String query = "DELETE FROM Alumnos WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idEliminar);
            int filasEliminadas = statement.executeUpdate();

            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente.");
                actualizarTabla(); // Actualiza la tabla después de eliminar el registro
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún registro con el ID especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar el registro de la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
