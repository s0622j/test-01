package part3_object

import scala.util.Random

/**
 * 样例类
 * 在 Scala 中样例类是一中特殊的类，可用于模式匹配。case class 是多例的，后面要跟构造
 * 参数，case object 是单例的，无需参数
 *
 * @param id
 * @param name
 */

case class SubmitTask(id: String, name: String)

case class HeartBeat(time: Long)

case object CheckTimeOutTask

object CaseDemo04_17 extends App {
  val arr = Array(CheckTimeOutTask, HeartBeat(12333), SubmitTask("0001", "task-0001"))
  arr(Random.nextInt(arr.length)) match {
    case SubmitTask(id, name) => {
      println(s"$id, $name")
    }
    case HeartBeat(time) => {
      println(time)
    }
    case CheckTimeOutTask => {
      println("check")
    }
  }
}
