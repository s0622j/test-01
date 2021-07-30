package part1_2_collection

object ImmutSetTest {
  def main(args: Array[String]) {
    // 默认是 immtable 包下的 Set
    val set1 = Set(1, 4, 6)
    // 执行添加,删除的操作，都是生成了新的 Set 集合
    val s2: Set[Int] = set1 + (10, 12)
    set1 - (1)
    println(set1 - (1))
    println(set1)
    // 查看 set 集合内容
    set1.foreach(println)
    //set 中元素不能重复
    val set3 = set1 ++ Set(5, 6, 7)
    val set0 = Set(1, 3, 4) ++ set1
    println(set3 + "*****\n" + set0)
  }
}
