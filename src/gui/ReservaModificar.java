package gui;

import lib.*;

import javax.swing.*;
import java.awt.event.*;

public class ReservaModificar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtCodigo;
    private JTextField txtId;
    private JTextField txtIsbn;
    private JTextField txtFechaA;
    private JTextField txtFecha;
    private JTextField txtHora;
    String codigo;

    public ReservaModificar(String codigo) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.codigo = codigo;
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

        RegistroReserva reg_res = new RegistroReserva(Util.loadD("r"));
        Reserva reserva = reg_res.getReserva(codigo);

        this.txtFecha.setText(reserva.fechaReserva());
        this.txtHora.setText(reserva.horaReserva());
        this.txtId.setText(reserva.estudiante().cedula());
        this.txtIsbn.setText(reserva.libro().isbn());
        this.txtFechaA.setText(reserva.fechaAReservar());
    }

    private void onOK() {
        // add your code here
        String codigo = txtCodigo.getText();
        String id = txtId.getText();
        String isbn = txtIsbn.getText();
        String fechaA = txtFechaA.getText();
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();

        if(!id.isEmpty() && !isbn.isEmpty() && !fechaA.isEmpty() && !fecha.isEmpty() && !hora.isEmpty()){
            RegistroEstudiante reg_est = new RegistroEstudiante(Util.loadD("e"));
            RegistroLibro reg_lib = new RegistroLibro(Util.loadD("l"));
            RegistroReserva reg_res = new RegistroReserva(Util.loadD("r"));

            Estudiante estudiante = reg_est.getEstudiante(id);
            Libro libro = reg_lib.getLibro(isbn);

            if(estudiante==null){
                WindowUtil.mjsAlerta("Error, estudiante no existe");

            }else if (libro == null){
                WindowUtil.mjsAlerta("Error, libro no existe");
            }else{
                reg_res.getReserva(codigo).edit(estudiante,libro,fechaA,fecha,hora);
                Util.saveD("r",reg_res);
                WindowUtil.mjsAlerta("Reserva <b>Modificada</b>");
                dispose();
            }
        }else{
            WindowUtil.mjsAlerta("Datos erroneos");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ReservaModificar dialog = new ReservaModificar("");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
