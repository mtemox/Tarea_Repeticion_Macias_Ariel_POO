package Ejercicio1_Prueba_IIB_2.Forms;

import Ejercicio1_Prueba_IIB_2.Clases.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarProductosForm extends JFrame {
    private JButton btn_regresar;
    private JLabel lbl_codigo;
    private JLabel lbl_nombre;
    private JLabel lbl_detalle;
    private JLabel lbl_stock;
    private JPanel Panel;

    private Producto p1;

    public MostrarProductosForm(Producto producto) {
        setTitle("Productos");
        setContentPane(Panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        this.p1 = producto;

        lbl_codigo.setText(p1.getCodigo());
        lbl_nombre.setText(p1.getNombreProducto());
        lbl_detalle.setText(p1.getDetalle());
        lbl_stock.setText(String.valueOf(p1.getStock()));

        btn_regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuForm(p1);
                dispose();
            }
        });
    }
}
