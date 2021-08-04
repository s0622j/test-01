package part3_object

/**
 * 偏函数本质上是由多个 case 语句组成的针对每一种可能的参数分别进行处理的一种“结构
 * 较为特殊”的函数，就是一个参数的函数。（Function1）
 */
object PartialFunctionDemo2_20 {
  def f: PartialFunction[Any, Int] = {
    case i: Int => i * 10
    case _ => 0

  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 3, 5, "seven")
    // arr.map{case t:Int =>t*10}
    val collect: Array[Int] = arr.collect {
      case t: Int
      => t * 10
    }
    println(collect)
    arr.collect(f).foreach(println)
  }
}
