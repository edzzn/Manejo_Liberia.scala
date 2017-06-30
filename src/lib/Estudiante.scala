package lib

/**
  * Created by edzzn on 6/29/17.
  */
class Estudiante(val cedula : String, var nombre : String, var apellido : String){
  def mostrarEstudiante() : String = {
    return (cedula + " " + nombre + " " + apellido)
  }

  def edit(nombreStr : String, apellidoStr : String): Unit ={
    nombre = nombreStr
    apellido = apellidoStr
  }

}