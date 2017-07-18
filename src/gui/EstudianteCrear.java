package gui;

import lib.Estudiante;
import lib.RegistroEstudiante;
import lib.Util;

import javax.swing.*;
import java.awt.event.*;

public class EstudianteCrear extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtIdEstudiante;
    private JTextField txtNombres;
    private JTextField txtApellido;

    public EstudianteCrear() {
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
        String cedula = txtIdEstudiante.getText();
        String nombres = txtNombres.getText();
        String apellidos = txtApellido.getText();

        if(!cedula.isEmpty() && !nombres.isEmpty() && !apellidos.isEmpty()){
            // validad si duplicado
            RegistroEstudiante reg_est = new RegistroEstudiante(Util.loadD("e"));
            if(reg_est.getEstudiante(cedula) != null){
                WindowUtil.mjsAlerta("Error, Estudiante ya registrado");
            } else {
                // agregamos a los usuarios
                Estudiante nuevoEst = new Estudiante(cedula, nombres, apellidos);
                reg_est.add(nuevoEst);
                Util.saveD("e", reg_est);
                WindowUtil.mjsAlerta("Estudiante <b>Registrado</b>");
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
        EstudianteCrear dialog = new EstudianteCrear();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
