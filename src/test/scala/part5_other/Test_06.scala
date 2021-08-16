package part5_other

import java.util.Collections
import java.util

object Test_06 {
  //  scala 中也有类似的两个特质 Ordered 和 Ordering：
  //  Ordered 相当于 java 中的 Comparable 功能更丰富 扩展了 compare < > 等方法
  //  Ordering 相当于 java 中的 Comparator 是一个比较器
  def main(args: Array[String]): Unit = {
    val lst = new util.ArrayList[Students]()
    val s1 = new Students("reba", 23, 90)
    val s2 = new Students("abb", 33, 89)
    val s3 = new Students("ruhua", 43, 79)
    lst.add(s1)
    lst.add(s2)
    lst.add(s3)

    /**
     * Collections.sort(lst, new Ordering[Students] {
     * override def compare(x: Students, y: Students): Int = {
     * x.age - y.age
     * }
     * })
     */
    Collections.sort(lst)
    // 导入一个 java 转 scala 的标识
    import scala.collection.JavaConversions._
    // 打印
    for (s <- lst) {
      println(s)
    }
  }
}

class Students(val name: String, val age: Int, val fv: Int) extends Ordered[Students] {
  override def toString: String = s"Students($name, $age, $fv)"

  override def compare(that: Students): Int = {
    this.age - that.age
  }
}
