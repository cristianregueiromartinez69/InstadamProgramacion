
package instadam;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MenuEdicionOBorradoPublicacion extends JFrame{

	private JButton botonEditarPublicacion;
	private JButton botonBorrarPublicacion;
	private JButton menuDeMisPublicaciones;

	public MenuEdicionOBorradoPublicacion() {
		super("EDICION DE PUBLICACIONES");
		setLayout(new GridLayout(8, 2, 10, 10));
		setVisible(true);
		setBounds(800,800,800,800);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		botonEditarPublicacion = new JButton("Editar publicacion");
		botonEditarPublicacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PublicacionesParaEditar();


			}

		});
		add(botonEditarPublicacion);
		botonBorrarPublicacion = new JButton("Borrar publicacion");
		botonBorrarPublicacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PublicacionesParaBorrar();

			}

		});
		add(botonBorrarPublicacion);
		menuDeMisPublicaciones = new JButton("Ir al menu de publicaciones");
		menuDeMisPublicaciones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}

		});
		add(menuDeMisPublicaciones);
	}
}

