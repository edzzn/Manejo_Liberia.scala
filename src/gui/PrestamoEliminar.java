package gui;

import lib.RegistroPrestamo;
import lib.Util;
import lib.Prestamo;

import javax.swing.*;
import java.awt.event.*;

public class PrestamoEliminar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtCodigo;

    public PrestamoEliminar() {
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
        RegistroPrestamo reg_pre = new RegistroPrestamo(Util.loadD("p"));
        String codigo = txtCodigo.getText();
        Prestamo prestamo = reg_pre.getPrestamo(codigo);
        System.out.println(reg_pre);
        if(prestamo != null){
            reg_pre.deletePrestamo(codigo);
            Util.saveD("p", reg_pre);
            WindowUtil.mjsAlerta("Prestamo " + codigo + " <b>Eliminado</b>");
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
        PrestamoEliminar dialog = new PrestamoEliminar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
