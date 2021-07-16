object MapTest {
  def main(args: Array[String]): Unit = {
    /**
     * 在 Scala 中，有两种 Map，一个是 immutable 包下的 Map，该 Map 中的内容不可变；
     * 另一个是 mutable 包下的 Map，该 Map 中的内容可变。
     */
    // 默认是 immtable 包下的 Map
    val mp1 = Map(("a", 1), ("b", 2))
    val mp2 = Map("a" -> 1, "b" -> 2)
    // 添加元素之后生成新的 map
    val mp3 = mp2 + ("c" -> 1)

    println(mp1 + "\n" + mp2 + "\n" + mp3)

    // 导包
    import scala.collection.mutable
    // 创建集合
    val mp4 = new mutable.HashMap[String, Int]()
    val mp5 = mutable.Map[String, Int]()

    mp4 += ("e" -> 8, "f" -> 9)
    mp4 += (("b1", 121))
    mp4.put("lyf", 21)
    mp4("nvshen") = 18
    println(mp4)

    //    获取映射值
    //    判断 key 是否存在 contains
    mp4.clear()
    mp4 += (("a", 1), ("b", 2))
    println(mp4.contains("b"))
    println(mp4("a"))
    println(mp4.get("xxoo"))
    //    如果没有值，赋予默认值：
    println(mp4.getOrElse("xxoo", 9527))


    val m1 = mutable.Map[String, Int]()
    m1 += (("a", 1), ("b", 2))
    //    赋值和修改值
    println(m1.getOrElse("d", 33))
    println(m1)
    m1("b") = 22
    println(m1)
    //    m1.updated("b",22) // 如果是不可变的 Map,那么会生成一个新的 map 集合
    //    删除元素
    //    根据 key 来删除一个或多个值
    m1 -= ("a")
    m1.remove("a")
    println(m1)
    //    去除多个 key：
    m1 -= ("a", "b")
    println(m1)
    m1 += (("a", 1), ("b", 2), ("d", 33))
    m1 --= List("a")
    println(m1)

    println("*******************************************")
    val mp = mutable.HashMap[String, Int]()
    mp += (("a", 1), ("b", 2), ("d", 33))
    //    map 遍历
    for (i <- mp) println(i)
    for ((k, v) <- mp) {
      println(k); println(v)
    }
    for ((_, v) <- mp) {
      println(v)
    }
    //    _是占位符，如果只需要遍历 value，不需要遍历 key，就可以用占位符
    //    交换 k,v
    for ((k, v) <- mp) yield (v, k)
    println(mp)
    val mp222 = mp.map(x => (x._2, x._1))
    println(mp222)
    val mp333 = mp.map(x => x.swap)
    println(mp333)
    //    获得 keys 和 values
    println(m1.keys) //Set(b, d)
    println(m1.values) //HashMap(2, 33)


    //    合并
    //    使用 ++ 运算符或 mp.++() 方法来连接两个 Map，Map 合并时会移除重复的 key。
    // 合并时，相同的 key 元素会被覆盖
    val colors1 = Map("nvshen" -> 18, "nanshen" -> 35)
    val colors2 = Map("bq" -> 40, "nvshen" -> 20)
    var colors = colors1 ++ colors2
    println(colors)

    println("*********************")
    //    map|flatten|flatMap|foreach 方法的使用
    // 定义一个数组
    val array = Array[Int](2, 4, 6, 9, 3)
    // map 方法是将 array 数组中的每个元素进行某种映射操作, (x: Int) => x * 2 为一个匿名函数, x 就是 array 中的每个元素
    val y = array map ((x: Int) => x * 2)
    // 或者这样写, 编译器会自动推测 x 的数据类型
    val z = array.map(x => x * 2)
    // 亦或者, _ 表示入参, 表示数组中的每个元素值
    val x = array.map(_ * 2)
    println(x)
    println(x.toBuffer)

    println("--------分割线--------")
    // 定义一个数组
    val words = Array("hello tom hello jim hello jerry", "hello Hatano")
    // 将数组中的每个元素进行分割
    // Array(Array(hello, tom, hello, jim, hello, jerry), Array(hello, Hatano))
    val splitWords: Array[Array[String]] = words.map(wd => wd.split(" "))
    println(splitWords.toBuffer)
    splitWords.foreach(println)
    // 此时数组中的每个元素经过 split 之后变成了 Array, flatten 是对 splitWords 里面的元素进行扁平化操作
    // Array(hello, tom, hello, jim, hello, jerry, hello, Hatano)
    val flattenWords = splitWords.flatten
    println(flattenWords.toBuffer)
    // 上述的 2 步操作, 可以等价于 flatMap, 意味先 map 操作后进行 flatten 操作
    val result: Array[String] = words.flatMap(wd => wd.split(" "))
    // 遍历数组, 打印每个元素
    println(result.toBuffer)
    result.foreach(println)

    println("--------分割线--------")
    // 定义一个数组
    val words2 = Array("hello tom hello star hello sheep", "hello tao hello tom")
    val wc = words2.flatMap(_.split(" ")) // 对数组中的每个元素进行切分, 并进行扁平化操作
      .map((_, 1)) // 将数组的每个元素转换成一个对偶元组, 元组的第二个元素为 1
      .groupBy(_._1) // 对集合中的所有元素进行按单词分组, 相同单词的元组分到一组
      .mapValues(_.length) // 对每个 key 的 value 集合进行求长度操作
      .toList // 将 map 转换成 List
    println(wc)

    // 实现方式二
    val stringToStrings: Map[String, Array[String]] = words2.flatMap(_.split(" ")).groupBy(x => x)
    val wc2 = stringToStrings.map(t => (t._1, t._2.length)).toList
    println(wc2)
  }
}
