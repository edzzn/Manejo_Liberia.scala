package gui;

import lib.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textNombre;
    private JPasswordField textPass;
    private JButton iButton;

    public Login() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        iButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onInfo();
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
        String usuario = "0001";
        String password = "11235813";
        if(this.textNombre.getText().equalsIgnoreCase(usuario) && this.textPass.getText().equalsIgnoreCase(password)){
            System.out.println("Usuario inicia");
            JDialog manejo  = new Manejo();
            WindowUtil.open(manejo);
            dispose();
        } else{
          WindowUtil.mjsAlerta("Datos Incorrectos");
        }
//        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void onInfo() {
        // add your code here if necessary
        WindowUtil.mjsAlerta("Usuario: 0001 <br>Conrtaseña: 11235813");
    }

    public static void main(String[] args) {
        Login dialog = new Login();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
