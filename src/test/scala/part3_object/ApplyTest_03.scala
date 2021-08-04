package part3_object

object ApplyTest_03 {
  /**
   * apply 方法
   * 通常我们会在类的伴生对象中定义 apply 方法，当遇到对象名(参数 1,...参数 n)时 apply 方
   * 法会被调用
   *
   * 当使用对象（参数列表）时，会去对象中找对应参数的 apply 方法，如果找到就执行相应
   * 的逻辑，如果找不到，就报错。
   * 注意：只能找到和参数列表对应的 apply 方法。
   * 要和对象区分开来
   * ApplyDemo // 对象
   * ApplyDemo() // ApplyDemo.apply() 方法
   * 该语法的目的：更方便的完成类或实例对象的初始化，赋值等工作。
   *
   */

  def main(args: Array[String]): Unit = {
    // 显然不能再对象后面加上（）
    println(ApplyDemo)
    // println(ApplyDemo.apply())
    // 这种写法是调用 apply 方法的简写
    println(ApplyDemo())
    println(ApplyDemo.apply(10))
    println(ApplyDemo(10)) // apply 方法名称固定
    // 对象名(参数列表) ---》 调用 对象名.apply(参数列表) 参数个数，参数的类型
    ApplyDemo("str", "st") //
    // 简单 apply 封装好了一些通过的代码，方便的进行初始化赋值
    val arr = Array(1, 3, 5, 6, 8, 0)
    /* val arr2 = new Array[Int](6)
    arr2(0) = 1
    arr(1) = 3*/
    println(ApplyDemo) // object
    println(ApplyDemo) // object
    println(ApplyDemo()) // class
    println(ApplyDemo()) // class
    // 如何保证实例是唯一的 单例
    // 1 对象本身就是单例的
    // 2 private 在伴生对象中还是可以 new 类的实例的，其他类中不能 new 实例
    // 3 ,在伴生对象中，只创建一个实例，然后通过 apply 方法，来返回这个实例

    Test2 // 这是一个对象，对象上不能有参数
    //    Test2() // 添加参数之后，就报错了
  }
}

class ApplyDemo() {
}

object ApplyDemo {

  private val ad: ApplyDemo = new ApplyDemo()

  // 类似于 java 中的方法重载
  /*def apply() = {
  println("hello apply")
  }*/
  def apply(): ApplyDemo = {
    // new ApplyDemo()
    ad
  }

  def apply(x: Int) = {
    println(s"x=$x")
    x
  }

  def apply(x: String, y: String) = {
    println(s"x=$x,y=$y")
  }
}

object Test2 {}

/**
 * 总结：
 * apply 方法，是 object 上的方法。
 * 1，一般情况下，对象没有构造方法， 不能加参数
 * 2，但是，如果对象（参数列表），实际上调用的是对象上的 apply 方法，具体会根据参数
 * 列表的个数，参数的类型去找对象上对应的 apply 方法，如果没找到，就报错。返回值
 * 类型取决于 apply 的返回类型
 * 3，apply 方法的作用，
 * 01，快速的创建类的实例对象
 * // 在 apply 方法中创建类的实例对象
 * //def apply(): ApplyDemo = new ApplyDemo()
 * 02，可以方便的对数组进行初始化。 val arr = Array(1, 3, 5, 6)
 * 4，apply 方法相当于 java 中的方法重载，可以定义多个 apply 方法，具体的参数类型，参
 * 数个数，以及返回值都是可以自定义的。
 */