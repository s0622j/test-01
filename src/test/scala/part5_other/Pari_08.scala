package part5_other

object Pari_08 extends App {

  val b1 = new Boy("段子王", 99)
  val b2 = new Boy("laozhao", 999)

  // Boy 类没有实现 Ordered，就不能进行比较
  // 但是在类的定义中，使用视图界定 <% 就可以使用隐式方法 进行隐式转换
  // 然后 Boy 类就可以正常比较了
  implicit def man2OrderedMan2(man: Boy): Ordered[Boy] = new Ordered[Boy] {
    // 排序的规则 按照颜值 升序
    override def compare(that: Boy): Int = {
      man.facVal - that.facVal
    }
  }

  // 除了隐式方法，还可以使用隐式函数 来达到隐式转化的目的 二者选其一即可，优先使用函数
  implicit val man2OrderedMan = (boy: Boy) => new Ordered[Boy] {
    override def compare(that: Boy): Int = {
      boy.facVal - that.facVal
    }
  }
  val p1 = new Pari_08[Boy]
  val bigger = p1.bigger(b1, b2)
  print(bigger.name)

}

class Boy(val name: String, val facVal: Int) {}

class Pari_08[T <% Ordered[T]] {
  // 定义一个比较方法
  def bigger(first: T, second: T): T = {
    if (first > second) first else second
  }
}

/**
 * 总结：
 * 视图界定，如果要比较的类实现了 Ordered 特质，可以直接进行比较。
 * 视图界定支持隐式转换，如果要比较的对象没有实现 Ordered 特质，可使用隐式转换
 * 隐式转换支持：隐式函数，隐式方法，
 * Ordered 特质的类型限定，可以在类上，也可以在方法上添加隐式参数实现。
 */