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

public class Consultas extends JInternalFrame implements ActionListener {
    private ConexionBD conexion;
    private DefaultTableModel tableModel;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfApellidoPaterno;
    private javax.swing.JTextField tfCalle;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfColonia;
    private javax.swing.JTextField tfCodigoPostal;
    private javax.swing.JTextField tfMunicipio;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfPais;
    private javax.swing.JTextField tfFecha;
    private javax.swing.JComboBox<String> comboMetodoPago;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JRadioButton radioNombre;
    private javax.swing.JRadioButton radioApellidoPaterno;
    private javax.swing.JRadioButton radioCalle;
    private javax.swing.JRadioButton radioNumero;
    private javax.swing.JRadioButton radioColonia;
    private javax.swing.JRadioButton radioCodigoPostal;
    private javax.swing.JRadioButton radioMunicipio;
    private javax.swing.JRadioButton radioEstado;
    private javax.swing.JRadioButton radioPais;
    private javax.swing.JRadioButton radioFecha;
    private javax.swing.JRadioButton radioMetodoPago;
    private javax.swing.JRadioButton radioCategoria;
    private javax.swing.JButton btnConsultar;
    private javax.swing.ButtonGroup group;

    public Consultas() {
        super("Consultas", true, true, true, true);
        conexion = ConexionBD.getInstance();
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        initComponents();
        cargarDatosTabla();
        habilitarCampos(false);
    }

