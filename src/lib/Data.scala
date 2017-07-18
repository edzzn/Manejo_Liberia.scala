package lib

/**
  * Created by edzzn on 6/29/17.
  */
object Data {

  // fills data to the program. Serves to help development and testing
  def makeData(): Unit ={

    val reg_e = new RegistroEstudiante()
    val reg_l = new RegistroLibro()
    val reg_c = new RegistroCategoria()
    val reg_r = new RegistroReserva()
    val reg_p = new RegistroPrestamo()

    var i = 0
    for(i <- 0 to 9 ) {
      reg_e.add(new Estudiante("00"+i, "Nombre" + i , "Apellido" + i))
      reg_c.add(new Categoria("CatId"+ i, "Descripcion"+ i))
    }
    i = 0
    for(i <- 0 to 9 ) {
      reg_l.add(new Libro("Isb00"+ i, "Nombre"+i, "Author"+i, reg_c.reg(i), i+300, "edit" + i, "es"))
    }

    i = 0
    for(i <- 0 to 9){
      reg_r.add(new Reserva(i.toString, reg_e.reg(i), reg_l.reg(i), i*20, i*25, i*40))
      reg_p.add(new Prestamo(i.toString, reg_e.reg(i), reg_l.reg(i), i*20, i*25, i*40))
    }

    Util.saveD("l", reg_l)
    Util.saveD("c", reg_c)
    Util.saveD("e", reg_e)
    Util.saveD("e", reg_r)
    Util.saveD("p", reg_p)

  }

}
