
package instadam;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VerMisPublicaciones extends JFrame{
    private JComboBox<String> combopublis;
	private JTextArea informacionPublicaciones;
	PublicacionesParaCrear vermispublis = new PublicacionesParaCrear();
	private JLabel mostrarNombre;
	private JButton menuDeMisPublicaciones;
	private static JLabel IndicadornumeroDeSeguidores;
	private static JLabel infoNumeroSeguidores;
	private static int seguidores;

	public VerMisPublicaciones() {
		super("PUBLICACIONES");
		setLayout(new GridLayout(8, 2, 10, 10));
		setVisible(true);
		setBounds(800,800,800,800);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		DefaultComboBoxModel<String> localizaciones = new DefaultComboBoxModel<>();
		informacionPublicaciones = new JTextArea();
		add(new JScrollPane(informacionPublicaciones));
		menuDeMisPublicaciones = new JButton("Ir al menu de publicaciones");
		menuDeMisPublicaciones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}

		});
		add(menuDeMisPublicaciones);
		for(String misPublis:vermispublis.getMisPublicaciones().keySet()) {
		if(vermispublis.getMisPublicaciones().isEmpty()) {

			informacionPublicaciones.setText("No hay publicaciones todavía");

		}
		else {
			localizaciones.addElement(misPublis);

		}

		}
		combopublis = new JComboBox<>(localizaciones);
		mostrarNombre = new JLabel("Usuario: " + IniciarSesion.getUsuario_actual());
		add(mostrarNombre);
		combopublis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				informacionDeMisPublicaciones();

			}

		});
		add(combopublis);
		IndicadornumeroDeSeguidores = new JLabel("Seguidores");
		add(IndicadornumeroDeSeguidores);

		infoNumeroSeguidores = new JLabel(""); // Inicialmente vacío
		add(infoNumeroSeguidores);

		actualizarSeguidores(); // Actualizar el número de seguidores al iniciar la ventana
	}


	public void informacionDeMisPublicaciones() {
		 informacionPublicaciones.setText("");
		 String tituloSeleccionado = (String) combopublis.getSelectedItem();
		 String descripcion = vermispublis.getMisPublicaciones().get(tituloSeleccionado);
		setBounds(500,500,500,500);
		setVisible(true);
		informacionPublicaciones.append("\nTítulo: " + tituloSeleccionado + "\nDescripción: " + descripcion + "\n");
	}

	public static JLabel getIndicadornumeroDeSeguidores() {
		return IndicadornumeroDeSeguidores;
	}

	public static void setIndicadornumeroDeSeguidores(JLabel indicadornumeroDeSeguidores) {
		IndicadornumeroDeSeguidores = indicadornumeroDeSeguidores;
	}

	public static JLabel getInfoNumeroSeguidores() {
		return infoNumeroSeguidores;
	}

	public static void setInfoNumeroSeguidores(JLabel infoNumeroSeguidores) {
		VerMisPublicaciones.infoNumeroSeguidores = infoNumeroSeguidores;
	}

	public static int getSeguidores() {
		return seguidores;
	}

	public static void setSeguidores(int seguidores) {
		VerMisPublicaciones.seguidores = seguidores;
	}

	// Método para actualizar el número de seguidores y su visualización
	private void actualizarSeguidores() {
		String aux_usuario_actual = IniciarSesion.getUsuario_actual();
		for (Map.Entry<String, Integer> entry : CreacionCuenta.getUsuariosSeguidores().entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue() != null ? entry.getValue() : 0;

			if (key.equals(aux_usuario_actual)) {
				seguidores = value;
				infoNumeroSeguidores.setText("Seguidores: " + seguidores);
			}
		}
	}

}
