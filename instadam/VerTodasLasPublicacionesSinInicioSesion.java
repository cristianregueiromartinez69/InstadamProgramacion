
package instadam;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VerTodasLasPublicacionesSinInicioSesion extends JFrame {

    private JButton listausuarios;
    private JTextArea informacionPublicacionesConUsuarios;
    private JButton menuInstagram;
    PublicacionesParaCrear vermispublisconusuario = new PublicacionesParaCrear();
    private JLabel indicador_filtrar_usuario;
    private JTextField campoACubrirFiltrar;
    private JButton filtrar;
    PublicacionesParaCrear publisparaversininiciarsesion = new PublicacionesParaCrear();

    public VerTodasLasPublicacionesSinInicioSesion() {

        super("Publicaciones de los panas");
        setLayout(new GridLayout(8, 2, 10, 10));
        setVisible(true);
        setBounds(800, 800, 800, 800);
        informacionPublicacionesConUsuarios = new JTextArea();
        indicador_filtrar_usuario = new JLabel("Escribe el nombre de un usuario para ver su última publicacion");
        add(indicador_filtrar_usuario);
        campoACubrirFiltrar = new JTextField(12);
        add(campoACubrirFiltrar);
        add(new JScrollPane(informacionPublicacionesConUsuarios));
        filtrar = new JButton("filtrar");
        add(filtrar);
        menuInstagram = new JButton("Menu de Instagram");
        menuInstagram.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }

        });
        add(menuInstagram);

        for (String usuariosConSusPublicaciones : vermispublisconusuario.getUsuarioConPublicacion().keySet()) {
            if (vermispublisconusuario.getUsuarioConPublicacion().isEmpty()) {
                informacionPublicacionesConUsuarios.setText("No hay publicaciones todavía");
            }
        }
        listausuarios = new JButton("Ver todas las publicaciones de usuarios");
        listausuarios.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                verListaUsuariosConPublicaciones();

            }

        });
        add(listausuarios);
        filtrar.addActionListener(this::filtrarPublicaciones);
    }

    public void filtrarPublicaciones(ActionEvent e) {
        if (e.getSource() == filtrar) {
            String aux_usuario_buscar = campoACubrirFiltrar.getText();
            HashMap<String, String> usuarioConPublicacion = PublicacionesParaCrear.getUsuarioConPublicacion();
            if (usuarioConPublicacion.containsKey(aux_usuario_buscar)) {
                String publicacion = usuarioConPublicacion.get(aux_usuario_buscar);
                informacionPublicacionesConUsuarios.setText(publicacion);
            } else {
                informacionPublicacionesConUsuarios.setText("Usuario no encontrado o sin publicaciones.");
            }
        }
    }




	public void verListaUsuariosConPublicaciones() {
	    informacionPublicacionesConUsuarios.setText("");



	    ArrayList<String> partesPublicacion = PublicacionesParaCrear.getUsuarioPublicacionParaBien();


	    for (String parte : partesPublicacion) {
	        informacionPublicacionesConUsuarios.append(parte + "\n");
	    }
	}

}
