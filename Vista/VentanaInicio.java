package Vista;

import Modelo.InicioSesion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame implements ActionListener {
    private JDesktopPane desktopPane;
    private JMenuItem menuInicioSesion;

    public VentanaInicio() {
        // Configuración de la ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("UNIVERSIDAD");
        setSize(600, 600);
        setLayout(new BorderLayout());

        // Crear el JDesktopPane
        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);

        // Crear el menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Menú");
        ImageIcon iconoMenu = new ImageIcon("./imagenes/menusito.png");
        menuArchivo.setIcon(iconoMenu);
        menuArchivo.setFont(new Font("Arial", Font.BOLD, 16)); // Establecer fuente y tamaño para el JMenu
        menuInicioSesion = new JMenuItem("Inicio Sesión");

// Redimensionar la imagen de "login.png" al mismo tamaño que la imagen de "menusito.png"
        ImageIcon iconoLogin = new ImageIcon("./imagenes/login.png");
        Image imagenLogin = iconoLogin.getImage();
        Image imagenRedimensionada = imagenLogin.getScaledInstance(iconoMenu.getIconWidth(), iconoMenu.getIconHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoLoginRedimensionado = new ImageIcon(imagenRedimensionada);
        menuInicioSesion.setIcon(iconoLoginRedimensionado);

        menuInicioSesion.setFont(new Font("Arial", Font.PLAIN, 14)); // Establecer fuente y tamaño para el JMenuItem
        menuInicioSesion.addActionListener(this);
        menuArchivo.add(menuInicioSesion);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuInicioSesion) {
            InicioSesion inicioSesion = new InicioSesion();
            desktopPane.add(inicioSesion);
            inicioSesion.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaInicio ventanaInicio = new VentanaInicio();
            ventanaInicio.setVisible(true);
        });
    }
}