
package instadam;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.*;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PublicacionesParaEditar extends JFrame {

	private JLabel indicador_nuevo_texto_publicacion;
	private JTextField nuevo_titulo_publicacion;
	private JLabel indicador_nueva_descripcion_publicacion;
	private JTextField nueva_descripcion_publicacion;
	private JTextArea area_confirmar_edicion;
	private JButton boton_confirmar_edicion;
	private JLabel indicador_titulo_a_buscar;
	private JTextField titulo_a_buscar;
	private JButton menuDeMisPublicaciones;
	PublicacionesParaCrear mispublis = new PublicacionesParaCrear();
	public PublicacionesParaEditar() {
		super("EDICION DE PUBLICACIONES");
		setLayout(new GridLayout(8, 2, 10, 10));
		setVisible(true);
		setBounds(800,800,800,800);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		indicador_titulo_a_buscar = new JLabel("Introduce el título a buscar");
		add(indicador_titulo_a_buscar);
		titulo_a_buscar = new JTextField(13);
		add(titulo_a_buscar);
		indicador_nuevo_texto_publicacion = new JLabel("Nuevo titulo");
		add(indicador_nuevo_texto_publicacion);
		nuevo_titulo_publicacion = new JTextField(14);
		add(nuevo_titulo_publicacion);
		indicador_nueva_descripcion_publicacion = new JLabel("Nueva descripcion");
		add(indicador_nueva_descripcion_publicacion);
		nueva_descripcion_publicacion = new JTextField(13);
		add(nueva_descripcion_publicacion);
		area_confirmar_edicion = new JTextArea();
		area_confirmar_edicion.setEditable(false);
		add(area_confirmar_edicion);
		boton_confirmar_edicion = new JButton("Confirmar");
		if (mispublis.getMisPublicaciones().isEmpty()) {
			String noHayNada = "No hay publicaciones todavía";
			area_confirmar_edicion.setText(noHayNada);
		}
		boton_confirmar_edicion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editarPublicacion();

			}

		});

		add(boton_confirmar_edicion);
		menuDeMisPublicaciones = new JButton("Ir al menu de publicaciones");
		menuDeMisPublicaciones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}

		});
		add(menuDeMisPublicaciones);
	}

	public void editarPublicacion() {
	    String buscador_titulo = titulo_a_buscar.getText();
	    Iterator<Map.Entry<String, String>> iter = mispublis.getMisPublicaciones().entrySet().iterator();
	    boolean encontrado = false;

	    while (iter.hasNext()) {
	        Map.Entry<String, String> entry = iter.next();
	        String clave = entry.getKey();

	        if (clave.equalsIgnoreCase(buscador_titulo)) {
	            iter.remove(); // Eliminar el elemento usando el iterador
	            String nuevo_titulo = nuevo_titulo_publicacion.getText();
	            String nueva_descripcion = nueva_descripcion_publicacion.getText();
	            mispublis.getMisPublicaciones().put(nuevo_titulo, nueva_descripcion);
	            area_confirmar_edicion.setText("Publicacion editada correctamente");
	            encontrado = true;
	            Timer timer = new Timer(5000, new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    dispose();
	                }
	            });
	            break; // Salir del bucle una vez que se haya encontrado y editado la publicación
	        }
	    }

	    if (!encontrado) {
	        area_confirmar_edicion.setText("Ningún nombre coincide con el titulo de las publicaciones");
	    }
	}

	}