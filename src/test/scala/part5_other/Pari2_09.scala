package part5_other

/**
 * Context bounds
 * [ T : Test ]
 * 与 view bounds 一样 context bounds(上下文界定)也是隐式的语法。
 * 这种形式要求存在一个 Test[T]类型的隐式值
 */

object Pari2_09 extends App {

  val b1 = new Boy2("段子王", 99)
  val b2 = new Boy2("laozhao", 999)
  // 没有 implicit Ordering 被定义 不能比较
  // 方法一：定义一个变量,类型为要求的比较器类型 Ordering[Boy2]
  implicit val b2Ordering: Ordering[Boy2] = new Ordering[Boy2] {
    override def compare(x: Boy2, y: Boy2): Int = x.facVal - y.facVal
  }
  // 方法二：定义一个隐式值（隐式 object） 继承自比较器类型
  // implicit object man2Ordering extends Ordering[Boy2] {
  // override def compare(x: Boy2, y: Boy2): Int = {
  // x.facVal - y.facVal
  // }
  // }
  // 在创建比较对象时，进行隐式转换
  val p = new Pari2_09[Boy2]
  val re = p.bigger(b1, b2)
  println(re.name)
}

class Pari2_09[T: Ordering](implicit ord: Ordering[T]) {
  def bigger(first: T, second: T) /*(implicit ord:Ordering[T])*/ : T = {
    if (ord.gt(first, second)) first else second
  }
}

class Boy2(val name: String, val facVal: Int)