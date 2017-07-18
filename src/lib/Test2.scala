package lib

/**
  * Created by edzzn on 6/29/17.
  */
object Main {
  def main(args: Array[String]): Unit = {

// Test Serializacion Estudiantes
    var est1 = new Estudiante("14001", "Edisson", "Reinozo")
    var est2 = new Estudiante("14001", "Edisson", "Reinozo")
    var est3 = new Estudiante("14001", "Edisson", "Reinozo")
    var est4 = new Estudiante("14001", "Edisson", "Reinozo")

    var reg_est = new RegistroEstudiante()

    reg_est.add(est1)
    reg_est.add(est2)
    reg_est.add(est3)
    reg_est.add(est4)
    println(reg_est)
    println("Serializamos")
    Util.saveD("e", reg_est)

    var n_reg_lib = new RegistroLibro((Util.loadD("l")))

    println(n_reg_lib)
    println("")

    var n_reg_est = new RegistroEstudiante(Util.loadD("e"))

    println(n_reg_est)
    println("")

    var n_reg_cat = new RegistroReserva(Util.loadD("r"))

    println(n_reg_cat)

      //
  //    // SERIALIZACION
  //    var cat1 = new Categoria("14001", "Nombre")
  //    var cat2 = new Categoria("14002", "Nombre")
  //    var cat3 = new Categoria("14003", "Nombre")
  //
  //    var reg_cat = new RegistroCategoria()
  //    reg_cat.add(cat1)
  //    reg_cat.add(cat2)
  //    reg_cat.add(cat3)
  //
  //    reg_cat.mostrar()
  //    println("")
  //
  ////    Util.serialize("data.dat", reg_cat)
  //    Util.saveD("c", reg_cat)
  //
  //    val nuevo_Rcat = new RegistroCategoria(Util.loadD("c"))
  ////    val nuevo_Rcat = new RegistroCategoria(Util.deserialize("data.dat"))
  //
  //    println("Deserealiazo")
  //    nuevo_Rcat.mostrar()



  //    val cat = new Categoria("SH", "decript")
  //    println(cat.toString())
  //    println(cat.codigo)
  //
  //    cat.edit("NUew dews")
  //    println(cat.toString())
  //    println(cat)
  //


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
