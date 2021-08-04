package part3_object

object TestCaseClass_13 extends App {
  // 可以不使用 new 关键字创建实例
  val msg = Message("hello")
  println(msg.msg)
}


/*
* 样例类,使用 case 关键字 修饰的类, 其重要的特征就是支持模式匹配
* */
case class Message(msg: String)

/**
 * 样例 object, 不能封装数据, 其重要特征就是支持模式匹配
 */
case object CheckHeartBeat

/**
 * 样例类/样例对象
 * 样例类：使用 case 关键字 修饰的类，重要的特征就是支持模式匹配,多例
 * 样例 object：使用 case 关键字修饰的对象，支持模式匹配，单例
 * case class 和 class 的一些区别：
 * case class 在初始化的时候，不用 new，而普通类初始化时必须要 new。
 * case class 重写了 toString 方法。
 * 默认实现了 equals 和 hashCode
 * case class 实现了序列化接口 with Serializable
 * case class 支持模式匹配（最重要的特征），所有 case class 必须要有参数列表
 * 有参数用 case class，无参用 case object
 * case class，和 case object,可以当作消息进行传递
 */