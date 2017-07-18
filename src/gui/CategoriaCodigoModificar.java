package gui;

import lib.Categoria;
import lib.RegistroCategoria;
import lib.Util;

import javax.swing.*;
import java.awt.event.*;

public class CategoriaCodigoModificar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtCodigo;

    public CategoriaCodigoModificar() {
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
        // Aqui buscamos y validamos la Categoria
        RegistroCategoria reg_cat = new RegistroCategoria(Util.loadD("c"));
        String codigo = txtCodigo.getText();
        Categoria estudiante = reg_cat.getCategoria(codigo);
        System.out.println(reg_cat);
        if (estudiante != null){
            JDialog categoriaEditar = new CategoriaModificar(codigo);

            WindowUtil.open(categoriaEditar);
            dispose();


        } else{
            WindowUtil.mjsAlerta("Id no registrado");
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
