package gui;

import lib.*;

import javax.swing.*;
import java.awt.event.*;


public class MostrarRegistros extends JDialog {
    private JPanel contentPane;
    private JButton btnCerrar;
    private JLabel lblInfo;
    private JTextPane txtPaneDatos;
    private String tipo;
    private String info;

    public MostrarRegistros(String tipo, String info) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnCerrar);

        this.tipo = tipo;
        this.info = info;

        this.lblInfo.setText(info);

        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        this.updateText();

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
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void updateText() {
        System.out.println("Por tipo: " + tipo);
        String cabecera = "";

        switch (tipo) {
            case "l":
                cabecera = "ISBN\tNombre\tAutor\tCategoría\tNumPag\tIdioma\n";
                this.txtPaneDatos.setText(cabecera + (new RegistroLibro(Util.loadD(tipo))).toString());
                break;
            case "p":
                cabecera = "Código\tEstudiante\t\tISBN\tLibro\tCategoria\tFechaPrest\n";
                this.txtPaneDatos.setText(cabecera + (new RegistroPrestamo(Util.loadD(tipo))).toString());
                break;
            case "r":
                cabecera = "Código\tEstudiante\t\tISBN\tLibro\tCategoria\tFechaReserva\n";
                this.txtPaneDatos.setText(cabecera + (new RegistroReserva(Util.loadD(tipo))).toString());
                break;
            case "e":
                cabecera = "Cédula\tNombre\tApellido\n";
                this.txtPaneDatos.setText(cabecera+(new RegistroEstudiante(Util.loadD(tipo))).toString());

                // Implementación con TextArea y JList
//                textArea1.setText((new RegistroEstudiante(Util.loadD(tipo))).toString());
//                RegistroEstudiante reg_est = new RegistroEstudiante(Util.loadD(tipo));
//                Vector<Estudiante> vectEstudiante = new Vector<Estudiante>();
//                System.out.println(reg_est);
//                for(int i=0; i < reg_est.reg().size(); i++){
//                    Estudiante estudiante = reg_est.reg().apply(i);
//
//                    vectEstudiante.add(estudiante);
//
//                }
//
//
//
//                list1.setListData(vectEstudiante);
//                scrollBar1.set
//                JScrollPane jsp = new JScrollPane(txtPaneDatos);

                break;
            case "c":
                cabecera = "Código\t Descripción\n";
                this.txtPaneDatos.setText(cabecera + (new RegistroCategoria(Util.loadD(tipo))).toString());
                break;
            default:
                System.out.println("Ninguno");
                break;
        }
    }


    public static void main(String[] args) {
        MostrarRegistros dialog = new MostrarRegistros("e","Estudiantes");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
