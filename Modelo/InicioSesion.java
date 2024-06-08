package Modelo;

import ConexionBD.ConexionBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InicioSesion extends JInternalFrame implements ActionListener {
    private JDesktopPane desktopPane;
    private JTextField tfUsuario;
    private JPasswordField tfContrasena;

    public InicioSesion() {
        desktopPane = new JDesktopPane();
        getContentPane().setLayout(new GridBagLayout());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("INICIO SESIÓN");
        setSize(400, 200);
        setClosable(true);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#7E2714"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblTitulo = new JLabel("INICIO SESIÓN");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(lblTitulo, gbc);

        JLabel lblUsuario = new JLabel("USUARIO: ");
        lblUsuario.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(lblUsuario, gbc);

        tfUsuario = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(tfUsuario, gbc);

        JLabel lblContrasena = new JLabel("CONTRASEÑA: ");
        lblContrasena.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(lblContrasena, gbc);

        tfContrasena = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(tfContrasena, gbc);

        JButton btnIniciarSesion = new JButton("INICIAR SESIÓN");
        btnIniciarSesion.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnIniciarSesion, gbc);

        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.addActionListener(e -> {
            setVisible(false);
            dispose();
        });
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnCancelar, gbc);

        desktopPane.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario = tfUsuario.getText();
        String contrasena = new String(tfContrasena.getPassword());

        // Guardar los datos en la base de datos
        try {
            Connection conexion = ConexionBD.getInstance().getConnection();
            String query = "INSERT INTO Usuarios (usuario, contrasena) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, usuario);
            statement.setString(2, contrasena);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.");
            setVisible(false);
            dispose();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los datos en la base de datos.");
        }
    }
}