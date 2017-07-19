package lib

/**
  * Created by edzzn on 6/29/17.
  */
class Libro(val isbn : String, var nombre : String,  var autor : String, var categoria : Categoria, var numPag : Int,var editorial:String, var idioma : String) extends Serializable{

  override def toString: String = s"$isbn\t$nombre\t$autor\t${categoria.codigo}\t$numPag\t$idioma"

  def edit(nombreN : String, autorN : String, categoriaN : Categoria, numPagN : Int, editorialN : String, idiomaN : String): Unit ={
    nombre = nombreN
    autor = autorN
    categoria = categoriaN
    numPag = numPagN
    idioma = idiomaN
    editorial = editorialN
  }
}