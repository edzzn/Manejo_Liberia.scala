package gui;

import lib.*;

import javax.swing.*;
import java.awt.event.*;

public class ReservaCrear extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtCodigo;
    private JTextField txtIdEstudiante;
    private JTextField txtIsbn;
    private JTextField txtFechaAR;
    private JTextField txtFechDR;
    private JTextField txtHoraReserva;

    public ReservaCrear() {
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
        String estudianteId = txtIdEstudiante.getText();
        String isbn = txtIsbn.getText();
        String fechaAR = txtFechaAR.getText();
        String fechaDR = txtFechDR.getText();
        String hora = txtHoraReserva.getText();

        if(!codigo.isEmpty() && !estudianteId.isEmpty() && !isbn.isEmpty() && !fechaDR.isEmpty() && !fechaAR.isEmpty() && !hora.isEmpty()) {
            RegistroEstudiante reg_est = new RegistroEstudiante(Util.loadD("e"));
            RegistroLibro reg_lib = new RegistroLibro(Util.loadD("l"));
            RegistroReserva reg_res = new RegistroReserva(Util.loadD("r"));

            if(reg_est.getEstudiante(estudianteId) == null){
                WindowUtil.mjsAlerta("Estudiante no registrado");
            } else if(reg_lib.getLibro(isbn) == null){
                WindowUtil.mjsAlerta("Libro no registrado");
            } else if (reg_res.getReserva(codigo) != null){
                WindowUtil.mjsAlerta("Reserva ya registrada");
            } else {
                // Datos validos aqui.
                Estudiante estudiante = reg_est.getEstudiante(estudianteId);
                Libro libro = reg_lib.getLibro(isbn);

                Reserva reserva = new Reserva(codigo, estudiante, libro, fechaAR, fechaDR, hora);
                reg_res.add(reserva);

                Util.saveD("r", reg_res);
                WindowUtil.mjsAlerta("Reserva <b>Registrada</b>");
                dispose ();

            }

        }else{
            WindowUtil.mjsAlerta("Datos invalidos");
        }
    }
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ReservaCrear dialog = new ReservaCrear();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
