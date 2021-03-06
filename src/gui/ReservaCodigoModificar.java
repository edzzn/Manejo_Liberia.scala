package gui;

import lib.*;

import javax.swing.*;
import java.awt.event.*;

public class ReservaCodigoModificar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtCodigo;

    public ReservaCodigoModificar() {
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
        System.out.println("Reserva " + reserva);
        if (reserva != null){
            JDialog reservaModificar = new ReservaModificar(codigo);

            WindowUtil.open(reservaModificar);
            dispose();


        } else{
            WindowUtil.mjsAlerta("Codigo no registrado");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ReservaCodigoModificar dialog = new ReservaCodigoModificar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
