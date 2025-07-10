package Ejercicio2_Banco.Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField txt_usuario;
    private JButton btn_ingresar;
    private JPanel Panel_1;
    private JPasswordField f_pass;

    public LoginForm() {
        setTitle("Login Form");
        setContentPane(Panel_1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Almaceno las credenciales
        String user = "cliente123";
        String psw = "clave456";

        btn_ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Obtener los datos de los datos de entrada
                String ususario = txt_usuario.getText();
                char[] passwordChars = f_pass.getPassword();
                String contrasenia = new String(passwordChars);

                // Validación de credenciales
                if ((ususario.equals(user))&&(contrasenia.equals(psw))) {
                    // Abre el form
                    new BancoForm();
                    // Para ocultar el form actual
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
                }


            }
        });
    }
}

