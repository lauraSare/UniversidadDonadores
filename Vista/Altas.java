package Vista;

import ConexionBD.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Altas extends JInternalFrame implements ActionListener {
    private JTextField tfNombre;
    private JTextField tfApellidoPaterno;
    private JTextField tfCalle;
    private JTextField tfNumero;
    private JTextField tfColonia;
    private JTextField tfCodigoPostal;
    private JTextField tfMunicipio;
    private JTextField tfEstado;
    private JTextField tfPais;
    private JTextField tfFecha;
    private JComboBox<String> comboMetodoPago;
    private JComboBox<String> comboCategoria;
    private JButton btnAgregar;
    private JButton btnLimpiar;
    private JButton btnCancelar;
    private DefaultTableModel tableModel;
    private JButton btnActualizar;
    private ImageIcon iconoActualizar;

    public Altas() {
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("ALTAS");
        setSize(800, 600);
        setClosable(true);
        setResizable(false);
        getContentPane().setBackground(new Color(0xB2838B));

        // Crear GridBagConstraints para centrar los componentes
        GridBagConstraints gbcCenter = new GridBagConstraints();
        gbcCenter.gridwidth = 2;
        gbcCenter.fill = GridBagConstraints.HORIZONTAL;
        gbcCenter.insets = new Insets(10, 10, 10, 10);

        JLabel lbl1 = new JLabel("AGREGAR");
        lbl1.setFont(new Font("Arial", Font.BOLD, 30));
        lbl1.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lbl1, gbc);

        JLabel lblNombre = new JLabel("NOMBRE:");
        lblNombre.setForeground(Color.white);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lblNombre, gbc);
        tfNombre = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; // Ajuste de peso para expandirse
        gbc.insets = new Insets(10, 10, 10, 10);
        add(tfNombre, gbc);

        JLabel lblApellidoPaterno = new JLabel("APELLIDO PATERNO:");
        lblApellidoPaterno.setForeground(Color.white);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lblApellidoPaterno, gbc);
        tfApellidoPaterno = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(tfApellidoPaterno, gbc);

        JLabel lblCalle = new JLabel("CALLE:");
        lblCalle.setForeground(Color.white);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lblCalle, gbc);
        tfCalle = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(tfCalle, gbc);

        JLabel lblNumero = new JLabel("NÚMERO:");
        lblNumero.setForeground(Color.white);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lblNumero, gbc);
        tfNumero = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(tfNumero, gbc);

        JLabel lblColonia = new JLabel("COLONIA:");
        lblColonia.setForeground(Color.white);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lblColonia, gbc);
        tfColonia = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(tfColonia, gbc);

        JLabel lblCodigoPostal = new JLabel("CÓDIGO POSTAL:");
        lblCodigoPostal.setForeground(Color.white);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lblCodigoPostal, gbc);
        tfCodigoPostal = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(tfCodigoPostal, gbc);

        JLabel lblMunicipio = new JLabel("MUNICIPIO:");
        lblMunicipio.setForeground(Color.white);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lblMunicipio, gbc);
        tfMunicipio = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(tfMunicipio, gbc);

        JLabel lblEstado = new JLabel("ESTADO:");
        lblEstado.setForeground(Color.white);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lblEstado, gbc);
        tfEstado = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(tfEstado, gbc);

        JLabel lblPais = new JLabel("PAÍS:");
        lblPais.setForeground(Color.white);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lblPais, gbc);
        tfPais = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(tfPais, gbc);

        JLabel lblFecha = new JLabel("FECHA (dd/mm/yyyy):");
        lblFecha.setForeground(Color.white);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lblFecha, gbc);
        tfFecha = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(tfFecha, gbc);

        JLabel lblMetodoPago = new JLabel("MÉTODO DE PAGO:");
        lblMetodoPago.setForeground(Color.white);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lblMetodoPago, gbc);
        String[] metodoPagoOptions = {"Efectivo", "Banco", "Deposito", "Transferencia"};
        comboMetodoPago = new JComboBox<>(metodoPagoOptions);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(comboMetodoPago, gbc);

        JLabel lblCategoria = new JLabel("CATEGORÍA:");
        lblCategoria.setForeground(Color.white);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(lblCategoria, gbc);
        String[] categoriaOptions = {"Alumno", "Donador", "Docente", "Ex-alumno", "Tutores"};
        comboCategoria = new JComboBox<>(categoriaOptions);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(comboCategoria, gbc);

        // Botones en la parte inferior de la ventana (centrados)
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));

        btnAgregar = new JButton("AGREGAR");
        btnAgregar.addActionListener(this);
        panelBotones.add(btnAgregar);

        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.addActionListener(this);
        panelBotones.add(btnLimpiar);

        btnCancelar = new JButton("CANCELAR");
        btnCancelar.addActionListener(this);
        panelBotones.add(btnCancelar);

        btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.addActionListener(this);
        panelBotones.add(btnActualizar);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(panelBotones, gbc);

        String[] columnNames = {"ID", "Nombre", "Apellido Paterno", "Calle", "Número", "Colonia", "Código Postal", "Municipio", "Estado", "País", "Fecha", "Método de Pago", "Categoría"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(scrollPane, gbc);

        cargarDatosTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            String nombre = tfNombre.getText();
            String apellidoPaterno = tfApellidoPaterno.getText();
            String calle = tfCalle.getText();
            String numero = tfNumero.getText();
            String colonia = tfColonia.getText();
            String codigoPostal = tfCodigoPostal.getText();
            String municipio = tfMunicipio.getText();
            String estado = tfEstado.getText();
            String pais = tfPais.getText();
            String fechaStr = tfFecha.getText();
            String metodoPago = (String) comboMetodoPago.getSelectedItem();
            String categoria = (String) comboCategoria.getSelectedItem();

            if (!validarNombre(nombre) || !validarApellidoPaterno(apellidoPaterno) ||
                    !validarCalle(calle) || !validarNumero(numero) ||
                    !validarColonia(colonia) || !validarCodigoPostal(codigoPostal) ||
                    !validarMunicipio(municipio) || !validarEstado(estado) ||
                    !validarPais(pais) || !validarFecha(fechaStr)) {
                return;
            }
            try {
                Connection conexion = ConexionBD.getInstance().getConnection();
                String query = "INSERT INTO Alumnos (nombre, apellido_paterno, calle, numero, colonia, codigo_postal, municipio, estado, pais, fecha, metodo_pago, categoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, nombre);
                statement.setString(2, apellidoPaterno);
                statement.setString(3, calle);
                statement.setString(4, numero);
                statement.setString(5, colonia);
                statement.setString(6, codigoPostal);
                statement.setString(7, municipio);
                statement.setString(8, estado);
                statement.setString(9, pais);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date utilDate = dateFormat.parse(fechaStr);
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                statement.setDate(10, sqlDate);

                statement.setString(11, metodoPago);
                statement.setString(12, categoria);
                statement.executeUpdate();

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    Object[] fila = {id, nombre, apellidoPaterno, calle, numero, colonia, codigoPostal, municipio, estado, pais, fechaStr, metodoPago, categoria};
                    tableModel.addRow(fila);
                }

                JOptionPane.showMessageDialog(this, "Datos guardados correctamente.");
                limpiarCampos();
            } catch (SQLException | ParseException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar los datos en la base de datos.");
            }
        } else if (e.getSource() == btnActualizar) {
            actualizarTabla();
        } else if (e.getSource() == btnCancelar) {
            regresarAlMenu();
        } else if (e.getSource() == btnLimpiar) {
            limpiarCampos();
        }
    }

    private void regresarAlMenu() {
        VentanaInicio ventanaInicio = (VentanaInicio) getDesktopPane().getParent().getParent().getParent().getParent();
        ventanaInicio.remove(this);
        dispose();
    }

    private void actualizarTabla() {
        tableModel.setRowCount(0);
        cargarDatosTabla();
    }

    private boolean validarNombre(String nombre) {
        if (!nombre.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Solo se permiten letras en el campo NOMBRE.");
            return false;
        }
        if (nombre.length() > 20) {
            JOptionPane.showMessageDialog(this, "La longitud máxima permitida es de 20 caracteres en el campo NOMBRE.");
            return false;
        }
        return true;
    }

    private boolean validarApellidoPaterno(String apellidoPaterno) {
        if (!apellidoPaterno.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Solo se permiten letras en el campo APELLIDO PATERNO.");
            return false;
        }
        if (apellidoPaterno.length() > 20) {
            JOptionPane.showMessageDialog(this, "La longitud máxima permitida es de 20 caracteres en el campo APELLIDO PATERNO.");
            return false;
        }
        return true;
    }

    private boolean validarCalle(String calle) {
        if (!calle.matches("^[a-zA-Z\\s]+$")) {
            JOptionPane.showMessageDialog(this, "Solo se permiten letras y espacios en el campo CALLE.");
            return false;
        }
        if (calle.length() > 20) {
            JOptionPane.showMessageDialog(this, "La longitud máxima permitida es de 20 caracteres en el campo CALLE.");
            return false;
        }
        return true;
    }

    private boolean validarNumero(String numero) {
        if (!numero.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Solo se permiten números en el campo NÚMERO.");
            return false;
        }
        if (numero.length() > 5) {
            JOptionPane.showMessageDialog(this, "La longitud máxima permitida es de 5 dígitos en el campo NÚMERO.");
            return false;
        }
        return true;
    }

    private boolean validarColonia(String colonia) {
        if (!colonia.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(this, "Solo se permiten letras en el campo COLONIA.");
            return false;
        }
        if (colonia.length() > 20) {
            JOptionPane.showMessageDialog(this, "La longitud máxima permitida es de 20 caracteres en el campo COLONIA.");
            return false;
        }
        return true;
    }

    private boolean validarCodigoPostal(String codigoPostal) {
        if (!codigoPostal.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Solo se permiten números en el campo CÓDIGO POSTAL.");
            return false;
        }
        if (codigoPostal.length() > 6) {
            JOptionPane.showMessageDialog(this, "La longitud máxima permitida es de 6 dígitos en el campo CÓDIGO POSTAL.");
            return false;
        }
        return true;
    }

    private boolean validarMunicipio(String municipio) {
        if (!municipio.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(this, "Solo se permiten letras en el campo MUNICIPIO.");
            return false;
        }
        if (municipio.length() > 20) {
            JOptionPane.showMessageDialog(this, "La longitud máxima permitida es de 20 caracteres en el campo MUNICIPIO.");
            return false;
        }
        return true;
    }

    private boolean validarEstado(String estado) {
        if (!estado.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(this, "Solo se permiten letras en el campo ESTADO.");
            return false;
        }
        if (estado.length() > 20) {
            JOptionPane.showMessageDialog(this, "La longitud máxima permitida es de 20 caracteres en el campo ESTADO.");
            return false;
        }
        return true;
    }

    private boolean validarPais(String pais) {
        if (!pais.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(this, "Solo se permiten letras en el campo PAÍS.");
            return false;
        }
        if (pais.length() > 20) {
            JOptionPane.showMessageDialog(this, "La longitud máxima permitida es de 20 caracteres en el campo PAÍS.");
            return false;
        }
        return true;
    }

    private boolean validarFecha(String fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(fecha);
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Utiliza el formato dd/mm/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void limpiarCampos() {
        tfNombre.setText("");
        tfApellidoPaterno.setText("");
        tfCalle.setText("");
        tfNumero.setText("");
        tfColonia.setText("");
        tfCodigoPostal.setText("");
        tfMunicipio.setText("");
        tfEstado.setText("");
        tfPais.setText("");
        tfFecha.setText("");
        comboMetodoPago.setSelectedIndex(0);
        comboCategoria.setSelectedIndex(0);
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
                Date fecha = resultSet.getDate("fecha");
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
}