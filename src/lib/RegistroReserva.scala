package lib

/**
  * Created by edzzn on 6/29/17.
  */
class RegistroReserva(obj : Any) extends Serializable{
  private var reg = scala.collection.mutable.ListBuffer.empty[Reserva]
  // Permite la deserealizacion
  if (obj.getClass == this.getClass){
    this.reg = obj.asInstanceOf[RegistroReserva].reg
  }

  override def toString: String = reg.mkString(" \n")

  def add(reserva: Reserva) : Unit ={
    reg += reserva
  }

  def editReserva(id: String, estudiante : Estudiante, libro : Libro, fechaAReservar : Int, fechaReserva : Int, horaReserva : Int): Unit ={
    var reserva = getReserva(id)
    reserva.edit(estudiante, libro, fechaAReservar, fechaReserva, horaReserva)
  }

  def deleteEstudiante(cedula : String): Unit ={
    val estudiante = getReserva(cedula)
    reg -= estudiante
  }

  def getReserva(id : String): Reserva ={
    for (reserva <- reg){
      if (reserva.id.equals(id)) {
        return reserva
      }
    }
    return null
  }

  def validateReserva(id : String) : Boolean = {
    for (reserva <- reg){
      if (reserva.id.equals(id)){
        return true
      }
    }
    return false
  }
}