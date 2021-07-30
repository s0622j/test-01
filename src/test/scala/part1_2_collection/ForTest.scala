package part1_2_collection

object ForTest {
  def main(args: Array[String]) {
    //for(i <- 数组)
    val arr = Array("a", "b", "c", "d", "e", "f")
    // 遍历打印数组中的每个元素
    for (i <- arr) // 类似 Java 中的增强 for
      println(i)
    // 通过角标获取数组中的元素
    val index = Array(0, 1, 2)
    // 遍历打印数组中的每个元素
    for (i <- index) // 类似 Java 中的传统 for
      println(arr(i)) // 获取元素的方式是（），java 中是[]
    //for(i <- 表达式),表达式 1 to 10 返回一个 Range（区间）
    //每次循环将区间中的一个值赋给 i
    //      for (i <- 1 to 6)
    //        println(i)
    //        println(arr(i)) // 报错，如果不加{}，只会把 for 后面的一行当做循环的内容。
    for (i <- 1 to 2) {
      println(i)
      println(arr(i))
    }
    for (i <- 1 until 2) { // 0 until 6 => 会生成一个范围集合 Range(0,1,2,3,4,5)
      println(arr(i))
    }
    // 打印数组中的偶数元素
    // 在 for 循环中，通过添加守卫来实现输出满足特定条件的数据
    val arr2 = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for (e <- arr2 if e % 2 == 0) { // for 表达式中可以增加守卫
      println(e)
    }
    //高级 for 循环
    //每个生成器都可以带一个条件
    for (i <- 1 to 3; j <- 1 to 3 if i != j) {
      print((10 * i + j) + " ")
    }
    //for 推导式：如果 for 循环的循环体以 yield 开始，则该循环会构建出一个集合
    //每次迭代生成集合中的一个值
    val v = for (i <- 1 to 10) yield i * 10
    println(v)

    //    两个生成器： to until
    //      1 to 10 生成 Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) 左闭右闭区间 [ ]
    //      1 until 10 生成 Range(1, 2, 3, 4, 5, 6, 7, 8, 9) 左闭右开区间 [ )
    //    for 循环总结：
    //    循环的标识： <-
    //    增强 for 循环: for(I <- arr)
    //      普通 for 循环： to until
    //      带守卫的 for 循环 （if 条件）
    //    嵌套 for 循环 （for(i<- 1 to 3 ;j <- 1 to 3 if( I != j )))）
    //    yield 推导式 返回一个满足条件的数组


    println("**************************************************")
    var i = 0
    //    while(i<5) {
    //      println(i)
    //      i += 1 // i = i + 1
    //    }

    //    Scala 也有 do-while 循环，它和 while 循环类似，只是检查条件是否满足在循环体执行之后检查。
    i = 0
    // while 直接判断
    while (i >= 0 && i <= 5) {
      println(i)
      i += 1
    }

    i = 0
    // do while 先执行一次循环，再进行判断
    do {
      println(i)
      i += 1
    } while (i > 0 && i <= 5)

    i = 1
    //    循环也有返回值，只不过都是 Unit
    val res = while (i > 0 && i <= 5) {
      println(i)
      i += 1
    }
    println(s"res = $res")
  }
}
