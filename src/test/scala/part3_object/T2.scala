package part3_object

trait T2 {
  // 定义一个属性
  val className: String = "NB 大神班"

  // 定义一个没有实现的方法,默认就是抽象方法
  def teacherSay(name: String)

  // 定义带有具体的实现的方法
  def doSomething() = {
    println("群主开始发红包了...")
  }
}
