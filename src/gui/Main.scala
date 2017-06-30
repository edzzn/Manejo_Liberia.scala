package gui
import lib.Util

/**
  * Created by edzzn on 6/30/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val dialog = new Login
    dialog.pack()
    dialog.setVisible(true)
    System.exit(0)
  }

}
