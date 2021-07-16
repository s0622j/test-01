object ImmutListTest {
  def main(args: Array[String]) {
    //创建一个不可变的集合
    val lst1 = List(1, 2, 3)
    //将 0 插入到 lst1 的前面生成一个新的 List
    val lst2 = 0 :: lst1
    val lst4 = 0 +: lst1
    //将一个元素添加到 lst1 的后面产生一个新的集合
    val lst6 = lst1 :+ 3
    val lst0 = List(4, 5, 6)
    //将 2 个 list 合并成一个新的 List
    val lst7 = lst1 ++ lst0
    val lst8 = lst1 ++: lst0
    val lst9 = lst1 ::: lst0
    val lst10 = List.concat(lst1, lst0)

    println(lst1 + " ** " + lst2)
    println(lst4 + " ** " + lst6)
    println(lst0 + " ** ")
    println(lst7 + " ** " + lst8)
    println(lst9 + " ** " + lst10)
    // 列表反转
    println(lst1.reverse)
    // 列表头元素
    println(lst1.head)
    // 列表的尾列表(除了头)
    println(lst1.tail)
  }
}
