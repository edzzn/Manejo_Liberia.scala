package lib

/**
  * Created by edzzn on 6/29/17.
  */


import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.io.FileInputStream
import java.io.ObjectInputStream

/**
  * El Objeto util va a tener funciones necesarias en la aplicación
  *
  */


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

  // Metodos para la serialización

  def saveD(tipo :String, objeto : Any): Unit ={
    val fileName = getFileName(tipo)
    val fos = new FileOutputStream(fileName)
    val oss = new ObjectOutputStream(fos)

    oss.writeObject(objeto)
    oss.close()
  }
  def loadD(tipo :String): Any ={
    val fileName = getFileName(tipo)
    val fis = new FileInputStream(fileName)
    val ois = new ClassLoader(fis)
    val data = ois.readObject
    ois.close

    return data
  }

  def getFileName(tipo: String): String ={
//     l -> libros
//     p -> prestamos
//     r -> reservas
//     e -> estudiantes
//     c -> categorias

    tipo match {
      case "l" => return "data_libros.dat"
      case "p" => return "data_perstamos.dat"
      case "r" => return "data_reservas.dat"
      case "e" => return "data_estudiantes.dat"
      case "c" => return "data_categorias.dat"
      case _   => return "None"
    }
    return "B"

  }


  class ClassLoader(fileInputStream: FileInputStream) extends ObjectInputStream(fileInputStream) {
    override def resolveClass(desc: java.io.ObjectStreamClass): Class[_] = {
      try { Class.forName(desc.getName, false, getClass.getClassLoader) }
      catch { case ex: ClassNotFoundException => super.resolveClass(desc) }
    }
  }

}
