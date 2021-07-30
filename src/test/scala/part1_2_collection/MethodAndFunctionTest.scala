package part1_2_collection

object MethodAndFunctionTest {
  //定义一个方法
  //方法 m2 参数要求是一个函数，函数的参数必须是两个 Int 类型
  //返回值类型也是 Int 类型
  def m1(f: (Int, Int) => Int): Int = {
    f(2, 6)
  }

  //定义一个函数 f1，参数是两个 Int 类型，返回值是一个 Int 类型
  val f1 = (x: Int, y: Int) => x + y
  //再定义一个函数 f2
  val f2 = (m: Int, n: Int) => m * n

  //main 方法
  def main(args: Array[String]) {
    //调用 m1 方法，并传入 f1 函数
    val r1 = m1(f1)
    println(r1)
    //调用 m1 方法，并传入 f2 函数
    val r2 = m1(f2)
    println(r2)

    //**************
    println(max(10, 20))
    println(max1((x: Int, y: Int) => if (x > y) x else y))
    println(max2((x: Int, y: Int) => if (x > y) x else y, 10, 20))
    println(max3()(10, 20))
  }


  //**************************************//
  // 定义一个普通方法
  def max(x: Int, y: Int) = if (x > y) x else y

  // 定义一个方法，参数是一个函数，参数只需要函数签名，在调用的时候具体再传入函数体
  def max1(f: (Int, Int) => Int) = f(20, 10)

  def max2(f: (Int, Int) => Int, x: Int, y: Int) = f(x, y)

  // 定义一个方法，方法返回值是函数
  def max3() = (x: Int, y: Int) => if (x > y) x else y


  def method1(f: (Int, Int) => Int): Int = {
    // 可以调用函数
    f(1, 100)
  }

  def max5(x: Int, y: Int) = x * y

  method1(max5 _)
  method1(max5) // 方法自动转换为函数
  println(method1(max5 _))
  println(method1(max5))


}
