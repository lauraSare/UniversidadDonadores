package Vista;

import ConexionBD.ConexionBD;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Consultas extends JInternalFrame implements ActionListener {
    private JRadioButton rbNombre;
    private JRadioButton rbApellidoPaterno;
    private JRadioButton rbCalle;
    private JRadioButton rbNumero;
    private JRadioButton rbColonia;
    private JRadioButton rbCodigoPostal;
    private JRadioButton rbMunicipio;
    private JRadioButton rbEstado;
    private JRadioButton rbPais;
    private JRadioButton rbFecha;
    private JRadioButton rbMetodoPago;
    private JRadioButton rbCategoria;
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
    private JTextField tfMetodoPago;
    private JTextField tfCategoria;
    private JButton btnLimpiar;
    private JButton btnCancelar;
    private JButton btnActualizar;
    private DefaultTableModel tableModel;

    public Consultas() {
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("CONSULTAS");
        setSize(800, 600);
        setClosable(true);
        setResizable(false);
        getContentPane().setBackground(new Color(0xB2838B));

        JLabel lblTitulo = new JLabel("CONSULTAS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        lblTitulo.setForeground(Color.white);
        GridBagConstraints gbcTitulo = new GridBagConstraints();
        gbcTitulo.gridx = 0;
        gbcTitulo.gridy = 0;
        gbcTitulo.gridwidth = 4;
        gbcTitulo.insets = new Insets(10, 10, 10, 10);
        add(lblTitulo, gbcTitulo);

        // Primera columna de campos y cajas de texto
        JLabel lblNombre = new JLabel("NOMBRE:");
        lblNombre.setForeground(Color.white);
        GridBagConstraints gbcLblNombre = new GridBagConstraints();
        gbcLblNombre.gridx = 0;
        gbcLblNombre.gridy = 1;
        gbcLblNombre.anchor = GridBagConstraints.WEST;
        gbcLblNombre.insets = new Insets(5, 10, 5, 10);
        add(lblNombre, gbcLblNombre);

        rbNombre = new JRadioButton();
        rbNombre.setForeground(Color.white);
        rbNombre.setBackground(new Color(0xB2838B));
        rbNombre.setSelected(true);
        rbNombre.addActionListener(this);
        GridBagConstraints gbcRbNombre = new GridBagConstraints();
        gbcRbNombre.gridx = 1;
        gbcRbNombre.gridy = 1;
        gbcRbNombre.anchor = GridBagConstraints.WEST;
        add(rbNombre, gbcRbNombre);

        tfNombre = new JTextField(20);
        tfNombre.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se utiliza en este caso
            }
        });
        GridBagConstraints gbcTfNombre = new GridBagConstraints();
        gbcTfNombre.gridx = 2;
        gbcTfNombre.gridy = 1;
        gbcTfNombre.fill = GridBagConstraints.HORIZONTAL;
        gbcTfNombre.weightx = 1.0;
        gbcTfNombre.insets = new Insets(5, 10, 5, 10);
        add(tfNombre, gbcTfNombre);

        JLabel lblApellidoPaterno = new JLabel("APELLIDO PATERNO:");
        lblApellidoPaterno.setForeground(Color.white);
        GridBagConstraints gbcLblApellidoPaterno = new GridBagConstraints();
        gbcLblApellidoPaterno.gridx = 0;
        gbcLblApellidoPaterno.gridy = 2;
        gbcLblApellidoPaterno.anchor = GridBagConstraints.WEST;
        gbcLblApellidoPaterno.insets = new Insets(5, 10, 5, 10);
        add(lblApellidoPaterno, gbcLblApellidoPaterno);

        rbApellidoPaterno = new JRadioButton();
        rbApellidoPaterno.setForeground(Color.white);
        rbApellidoPaterno.setBackground(new Color(0xB2838B));
        rbApellidoPaterno.addActionListener(this);
        GridBagConstraints gbcRbApellidoPaterno = new GridBagConstraints();
        gbcRbApellidoPaterno.gridx = 1;
        gbcRbApellidoPaterno.gridy = 2;
        gbcRbApellidoPaterno.anchor = GridBagConstraints.WEST;
        add(rbApellidoPaterno, gbcRbApellidoPaterno);

        tfApellidoPaterno = new JTextField(20);
        tfApellidoPaterno.setEnabled(false);
        tfApellidoPaterno.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se utiliza en este caso
            }
        });
        GridBagConstraints gbcTfApellidoPaterno = new GridBagConstraints();
        gbcTfApellidoPaterno.gridx = 2;
        gbcTfApellidoPaterno.gridy = 2;
        gbcTfApellidoPaterno.fill = GridBagConstraints.HORIZONTAL;
        gbcTfApellidoPaterno.weightx = 1.0;
        gbcTfApellidoPaterno.insets = new Insets(5, 10, 5, 10);
        add(tfApellidoPaterno, gbcTfApellidoPaterno);

        JLabel lblCalle = new JLabel("CALLE:");
        lblCalle.setForeground(Color.white);
        GridBagConstraints gbcLblCalle = new GridBagConstraints();
        gbcLblCalle.gridx = 0;
        gbcLblCalle.gridy = 3;
        gbcLblCalle.anchor = GridBagConstraints.WEST;
        gbcLblCalle.insets = new Insets(5, 10, 5, 10);
        add(lblCalle, gbcLblCalle);

        rbCalle = new JRadioButton();
        rbCalle.setForeground(Color.white);
        rbCalle.setBackground(new Color(0xB2838B));
        rbCalle.addActionListener(this);
        GridBagConstraints gbcRbCalle = new GridBagConstraints();
        gbcRbCalle.gridx = 1;
        gbcRbCalle.gridy = 3;
        gbcRbCalle.anchor = GridBagConstraints.WEST;
        add(rbCalle, gbcRbCalle);

        tfCalle = new JTextField(20);
        tfCalle.setEnabled(false);
        tfCalle.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se utiliza en este caso
            }
        });
        GridBagConstraints gbcTfCalle = new GridBagConstraints();
        gbcTfCalle.gridx = 2;
        gbcTfCalle.gridy = 3;
        gbcTfCalle.fill = GridBagConstraints.HORIZONTAL;
        gbcTfCalle.weightx = 1.0;
        gbcTfCalle.insets = new Insets(5, 10, 5, 10);
        add(tfCalle, gbcTfCalle);

        JLabel lblNumero = new JLabel("NÚMERO:");
        lblNumero.setForeground(Color.white);
        GridBagConstraints gbcLblNumero = new GridBagConstraints();
        gbcLblNumero.gridx = 0;
        gbcLblNumero.gridy = 4;
        gbcLblNumero.anchor = GridBagConstraints.WEST;
        gbcLblNumero.insets = new Insets(5, 10, 5, 10);
        add(lblNumero, gbcLblNumero);

        rbNumero = new JRadioButton();
        rbNumero.setForeground(Color.white);
        rbNumero.setBackground(new Color(0xB2838B));
        rbNumero.addActionListener(this);
        GridBagConstraints gbcRbNumero = new GridBagConstraints();
        gbcRbNumero.gridx = 1;
        gbcRbNumero.gridy = 4;
        gbcRbNumero.anchor = GridBagConstraints.WEST;
        add(rbNumero, gbcRbNumero);

        tfNumero = new JTextField(20);
        tfNumero.setEnabled(false);
        tfNumero.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se utiliza en este caso
            }
        });
        GridBagConstraints gbcTfNumero = new GridBagConstraints();
        gbcTfNumero.gridx = 2;
        gbcTfNumero.gridy = 4;
        gbcTfNumero.fill = GridBagConstraints.HORIZONTAL;
        gbcTfNumero.weightx = 1.0;
        gbcTfNumero.insets = new Insets(5, 10, 5, 10);
        add(tfNumero, gbcTfNumero);

        JLabel lblColonia = new JLabel("COLONIA:");
        lblColonia.setForeground(Color.white);
        GridBagConstraints gbcLblColonia = new GridBagConstraints();
        gbcLblColonia.gridx = 0;
        gbcLblColonia.gridy = 5;
        gbcLblColonia.anchor = GridBagConstraints.WEST;
        gbcLblColonia.insets = new Insets(5, 10, 5, 10);
        add(lblColonia, gbcLblColonia);

        rbColonia = new JRadioButton();
        rbColonia.setForeground(Color.white);
        rbColonia.setBackground(new Color(0xB2838B));
        rbColonia.addActionListener(this);
        GridBagConstraints gbcRbColonia = new GridBagConstraints();
        gbcRbColonia.gridx = 1;
        gbcRbColonia.gridy = 5;
        gbcRbColonia.anchor = GridBagConstraints.WEST;
        add(rbColonia, gbcRbColonia);

        tfColonia = new JTextField(20);
        tfColonia.setEnabled(false);
        tfColonia.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se utiliza en este caso
            }
        });
        GridBagConstraints gbcTfColonia = new GridBagConstraints();
        gbcTfColonia.gridx = 2;
        gbcTfColonia.gridy = 5;
        gbcTfColonia.fill = GridBagConstraints.HORIZONTAL;
        gbcTfColonia.weightx = 1.0;
        gbcTfColonia.insets = new Insets(5, 10, 5, 10);
        add(tfColonia, gbcTfColonia);

        JLabel lblCodigoPostal = new JLabel("CÓDIGO POSTAL:");
        lblCodigoPostal.setForeground(Color.white);
        GridBagConstraints gbcLblCodigoPostal = new GridBagConstraints();
        gbcLblCodigoPostal.gridx = 0;
        gbcLblCodigoPostal.gridy = 6;
        gbcLblCodigoPostal.anchor = GridBagConstraints.WEST;
        gbcLblCodigoPostal.insets = new Insets(5, 10, 5, 10);
        add(lblCodigoPostal, gbcLblCodigoPostal);

        rbCodigoPostal = new JRadioButton();
        rbCodigoPostal.setForeground(Color.white);
        rbCodigoPostal.setBackground(new Color(0xB2838B));
        rbCodigoPostal.addActionListener(this);
        GridBagConstraints gbcRbCodigoPostal = new GridBagConstraints();
        gbcRbCodigoPostal.gridx = 1;
        gbcRbCodigoPostal.gridy = 6;
        gbcRbCodigoPostal.anchor = GridBagConstraints.WEST;
        add(rbCodigoPostal, gbcRbCodigoPostal);

        tfCodigoPostal = new JTextField(20);
        tfCodigoPostal.setEnabled(false);
        tfCodigoPostal.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se utiliza en este caso
            }
        });

        GridBagConstraints gbcTfCodigoPostal = new GridBagConstraints();
        gbcTfCodigoPostal.gridx = 2;
        gbcTfCodigoPostal.gridy = 6;
        gbcTfCodigoPostal.fill = GridBagConstraints.HORIZONTAL;
        gbcTfCodigoPostal.weightx = 1.0;
        gbcTfCodigoPostal.insets = new Insets(5, 10, 5, 10);
        add(tfCodigoPostal, gbcTfCodigoPostal);

        // Segunda columna de campos y cajas de texto
        JLabel lblMunicipio = new JLabel("MUNICIPIO:");
        lblMunicipio.setForeground(Color.white);
        GridBagConstraints gbcLblMunicipio = new GridBagConstraints();
        gbcLblMunicipio.gridx = 3;
        gbcLblMunicipio.gridy = 1;
        gbcLblMunicipio.anchor = GridBagConstraints.WEST;
        gbcLblMunicipio.insets = new Insets(5, 10, 5, 10);
        add(lblMunicipio, gbcLblMunicipio);

        rbMunicipio = new JRadioButton();
        rbMunicipio.setForeground(Color.white);
        rbMunicipio.setBackground(new Color(0xB2838B));
        rbMunicipio.addActionListener(this);
        GridBagConstraints gbcRbMunicipio = new GridBagConstraints();
        gbcRbMunicipio.gridx = 4;
        gbcRbMunicipio.gridy = 1;
        gbcRbMunicipio.anchor = GridBagConstraints.WEST;
        add(rbMunicipio, gbcRbMunicipio);

        tfMunicipio = new JTextField(20);
        tfMunicipio.setEnabled(false);
        tfMunicipio.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se utiliza en este caso
            }
        });
        GridBagConstraints gbcTfMunicipio = new GridBagConstraints();
        gbcTfMunicipio.gridx = 5;
        gbcTfMunicipio.gridy = 1;
        gbcTfMunicipio.fill = GridBagConstraints.HORIZONTAL;
        gbcTfMunicipio.weightx = 1.0;
        gbcTfMunicipio.insets = new Insets(5, 10, 5, 10);
        add(tfMunicipio, gbcTfMunicipio);

        JLabel lblEstado = new JLabel("ESTADO:");
        lblEstado.setForeground(Color.white);
        GridBagConstraints gbcLblEstado = new GridBagConstraints();
        gbcLblEstado.gridx = 3;
        gbcLblEstado.gridy = 2;
        gbcLblEstado.anchor = GridBagConstraints.WEST;
        gbcLblEstado.insets = new Insets(5, 10, 5, 10);
        add(lblEstado, gbcLblEstado);

        rbEstado = new JRadioButton();
        rbEstado.setForeground(Color.white);
        rbEstado.setBackground(new Color(0xB2838B));
        rbEstado.addActionListener(this);
        GridBagConstraints gbcRbEstado = new GridBagConstraints();
        gbcRbEstado.gridx = 4;
        gbcRbEstado.gridy = 2;
        gbcRbEstado.anchor = GridBagConstraints.WEST;
        add(rbEstado, gbcRbEstado);

        tfEstado = new JTextField(20);
        tfEstado.setEnabled(false);
        tfEstado.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se utiliza en este caso
            }
        });
        GridBagConstraints gbcTfEstado = new GridBagConstraints();
        gbcTfEstado.gridx = 5;
        gbcTfEstado.gridy = 2;
        gbcTfEstado.fill = GridBagConstraints.HORIZONTAL;
        gbcTfEstado.weightx = 1.0;
        gbcTfEstado.insets = new Insets(5, 10, 5, 10);
        add(tfEstado, gbcTfEstado);

        JLabel lblPais = new JLabel("PAÍS:");
        lblPais.setForeground(Color.white);
        GridBagConstraints gbcLblPais = new GridBagConstraints();
        gbcLblPais.gridx = 3;
        gbcLblPais.gridy = 3;
        gbcLblPais.anchor = GridBagConstraints.WEST;
        gbcLblPais.insets = new Insets(5, 10, 5, 10);
        add(lblPais, gbcLblPais);

        rbPais = new JRadioButton();
        rbPais.setForeground(Color.white);
        rbPais.setBackground(new Color(0xB2838B));
        rbPais.addActionListener(this);
        GridBagConstraints gbcRbPais = new GridBagConstraints();
        gbcRbPais.gridx = 4;
        gbcRbPais.gridy = 3;
        gbcRbPais.anchor = GridBagConstraints.WEST;
        add(rbPais, gbcRbPais);

        tfPais = new JTextField(20);
        tfPais.setEnabled(false);
        tfPais.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se utiliza en este caso
            }
        });

        GridBagConstraints gbcTfPais = new GridBagConstraints();
        gbcTfPais.gridx = 5;
        gbcTfPais.gridy = 3;
        gbcTfPais.fill = GridBagConstraints.HORIZONTAL;
        gbcTfPais.weightx = 1.0;
        gbcTfPais.insets = new Insets(5, 10, 5, 10);
        add(tfPais, gbcTfPais);

        JLabel lblFecha = new JLabel("FECHA:");
        lblFecha.setForeground(Color.white);
        GridBagConstraints gbcLblFecha = new GridBagConstraints();
        gbcLblFecha.gridx = 3;
        gbcLblFecha.gridy = 4;
        gbcLblFecha.anchor = GridBagConstraints.WEST;
        gbcLblFecha.insets = new Insets(5, 10, 5, 10);
        add(lblFecha, gbcLblFecha);

        rbFecha = new JRadioButton();
        rbFecha.setForeground(Color.white);
        rbFecha.setBackground(new Color(0xB2838B));
        rbFecha.addActionListener(this);
        GridBagConstraints gbcRbFecha = new GridBagConstraints();
        gbcRbFecha.gridx = 4;
        gbcRbFecha.gridy = 4;
        gbcRbFecha.anchor = GridBagConstraints.WEST;
        add(rbFecha, gbcRbFecha);

        tfFecha = new JTextField(20);
        tfFecha.setEnabled(false);
        tfFecha.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se utiliza en este caso
            }
        });

        GridBagConstraints gbcTfFecha = new GridBagConstraints();
        gbcTfFecha.gridx = 5;
        gbcTfFecha.gridy = 4;
        gbcTfFecha.fill = GridBagConstraints.HORIZONTAL;
        gbcTfFecha.weightx = 1.0;
        gbcTfFecha.insets = new Insets(5, 10, 5, 10);
        add(tfFecha, gbcTfFecha);

        JLabel lblMetodoPago = new JLabel("MÉTODO DE PAGO:");
        lblMetodoPago.setForeground(Color.white);
        GridBagConstraints gbcLblMetodoPago = new GridBagConstraints();
        gbcLblMetodoPago.gridx = 3;
        gbcLblMetodoPago.gridy = 5;
        gbcLblMetodoPago.anchor = GridBagConstraints.WEST;
        gbcLblMetodoPago.insets = new Insets(5, 10, 5, 10);
        add(lblMetodoPago, gbcLblMetodoPago);

        rbMetodoPago = new JRadioButton();
        rbMetodoPago.setForeground(Color.white);
        rbMetodoPago.setBackground(new Color(0xB2838B));
        rbMetodoPago.addActionListener(this);
        GridBagConstraints gbcRbMetodoPago = new GridBagConstraints();
        gbcRbMetodoPago.gridx = 4;
        gbcRbMetodoPago.gridy = 5;
        gbcRbMetodoPago.anchor = GridBagConstraints.WEST;
        add(rbMetodoPago, gbcRbMetodoPago);

        tfMetodoPago = new JTextField(20);
        tfMetodoPago.setEnabled(false);
        tfMetodoPago.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se utiliza en este caso
            }
        });
        GridBagConstraints gbcTfMetodoPago = new GridBagConstraints();
        gbcTfMetodoPago.gridx = 5;
        gbcTfMetodoPago.gridy = 5;
        gbcTfMetodoPago.fill = GridBagConstraints.HORIZONTAL;
        gbcTfMetodoPago.weightx = 1.0;
        gbcTfMetodoPago.insets = new Insets(5, 10, 5, 10);
        add(tfMetodoPago, gbcTfMetodoPago);

        JLabel lblCategoria = new JLabel("CATEGORÍA:");
        lblCategoria.setForeground(Color.white);
        GridBagConstraints gbcLblCategoria = new GridBagConstraints();
        gbcLblCategoria.gridx = 3;
        gbcLblCategoria.gridy = 6;
        gbcLblCategoria.anchor = GridBagConstraints.WEST;
        gbcLblCategoria.insets = new Insets(5, 10, 5, 10);
        add(lblCategoria, gbcLblCategoria);

        rbCategoria = new JRadioButton();
        rbCategoria.setForeground(Color.white);
        rbCategoria.setBackground(new Color(0xB2838B));
        rbCategoria.addActionListener(this);
        GridBagConstraints gbcRbCategoria = new GridBagConstraints();
        gbcRbCategoria.gridx = 4;
        gbcRbCategoria.gridy = 6;
        gbcRbCategoria.anchor = GridBagConstraints.WEST;
        add(rbCategoria, gbcRbCategoria);

        tfCategoria = new JTextField(20);
        tfCategoria.setEnabled(false);
        tfCategoria.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                realizarConsulta();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se utiliza en este caso
            }
        });
        GridBagConstraints gbcTfCategoria = new GridBagConstraints();
        gbcTfCategoria.gridx = 5;
        gbcTfCategoria.gridy = 6;
        gbcTfCategoria.fill = GridBagConstraints.HORIZONTAL;
        gbcTfCategoria.weightx = 1.0;
        gbcTfCategoria.insets = new Insets(5, 10, 5, 10);
        add(tfCategoria, gbcTfCategoria);

        // Agregar los botones de radio al ButtonGroup
        ButtonGroup bgBusqueda = new ButtonGroup();
        bgBusqueda.add(rbNombre);
        bgBusqueda.add(rbApellidoPaterno);
        bgBusqueda.add(rbCalle);
        bgBusqueda.add(rbNumero);
        bgBusqueda.add(rbColonia);
        bgBusqueda.add(rbCodigoPostal);
        bgBusqueda.add(rbMunicipio);
        bgBusqueda.add(rbEstado);
        bgBusqueda.add(rbPais);
        bgBusqueda.add(rbFecha);
        bgBusqueda.add(rbMetodoPago);
        bgBusqueda.add(rbCategoria);

        // Panel de botones en la parte inferior de la ventana (centrados)
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.setBackground(new Color(0xB2838B));


        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(this);
        panelBotones.add(btnLimpiar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        panelBotones.add(btnCancelar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(this);
        panelBotones.add(btnActualizar);

        GridBagConstraints gbcBotones = new GridBagConstraints();
        gbcBotones.gridx = 0;
        gbcBotones.gridy = 7;
        gbcBotones.gridwidth = 6;
        gbcBotones.fill = GridBagConstraints.HORIZONTAL;
        gbcBotones.insets = new Insets(10, 10, 10, 10);
        add(panelBotones, gbcBotones);

        // Tabla para mostrar los registros
        String[] columnNames = {"ID", "Nombre", "Apellido Paterno", "Calle", "Número", "Colonia", "Código Postal", "Municipio", "Estado", "País", "Fecha", "Método de Pago", "Categoría"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        GridBagConstraints gbcTabla = new GridBagConstraints();
        gbcTabla.gridx = 0;
        gbcTabla.gridy = 8;
        gbcTabla.gridwidth = 6;
        gbcTabla.fill = GridBagConstraints.BOTH;
        gbcTabla.weightx = 1.0;
        gbcTabla.weighty = 1.0;
        gbcTabla.insets = new Insets(10, 10, 10, 10);
        add(scrollPane, gbcTabla);

        // Cargar los registros en la tabla utilizando hilos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                cargarRegistrosTabla();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLimpiar) {
            limpiarCampos();
        } else if (e.getSource() == btnCancelar) {
            regresarAlMenu();
        } else if (e.getSource() == btnActualizar) {

            // Iniciar el hilo al presionar el botón "Actualizar"
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    actualizarTabla();
                }
            });
            thread.start();
        } else if (e.getSource() == rbNombre) {
            habilitarCajaTexto(tfNombre);
            tfNombre.requestFocus();
        } else if (e.getSource() == rbApellidoPaterno) {
            habilitarCajaTexto(tfApellidoPaterno);
            tfApellidoPaterno.requestFocus();
        } else if (e.getSource() == rbCalle) {
            habilitarCajaTexto(tfCalle);
            tfCalle.requestFocus();
        } else if (e.getSource() == rbNumero) {
            habilitarCajaTexto(tfNumero);
            tfNumero.requestFocus();
        } else if (e.getSource() == rbColonia) {
            habilitarCajaTexto(tfColonia);
            tfColonia.requestFocus();
        } else if (e.getSource() == rbCodigoPostal) {
            habilitarCajaTexto(tfCodigoPostal);
            tfCodigoPostal.requestFocus();
        } else if (e.getSource() == rbMunicipio) {
            habilitarCajaTexto(tfMunicipio);
            tfMunicipio.requestFocus();
        } else if (e.getSource() == rbEstado) {
            habilitarCajaTexto(tfEstado);
            tfEstado.requestFocus();
        } else if (e.getSource() == rbPais) {
            habilitarCajaTexto(tfPais);
            tfPais.requestFocus();
        } else if (e.getSource() == rbFecha) {
            habilitarCajaTexto(tfFecha);
            tfFecha.requestFocus();
        } else if (e.getSource() == rbMetodoPago) {
            habilitarCajaTexto(tfMetodoPago);
            tfMetodoPago.requestFocus();
        } else if (e.getSource() == rbCategoria) {
            habilitarCajaTexto(tfCategoria);
            tfCategoria.requestFocus();
        }
    }

    private void habilitarCajaTexto(JTextField textField) {
        tfNombre.setEnabled(false);
        tfApellidoPaterno.setEnabled(false);
        tfCalle.setEnabled(false);
        tfNumero.setEnabled(false);
        tfColonia.setEnabled(false);
        tfCodigoPostal.setEnabled(false);
        tfMunicipio.setEnabled(false);
        tfEstado.setEnabled(false);
        tfPais.setEnabled(false);
        tfFecha.setEnabled(false);
        tfMetodoPago.setEnabled(false);
        tfCategoria.setEnabled(false);

        textField.setEnabled(true);

        textField.requestFocus();
    }

    private void realizarConsulta() {
        String campoBusqueda = "";
        String valorBusqueda = "";
        if (tfNombre.isEnabled()) {
            campoBusqueda = "nombre";
            valorBusqueda = tfNombre.getText();
        } else if (tfApellidoPaterno.isEnabled()) {
            campoBusqueda = "apellido_paterno";
            valorBusqueda = tfApellidoPaterno.getText();
        } else if (tfCalle.isEnabled()) {
            campoBusqueda = "calle";
            valorBusqueda = tfCalle.getText();
        } else if (tfNumero.isEnabled()) {
            campoBusqueda = "numero";
            valorBusqueda = tfNumero.getText();
        } else if (tfColonia.isEnabled()) {
            campoBusqueda = "colonia";
            valorBusqueda = tfColonia.getText();
        } else if (tfCodigoPostal.isEnabled()) {
            campoBusqueda = "codigo_postal";
            valorBusqueda = tfCodigoPostal.getText();
        } else if (tfMunicipio.isEnabled()) {
            campoBusqueda = "municipio";
            valorBusqueda = tfMunicipio.getText();
        } else if (tfEstado.isEnabled()) {
            campoBusqueda = "estado";
            valorBusqueda = tfEstado.getText();
        } else if (tfPais.isEnabled()) {
            campoBusqueda = "pais";
            valorBusqueda = tfPais.getText();
        } else if (tfFecha.isEnabled()) {
            campoBusqueda = "fecha";
            valorBusqueda = tfFecha.getText();
            // Verificar el formato de fecha o valor ingresado
            if (valorBusqueda.matches("\\d{2}/\\d{2}/\\d{4}")) {
                // Formato de fecha completo: dd/mm/yyyy
                String[] fechaPartes = valorBusqueda.split("/");
                String dia = fechaPartes[0];
                String mes = fechaPartes[1];
                String anio = fechaPartes[2];
                valorBusqueda = anio + "-" + mes + "-" + dia;
            } else if (valorBusqueda.matches("\\d+")) {
                // Se ingresó uno o más números
                int valor = Integer.parseInt(valorBusqueda);
                if (valor > 31) {
                    // Se asume que es un año
                    valorBusqueda = valorBusqueda + "%";
                } else if (valor > 12) {
                    // Se asume que es un día
                    valorBusqueda = "%-" + valorBusqueda + "-%";
                } else {
                    // Se asume que es un mes
                    valorBusqueda = "%-" + valorBusqueda + "%";
                }
            } else {
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Utiliza el formato dd/mm/yyyy o ingresa solo el día, mes o año.");
                return;
            }
        } else if (tfMetodoPago.isEnabled()) {
            campoBusqueda = "metodo_pago";
            valorBusqueda = tfMetodoPago.getText();
        } else if (tfCategoria.isEnabled()) {
            campoBusqueda = "categoria";
            valorBusqueda = tfCategoria.getText();
        }

        try {
            Connection conexion = ConexionBD.getInstance().getConnection();
            String query = "SELECT * FROM Alumnos WHERE " + campoBusqueda + " LIKE ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, "%" + valorBusqueda + "%");
            ResultSet resultSet = statement.executeQuery();

            tableModel.setRowCount(0);

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
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaStr = dateFormat.format(fecha);
                String metodoPago = resultSet.getString("metodo_pago");
                String categoria = resultSet.getString("categoria");
                Object[] fila = {id, nombre, apellidoPaterno, calle, numero, colonia, codigoPostal, municipio, estado, pais, fechaStr, metodoPago, categoria};
                tableModel.addRow(fila);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al realizar la consulta.");
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
        tfMetodoPago.setText("");
        tfCategoria.setText("");

        rbNombre.setSelected(true);
        habilitarCajaTexto(tfNombre);
    }

    private void regresarAlMenu() {
        VentanaInicio ventanaInicio = (VentanaInicio) getDesktopPane().getParent().getParent().getParent().getParent();
        ventanaInicio.remove(this);
        dispose();
    }

    private void actualizarTabla() {
        cargarRegistrosTabla();
    }

    // Código del hilo
    private void cargarRegistrosTabla() {
        try {
            Connection conexion = ConexionBD.getInstance().getConnection();
            String query = "SELECT * FROM Alumnos";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            final DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nombre", "Apellido Paterno", "Calle", "Número", "Colonia", "Código Postal", "Municipio", "Estado", "País", "Fecha", "Método de Pago", "Categoría"});

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
                String fechaStr = new SimpleDateFormat("yyyy-MM-dd").format(fecha);
                String metodoPago = resultSet.getString("metodo_pago");
                String categoria = resultSet.getString("categoria");
                Object[] fila = {id, nombre, apellidoPaterno, calle, numero, colonia, codigoPostal, municipio, estado, pais, fechaStr, metodoPago, categoria};
                model.addRow(fila);
            }

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    tableModel.setRowCount(0);
                    for (int i = 0; i < model.getRowCount(); i++) {
                        tableModel.addRow(model.getDataVector().get(i));
                    }
                }
            });
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Consultas.this, "Error al cargar los registros en la tabla.");
        }
    }
}
