package gui;

import lib.*;

import javax.swing.*;
import java.awt.event.*;

public class PrestamoCrear extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtCodigo;
    private JTextField txtId;
    private JTextField txtIsbn;
    private JTextField txtFecha;
    private JTextField txtHora;

    public PrestamoCrear() {
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
        String codigo = txtCodigo.getText();
        String id = txtId.getText();
        String isbn = txtIsbn.getText();
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();

        if(!codigo.isEmpty() && !id.isEmpty() && !isbn.isEmpty() && !fecha.isEmpty() && !hora.isEmpty()){
            RegistroEstudiante reg_est = new RegistroEstudiante(Util.loadD("e"));
            RegistroLibro reg_lib = new RegistroLibro(Util.loadD("l"));
            RegistroPrestamo reg_pre = new RegistroPrestamo(Util.loadD("p"));

            if(reg_est.getEstudiante(id) == null){
                WindowUtil.mjsAlerta("Estudiante no registrado");
            }else if(reg_lib.getLibro(isbn) == null){
                WindowUtil.mjsAlerta("Libro no registrado");
            }else if(reg_pre.getPrestamo(codigo) != null){
                WindowUtil.mjsAlerta("Reserva ya registrada");
            }else {
                Estudiante estudiante = reg_est.getEstudiante(id);
                Libro libro = reg_lib.getLibro(isbn);

                Prestamo nuevoPrestamo =new Prestamo(codigo,estudiante,libro,fecha,hora);
                reg_pre.add(nuevoPrestamo);

                Util.saveD("p",reg_pre);
                WindowUtil.mjsAlerta("Libro <b>Registrado</b>");
                dispose();
            }
        }else{
            WindowUtil.mjsAlerta("Datos invalidos");
        }
        dispose();

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        PrestamoCrear dialog = new PrestamoCrear();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
