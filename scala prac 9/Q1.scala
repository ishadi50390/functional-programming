object InterestCalculator {
  val calculateInterest: Double => Double = deposit => 
    if (deposit <= 20000) deposit * 0.02
    else if (deposit <= 200000) deposit * 0.04
    else if (deposit <= 2000000) deposit * 0.035
    else deposit * 0.065

  def main(args: Array[String]): Unit = {
    val deposit = 800000.0
    val interest = calculateInterest(deposit)
    println(s"The interest for a deposit of Rs. $deposit is Rs. $interest")
  }
}
