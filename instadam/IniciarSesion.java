
package instadam;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.*;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class IniciarSesion extends JFrame {

	private JLabel mostrarUsuario;
	private JTextField usuario;
	private JLabel mostrarContraseña;
	private JPasswordField contraseña;
	private JTextArea confirmarInicio;
	private JButton iniciarSesion;
	private static String usuario_actual;

	public IniciarSesion() {

		setBounds(800, 800, 800, 800);
		setLayout(new GridLayout(8, 2, 10, 10));
		setVisible(true);
		mostrarUsuario = new JLabel("Usuario");
		add(mostrarUsuario);
		usuario = new JTextField(10);
		add(usuario);
		mostrarContraseña = new JLabel("contraseña");
		add(mostrarContraseña);
		contraseña = new JPasswordField();
		add(contraseña);
		confirmarInicio = new JTextArea();
		confirmarInicio.setEditable(false);
		add(confirmarInicio);
		iniciarSesion = new JButton("confirmar");
		iniciarSesion = new JButton("Confirmar");
		iniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				InicioSesion();
			}

		});

		add(iniciarSesion);

	}

	private boolean camposCompletos() {
		return !contraseña.getText().isEmpty() && !usuario.getText().isEmpty();
	}

	public void InicioSesion() {

		if (camposCompletos()) {

			String aux_usuario = usuario.getText();
			String aux_contraseña = contraseña.getText();
			for (Usuarios u : CreacionCuenta.misUsuarios) {
				if (u.getNombre_Usuario().equals(aux_usuario) && u.getContraseña().equals(aux_contraseña)) {

					usuario_actual = aux_usuario;
					confirmarInicio.setText("Sesion iniciada correctamente");
					new MenuPublicaciones();


				}

			}

		} else {
			confirmarInicio.setText("No existe usuario o contraseña o han sido escritos incorrectamente");
		}
	}

	public static String getUsuario_actual() {
		return usuario_actual;
	}

	public static void setUsuario_actual(String usuario_actual) {
		IniciarSesion.usuario_actual = usuario_actual;
	}

}
