package part5_other

object ImplicitDemo_02 {
  def main(args: Array[String]): Unit = {
    // 使用 to 这个生成器的时候，会发现在 Int 类中，根本就没有 to 方法,实际调用的是 RichInt 方法
    val rg = 1.to(10)
    println(rg)

    // 该类所在包的位置：scala.runtime.RichInt
    import scala.runtime.RichInt
    val rg2 = new RichInt(1).to(10)
    println(s"richint : ${rg2}")

    /**
     * 发生了什么？？就是因为 implicit 隐式转换
     * 在调用 Int 的 to 方法时，发现没有，但是呢？在上下文 context 环境中，找到了一个 implicit 修饰的方法：
     * implicit def intWrapper(x: Int) = new runtime.RichInt(x)
     * 该方法的输入参数是一个 Int 类型，返回值类型是 RichInt 类型，该类型中有 to 方法
     * 于是编译器，就调用了这个类型的 to 方法，并返回相应的结果
     */
  }
}
