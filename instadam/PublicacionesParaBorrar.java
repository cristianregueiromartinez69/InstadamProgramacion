
package instadam;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PublicacionesParaBorrar extends JFrame{
	private JLabel indicador_introducir_texto_publicacion;
	private JTextField introducir_borrado_titulo_publicacion;
	private JTextArea area_confirmar_borrado;
	private JButton boton_confirmar_borrado;
	private JButton menuDeMisPublicaciones;
	 PublicacionesParaCrear mispublis = new PublicacionesParaCrear();
	public PublicacionesParaBorrar() {
		super("BORRADO DE PUBLICACIONES");
		setLayout(new GridLayout(8, 2, 10, 10));
		setVisible(true);
		setBounds(800,800,800,800);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		indicador_introducir_texto_publicacion = new JLabel("Titulo a buscar para borrar");
		add(indicador_introducir_texto_publicacion);
		introducir_borrado_titulo_publicacion = new JTextField(14);
		add(introducir_borrado_titulo_publicacion);
		area_confirmar_borrado = new JTextArea();
		area_confirmar_borrado.setEditable(false);
		add(area_confirmar_borrado);
		boton_confirmar_borrado = new JButton("Confirmar");
		if (mispublis.getMisPublicaciones().isEmpty()) {
			String noHayNada = "No hay publicaciones todavía";
			area_confirmar_borrado.setText(noHayNada);
		}
		boton_confirmar_borrado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				borrarPublicacion();
			}

		});

		add(boton_confirmar_borrado);
		menuDeMisPublicaciones = new JButton("Ir al menu de publicaciones");
		menuDeMisPublicaciones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}

		});
		add(menuDeMisPublicaciones);

	}

	public void borrarPublicacion() {
	    String buscador_titulo = introducir_borrado_titulo_publicacion.getText();
	    Iterator<Map.Entry<String, String>> iter = mispublis.getMisPublicaciones().entrySet().iterator();
	    boolean encontrado = false;

	    while (iter.hasNext()) {
	        Map.Entry<String, String> entry = iter.next();
	        String clave = entry.getKey();

	        if (clave.equalsIgnoreCase(buscador_titulo)) {
	            iter.remove(); // Eliminar el elemento usando el iterador
	            area_confirmar_borrado.setText("Publicacion borrada correctamente");
	            encontrado = true;
	            Timer timer = new Timer(5000, new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    dispose();
	                }
	            });
	            break; // Salir del bucle una vez que se haya encontrado y borrado la publicación
	        }
	    }

	    if (!encontrado) {
	        area_confirmar_borrado.setText("Ningún nombre coincide con los titulos de las publicaciones");
	    }
	}

	}


