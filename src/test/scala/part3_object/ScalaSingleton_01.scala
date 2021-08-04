package part3_object

/**
 * 对象-单例对象
 * Scala 中没有静态方法和静态字段，没有 static，
 * java 中，没有关键字修饰的方法，只能用 new class（）.方法
 * so 对于一个 class 来说，所有的方法和成员变量在实例被 new 出来之前都无法访问
 * 虽然可以在 class 中定义 main 方法，然并卵…
 * 但是可以使用 object 这个语法结构来达到同样的目的
 * 用 object 关键字修饰的对象是单例的，称为单例对象，静态对象。
 */

//单例对象
object ScalaSingleton_01 {
  def saySomething(msg: String) = {
    println(msg)
  }
}


object test {
  def main(args: Array[String]): Unit = {
    ScalaSingleton_01.saySomething("singleton....")
    println(ScalaSingleton_01)
    println(ScalaSingleton_01)
    // 输出结果:
    // cn.demo.ScalaSingleton$@28f67ac7
    // cn.demo.ScalaSingleton$@28f67ac7
  }
}