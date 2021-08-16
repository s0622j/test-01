package part5_other

object TestBGirl extends App {
  // 普通的 int 类型没有实现 Ordered 特质，无法进行比较
  val i: Int = 10
  val j: Int = 20
  // val com = new TestOrderedCompare[Int]
  // val result = compare.bigger(i,j)
  // println(res.name)
  // class BGirl 实现了 Ordered 特质，所以可以传入比较器中进行比较
  private val g1 = new BGirl("ab", 95, 30)
  private val g2 = new BGirl("hatono", 95, 28)
  val compare = new TestOrderedCompare[BGirl]
  val res = compare.bigger(g1, g2)
  println(res.name)

  /** **************************************************************** */
  //  下界示例：
  val arr = Array[Int](1, 3, 5, 6)
  val f0: (AnyVal, AnyVal) => AnyVal = (x, y) => 100
  val f: (AnyVal, AnyVal) => AnyVal = (x, y) => if (!x.isInstanceOf[Unit]) x.asInstanceOf[Int] + y.asInstanceOf[Int]
  val f2: (String, String) => String = (x, y) => "x"
  println(arr.reduce(f)) // 正确：因为 泛型 A 的类型是 Int，由 arr 的类型决定的，而且 AnyVal 是 Int 类型的父类，所以 f 可以传递
  // println(arr.reduce(f2)) // 错误，因为 String 类型不是 Int 类型的父类，所以这里不能传递
}

// 定义一个 class 实现了 Ordered 特质
class BGirl(val name: String, val facVal: Int, val age: Int) extends Ordered[BGirl] {
  // 重写 compare 方法
  override def compare(that: BGirl): Int = {
    // 比较 颜值相同，比较年龄 ; 如果颜值不同，就比较颜值
    if (this.facVal == that.facVal) {
      this.age - that.age
    } else {
      this.facVal - that.facVal
    }
  }
}

// 泛型限制了上界，比较的类型必须是 Ordered 的子类或者实现类
class TestOrderedCompare[T <: Ordered[T]] {
  // 定义一个比较方法 使用> 比较
  def bigger(first: T, second: T): T = {
    if (first > second) first else second
  }
}