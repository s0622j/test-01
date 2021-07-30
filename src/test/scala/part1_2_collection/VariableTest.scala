package part1_2_collection

object VariableTest {
  //    占位符初始化，如果是局部变量，都会报错！只能在全局变量中使用！
  var str2: String = _

  def main(args: Array[String]) {
    // 使用 val 定义的变量值是不可变的，相当于 java 里用 final 修饰的变量
    //变量名在前，类型在后
    val name: String = "nvshen"
    // 使用 var 定义的变量是可变的，在 Scala 中鼓励使用 val
    var age = 18
    age = 19
    //Scala 编译器会自动推断变量的类型，可以省略变量类型
    val str = "world"
    // 声明多个变量
    var age2, fv = 18

    println(18 / 2)
    println(19.toFloat / 2)
    //    a.formatted("%.2f")   #其中2表示保留小数位数
  }

}
