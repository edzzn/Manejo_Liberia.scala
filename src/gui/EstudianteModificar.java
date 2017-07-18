package gui;

import lib.Estudiante;
import lib.RegistroEstudiante;
import lib.Util;
import scala.reflect.internal.TreeInfo;

import javax.swing.*;
import java.awt.event.*;

public class EstudianteModificar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtIdEstudiante;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    String cedula;

    public EstudianteModificar(String cedula) {
        this.cedula = cedula;
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
        this.txtIdEstudiante.setText(cedula);
        txtIdEstudiante.setEditable(false);

        RegistroEstudiante reg_est = new RegistroEstudiante(Util.loadD("e"));
        Estudiante est = reg_est.getEstudiante(cedula);

        this.txtNombres.setText(est.nombre());
        this.txtApellidos.setText(est.apellido());
    }

    private void onOK() {
        String cedula = txtIdEstudiante.getText();
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();

        if(!nombres.isEmpty() && !apellidos.isEmpty()){
            // agregamos a los usuarios
            Estudiante nuevoEst = new Estudiante(cedula, nombres, apellidos);
            RegistroEstudiante reg_est = new RegistroEstudiante(Util.loadD("e"));
            reg_est.getEstudiante(cedula).edit(nombres, apellidos);
            Util.saveD("e",reg_est);
            WindowUtil.mjsAlerta("Estudiante <b>Modificado</b>");
            dispose();
        } else{
            WindowUtil.mjsAlerta("Datos invalidos");
        }
        dispose();

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        EstudianteModificar dialog = new EstudianteModificar("id");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
