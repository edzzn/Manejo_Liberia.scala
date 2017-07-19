package lib

/**
  * Created by edzzn on 6/29/17.
  */
class Categoria(val codigo : String, var descripcion : String) extends Serializable{
  def edit(descripcionStr : String): Unit = {
    descripcion = descripcionStr
  }

  override def toString : String = s"$codigo\t$descripcion"

}
