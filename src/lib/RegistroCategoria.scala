package lib

/**
  * Created by edzzn on 6/29/17.
  */

class RegistroCategoria(){
  private var reg = scala.collection.mutable.ListBuffer.empty[Categoria]

  def mostrar(): Unit ={
    for (categoria <- reg){
      println(categoria.toString())
    }
  }

  def add(categoria: Categoria) : Unit ={
    reg += categoria
  }

  def editcategoria(codigo : String, nombre : String, descripcion : String): Unit ={
    var categoria = getcategoria(codigo)
    categoria.edit(descripcion)
  }

  def deletecategoria(codigo : String): Unit ={
    val categoria = getcategoria(codigo)
    reg -= categoria
  }

  def getcategoria(codigo : String): Categoria ={
    for (categoria <- reg){
      if (categoria.codigo.equals(codigo)) {
        return categoria
      }
    }
    return null
  }

  def validatecategoria(codigo : String) : Boolean = {
    for (categoria <- reg){
      if (categoria.codigo.equals(codigo)){
        return true
      }
    }
    return false
  }
}