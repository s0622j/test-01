package part1_2_collection

object CollectionTest {
  def main(args: Array[String]): Unit = {


    val arr = Array("aa", "bb", "cc", "dd")
    //    arr.reduce((x,y)=>自定义操作)
    //    自定义操作的方法，必须是 x 数据类型上支持的方法。x 可以是任意类型
    arr.reduce(_ + _) // String = aabbccdd
    arr.reduce(_ ++ _) // String = aabbccdd
    val lst = List(List("a"), List("b"), List("c"))
    lst.reduce(_ ++ _) // List[String] = List(a, b, c)
    lst.reduce(_ ::: _) // List[String] = List(a, b, c)

    //    reduceLeft reduceRight
    //    reduce 底层调用的就是 reduceLeft,只不过，reduce 要求函数的输入类型和返回值类型必须一致，而 reduceLeft,可以不一致。
    //    fold foldLeft foldRight
    //    fold 有两个参数，第一个参数是默认值，第二个参数是一个函数，该函数有两个参数 累加值 元素值 调用的就是 reduceLeft
    //    fold 要求函数的 2 个输入参数类型必须一致，foldLeft 可以允许函数的 2 个输入参数类型不一致

    //    示例：求平均值
    val d1 = Array(("bj", 28.1), ("sh", 28.7), ("gz", 32.0), ("sz", 33.1))
    val d2 = Array(("bj", 27.3), ("sh", 30.1), ("gz", 33.3))
    val d3 = Array(("bj", 28.2), ("sh", 29.1), ("gz", 32.0), ("sz", 30.5))
    // 1,需要把数据组装到一起
    val data1: Array[(String, Double)] = d1.union(d2).union(d3) // d1 union d2 union d3
    //d1 ++ d2 ++ d3
    // 2 分组 按照城市名称来分组
    val data2: Map[String, Array[(String, Double)]] = data1.groupBy(t => t._1)
    // 统计
    val data4 = data2.mapValues(kv => {
      var v = kv.flatMap(v => v._2.toString.split(" "))
      var sum = 0d
      for (e <- v) {
        sum = sum + e.toDouble
      }
      sum



      // kv 数据类型： Array[(String,Double)]
      // t 的数据类型是元组（String,Double）

    })
    println("--------111------------")
    println(data4)
    // 3 统计 拿到这几个月份的温度的总值，然后再求平均
    val result: Map[String, Double] = data2.map {
      t =>
        // t (String,Array[(String, Double)])
        val city = t._1
        // foldLeft 第一个是累加值 第二个是元素值
        val wendu: Double = t._2.foldLeft(0d)({
          // total 是 Double a 是(String, Double)
          (total, a) =>
            total + a._2
        }) / t._2.length
        (city, wendu)
    }
    println(result)


    println("*********************************")
    /**
     * 交集，并集 差集
     * intersect union diff
     * union 是一个轻量级的方法
     * //比较常用的方法：先 union，然后再分组
     * distinct 元素去重
     * mkString 把集合中的所有元素拼接成字符串
     * mkString(分隔符)
     * take(n) 获取集合中前几个元素 没有排序
     * slice(from,until) 截取元素，提取元素列表中的 from 到 until 位置的元素
     * 聚合 aggregate
     * val arr = List(List(1, 2, 3), List(2))
     * val result = arr.aggregate(0)(_+_.sum, _+_)
     */
    val arr001 = Array("aa", "bb", "cc", "dd")
    val arr002 = Array("11", "22", "cc", "dd")

    println(arr001.intersect(arr002).toBuffer)
    println(arr001.union(arr002).toBuffer)
    println(arr001.diff(arr002).toBuffer)
    println(arr001.diff(arr002).distinct.toBuffer)
    println(arr001.union(arr002).mkString(","))
    println(arr001.union(arr002).take(3).toBuffer)
    println(arr001.union(arr002).slice(2, 3).toBuffer)
    val arr003 = List(List(1, 2, 3), List(2))
    println(arr003.aggregate(0)(_ + _.sum, _ + _))

  }

  //  def arrSum(arr: Array[(String, Double)]): Int = {
  //    for()
  //    1
  //  }


}
