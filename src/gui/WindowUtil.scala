package gui

/**
  * Created by edzzn on 6/30/17.
  * Metodos Utiles para el manejo de ventanas
  */
object WindowUtil {

  def mjsAlerta(mensaje : String): Unit ={
    val dialog = new MensajeAlerta(mensaje)
    dialog.pack()
    dialog.setVisible(true)
  }

  def open(obj : Any): Unit ={
//    val window = new
  }
}
