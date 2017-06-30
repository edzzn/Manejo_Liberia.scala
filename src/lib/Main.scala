package lib

/**
  * Created by edzzn on 6/29/17.
  */
object Main {
  def main(args: Array[String]): Unit = {

    val cat = new Categoria("SH", "decript")
    println(cat.mostrarCategoria())
    println(cat.codigo)

    cat.edit("NUew dews")
    println(cat.mostrarCategoria())



    //    val libro = new Libro("002", "4HWW" , "Tim", new Categoria("SH", "SelfH"), 450, "es")
    //
    //    println(libro.mostrarLibro())
    //
    //    libro.edit("4HW5" , "Tom", new Categoria("SH", "SelfH"), 450, "en")
    //
    //    println(libro.mostrarLibro())

    //    val est1 = new Estudiante("1401", "Edisson", "Reinozo")
    //    val est2 = new Estudiante("1402", "Edisson", "Reinozo")
    //    val est3 = new Estudiante("1403", "Edisson", "Reinozo")
    //    var reg_est = new RegistroEstudiante()
    //    reg_est.add(est1)
    //    reg_est.add(est2)
    //    reg_est.add(est3)
    //    reg_est.mostrar()
    //
    //    println(reg_est.validateEstudiante("1402"))
    //    println("  ")
    //    reg_est.editEstudiante("1402", "Reinozo", "Edisson")
    //    reg_est.mostrar()
    //
    //    println(reg_est.validateEstudiante("1402"))
  }
}
