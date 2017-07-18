package gui;

import lib.RegistroLibro;
import lib.Util;
import lib.Libro;

import javax.swing.*;
import java.awt.event.*;

public class LibroIsbnModificar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtIsbn;

    public LibroIsbnModificar() {
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
        // Aqui buscamos y validamos al libro
        RegistroLibro reg_lib = new RegistroLibro(Util.loadD("l"));
        String isbn = txtIsbn.getText();
        Libro libro = reg_lib.getLibro(isbn);
        System.out.println(reg_lib);
        if (libro != null){
            JDialog libroModificar = new LibroModificar(isbn);

            WindowUtil.open(libroModificar);
            dispose();


        } else{
            WindowUtil.mjsAlerta("ISBD no registrado");
        }
    }
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        LibroIsbnModificar dialog = new LibroIsbnModificar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
