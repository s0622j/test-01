import scala.collection.mutable

object MutSetTest {
  //  可变 Set 中，remove 方法，移除的是元素，而不是下标
  def main(args: Array[String]) {
    import scala.collection.mutable.Set // 可以在任何地方引入 可变集合
    val mSet = new mutable.HashSet[Int]()
    val mutableSet = Set(1, 2, 3)
    mutableSet.add(4)
    // mutableSet += 5
    mutableSet += (5, 15)
    // 添加 set 集合
    mutableSet ++= Set(12, 14)
    // mutableSet -= 4
    mutableSet -= (4, 2)
    println(mutableSet)
    // remove 方法，删除的不是下标，而是元素
    mutableSet.remove(2)
    mutableSet.remove(14)
    println(mutableSet)
    // 转换为不可变集合
    val another = mutableSet.toSet
    println(another.getClass.getName) // scala.collection.immutable.Set

    /**
    // Option 是 Some 和 None 的父类
    // Some 代表有（多例），样例类
    // None 代表没有（单例），样例对象
    val mp = Map("a" -> 1, "b" -> 2, "c" -> 3)
    val r: Int = mp("d")
    // Map 的 get 方法返回的为 Option, 也就意味着 rv 可能取到也有可能没取到
    val rv: Option[Int] = mp.get("d")
    // 如果 rv=None 时， 会出现异常情况
    val r1 = rv.get
    // 使用 getOrElse 方法，
    // 第一个参数为要获取的 key,
    // 第二个参数为默认值， 如果没有获取到 key 对应的值就返回默认值
    val r2 = mp.getOrElse("d", -1)
    println(r2)
     */
  }
}
