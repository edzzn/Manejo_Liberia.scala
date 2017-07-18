package gui;

import lib.Estudiante;
import lib.RegistroEstudiante;
import lib.Util;

import javax.swing.*;
import java.awt.event.*;

public class EstudianteIdEliminar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtIdEstudiante;

    public EstudianteIdEliminar() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onEliminar();
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

    private void onEliminar() {
        // Aqui buscamos y validamos al estudiante
        RegistroEstudiante reg_est = new RegistroEstudiante(Util.loadD("e"));
        String cedula = txtIdEstudiante.getText();
        Estudiante estudiante = reg_est.getEstudiante(cedula);
        if (estudiante != null){
            reg_est.deleteEstudiante(cedula);
            Util.saveD("e",reg_est);
            WindowUtil.mjsAlerta("Estudiante " + cedula +  " <b>Eliminado</b>");
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
        EstudianteIdEliminar dialog = new EstudianteIdEliminar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
