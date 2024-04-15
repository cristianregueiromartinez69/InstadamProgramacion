
package instadam;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MenuPublicaciones extends JFrame {

	private JButton verMisPublicaciones;
	private JButton crearNuevaPublicacion;
	private JButton editarPublicacionExistente;
	private JButton seguirOtrosUsuarios;
	private JButton cerrarSesion;
	private JLabel usuario_actual;

	public MenuPublicaciones() {
		super("MENU DE LAS PUBLICACIONES");
		setLayout(new GridLayout(8, 2, 10, 10));
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(800,800,800,800);
		verMisPublicaciones = new JButton("Ver mis publicaciones");
		crearNuevaPublicacion = new JButton("Crear una nueva publicacion");
		editarPublicacionExistente = new JButton("editar mis publicaciones");
		cerrarSesion = new JButton("Cerrar sesion");
		seguirOtrosUsuarios = new JButton("Buscar usuarios para seguir");
		String auxUsuario_actual = IniciarSesion.getUsuario_actual();
		usuario_actual= new JLabel("Usuario: " + auxUsuario_actual);
		add(usuario_actual);
				verMisPublicaciones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VerMisPublicaciones();

			}

		});
		add(verMisPublicaciones);
		crearNuevaPublicacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PublicacionesParaCrear();

			}

		});
		add(crearNuevaPublicacion);
		editarPublicacionExistente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new MenuEdicionOBorradoPublicacion();
			}

		});
		add(editarPublicacionExistente);
		cerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				IniciarSesion.setUsuario_actual(null);
				dispose();

			}

		});
		add(cerrarSesion);
		seguirOtrosUsuarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new SeguirUsuarios();
			}

		});
		add(seguirOtrosUsuarios);
	}


}
