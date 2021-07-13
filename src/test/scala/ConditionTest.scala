object ConditionTest {
  def main(args: Array[String]) {
    val x = 1
    //判断 x 的值，将结果赋给 y
    val y = if (x > 0) x else -1
    //打印 y 的值
    println(y)
    //如果缺失 else，相当于 if (x > 2) 1 else ()
    val m = if (x > 2) 1
    println(m)
    //在 scala 中每个表达式都有返回值，scala 中有个 Unit 类，写做(),相当于 Java 中的 void
    val n = if (x > 2) 1 else ()
    println(n)
    //支持混合类型表达式
    val z = if (x > 1) 1 else "error"
    //打印 z 的值
    println(z)
//    混合类型会返回父类类型。
    //if 和 else if
    val k = if (x < 0) 0 else if (x >= 1) 1 else -1
    println(k)
  }
}
