
package instadam;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


	public class Usuarios extends JFrame{

	    private String nombre_Usuario;
	    private String contraseña;
	    private JLabel mostrarUsuario;
	    public Usuarios(){

	    }

	    public Usuarios(String nombre_Usuario, String contraseña) {
	        this.nombre_Usuario = nombre_Usuario;
	        this.contraseña = contraseña;
	        setBounds(800,800,800,800);
	        setVisible(true);
	        setLayout(new GridLayout(8, 2, 10, 10));
	        mostrarUsuario = new JLabel(IniciarSesion.getUsuario_actual());
	        mostrarUsuario.setLocation(0, 0);
	        new PublicacionesParaCrear();

	    }



	    public String getNombre_Usuario() {
	        return nombre_Usuario;
	    }

	    public void setNombre_Usuario(String nombre_Usuario) {
	        this.nombre_Usuario = nombre_Usuario;
	    }

	    public String getContraseña() {
	        return contraseña;
	    }

	    public void setContraseña(String contraseña) {
	        this.contraseña = contraseña;
	    }



	}

