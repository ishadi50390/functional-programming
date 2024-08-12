object Q2 {
  def main(args: Array[String]): Unit = {
  
      print("Enter an integer: ")
      val number = scala.io.StdIn.readInt()
      
      val isMultipleOfThree: Int => Boolean = _ % 3 == 0
      val isMultipleOfFive: Int => Boolean = _ % 5 == 0
      
      val message = (number match {
        case _ if isMultipleOfThree(number) && isMultipleOfFive(number) => "Multiple of Both Three and Five"
        case _ if isMultipleOfThree(number) => "Multiple of Three"
        case _ if isMultipleOfFive(number) => "Multiple of Five"
        case _ => "Not a Multiple of Three or Five"
      })
      
      println(message)
    
  }
}
