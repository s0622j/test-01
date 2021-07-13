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



  val t = (12.3, 1000, "spark")
  val t1 = new Tuple1(1) // 必须 1 个元素
  val t4 = new Tuple4(1,2.0,"",3) // 必须 4 个元
}
//
//方法和函数的总结（重点）：
//1，方法的定义 使用 def 关键字 函数的定义 使用 =>
//函数有两种定义方式
//val f = (x:Int,y:Int) => x + y
//val f:(Int,Int) => Int = (x,y) => if(x>y) x else y
//2，方法不能作为最终的表达式存在，但是函数可以作为最终的表达式存在，返回函数签名
//函数签名：函数的名称，参数类型，返回值类型 函数的别名（函数参数个数）
//3，方法和函数的调用，方法和函数可以相互调用。
//方法名称（参数列表） 函数名称（参数列表）
//无参的方法可以省略（），无参的函数不能省略括号
//4，函数是一等公民，可以作为方法的参数和返回值类型。
//函数作为方法的参数： 定义方法的时候，函数参数规范（函数的名称，参数类型，返
//回值类型），然后在调用方法的时候，传递的是一个已存在的函数，或者是一个匿名函数。
//都要求传入的函数，必须满足定义的规范，使用匿名函数的时候，可以省略参数类型((x,y)=>x*y)
//函数最为方法的返回值类型，当调用方法的时候，返回函数，传入参数进行函数的调用。
//5，方法可以转化为函数，通过在方法名称 _ ,另外当方法的参数是一个函数的时候，满足
//条件的方法会被自动转换为函数，进行传递。
//方法和函数应该怎么使用？
//一般情况下，优先使用函数
//实际上，还是定义方法使用的更多，函数会作为方法的参数。
//最最常用的：调用方法的时候传递函数