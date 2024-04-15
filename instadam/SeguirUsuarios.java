
package instadam;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SeguirUsuarios extends JFrame {

    private JComboBox<String> listaUsuarios;
    private JButton seguir;
    private JButton dejarDeSeguir;
    private JButton menuPublicaciones;
    private JTextArea infoSeguimiento;

    public SeguirUsuarios() {

        super("SEGUIR A OTROS USUARIOS");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(8, 2, 10, 10));

        infoSeguimiento = new JTextArea();
        infoSeguimiento.setEditable(false);
        add(new JScrollPane(infoSeguimiento));

        listaUsuarios = new JComboBox<>(PublicacionesParaCrear.getUsuarioConPublicacion().keySet().toArray(new String[0]));
        add(listaUsuarios);

        seguir = new JButton("Seguir");
        dejarDeSeguir = new JButton("Dejar de seguir");
        add(seguir);
        add(dejarDeSeguir);

        menuPublicaciones = new JButton("Ir al menú de publicaciones");
        menuPublicaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(menuPublicaciones);

        seguir.addActionListener(this::actionPerformed);
        dejarDeSeguir.addActionListener(this::actionPerformed);
        listaUsuarios.addActionListener(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent e) {

        String usuarioSeguirODejardeSeguir = (String) listaUsuarios.getSelectedItem();
        String aux_usuario_actual = IniciarSesion.getUsuario_actual();

        for (Map.Entry<String, Integer> entry : CreacionCuenta.getUsuariosSeguidores().entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (key.equals(usuarioSeguirODejardeSeguir) && key.equals(aux_usuario_actual)) {

                if (e.getSource() == seguir) {
                    if (value == null) {
                        CreacionCuenta.modificarValor(key, 1);
                        infoSeguimiento.setText("Usuario seguido correctamente");
                    } else {
                        int numSeguidores = value + 1;
                        CreacionCuenta.modificarValor(key, numSeguidores);
                        infoSeguimiento.setText("Usuario seguido correctamente");
                    }
                } else if (e.getSource() == dejarDeSeguir) {
                    if (value != null && value > 0) {
                        int numSeguidores = value - 1;
                        CreacionCuenta.modificarValor(key, numSeguidores);
                        infoSeguimiento.setText("Has dejado de seguir al usuario correctamente");
                    } else {
                        infoSeguimiento.setText("Usuario sin seguidores, no se puede dejar de seguir");
                    }
                }
            }
        }
    }
}