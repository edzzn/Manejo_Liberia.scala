package lib

/**
  * Created by edzzn on 6/29/17.
  */
class Reserva (val id: String, var estudiante : Estudiante, var libro : Libro, var fechaAReservar : String, var fechaReserva : String, var horaReserva : String) extends Serializable{

  override def toString: String = s"$estudiante.nombre $libro.nombre"

  def edit(estudianteN : Estudiante, libroN : Libro, fechaAReservarN : String, fechaReservaN : String, horaReservaN : String): Unit ={
    estudiante = estudianteN
    libro = libroN
    fechaAReservar = fechaAReservarN
    fechaReserva = fechaAReservarN
    horaReserva = horaReservaN
  }
}
