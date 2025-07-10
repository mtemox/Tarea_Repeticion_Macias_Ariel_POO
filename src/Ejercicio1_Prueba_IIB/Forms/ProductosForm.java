package Ejercicio1_Prueba_IIB.Forms;

import Ejercicio1_Prueba_IIB.Clases.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductosForm extends JFrame {
    private JTextField txt_codigo;
    private JTextField txt_nombre;
    private JTextField txt_detalle;
    private JTextField txt_precio_unitario;
    private JTextField txt_stock;
    private JButton btn_guardar;
    private JButton btn_limpiar;
    private JButton btn_volver;
    private JPanel Panel;

    private Producto p1;

    // Funcion para validar que los campos no estén vacios
    public boolean validarCampo(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    // Funcion para validar el precio
    public boolean validarPrecio(String text) {
        try {
            double n = Double.parseDouble(text);
            return n > 0 && text.matches("\\d{1,4}(\\.\\d{1,2})?");
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    // Funcion para validar el stock
    public boolean validarStock(String text) {
        try {
            int n = Integer.parseInt(text);
            return n > 0 && text.matches("\\d{1,3}?");
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public ProductosForm(Producto producto) {
        setTitle("Ingresar Productos");
        setContentPane(Panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        this.p1 = producto;

        // Acción del botón de volver
        btn_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuForm(p1);
                dispose();
            }
        });

        // Acción del botón de guardar
        btn_guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoInput = txt_codigo.getText();
                String nombreInput = txt_nombre.getText();
                String detalleInput = txt_detalle.getText();
                String precioUnitarioInputStr = txt_precio_unitario.getText();

                String stockInputStr = txt_stock.getText();

                if ((validarCampo(codigoInput))&&(validarCampo(nombreInput))&&
                        (validarCampo(detalleInput))&&(validarCampo(precioUnitarioInputStr))&&
                                (validarCampo(stockInputStr))) {
                    try {
                        double precioUnitarioInput = Double.parseDouble(precioUnitarioInputStr);
                        int stockInput = Integer.parseInt(stockInputStr);

                        if (validarPrecio(precioUnitarioInputStr) && (validarStock(stockInputStr))) {

                            p1 = new Producto(codigoInput, nombreInput, detalleInput, precioUnitarioInput, stockInput);
                            JOptionPane.showMessageDialog(null, "Se ingreso el producto con éxito.");

                        } else if (!validarPrecio(precioUnitarioInputStr) && (validarStock(stockInputStr))){
                            JOptionPane.showMessageDialog(null, "Solo se acepta un precio de máximo 4 cifras con 2 decimales.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Solo se acepta un stock de máximo 3.");
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Valor no válido (precio).");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Uno o más campos están vacios.");
                }
            }
        });

        // Acción del botón de limpiar
        btn_limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_codigo.setText("");
                txt_nombre.setText("");
                txt_detalle.setText("");
                txt_precio_unitario.setText("");
                txt_stock.setText("");
            }
        });
    }
}
