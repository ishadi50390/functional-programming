object Main extends App{
def lis(s:List[String]):List[String]={
s.filter(_.length>5)



}
val str=List("Ish","Tashmika","Magallagoda")
val newl=lis(str)
println(newl)


}