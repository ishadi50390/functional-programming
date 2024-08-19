object NameFormatter {
//toUpper function
  def toUpper(str: String): String = str.toUpperCase
//toLower function
  def toLower(str: String): String = str.toLowerCase
//formatNames function
  def formatNames(name: String)(formatFunc: String => String): String = {
    formatFunc(name)
  }

  def main(args: Array[String]): Unit = {

    println(formatNames("Benny")(toUpper)) 

    println(formatNames("Niroshan")(name => toUpper(name.substring(0, 2)) + name.substring(2))) 

    println(formatNames("Saman")(toLower)) 
    println(formatNames("Kumara")(name => toUpper(name.substring(0, 1)) + name.substring(1, name.length - 1).toLowerCase + toUpper(name.substring(name.length - 1)))) 
  }
}
