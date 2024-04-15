
package instadam;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;
import java.util.*;

public class PublicacionesParaCrear extends JFrame {

    private JButton crearPublicacion;
    private JLabel indicacion_texto_publicacion;
    private JTextField textoPublicacion;
    private JLabel indicacion_descripcion_publicacion;
    private JTextField descripcion_publicacion;
    private JTextArea confirmacionCreacionPublicacion;
    private static HashMap<String, String> misPublicaciones = new HashMap<>();
    private static HashMap<String, String> usuarioConPublicacion = new HashMap<>();
    private static ArrayList<String> usuarioPublicacionParaBien = new ArrayList<>();
    private JButton menuDeMisPublicaciones;

    public PublicacionesParaCrear() {

        super("MIS PUBLICACIONES");
        setLayout(new GridLayout(8, 2, 10, 10));
        setBounds(800, 800, 800, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        indicacion_texto_publicacion = new JLabel("publicar un mensaje");
        add(indicacion_texto_publicacion);
        textoPublicacion = new JTextField(13);
        add(textoPublicacion);
        indicacion_descripcion_publicacion = new JLabel("Descripcion del mensaje");
        add(indicacion_descripcion_publicacion);
        descripcion_publicacion = new JTextField(13);
        add(descripcion_publicacion);
        confirmacionCreacionPublicacion = new JTextArea();
        add(confirmacionCreacionPublicacion);
        crearPublicacion = new JButton("Confirmar publicacion");
        if (IniciarSesion.getUsuario_actual() == null) {
            dispose();
        }
        crearPublicacion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                CreacionDePublicacion();
            }

        });
        add(crearPublicacion);
        menuDeMisPublicaciones = new JButton("Ir al menu de publicaciones");
        menuDeMisPublicaciones.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }

        });
        add(menuDeMisPublicaciones);

    }

    private boolean campoCompletoCreacionCuenta() {
        return !textoPublicacion.getText().isEmpty() && !descripcion_publicacion.getText().isEmpty();
    }

    public void CreacionDePublicacion() {

        if (campoCompletoCreacionCuenta()) {

            String aux_texto_publicacion = textoPublicacion.getText();
            String aux_descripcion_publicacion = descripcion_publicacion.getText();
            misPublicaciones.put(aux_texto_publicacion, aux_descripcion_publicacion);
            String texto_para_usuario_con_publicacion = aux_texto_publicacion + aux_descripcion_publicacion;
            if (usuarioConPublicacion.isEmpty()) {
                usuarioConPublicacion.put(IniciarSesion.getUsuario_actual(), texto_para_usuario_con_publicacion);
            } else {
                usuarioConPublicacion.remove(IniciarSesion.getUsuario_actual());
                usuarioConPublicacion.put(IniciarSesion.getUsuario_actual(), texto_para_usuario_con_publicacion);
            }
            // Agregar cada parte de la publicación a la lista
            usuarioPublicacionParaBien.add("Usuario: " + IniciarSesion.getUsuario_actual());
            usuarioPublicacionParaBien.add("Titulo: " + aux_texto_publicacion);
            usuarioPublicacionParaBien.add("Descripción: " + aux_descripcion_publicacion);

            confirmacionCreacionPublicacion.setText("Publicacion creada correctamente");
            Timer timer = new Timer(5000, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();

                }

            });

        } else {
            confirmacionCreacionPublicacion.setText("Por favor, rellene los campos vacíos");
        }

    }

    public static HashMap<String, String> getMisPublicaciones() {
        return misPublicaciones;
    }

    public static void setMisPublicaciones(HashMap<String, String> misPublicaciones) {
        PublicacionesParaCrear.misPublicaciones = misPublicaciones;
    }

    public static HashMap<String, String> getUsuarioConPublicacion() {
        return usuarioConPublicacion;
    }

    public static void setUsuarioConPublicacion(HashMap<String, String> usuarioConPublicacion) {
        PublicacionesParaCrear.usuarioConPublicacion = usuarioConPublicacion;
    }

    public static ArrayList<String> getUsuarioPublicacionParaBien() {
        return usuarioPublicacionParaBien;
    }

    public static void setUsuarioPublicacionParaBien(ArrayList<String> usuarioPublicacionParaBien) {
        PublicacionesParaCrear.usuarioPublicacionParaBien = usuarioPublicacionParaBien;
    }

}
