object REV extends App{
    def rev(s:String):String={
if(s.isEmpty) " "
else rev(s.tail)+s.head

    }
val a="Hello"
println(rev(a))



}