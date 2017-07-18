package gui;

import lib.*;

import javax.swing.*;
import java.awt.event.*;

public class LibroCrear extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtIsbn;
    private JTextField txtIntNumPag;
    private JTextField txtLenguaje;
    private JTextField txtAutor;
    private JTextField txtEditorial;
    private JTextField txtCategoria;
    private JTextField txtNombre;

    public LibroCrear() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

//        txtIntNumPag.setEnabled(false);

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
        String isbn = txtIsbn.getText();
        String nombre = txtNombre.getText();
        String idioma = txtLenguaje.getText();
        String autor = txtAutor.getText();
        String editorial = txtEditorial.getText();
        String categoriaID = txtCategoria.getText();
        int numPag = 0;

        try{
            numPag = Integer.parseInt(txtIntNumPag.getText());
        } catch (Exception e) {
            WindowUtil.mjsAlerta("Error, Num de paginas debe ser entero");
        }


        if(!isbn.isEmpty() && numPag != 0 && !idioma.isEmpty() && !autor.isEmpty() && !editorial.isEmpty() && !categoriaID.isEmpty() && !nombre.isEmpty()){
            // validad si duplicado
            RegistroCategoria reg_cat = new RegistroCategoria(Util.loadD("c"));
            RegistroLibro reg_lib = new RegistroLibro(Util.loadD("l"));

            if(reg_cat.getCategoria(categoriaID) == null){
                // Validamos la Categoria existe
                WindowUtil.mjsAlerta("Error, Categoria no existe");
            } else if(reg_lib.getLibro(isbn) != null){
                // Valida libro no duplicado
                WindowUtil.mjsAlerta("Error, Libro ya registrado");
            }else {
                Categoria categoria = reg_cat.getCategoria(categoriaID);
                // agregamos a los usuarios
                Libro nuevoLibro = new Libro(isbn, nombre, autor, categoria, numPag, editorial, idioma);
                reg_lib.add(nuevoLibro);
                Util.saveD("l", reg_lib);
                WindowUtil.mjsAlerta("Libro <b>Registrado</b>");
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
        LibroCrear dialog = new LibroCrear();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
