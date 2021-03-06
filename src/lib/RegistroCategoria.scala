package lib

/**
  * Created by edzzn on 6/29/17.
  */

class RegistroCategoria(obj : Any) extends Serializable{

  var reg = scala.collection.mutable.ListBuffer.empty[Categoria]
  // Permite la deserealizacion
  if (obj.getClass == this.getClass){
    this.reg = obj.asInstanceOf[RegistroCategoria].reg
  }

  override def toString: String = reg.mkString(" \n")

  def add(categoria: Categoria) : Unit ={
    reg += categoria
  }

  def editcategoria(codigo : String, nombre : String, descripcion : String): Unit ={
    var categoria = getCategoria(codigo)
    categoria.edit(descripcion)
  }

  def deleteCategoria(codigo : String): Unit ={
    val categoria = getCategoria(codigo)
    reg -= categoria
  }

  def getCategoria(codigo : String): Categoria ={
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