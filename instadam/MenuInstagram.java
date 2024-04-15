
package instadam;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MenuInstagram extends JFrame {
    private JButton crearCuenta;
    private JButton iniciarSesion;
    private JButton continuarSinInicioDeSesion;

    public MenuInstagram(){
        super("INSTADAM");
        setBounds(800,800,800,800);
        setVisible(true);
        setLayout(new GridLayout(8, 2, 10, 10));
        crearCuenta = new JButton("Crear cuenta");
        iniciarSesion = new JButton("Iniciar sesión");
        continuarSinInicioDeSesion = new JButton("Ver publicaciones de instagraneros");

        crearCuenta.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               new CreacionCuenta();
            }

        });
        add(crearCuenta);

        iniciarSesion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                new IniciarSesion();
            }

        });
        add(iniciarSesion);

        continuarSinInicioDeSesion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
             new VerTodasLasPublicacionesSinInicioSesion();
            }

        });

        add(continuarSinInicioDeSesion);

    }



}