import scala.collection.mutable.ListBuffer

object MutListTest {
  def main(args: Array[String]) {
    //构建一个可变列表，初始有 3 个元素 1,2,3
    val lst0 = ListBuffer[Int](1,2,3)
    println(lst0)
    //创建一个空的可变列表
    val lst1 = new ListBuffer[Int]
    //向 lst1 中追加元素，注意：没有生成新的集合
    lst1 += (4,6)
    lst1.append(5)
    //将 lst0 和 lst1 合并成一个新的 ListBuffer 注意：生成了一个新集合
    val lst2 = lst0 ++ lst1
    println(lst2 + "********")
    //将 lst1 中的元素追加到 lst0 中， 注意：没有生成新的集合
    lst0 ++= lst1
    println(lst0)
    //将元素追加到 lst0 的后面生成一个新的集合
    val lst3 = lst0 :+ 5
    println(lst3)
    //将元素追加到 lst0 的前面
    val lst4 = 5 +: lst0
    println(lst4)
    // 去除元素
    lst2 -= (1,3)
    println(lst2)
    lst2 --= List(5)
    println(lst2)
    lst2.remove(1,2) //去除元素 第一个参数是下标，第二个参数的个数
    println(lst2)
    // 判断集合是否为空
    lst2.isEmpty
    println(lst2.isEmpty)
  }
}
