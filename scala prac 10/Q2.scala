class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")
  private val g = gcd(n.abs, d.abs)
  val numer: Int = if (d < 0) -n / g else n / g
  val denom: Int = d.abs / g

  def this(n: Int) = this(n, 1)

  def neg: Rational = new Rational(-numer, denom)

  // Method to subtract two rational numbers
  def sub(that: Rational): Rational = {
    val newNumer = this.numer * that.denom - that.numer * this.denom
    val newDenom = this.denom * that.denom
    new Rational(newNumer, newDenom)
  }

  override def toString: String = s"$numer/$denom"

  // Helper method to find the greatest common divisor
  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }
}

object RationalApp {
  def main(args: Array[String]): Unit = {
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)
    val x = y.sub(z) // x = y - z
    println(x) // Outputs the result of 5/8 - 2/7
  }
}
