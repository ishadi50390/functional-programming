object Main extends App{
    def sumint(l:List[Int]):Int={
l.filter(_%2==0).sum
    }


    val l=List(1,2,3,4,5)
    println(s"The sum of even numbers is ${sumint(l)}")
}