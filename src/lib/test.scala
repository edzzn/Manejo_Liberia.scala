package lib

/**
  * Created by edzzn on 6/29/17.
  */


object test{
  def main(args: Array[String]): Unit = {

    var c1 = new Categoria("01", "def")
    var c2 = new Categoria("02", "def")
    var c3 = new Categoria("03", "def")
    var c4 = new Categoria("04", "def")

    var rc = new RegistroCategoria()
    rc.add(c1)
    rc.add(c2)
    rc.add(c3)
    rc.add(c4)

    print(rc)
    println("")
    println("")
    println(rc)

  }
}