package gui;

import lib.Categoria;
import lib.RegistroCategoria;
import lib.Util;

import javax.swing.*;
import java.awt.event.*;

public class CategoriaCodigoEliminar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtCodigo;

    public CategoriaCodigoEliminar() {
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
        // Aqui buscamos y validamos la categoria
        RegistroCategoria reg_cat = new RegistroCategoria(Util.loadD("c"));

        String codigo = txtCodigo.getText();
        Categoria categoria = reg_cat.getCategoria(codigo);
        if (categoria != null){
            reg_cat.deleteCategoria(codigo);
            Util.saveD("c",reg_cat);
            WindowUtil.mjsAlerta("Categoría " + codigo +  " <b>Eliminada</b>");
            dispose();


        } else{
            WindowUtil.mjsAlerta("Código no registrado");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CategoriaCodigoModificar dialog = new CategoriaCodigoModificar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
