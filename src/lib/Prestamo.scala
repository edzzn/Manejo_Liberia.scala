package lib

/**
  * Created by edzzn on 6/29/17.
  */
class Prestamo(val id: String, var estudiante : Estudiante, var libro : Libro, var fechaPrestamo : String, var horaPrestamo : String) extends Serializable{

  override def toString: String = s"$id\t${estudiante.nombre}\t${estudiante.apellido}\t${libro.isbn}\t${libro.nombre}\t${libro.categoria.codigo}\t$fechaPrestamo"

  def edit(estudianteN : Estudiante, libroN : Libro, fechaPrestamoN : String, horaPrestamoN : String): Unit ={
    estudiante = estudianteN
    libro = libroN
    fechaPrestamo = fechaPrestamoN
    horaPrestamo = horaPrestamoN
  }
}
