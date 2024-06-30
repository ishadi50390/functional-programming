object Main extends App{
def avg(a:Int,b:Int):Double={
    val average=(a+b)/2.0
    val roundedNumber = BigDecimal(average).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
        roundedNumber
}
val a=15
val b=25
println(s"The  mean is  ${avg(a,b)}")

}