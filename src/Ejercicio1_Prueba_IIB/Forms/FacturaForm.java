package Ejercicio1_Prueba_IIB.Forms;

import Ejercicio1_Prueba_IIB.Clases.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturaForm extends JFrame {
    private JPanel Panel;
    private JTextField txt_codigo;
    private JTextField txt_producto;
    private JTextField txt_precio;
    private JTextField txt_cantidad;
    private JTextField txt_subtotal;
    private JTextField txt_total;
    private JButton btn_calcular;
    private JButton btn_regresar;
    private JLabel lbl_iva;
    // Declaro una variable para la tasa del IVA
    private static final double tasaIva = 0.15;

    private Producto p1;

    // Funcion para validar que los campos no estén vacios
    public boolean validarCampo(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    // Funcion para validar la cantidad
    public boolean validarCantidad(String text) {
        try {
            int n = Integer.parseInt(text);
            return n > 0 && text.matches("\\d{1,3}?");
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public FacturaForm(Producto producto) {
        setTitle("Factura");
        setContentPane(Panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        this.p1 = producto;

        txt_codigo.setText(p1.getCodigo());
        txt_producto.setText(p1.getNombreProducto());
        txt_precio.setText(String.format("%.2f", p1.getPrecio()));

        txt_codigo.setEnabled(false);
        txt_producto.setEnabled(false);
        txt_precio.setEnabled(false);
        txt_subtotal.setEnabled(false);
        txt_total.setEnabled(false);

        // Acción para el boton de regresar
        btn_regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuForm(p1);
                dispose();
            }
        });

        // Acción para el boton de calcular
        btn_calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cantidadIntputStr = txt_cantidad.getText();

                double precioUnitarioProducto = p1.getPrecio();


                if (validarCampo(cantidadIntputStr)) {

                    try {
                        int cantidadIntput = Integer.parseInt(cantidadIntputStr);

                        if (cantidadIntput <= p1.getStock() && validarCantidad(cantidadIntputStr)) {

                            double subtotal;
                            double total;

                            subtotal = cantidadIntput * precioUnitarioProducto;
                            // Uso la constante del iva
                            total = subtotal * (1 + tasaIva);

                            txt_subtotal.setText(String.format("%.2f", subtotal));
                            txt_total.setText(String.format("%.2f", total));

                        } else {
                            JOptionPane.showMessageDialog(null, "Cantidad invalida o no hay suficiente en Stock.");
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Cantidad inválida.");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No se ingreso la cantidad.");
                }


            }
        });


    }
}
