package part5_other

import java.io.File
import scala.io.Source

//案例：现在我们就可以给 File 类添加一个 read 方法，返回一个文件中的所有内容。
//方案 1：使用装饰模式实现 File 类的 read 方法增强：
object RichFile_03 {
  def main(args: Array[String]): Unit = {
    val file = new File("D:\\work\\yto\\idea_workspace\\test-01\\src\\main\\resources\\hello.txt")
    // File 类中并没有 read 方法来返回所有的内容
    //    file.read()
    // 使用装饰模式
    val rf: RichFile_03 = new RichFile_03(file)
    val content = rf.read()
    println(content)
  }
}


class RichFile_03(val file: File) {
  // 使用 scala.io.Source 来读取文件， 并把结果拼接为字符串
  def read() = Source.fromFile(file).mkString
}