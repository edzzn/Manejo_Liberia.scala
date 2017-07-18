package gui
import lib.{RegistroReserva, Util}

/**
  * Created by edzzn on 6/30/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val reg_res = new RegistroReserva(Util.loadD("r"))
    println(reg_res)

    val dialog = new Manejo
    WindowUtil.open(dialog)
    System.exit(0)


  }
}
