package Ejercicio2_Banco.Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoForm extends JFrame {
    private String propietario = "Ariel Macias";
    private double saldo = 1000.00;
    private JLabel lbl_name;
    private JLabel lbl_monto;
    private JPanel Panel_2;
    private JButton btn_deposito;
    private JButton btn_retiro;
    private JButton btn_transferencia;
    private JButton btn_salir;
    private JTextArea txta_historial;

    public BancoForm() {
        setTitle("Banco Form");
        setContentPane(Panel_2);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        lbl_name.setText(propietario);
        lbl_monto.setText("$" + String.valueOf(saldo));

        btn_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginForm();
                dispose();
            }
        });

        btn_deposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el monto a depositar: ");
                if (input != null) {
                    try {
                        double cantidad = Double.parseDouble(input);
                        if (cantidad > 0) {
                            saldo += cantidad;
                            lbl_monto.setText("$" + String.format("%.2f", saldo));
                            txta_historial.append("Depósito de $" + String.format("%.2f", cantidad) + "\n");
                            JOptionPane.showMessageDialog(null, "Deposito de $" + String.format("%.2f", cantidad) + " realizada con éxito.");
                            pack();
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese un valor positivo.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor válido.");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No se ingresó ningun valor.");
                }
            }
        });

        btn_retiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String input = JOptionPane.showInputDialog(null, "Ingrese el valor a retirar: ");
                if (input != null) {
                    try {
                        double cantidad = Double.parseDouble(input);
                        if (cantidad > 0) {
                            if ((cantidad <= saldo)) {
                                saldo -= cantidad;
                                lbl_monto.setText("$" + String.format("%.2f", saldo));
                                txta_historial.append("Retiro de $" + String.format("%.2f", cantidad) + "\n");
                                JOptionPane.showMessageDialog(null, "Retiro de $" + String.format("%.2f", cantidad) + " realizada con éxito.");
                                pack();
                            } else {
                                JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese un valor positivo.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor válido.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se ingresó ningun valor.");
                }
            }
        });

        btn_transferencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField txt_destinatario = new JTextField();
                JTextField txt_monto = new JTextField();
                Object[] campos = {
                        "Nombre del destinatario: ", txt_destinatario,
                        "Monto a transferir: ", txt_monto
                };
                int resultado = JOptionPane.showConfirmDialog(null, campos, "Transferencia",  JOptionPane.OK_CANCEL_OPTION);
                if (resultado == JOptionPane.OK_OPTION) {
                    try {
                        String destinatario = txt_destinatario.getText().trim();
                        double cantidad = Double.parseDouble(txt_monto.getText());
                        if (cantidad > 0) {
                            if (cantidad <= saldo) {
                                saldo -= cantidad;
                                lbl_monto.setText("$" + String.format("%.2f", saldo));
                                txta_historial.append("Transferencia a " + destinatario + " por $" + String.format("%.2f", cantidad) + "\n");
                                JOptionPane.showMessageDialog(null, "Transferencia exitosa a " + destinatario + " por $" + String.format("%.2f", cantidad) + "\n");
                                pack();
                            } else {
                                JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese un valor positivo.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor válido.");
                    }
                }
            }
        });

    }
}
