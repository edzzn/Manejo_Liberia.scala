package gui;

import javax.swing.*;
import java.awt.event.*;

public class Manejo extends JDialog {
    private JPanel contentPane;
    private JButton btnEstudianteCrear;
    private JButton btnEstudianteEditar;
    private JButton btnEstudianteEliminar;
    private JButton btnCategoriaCrear;
    private JButton btnCategoriaEditar;
    private JButton btnCategoriaEliminar;
    private JButton btnLibroCrear;
    private JButton btnLibroEditar;
    private JButton btnLibroEliminar;
    private JButton btnReservaCrear;
    private JButton btnPrestamosCrear;
    private JButton btnPrestamoEditar;
    private JButton btnReservaEditar;
    private JButton btnPrestamoEliminar;
    private JButton btnReservaEliminar;

    public Manejo() {
        setContentPane(contentPane);
        setModal(true);
        fijarAcciones();


    }

    private void fijarAcciones(){
        btnReservaCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onReservaCrear();
            }
        });
        btnReservaEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onReservaEditar();
            }
        });
        btnReservaEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onReservaEliminar();
            }
        });
        btnPrestamosCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPrestamoCrear();
            }
        });
        btnPrestamoEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPrestamoEditar();
            }
        });
        btnPrestamoEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPrestamosEliminar();
            }
        });
        btnEstudianteCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onEstudianteCrear();
            }
        });
        btnEstudianteEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onEstudianteEditar();
            }
        });
        btnEstudianteEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onEstudianteElimiar();
            }
        });
        btnLibroCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLibrosCrear();
            }
        });
        btnLibroEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLibrosEditar();
            }
        });
        btnLibroEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLibrosEliminar();
            }
        });
        btnCategoriaCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCategoriaCrear();
            }
        });

        btnCategoriaEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCategoriaEditar();
            }
        });

        btnCategoriaEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCategoriaEliminar();
            }
        });
    }

    // creamos nuestras funciones

    private void onReservaCrear() {
        // add your code here
        System.out.println("on onReservaCrear");
    }

    private void onReservaEditar() {
        // add your code here
        System.out.println("onReservaEditar");
    }

    private void onReservaEliminar() {
        // add your code here
        System.out.println("onReservaEliminar");
    }

    private void onPrestamoCrear() {
        // add your code here
        System.out.println("onPrestamoCrear");
    }

    private void onPrestamoEditar() {
        // add your code here
        System.out.println("onPrestamoEditar");
    }

    private void onPrestamosEliminar() {
        // add your code here
        System.out.println("onPrestamosEliminar");
    }

    private void onEstudianteCrear() {
        // add your code here
        System.out.println("on btnEstudianteCrear");
        JDialog crearEstudiante = new EstudianteCrear();
        WindowUtil.open(crearEstudiante);
    }

    private void onEstudianteEditar() {
        JDialog getId = new EstudianteIdModificar();
        WindowUtil.open(getId);
        System.out.println("on btnEstudianteEditar");
    }

    private void onEstudianteElimiar() {
        JDialog getIdEliminar = new EstudianteIdEliminar();
        WindowUtil.open(getIdEliminar);
        System.out.println("on btnEstudianteEliminar");
    }

    private void onLibrosCrear() {
        JDialog crearLibro = new LibroCrear();
        WindowUtil.open(crearLibro);
        System.out.println("onLibrosCrear");
    }

    private void onLibrosEditar() {
        // add your code here
        JDialog editarLibro = new LibroIsbnModificar();
        WindowUtil.open(editarLibro);
        System.out.println("onLibrosEditar");
    }

    private void onLibrosEliminar() {
        // add your code here
        JDialog eliminarLibro = new LibroIsbnEliminar();
        WindowUtil.open(eliminarLibro);
        System.out.println("on onLibrosEliminar");
    }

    private void onCategoriaCrear() {
        // add your code here
        JDialog crearCategoria = new CategoriaCrear();
        WindowUtil.open(crearCategoria);
        System.out.println("on onCategoriaCrear");
    }

    private void onCategoriaEditar() {
        JDialog editarCategoria = new CategoriaCodigoModificar();
        WindowUtil.open(editarCategoria);
        System.out.println("on onCategoriaEditar");
    }

    private void onCategoriaEliminar() {
        JDialog eliminarCategoria = new CategoriaCodigoModificar();
        WindowUtil.open(eliminarCategoria);
        System.out.println("on onCategoriaEliminar");
    }

    public static void main(String[] args) {
        Manejo dialog = new Manejo();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        System.exit(0);
    }
}
