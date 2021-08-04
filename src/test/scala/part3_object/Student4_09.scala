package part3_object

//类包的访问权限
//private 作用域为当前包及其子包 同 private [this]
//private [packageName] 作用域为指定包及其子包

object Student4_09 {
  def main(args: Array[String]): Unit = {
    val s = new Student4_09("张三", 20)
    println(s"${s.name}")
  }
}

/*
* private[包名] class 放在类最前面, 是修饰类的访问权限, 也就是说类在某些包下不可见或不能访问
* private[edu360] class 代表 student4 在 edu360 包下及其子包下可以见, 同级包中不能访问
* */
private[this] class Student4_09(val name: String, private var age: Int) {
  var xx: Int = _
}


/**
 * 访问权限总结：
 * 对于成员属性，成员方法（辅助构造器，主构造器）：
 * 默认： public
 * private 在伴生对象中有效，其他地方无效
 * private [this] 只在当前类中有效，伴生对象中无效，其他地方无效
 * private [包名] 在指定包及其子包访问内有效 其他地方无效
 * 包名： 只能在当前类的全局包中的一个
 * [cn.edu360]
 * [cn]
 * 对于类：
 * 默认： public
 * private private[this] 在当前包及其子包范围内有效，其他地方无效
 * private [包名] 在指定包及其子包访问内有效 其他地方无效
 */