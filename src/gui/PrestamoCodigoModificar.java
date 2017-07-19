package gui;

import lib.*;

import javax.swing.*;
import java.awt.event.*;

public class PrestamoCodigoModificar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtCodigo;

    public PrestamoCodigoModificar() {
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
        if (prestamo != null){
            JDialog prestamoModificar = new PrestamoModificar(codigo);

            WindowUtil.open(prestamoModificar);
            dispose();


        } else{
            WindowUtil.mjsAlerta("prestamo no registrado");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        PrestamoCodigoModificar dialog = new PrestamoCodigoModificar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
