package instadam;

import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.*;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CreacionCuenta extends JFrame {

	private JTextField nombre;
	private JTextField primerApellido;
	private JTextField segundoApellido;
	private JTextField edad;
	private JTextField nombreUsuario;
	private JPasswordField contraseña;
	private JTextField genero;
	private JButton botonIntroducirDatos;
	private JTextArea resultadoArea;
	static ArrayList<Usuarios> misUsuarios = new ArrayList<>();
	private static HashMap <String, Integer> usuariosSeguidores = new HashMap <>();
	public CreacionCuenta() {

		setBounds(100, 100, 600, 400);
		setVisible(true);
		setLayout(new GridLayout(8, 2, 10, 10));

		JLabel indicacion_nombre = new JLabel("Nombre:");
		nombre = new JTextField(20);
		add(indicacion_nombre);
		add(nombre);

		JLabel indicacion_primer_apellido = new JLabel("Primer Apellido:");
		primerApellido = new JTextField(20);
		add(indicacion_primer_apellido);
		add(primerApellido);

		JLabel indicacion_segundo_apellido = new JLabel("Segundo Apellido:");
		segundoApellido = new JTextField(20);
		add(indicacion_segundo_apellido);
		add(segundoApellido);

		JLabel indicacion_edad = new JLabel("Edad:");
		edad = new JTextField(10);
		add(indicacion_edad);
		add(edad);

		JLabel indicacion_nombre_usuario = new JLabel("Usuario:");
		nombreUsuario = new JTextField(15);
		add(indicacion_nombre_usuario);
		add(nombreUsuario);

		JLabel indicacion_contraseña = new JLabel("Contraseña:");
		contraseña = new JPasswordField();
		add(indicacion_contraseña);
		add(contraseña);

		JLabel indicacion_genero = new JLabel("Género (Hombre o Mujer):");
		genero = new JTextField(15);
		add(indicacion_genero);
		add(genero);

		resultadoArea = new JTextArea(5, 20);
		resultadoArea.setEditable(false);
		add(resultadoArea);

		botonIntroducirDatos = new JButton("Confirmar");
		add(botonIntroducirDatos);


		botonIntroducirDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				creacionCuenta();
			}
		});

		nombre.getDocument().addDocumentListener(new FieldListener());
		primerApellido.getDocument().addDocumentListener(new FieldListener());
		segundoApellido.getDocument().addDocumentListener(new FieldListener());
		edad.getDocument().addDocumentListener(new FieldListener());
		nombreUsuario.getDocument().addDocumentListener(new FieldListener());
		contraseña.getDocument().addDocumentListener(new FieldListener());
		genero.getDocument().addDocumentListener(new FieldListener());
	}

	private boolean camposCompletos() {
		return !nombre.getText().isEmpty() && !primerApellido.getText().isEmpty()
				&& !segundoApellido.getText().isEmpty() && !edad.getText().isEmpty()
				&& !nombreUsuario.getText().isEmpty() && !contraseña.getText().isEmpty() && !genero.getText().isEmpty();
	}

	private boolean HombreOMujer() {

		String hombre = "hombre";
		String mujer = "Mujer";
		return hombre.equalsIgnoreCase(genero.getText()) || mujer.equalsIgnoreCase(genero.getText());
	}
	private boolean nombreUsuarioRepetido() {
		String nombreRepetido = nombreUsuario.getText();
		boolean marca = true;
		for(Usuarios usuarios:misUsuarios) {
			if(nombreRepetido.equalsIgnoreCase(usuarios.getNombre_Usuario())) {
				marca = false;
			}
		}
		return marca;
	}

	private void creacionCuenta() {
		if (camposCompletos()&&HombreOMujer()&&nombreUsuarioRepetido()) {

			String nombreText = nombre.getText();
			String primerApellidoText = primerApellido.getText();
			String segundoApellidoText = segundoApellido.getText();
			int edadNum;
			try {
				edadNum = Integer.parseInt(edad.getText());
			} catch (NumberFormatException e) {
				resultadoArea.setText("Edad no válida.");
				return;
			}
			String nombreUsuarioText = nombreUsuario.getText();
			String contraseñaText = contraseña.getText();
			String generoText = genero.getText();


			resultadoArea.setText("Cuenta creada con éxito.");
			misUsuarios.add(new Usuarios(nombreUsuarioText, contraseñaText));
			usuariosSeguidores.put(nombreUsuarioText, 0);

			nombre.setText("");
			primerApellido.setText("");
			segundoApellido.setText("");
			edad.setText("");
			nombreUsuario.setText("");
			contraseña.setText("");
			genero.setText("");

		} else {
			// Si algún campo está vacío, mostrar un mensaje de error
			resultadoArea.setText("Por favor, llene todos los campos o corrija el incorrecto. Recuerde que no puede habewr 2 usuarios con el mismo nomnre");
		}
	}

	// Clase interna para verificar campos al cambiar su contenido
	private class FieldListener implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			actualizarEstadoBoton();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			actualizarEstadoBoton();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			actualizarEstadoBoton();
		}

		private void actualizarEstadoBoton() {
			botonIntroducirDatos.setEnabled(camposCompletos());
		}

	}

	public static ArrayList<Usuarios> getMisUsuarios() {
		return misUsuarios;
	}

	public static HashMap<String, Integer> getUsuariosSeguidores() {
		return usuariosSeguidores;
	}

	 public static void modificarValor(String clave, Integer nuevoValor) {
		 usuariosSeguidores.put(clave, nuevoValor);
	    }


}
