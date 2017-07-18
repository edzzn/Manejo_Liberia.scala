package gui;

import lib.Estudiante;
import lib.RegistroEstudiante;
import lib.Util;

import javax.swing.*;
import java.awt.event.*;

public class EstudianteId extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtIdEstudiante;

    public EstudianteId() {
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
        // Aqui buscamos y validamos al estudiante
        RegistroEstudiante reg_est = new RegistroEstudiante(Util.loadD("e"));
        String cedula = txtIdEstudiante.getText();
        Estudiante estudiante = reg_est.getEstudiante(cedula);
        System.out.println(reg_est);
        if (estudiante != null){
            JDialog estudianteEditar = new EstudianteModificar(cedula);

            WindowUtil.open(estudianteEditar);
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
        EstudianteId dialog = new EstudianteId();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
