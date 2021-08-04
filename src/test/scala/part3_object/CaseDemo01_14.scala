package part3_object

import scala.util.Random


/**
 * 模式匹配
 * 概念上的理解：
 * 模式 pattern 正则表达式
 * Scala 有一个十分强大的模式匹配机制，可以应用到很多场合：如 switch 语句、类型检查等。
 *
 * 并且 Scala 还提供了样例类，对模式匹配进行了优化，可以快速进行匹配
 * 模式匹配就是 match 和 一系列的 case 语法实现
 * 其中，每一个 case 里面就是一个匿名函数 =>
 * 模式匹配的基本关键字 就是 match case
 */

//匹配字符串
object CaseDemo01_14 extends App {
  val arr = Array("YoshizawaAkiho", "YuiHatano", "AoiSola")
  val name = arr(Random.nextInt(arr.length))
  name match {
    case "YoshizawaAkiho" => println("xx 老师...")
    case "YuiHatano" => println("oo 老师...")
    case _ => println("真不知道你们在说什么...")
  }
}
