package Ejercicio1_Prueba_IIB_2.Forms;

import Ejercicio1_Prueba_IIB_2.Clases.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm extends JFrame {
    private JButton btn_registro;
    private JButton btn_ventas;
    private JButton btn_ver_productos;
    private JPanel Panel;

    private Producto p1;

    public MenuForm (Producto producto) {
        setTitle("Menú");
        setContentPane(Panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        this.p1 = producto;

        // Acción del botón de registro
        btn_registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductosForm(p1);
                dispose();
            }
        });

        // Acción del botón de ventas
        btn_ventas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FacturaForm(p1);
                dispose();
            }
        });

        // Acción del botón de ver productos
        btn_ver_productos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MostrarProductosForm(p1);
                dispose();
            }
        });
    }
}
