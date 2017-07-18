package gui;

import lib.Categoria;
import lib.RegistroCategoria;
import lib.Util;

import javax.swing.*;
import java.awt.event.*;

public class CategoriaModificar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtCodigo;
    private JTextArea txtDescripcion;
    String codigo;

    public CategoriaModificar(String codigo) {
        this.codigo = codigo;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        updateDataDisplay();

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

    private void updateDataDisplay(){
        this.txtCodigo.setText(codigo);
        txtCodigo.setEditable(false);

        RegistroCategoria reg_cat = new RegistroCategoria(Util.loadD("c"));
        Categoria cat = reg_cat.getCategoria(codigo);

        this.txtDescripcion.setText(cat.descripcion());
    }

    private void onOK() {
        String codigo = txtCodigo.getText();
        String descripcion = txtDescripcion.getText();


        if(!descripcion.isEmpty()){
            //Modificamos la categoria
            Categoria nuevoEst = new Categoria(codigo, descripcion);
            RegistroCategoria reg_cat = new RegistroCategoria(Util.loadD("c"));
            reg_cat.getCategoria(codigo).edit(descripcion);
            Util.saveD("c",reg_cat);
            WindowUtil.mjsAlerta("Categoria <b>Modificado</b>");
            dispose();
        } else{
            WindowUtil.mjsAlerta("Datos invalidos");
        }
    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CategoriaModificar dialog = new CategoriaModificar("A");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
