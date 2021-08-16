package part5_other

object Test_05 {
  def main(args: Array[String]): Unit = {
    val s = new StrMessage("i hate you !")
    val i = new IntMessage(100)
    println(s.get)
    println(i.get)
    // 定义一个函数，可以获取各类 List 的中间位置的值
    val list1 = List("a", "b", "c")
    val list2 = List(1, 2, 3, 4, 5, 6)

    // 定义一个方法接收任意类型的 List 集合
    def getData[T](l: List[T]) = {
      l(l.length / 2)
    }
  }
}

// 在 Scala 定义泛型用[T]， s 为泛型的引用
abstract class Message[T](s: T) {
  def get: T = s
}

// 子类扩展的时候，约定了具体的类型
class StrMessage[String](msg: String) extends Message(msg)

class IntMessage[Int](msg: Int) extends Message(msg)