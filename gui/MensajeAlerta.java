package gui;

import javax.swing.*;
import java.awt.event.*;

public class MensajeAlerta extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel textoInformacion;
    private String mensaje;

    public MensajeAlerta(String mensaje) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.mensaje = mensaje;

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        this.setLocation(300,200);
        this.setInformation(this.mensaje);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public static void main(String[] args) {
        MensajeAlerta dialog = new MensajeAlerta("mensaje");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void setInformation(String mensaje) {
        // TODO: place custom component creation code here
        this.textoInformacion.setText("<html>" + mensaje + "</html>");
    }
}
