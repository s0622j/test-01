package part5_other

object ImplicitDemo_01 {
  implicit val abc = 12000
  implicit val str = "hello"

  // implicit val str2= "hello"
  def m1(x: Int)(implicit y: Int = 10) = x + y

  // 隐式参数只能放在最后一个参数列表中，m2 方法是错误的
  // def m2(x:Int)( implicit y:Int=10)(z:Int)= x + y + z
  // 有多个隐式参数的定义方式
  def m3(x: Int)(implicit y: String, z: Double = 30d) = {
    x + z
  }

  def main(args: Array[String]): Unit = {
    println(m1(1))
    println(m3(10))
  }
}

/**
 * 如果在其他的 object 中定义的隐式值，可以通过 import 对象导入：
 * import ValuesDemo._
 * 如果在其他的 class 中定义的隐式值，需要创建类的实例，然后 import 实例对象.隐式值
 * val vc = new ValueClass()
 * import vc.varparam
 * 隐式参数总结：
 * 1. 使用 implicit 关键字修饰的参数，就是隐式参数
 * 2. 一旦方法中有隐式参数，那么在调用该方法的时候，可以不用显示传递参数了
 * 3. 隐式参数值的使用顺序，优先使用上下文环境中的值（和隐式参数类型一致，而且使用
 * implicit 关键字修饰，有且只能有一个），如果上下文环境中没有，就使用默认值，默
 * 认值也没有，就报错。
 * 4. 编译器会去上下文环境中找对应的值，类型相同，变量必须使用 implicit 关键字修饰，
 * 最多只能找到一个，然后就会把这个找到的值赋予给隐式参数。如果找到多个，就报错
 * 5. 如果想设置多个隐式参数，只能在最后一个参数列表中，而且只能使用一个 implicit关键字
 *
 * 6. 我们可以把隐式的变量，写到外部的对象中，或者外部的类中，然后可以通过 import
 * 关键字导入外部的隐式变量。类必须先 new 类（）
 */