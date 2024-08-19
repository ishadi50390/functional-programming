import scala.io.StdIn.readInt

object PatternMatching{
    val matchInput: Int => String = (num: Int) => num match {
    case n if n <= 0  => "Negative/Zero"
    case n if n % 2 == 0 => "Even number"
    case n if n % 2 != 0 => "Odd number"
  }

       def main(args: Array[String]): Unit = {
    println("Please enter an integer: ")
    val input = readInt()

    val result = matchInput(input)

    println(result)
  }
}
