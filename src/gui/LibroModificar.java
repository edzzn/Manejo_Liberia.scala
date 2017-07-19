package gui;

import lib.*;

import javax.swing.*;
import java.awt.event.*;

public class LibroModificar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtIsbn;
    private JTextField txtNombre;
    private JTextField txtNumPagina;
    private JTextField txtLenguaje;
    private JTextField txtAutor;
    private JTextField txtEditorial;
    private JTextField txtCategoria;
    String isbn;

    public LibroModificar(String isbn) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.isbn = isbn;
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
        this.txtIsbn.setText(isbn);
        txtIsbn.setEditable(false);

        RegistroLibro reg_lib = new RegistroLibro(Util.loadD("l"));
        Libro libro = reg_lib.getLibro(isbn);

        this.txtLenguaje.setText(libro.idioma());
        this.txtAutor.setText(libro.autor());
        this.txtCategoria.setText(libro.categoria().descripcion());
        this.txtEditorial.setText(libro.editorial());
        this.txtNumPagina.setText(String.valueOf(libro.numPag()));
        this.txtNombre.setText(libro.nombre());
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
            numPag = Integer.parseInt(txtNumPagina.getText());
        } catch (Exception e) {
            WindowUtil.mjsAlerta("Error, Num de paginas debe ser entero");
        }

        if(numPag != 0 && !idioma.isEmpty() && !autor.isEmpty() && !editorial.isEmpty() && !categoriaID.isEmpty() && !nombre.isEmpty()){
            // validad si existe el regi
            RegistroCategoria reg_cat = new RegistroCategoria(Util.loadD("c"));
            RegistroLibro reg_lib = new RegistroLibro(Util.loadD("l"));
            Categoria categoria = reg_cat.getCategoria(categoriaID);
            if(categoria == null){
                // Validamos la Categoria existe
                WindowUtil.mjsAlerta("Error, Categoria no existe");
            } else {
                // Guardamos los cambios
                reg_lib.getLibro(isbn).edit(nombre, autor, categoria, numPag, editorial, idioma);
                Util.saveD("l", reg_lib);
                WindowUtil.mjsAlerta("Libro <b>Modificado</b>");
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
        LibroModificar dialog = new LibroModificar("");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
