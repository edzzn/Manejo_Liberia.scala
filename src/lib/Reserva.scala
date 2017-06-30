package lib

/**
  * Created by edzzn on 6/29/17.
  */
class Reserva (val id: String, var estudiante : Estudiante, var libro : Libro, var fechaAReservar : Int, var fechaReserva : Int, var horaReserva : Int){

  override def toString: String = s"$estudiante.nombre $libro.nombre"

  def edit(estudianteN : Estudiante, libroN : Libro, fechaAReservarN : Int, fechaReservaN : Int, horaReservaN : Int): Unit ={
    estudiante = estudianteN
    libro = libroN
    fechaAReservar = fechaAReservarN
    fechaReserva = fechaAReservarN
    horaReserva = horaReservaN
  }
}
