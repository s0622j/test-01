object TupleTest {

  def main(args: Array[String]): Unit = {
    val t: (Double, Int, String) = (12.3, 1000, "spark")
    val t1 = new Tuple1(1) // 必须 1 个元素
    val t4 = new Tuple4(1,2.0,"",3) // 必须 4 个元

    println(t4._1)
    //zip 命令可以将多个值绑定在一起，生成元组
    val name=Array("xx1","xx2","xx3","xx4")
    val values=Array(1,2,3)
    var tt = name.zip(values)  // 拉链操作 zip 命令可以将多个值绑定在一起，生成元组
    println("长度："+tt.length)
    println("长度0："+tt(0))
    for (x <- tt){
      println(x)
    }

    println("***************************************")
    // 定义元组
    var ttt = (1, "hello", true)
    // 或者
    val tuple3 = new Tuple3(1, "hello", true)
    // 访问 tuple 中的元素
    println(ttt._2) // 访问元组总的第二个元素
    // 对偶元组
    val tuple2 = (1, 3)
    // 交换元组的元素位置, tuple2 没有变化, 生成了新的元组
    val swap = tuple2.swap
    println(swap)

    /**
     * 元组类型 Tuple1，Tuple2，Tuple3 等等。目前在 Scala 中只能有 22 个上限，如果需要更多个元素，那么可以使用集合而不是元组
     */

  }
}
