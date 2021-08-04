package part3_object

/**
 * 偏函数
 * 被包在大括号内没有 match 的一组 case 语句是一个偏函数，它是 PartialFunction[A, B]
 * 的一个实例，A 代表输入参数类型，B 代表返回类型，常用作输入模式匹配
 */
object PartialFuncDemo_19 {
  def func1(num: String): Int = num match {
    case "one" => 1
    case "two" => 2
    case _ => -1
  }

  def func2: PartialFunction[String, Int] = {
    case "one" => 1
    case "two" => 2
    case _ => -1
  }

  def main(args: Array[String]) {
    println(func1("one"))
    println(func2("one"))
  }
}
