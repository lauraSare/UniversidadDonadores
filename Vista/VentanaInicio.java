package Vista;

import Modelo.InicioSesion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaInicio extends JFrame implements ActionListener {
    private static VentanaInicio instancia;
    public boolean sesionIniciada;
    private JDesktopPane desktopPane;
    private JMenuItem menuInicioSesion;
    private JMenuItem menuAltas;
    private JMenuItem menuBajas;


    public VentanaInicio() {
        sesionIniciada = false; // Inicializar la variable sesionIniciada como falsa

        // Configuración de la ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sesionIniciada = false; // Restablecer sesionIniciada a false al cerrar la ventana principal
            }
        });
        setTitle("UNIVERSIDAD");
        setSize(800, 800);
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
        Image imagenRedimensionadaLogin = imagenLogin.getScaledInstance(iconoMenu.getIconWidth(), iconoMenu.getIconHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoLoginRedimensionado = new ImageIcon(imagenRedimensionadaLogin);
        menuInicioSesion.setIcon(iconoLoginRedimensionado);

        menuInicioSesion.setFont(new Font("Arial", Font.PLAIN, 14)); // Establecer fuente y tamaño para el JMenuItem
        menuInicioSesion.addActionListener(this);
        menuArchivo.add(menuInicioSesion);

        menuAltas = new JMenuItem("Altas");

        // Redimensionar la imagen de "add.png" al mismo tamaño que la imagen de "menusito.png"
        ImageIcon iconoAdd = new ImageIcon("./imagenes/add.png");
        Image imagenAdd = iconoAdd.getImage();
        Image imagenRedimensionadaAdd = imagenAdd.getScaledInstance(iconoMenu.getIconWidth(), iconoMenu.getIconHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoAddRedimensionado = new ImageIcon(imagenRedimensionadaAdd);
        menuAltas.setIcon(iconoAddRedimensionado);

        menuAltas.setFont(new Font("Arial", Font.PLAIN, 14)); // Establecer fuente y tamaño para el JMenuItem
        menuAltas.addActionListener(this);
        menuArchivo.add(menuAltas);

        menuBajas = new JMenuItem("Bajas");

        // Redimensionar la imagen de "delete.png" al mismo tamaño que la imagen de "menusito.png"
        ImageIcon iconoDelete = new ImageIcon("./imagenes/remove.png");
        Image imagenDelete = iconoDelete.getImage();
        Image imagenRedimensionadaDelete = imagenDelete.getScaledInstance(iconoMenu.getIconWidth(), iconoMenu.getIconHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoDeleteRedimensionado = new ImageIcon(imagenRedimensionadaDelete);
        menuBajas.setIcon(iconoDeleteRedimensionado);

        menuBajas.setFont(new Font("Arial", Font.PLAIN, 14)); // Establecer fuente y tamaño para el JMenuItem
        menuBajas.addActionListener(this);
        menuArchivo.add(menuBajas);

        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);
    }

    public static VentanaInicio getInstancia() {
        if (instancia == null) {
            instancia = new VentanaInicio();
        }
        return instancia;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuInicioSesion) {
            if (!sesionIniciada) {
                InicioSesion inicioSesion = new InicioSesion();
                desktopPane.add(inicioSesion);
                inicioSesion.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Ya ha iniciado sesión.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == menuAltas) {
            if (sesionIniciada) {
                Altas altas = new Altas();
                desktopPane.add(altas);
                altas.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Debe iniciar sesión primero.", "Acceso denegado", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == menuBajas) { // Acción para la opción de bajas
            if (sesionIniciada) {
                Bajas bajas = new Bajas();
                desktopPane.add(bajas);
                bajas.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Debe iniciar sesión primero.", "Acceso denegado", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaInicio ventanaInicio = VentanaInicio.getInstancia();
            ventanaInicio.setVisible(true);
        });
    }
}