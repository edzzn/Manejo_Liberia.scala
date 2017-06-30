package lib

/**
  * Created by edzzn on 6/29/17.
  */

/**
  * El Objeto util va a tener funciones necesarias en la aplicación
  *
  */
/
object Util {

  def validaCedula(cedulaString :String): Boolean ={

    // Cedula -> list Int
    var cedula = cedulaString.split("").toList.map(_.toInt)

    // Lista para multiplicar items
    var multiList = List(2, 1, 2, 1, 2, 1, 2, 1, 2)

    // Multi = _cedula * _multiList
    var listaMultiplicada = (cedula, multiList).zipped.map(_ * _)

    // Denominadores de la lista anterior
    var denominadores = listaMultiplicada.map(_ / 10)

    // Numeradores de la lista.
    var numeradores =  listaMultiplicada.map(_ % 10)

    // Si el int de cedula es > 10 se resta 9. Es igual a restar 10 y sumar
    // sumar el valor de la decena.
    var cedula9 = (denominadores, numeradores).zipped.map(_ + _)

    //    Sumamos todos los elementos de la lista
    var suma = cedula9.foldLeft(0)(_ + _)

    // 10 menos el modulo de 10 de la suma debe ser igual al ultimo
    // digito de la cedula, o puede ser CERO
    if ((10 - (suma% 10)) == cedula(9) || (suma % 10 == 0 && suma %10 == cedula(9)))
      return true
    else
      return false
  }


}
