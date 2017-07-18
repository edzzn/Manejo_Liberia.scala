package gui;

import lib.Categoria;
import lib.RegistroCategoria;
import lib.Util;

import javax.swing.*;
import java.awt.event.*;

public class CategoriaCrear extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtCodigo;
    private JTextArea txtDescripcion;
    private JLabel lblDescripcion;

    public CategoriaCrear() {
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
        String codigo = txtCodigo.getText();
        String descripcion = txtDescripcion.getText();

        if(!codigo.isEmpty() && !descripcion.isEmpty()){
            // validad si duplicado
            RegistroCategoria reg_cat = new RegistroCategoria(Util.loadD("c"));
            if(reg_cat.getCategoria(codigo) != null){
                WindowUtil.mjsAlerta("Error, Categoría ya registrado");
            } else {
                // agregamos a los usuarios
                Categoria nuevaCat = new Categoria(codigo, descripcion);
                reg_cat.add(nuevaCat);
                Util.saveD("c", reg_cat);
                WindowUtil.mjsAlerta("Categoría <b>Registrado</b>");
                dispose();
            }
        } else{
            WindowUtil.mjsAlerta("Datos invalidos");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CategoriaCrear dialog = new CategoriaCrear();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
