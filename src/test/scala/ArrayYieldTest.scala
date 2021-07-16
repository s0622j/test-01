object ArrayYieldTest {
  def main(args: Array[String]) {
    //定义一个数组
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    //将偶数取出乘以 10 后再生成一个新的数组
    val res = for (e <- arr if e % 2 == 0) yield e * 10
    println(res.toBuffer)
    //更高级的写法,用着更爽
    //filter 是过滤，接收一个返回值为 boolean 的函数
    //map 相当于将数组中的每一个元素取出来，应用传进去的函数
    val r = arr.filter(x => x % 2 == 0).map(x => x * 10)
    println(r.toBuffer)


    val arr2 = Array(2, 5, 1, 4, 3)
    println(arr2.sum)
    println(arr2.max)
    println(arr2.sorted.toBuffer)
    println(arr2.sortWith(_ < _).toBuffer)

    println("==============sorted排序=================")
    println(arr2.sorted.mkString(",")) //升序
    println(arr2.sorted.reverse.mkString(",")) //降序
    println("==============sortBy排序=================")
    println(arr2.sortBy(d => d).mkString(",")) //升序
    println(arr2.sortBy(d => d).reverse.mkString(",")) //降序
    println("==============sortWith排序=================")
    println(arr2.sortWith(_ < _).mkString(",")) //升序
    println(arr2.sortWith(_ > _).mkString(",")) //降序

    val doubles: Array[Double] = Array(3.4, 1.2, 0.8, 9.4, 3)
    val arr3 = doubles
    println("avg:" + avgArr(arr2))
    println("T:" + arrT(arr3))
  }

  //定义一个方法或函数，求 Int 数组的平均值
  def avgArr(arr: Array[Int]): Double = {
    arr.sum.toFloat / arr.length
  }

  //定义一个方法或函数，求一个 Double 数组的最大值和最小值，返回两个最值组成的元组。
  def arrT(arr: Array[Double]) = {
    (arr.sortWith(_ > _)(0), arr.sortWith(_ < _)(0))
  }
}
