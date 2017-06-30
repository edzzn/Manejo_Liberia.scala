package lib

/**
  * Created by edzzn on 6/29/17.
  */
class Categoria(val codigo : String, var descripcion : String){
  def edit(descripcionStr : String): Unit = {
    descripcion = descripcionStr
  }

  def mostrarCategoria(): String ={
    return (s"$codigo $descripcion")
  }
}
