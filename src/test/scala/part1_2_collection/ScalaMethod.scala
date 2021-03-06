package part1_2_collection

/**
 * 方法的定义及调用
 *
 * 定义方法的格式为:
 * def methodName ([list of parameters]) : [return type] = {}
 * 如果不使用等号和方法体，则隐式声明抽象(abstract)方法。
 */
object ScalaMethod extends App {
  // 定义个 sum 方法, 该方法有 2 个参数, 参数类型为整型, 方法的返回值为整型
  def sum(a: Int, b: Int): Int = {
    a + b
  }

  // 定义有可变参数的方法,
  def sumAll(b: Int*): Int = {
    var v = 0
    for (i <- b) {
      v += i
    }
    v // 返回值
  }

  // 调用
  val result1 = sum(1, 5)
  println(result1)
  println(sumAll(1, 11, 13))

  // 该方法没有任何参数, 也没有返回值
  def sayHello1 = println("Say BB1")

  def sayHello2() = println("Say BB2")

  sayHello1 // 如果方法没有() 调用时不能加()
  sayHello2() // 可是省略(), 也可以不省略

  //  方法总结：
  //  1，定义方法的关键字，def
  //  格式： def 方法的名称（参数列表）：返回值类型 = {方法体内容}
  //  2，方法的返回值，最后一行的内容，如果是循环，那么返回值是 Unit
  //    3，如果空参方法，定义的时候有（），调用的时候可以省略（），但是如果定义的时候没
  //  有（），调用方法的时候，不能加（）
  //  4，方法的返回值类型，可以省略，但是特殊情况下，必须加上：
  //  4.1,方法有 return 关键字
  //  4.2，递归调用的方法。
  //  5，方法不能成为最终的表达式存在，（空参的方法调用除外）


  // *********************************************************
  /**
   *
   * 定义函数(和方法类似，基本能实现相同的功能)
   * val| var 函数名称=（函数的参数列表） => 函数体
   *
   * 第二种定义方式：复杂全面的定义
   * val | var 函数名称：（输入参数类型）=> 返回值类型 = （参数的引用）=> 函数体
   * 不同于方法，没有参数的函数定义，也必须加()
   * val f2:()=>Unit =() => println(123)  val f2 =() => println(123) 返回值类型为 Unit
   * val f2:()=>Int =() => 123   val f2=() => 123 返回值类型为 Int
   */
}
