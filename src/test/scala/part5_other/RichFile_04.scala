package part5_other

import java.io.File
import scala.io.Source

//如果同时有同样功能的 隐式的方法和隐式的函数，优先使用函数。因为函数是头等公民。
object RichFile_04 {

  def main(args: Array[String]): Unit = {
    val file = new File("D:\\work\\yto\\idea_workspace\\test-01\\src\\main\\resources\\hello.txt")

    // scala 隐式转换
    implicit def file2RichFile(file: File): RichFile_04 = new RichFile_04(file)

    // 我们普通的一个 File 类，没有这样一个 read 方法，那么 scala 提供一种隐式转换的方式，
    // 会在当前的上下文环境中，去找，有没有这样一个方法，把 File 转换为另一个类，
    // 而且这个类中，有和 read 方法签名一样的方法: 方法名，方法返回值类型，方法参数
    val content: String = file.read()
    println(content)
  }

  //  自定义示例：
  //  val i: Int = 3.1415 // 此时程序会报错，因为声明的为 Int 类型

  //添加如下代码:
  implicit def double2Int(d: Double) = d.toInt // 在运行代码则没有错误，隐式方法

  val i: Int = 3.5 // 成功输出 3
}


//定义一个 RichFile 类及伴生对象，在伴生对象中定义一个隐式转换方法（file -> RichFile），
//在伴生类中定义一个 read 方法并返回文件中的所有内容。

class RichFile_04(val file: File) {
  // 使用 scala.io.Source 来读取文件， 并把结果拼接为字符串
  def read() = Source.fromFile(file).mkString
}