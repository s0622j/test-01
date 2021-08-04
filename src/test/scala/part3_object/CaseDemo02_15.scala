package part3_object

import scala.util.Random

//匹配类型
//注意：case y: Double if(y >= 0) => ...
//模式匹配的时候还可以添加守卫条件。如不符合守卫条件，将掉入 case _中
object CaseDemo02_15 extends App {
  //val v = if(x >= 5) 1 else if(x < 2) 2.0 else "hello"
  val arr = Array("hello", 1, 2.0, CaseDemo02_15)
  val v = arr(Random.nextInt(arr.length))
  println(v)
  v match {
    case x: Int => println("Int " + x)
    case y: Double if (y >= 0) => println("Double " + y) // if 守卫
    case z: String => println("String " + z)
    case CaseDemo02_15 => {
      println("case demo 2")
      //throw new Exception("not match exception")
    }
    case _ => throw new Exception("not match exception")
  }
}
