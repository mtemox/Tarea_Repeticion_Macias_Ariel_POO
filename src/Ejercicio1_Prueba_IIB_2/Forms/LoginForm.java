package Ejercicio1_Prueba_IIB_2.Forms;

import Ejercicio1_Prueba_IIB_2.Clases.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private String usuario = "macias";
    private String contrasena = "esfot";

    private JPanel Panel;
    private JTextField txt_usuario;
    private JButton btn_acceso;
    private JButton btn_limpiar;
    private JPasswordField pw_contrasena;

    private Producto p1;

    public boolean validarCampo(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public LoginForm() {
        setTitle("Login");
        setContentPane(Panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


        // Acción del botón de limpiar
        btn_limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_usuario.setText("");
                pw_contrasena.setText("");
            }
        });

        // Acción del botón de ingresar
        btn_acceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuarioInput = txt_usuario.getText();
                char[] contrasenaInputChar = pw_contrasena.getPassword();
                String contrasenaInput = new String(contrasenaInputChar);

                if (validarCampo(usuarioInput) && validarCampo(contrasenaInput)) {
                    if ((usuarioInput.equals(usuario))&&(contrasenaInput.equals(contrasena))) {
                        new MenuForm(p1);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se han ingresado datos.");
                }
            }
        });
    }


}