    private void initComponents() {
        tfNombre = new JTextField();
        tfApellidoPaterno = new JTextField();
        tfCalle = new JTextField();
        tfNumero = new JTextField();
        tfColonia = new JTextField();
        tfCodigoPostal = new JTextField();
        tfMunicipio = new JTextField();
        tfEstado = new JTextField();
        tfPais = new JTextField();
        tfFecha = new JTextField();
        comboMetodoPago = new JComboBox<>(new String[]{"Efectivo", "Tarjeta", "Transferencia"});
        comboCategoria = new JComboBox<>(new String[]{"Estudiante", "Profesional", "Otro"});
        radioNombre = new JRadioButton("NOMBRE");
        radioApellidoPaterno = new JRadioButton("APELLIDO PATERNO");
        radioCalle = new JRadioButton("CALLE");
        radioNumero = new JRadioButton("NÚMERO");
        radioColonia = new JRadioButton("COLONIA");
        radioCodigoPostal = new JRadioButton("CÓDIGO POSTAL");
        radioMunicipio = new JRadioButton("MUNICIPIO");
        radioEstado = new JRadioButton("ESTADO");
        radioPais = new JRadioButton("PAÍS");
        radioFecha = new JRadioButton("FECHA");
        radioMetodoPago = new JRadioButton("MÉTODO DE PAGO");
        radioCategoria = new JRadioButton("CATEGORÍA");
        btnConsultar = new JButton("CONSULTAR");
        group = new ButtonGroup();

        group.add(radioNombre);
        group.add(radioApellidoPaterno);
        group.add(radioCalle);
        group.add(radioNumero);
        group.add(radioColonia);
        group.add(radioCodigoPostal);
        group.add(radioMunicipio);
        group.add(radioEstado);
        group.add(radioPais);
        group.add(radioFecha);
        group.add(radioMetodoPago);
        group.add(radioCategoria);

        String[] columnNames = {"ID", "Nombre", "Apellido Paterno", "Calle", "Número", "Colonia", "Código Postal", "Municipio", "Estado", "País", "Fecha", "Método de Pago", "Categoría"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());
        JPanel panelOpciones = new JPanel();
        GroupLayout layout = new GroupLayout(panelOpciones);
        panelOpciones.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(radioNombre)
                                .addComponent(radioApellidoPaterno)
                                .addComponent(radioCalle)
                                .addComponent(radioNumero)
                                .addComponent(radioColonia)
                                .addComponent(radioCodigoPostal)
                                .addComponent(radioMunicipio)
                                .addComponent(radioEstado)
                                .addComponent(radioPais)
                                .addComponent(radioFecha)
                                .addComponent(radioMetodoPago)
                                .addComponent(radioCategoria))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(tfNombre)
                                .addComponent(tfApellidoPaterno)
                                .addComponent(tfCalle)
                                .addComponent(tfNumero)
                                .addComponent(tfColonia)
                                .addComponent(tfCodigoPostal)
                                .addComponent(tfMunicipio)
                                .addComponent(tfEstado)
                                .addComponent(tfPais)
                                .addComponent(tfFecha)
                                .addComponent(comboMetodoPago)
                                .addComponent(comboCategoria)
                                .addComponent(btnConsultar))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioNombre)
                                .addComponent(tfNombre))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioApellidoPaterno)
                                .addComponent(tfApellidoPaterno))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioCalle)
                                .addComponent(tfCalle))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioNumero)
                                .addComponent(tfNumero))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioColonia)
                                .addComponent(tfColonia))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioCodigoPostal)
                                .addComponent(tfCodigoPostal))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioMunicipio)
                                .addComponent(tfMunicipio))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioEstado)
                                .addComponent(tfEstado))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioPais)
                                .addComponent(tfPais))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioFecha)
                                .addComponent(tfFecha))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioMetodoPago)
                                .addComponent(comboMetodoPago))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioCategoria)
                                .addComponent(comboCategoria))
                        .addComponent(btnConsultar)
        );

        add(panelOpciones, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Estilo de la tabla
        table.setFillsViewportHeight(true);
        table.setBackground(new Color(0xFFFFFF));
        table.setForeground(new Color(0x000000));
        table.setSelectionBackground(new Color(0xFF5733));
        table.setSelectionForeground(new Color(0xFFFFFF));
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);

        // Configurar la cabecera de la tabla
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(0xFF5733));
        table.getTableHeader().setForeground(new Color(0xFFFFFF));

        pack();

        radioNombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioNombreActionPerformed(evt);
            }
        });
        radioApellidoPaterno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioApellidoPaternoActionPerformed(evt);
            }
        });
        radioCalle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioCalleActionPerformed(evt);
            }
        });
        radioNumero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioNumeroActionPerformed(evt);
            }
        });
        radioColonia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioColoniaActionPerformed(evt);
            }
        });
        radioCodigoPostal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioCodigoPostalActionPerformed(evt);
            }
        });
        radioMunicipio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioMunicipioActionPerformed(evt);
            }
        });
        radioEstado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioEstadoActionPerformed(evt);
            }
        });
        radioPais.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioPaisActionPerformed(evt);
            }
        });
        radioFecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioFechaActionPerformed(evt);
            }
        });
        radioMetodoPago.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioMetodoPagoActionPerformed(evt);
            }
        });
        radioCategoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radioCategoriaActionPerformed(evt);
            }
        });
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
    }

    private void cargarDatosTabla() {
        try {
            Connection connection = conexion.getConnection();
            String query = "SELECT * FROM Alumnos";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido_paterno"),
                        resultSet.getString("calle"),
                        resultSet.getString("numero"),
                        resultSet.getString("colonia"),
                        resultSet.getString("codigo_postal"),
                        resultSet.getString("municipio"),
                        resultSet.getString("estado"),
                        resultSet.getString("pais"),
                        resultSet.getString("fecha"),
                        resultSet.getString("metodo_pago"),
                        resultSet.getString("categoria")
                };
                tableModel.addRow(row);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar datos de la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void habilitarCampos(boolean estado) {
        tfNombre.setEnabled(estado);
        tfApellidoPaterno.setEnabled(estado);
        tfCalle.setEnabled(estado);
        tfNumero.setEnabled(estado);
        tfColonia.setEnabled(estado);
        tfCodigoPostal.setEnabled(estado);
        tfMunicipio.setEnabled(estado);
        tfEstado.setEnabled(estado);
        tfPais.setEnabled(estado);
        tfFecha.setEnabled(estado);
        comboMetodoPago.setEnabled(estado);
        comboCategoria.setEnabled(estado);
    }

    private void radioNombreActionPerformed(ActionEvent evt) {
        habilitarCampos(false);
        tfNombre.setEnabled(true);
    }

    private void radioApellidoPaternoActionPerformed(ActionEvent evt) {
        habilitarCampos(false);
        tfApellidoPaterno.setEnabled(true);
    }

    private void radioCalleActionPerformed(ActionEvent evt) {
        habilitarCampos(false);
        tfCalle.setEnabled(true);
    }

    private void radioNumeroActionPerformed(ActionEvent evt) {
        habilitarCampos(false);
        tfNumero.setEnabled(true);
    }

    private void radioColoniaActionPerformed(ActionEvent evt) {
        habilitarCampos(false);
        tfColonia.setEnabled(true);
    }

    private void radioCodigoPostalActionPerformed(ActionEvent evt) {
        habilitarCampos(false);
        tfCodigoPostal.setEnabled(true);
    }

    private void radioMunicipioActionPerformed(ActionEvent evt) {
        habilitarCampos(false);
        tfMunicipio.setEnabled(true);
    }

    private void radioEstadoActionPerformed(ActionEvent evt) {
        habilitarCampos(false);
        tfEstado.setEnabled(true);
    }

    private void radioPaisActionPerformed(ActionEvent evt) {
        habilitarCampos(false);
        tfPais.setEnabled(true);
    }

    private void radioFechaActionPerformed(ActionEvent evt) {
        habilitarCampos(false);
        tfFecha.setEnabled(true);
    }

    private void radioMetodoPagoActionPerformed(ActionEvent evt) {
        habilitarCampos(false);
        comboMetodoPago.setEnabled(true);
    }

    private void radioCategoriaActionPerformed(ActionEvent evt) {
        habilitarCampos(false);
        comboCategoria.setEnabled(true);
    }

    private void btnConsultarActionPerformed(ActionEvent evt) {
        filtrarTabla();
    }

    private void filtrarTabla() {
        try {
            Connection connection = conexion.getConnection();
            String query = "SELECT * FROM Alumnos WHERE ";
            boolean first = true;

            if (radioNombre.isSelected()) {
                query += "nombre LIKE ?";
                first = false;
            }
            if (radioApellidoPaterno.isSelected()) {
                if (!first) query += " AND ";
                query += "apellido_paterno LIKE ?";
                first = false;
            }
            if (radioCalle.isSelected()) {
                if (!first) query += " AND ";
                query += "calle LIKE ?";
                first = false;
            }
            if (radioNumero.isSelected()) {
                if (!first) query += " AND ";
                query += "numero LIKE ?";
                first = false;
            }
            if (radioColonia.isSelected()) {
                if (!first) query += " AND ";
                query += "colonia LIKE ?";
                first = false;
            }
            if (radioCodigoPostal.isSelected()) {
                if (!first) query += " AND ";
                query += "codigo_postal LIKE ?";
                first = false;
            }
            if (radioMunicipio.isSelected()) {
                if (!first) query += " AND ";
                query += "municipio LIKE ?";
                first = false;
            }
            if (radioEstado.isSelected()) {
                if (!first) query += " AND ";
                query += "estado LIKE ?";
                first = false;
            }
            if (radioPais.isSelected()) {
                if (!first) query += " AND ";
                query += "pais LIKE ?";
                first = false;
            }
            if (radioFecha.isSelected()) {
                if (!first) query += " AND ";
                query += "fecha LIKE ?";
                first = false;
            }
            if (radioMetodoPago.isSelected()) {
                if (!first) query += " AND ";
                query += "metodo_pago LIKE ?";
                first = false;
            }
            if (radioCategoria.isSelected()) {
                if (!first) query += " AND ";
                query += "categoria LIKE ?";
                first = false;
            }

            PreparedStatement statement = connection.prepareStatement(query);

            int index = 1;
            if (radioNombre.isSelected()) {
                statement.setString(index++, "%" + tfNombre.getText() + "%");
            }
            if (radioApellidoPaterno.isSelected()) {
                statement.setString(index++, "%" + tfApellidoPaterno.getText() + "%");
            }
            if (radioCalle.isSelected()) {
                statement.setString(index++, "%" + tfCalle.getText() + "%");
            }
            if (radioNumero.isSelected()) {
                statement.setString(index++, "%" + tfNumero.getText() + "%");
            }
            if (radioColonia.isSelected()) {
                statement.setString(index++, "%" + tfColonia.getText() + "%");
            }
            if (radioCodigoPostal.isSelected()) {
                statement.setString(index++, "%" + tfCodigoPostal.getText() + "%");
            }
            if (radioMunicipio.isSelected()) {
                statement.setString(index++, "%" + tfMunicipio.getText() + "%");
            }
            if (radioEstado.isSelected()) {
                statement.setString(index++, "%" + tfEstado.getText() + "%");
            }
            if (radioPais.isSelected()) {
                statement.setString(index++, "%" + tfPais.getText() + "%");
            }
            if (radioFecha.isSelected()) {
                statement.setString(index++, "%" + tfFecha.getText() + "%");
            }
            if (radioMetodoPago.isSelected()) {
                statement.setString(index++, "%" + comboMetodoPago.getSelectedItem().toString() + "%");
            }
            if (radioCategoria.isSelected()) {
                statement.setString(index++, "%" + comboCategoria.getSelectedItem().toString() + "%");
            }

            ResultSet resultSet = statement.executeQuery();

            tableModel.setRowCount(0);
            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido_paterno"),
                        resultSet.getString("calle"),
                        resultSet.getString("numero"),
                        resultSet.getString("colonia"),
                        resultSet.getString("codigo_postal"),
                        resultSet.getString("municipio"),
                        resultSet.getString("estado"),
                        resultSet.getString("pais"),
                        resultSet.getString("fecha"),
                        resultSet.getString("metodo_pago"),
                        resultSet.getString("categoria")
                };
                tableModel.addRow(row);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al filtrar datos de la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
