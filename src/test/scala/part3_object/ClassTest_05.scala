package part3_object

object ClassTest_05 {
  val name: String = "zhangsan"

  def main(args: Array[String]): Unit = {
    // 调用空参构造器,
    val student = new Student()
    student.name = "laowang"
    // 类中使用 val 修饰的变量不能更改
    // student.age = 20
    println(s"student.name ====== ${student.name} ${student.age}")
    println("Test.name ======" + ClassTest_05.name)
  }
}

class Student {
  val id = 666
  // _ 表示一个占位符, 编译器会根据变量的具体类型赋予相应初始值
  // 注意: 使用_ 占位符是, 变量类型必须指定
  var name: String = _
  //用 var 修饰的变量既有 getter 又有 setter
  var age: Int = 20
}

/**
 * 类的定义
 * 在 Scala 中，类并不用声明为 public。
 * Scala 源文件中可以包含多个类，所有这些类都具有公有可见性。
 * var 修饰的变量, 这个变量对外提供 getter setter 方法
 * val 修饰的变量,是只读属性 对外提供了 getter 方法,没有 setter（相当于 java 中用 final 修饰的变量）
 */