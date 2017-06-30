package lib

/**
  * Created by edzzn on 6/29/17.
  */
class Libro(val isbn : String, var nombre : String,  var autor : String, var categoria : Categoria, var numPag : Int, var idioma : String){

  def mostrarLibro(): String ={
    return (s"$isbn $categoria $nombre $autor $numPag $idioma")
  }

  def edit(nombreStr : String, autorStr : String, categoriaCat : Categoria, numPagInt : Int, idiomaStr : String): Unit ={
    nombre = nombreStr
    autor = autorStr
    categoria = categoriaCat
    numPag = numPagInt
    idioma = idiomaStr
  }
}