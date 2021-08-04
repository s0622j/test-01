package part3_object


/**
 * Option 类型
 * 在 Scala 中 Option 类型样例类用来表示可能存在或也可能不存在的值(Option 的子类有 Some 和 None)。Some 包装了某个值，None 表示没有值
 *
 */
object OptionDemo_18 {
  def main(args: Array[String]) {
    val map = Map("a" -> 1, "b" -> 2)
    val v = map.get("b") match {
      case Some(i) => i
      case None => 0
    }
    println(v)
    //更好的方式
    val v1 = map.getOrElse("c", 0)
    println(v1)
  }
}
