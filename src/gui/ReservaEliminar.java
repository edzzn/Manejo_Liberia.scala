package gui;

import lib.RegistroReserva;
import lib.Reserva;
import lib.Util;

import javax.swing.*;
import java.awt.event.*;

public class ReservaEliminar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtCodigo;

    public ReservaEliminar() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        RegistroReserva reg_res = new RegistroReserva(Util.loadD("r"));
        String codigo = txtCodigo.getText();
        Reserva reserva = reg_res.getReserva(codigo);
        System.out.println(reg_res);
        if(reserva != null){
            reg_res.deleteReserva(codigo);
            Util.saveD("r", reg_res);
            WindowUtil.mjsAlerta("Reserva " + codigo + " <b>Eliminada</b>");
            dispose();
        }else{
            WindowUtil.mjsAlerta("Código no registrado");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ReservaEliminar dialog = new ReservaEliminar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
