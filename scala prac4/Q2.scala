import scala.io.StdIn.readInt;

object Q2 {

  def Q2(a: Int): Unit = a match {
    case a if (a <= 0)     => print("negative number");
    case a if (a % 2 == 0) => print("even number");
    case a if (a % 2 != 0) => print("odd number");
  }
  def main(args: Array[String]): Unit = {
    println("enter number:");
    var a = readInt();
    
    Q2(a);

  }
}