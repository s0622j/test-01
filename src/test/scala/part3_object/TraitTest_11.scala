package part3_object

object TraitTest_11 {
  def main(args: Array[String]): Unit = {
    // 动态混入特征，让类有了特质的方法
    val t1 = new Teacher with T1
    println(t1.youcanfly())
    // 动态混入特质不能使用 extends 关键字,可同时混入多个特质
    val t = new Teacher() with T1 with T2 {
      // 如果特质中有抽象方法，则必须重写该抽象方法，可以不使用 override 关键字
      def teacherSay(name: String) = {
        println(s"最高 face，${name}")
      }

      // 重写一个有具体的实现的方法，必须使用关键字 override
      override def doSomething() = {
        println("群主:抢到红包继续接龙...")
      }
    }
    println(t.teacherSay("laozhao"))
    println(t.doSomething)
    println(t.youcanfly())
  }
}

class Teacher {
}

/**
 * 特质 Trait
 * scala 中没有 interface implements
 * Trait(特质)相当于 java 的接口。比接口功能更强大。特质中可以定义属性和方法的实现。
 * Scala 的类只能够继承单一父类，但是可以实现（继承，混入）多个特质（Trait）使用的关
 * 键字是 with 和 extends
 * 特质不能有任何的类参数，即传递给类的主构造器的参数。
 * trait PointTest(x: Int, y: Int) // 编译不过
 */

/**
 * 比较：scala 的 trait 和 java 中的 interface 的异同？
 * 1,java 的 interface 只定义方法名称和参数列表，不能定义方法体（jdk1.7）。而 trait 则可以定义方法体。 jdk1.8+ 之后，可以定义具体的方法
 * 2,在 java 中实现接口用 implements，而在 scala 中，实现 trait 用 extends 和 with。
 * 3,java 的 interface 和 scala 的 trait 的最大区别是，scala 可以在一个 class 实例化的时候动态混入 trait。
 * 用特质还是用抽象类？？
 * 1，优先使用特质。一个类可以扩展多个特质，但却只能扩展一个抽象类。
 * 2，如果需要构造器，使用抽象类。因为抽象类可以定义带参数的构造器，而特质不行。
 */