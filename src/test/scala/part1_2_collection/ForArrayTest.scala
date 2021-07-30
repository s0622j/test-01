package part1_2_collection

object ForArrayTest {
  def main(args: Array[String]) {
    //初始化一个数组
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8)
    //增强 for 循环
    for (i <- arr)
      println(i)
    //好用的 until 会生成一个 Range
    //reverse 是将前面生成的 Range 反转
    for (i <- (0 until arr.length).reverse)
      println(arr(i))

    println("-----------------------------")
    for (i <- (arr.length - 1 until(-1, -1))) {
      println((arr(i), i))
    }

    for (i <- (arr.length - 1 to(0, -1))) {
      println((arr(i), i))
    }
    println("*****************************")

    //    Scala to和until的区别
    //    1 to 10 生成 1到10的数字 包括10  //to  每次迭代为1
    for (i <- 1 to 10) println(i)
    //    1 until 10 生成 1直到10的数字 不包括10  //Range:until  (包前不包后,每次迭代为1)
    for (i <- 1 until 10) println(i)
    //    by的使用
    //    by是步长
    //    1 to 10 by 2 就是产生公差为2的范围在从1到10内的等差数列
    for (i <- 1 to 10 by 2) println(i)
  }
}
