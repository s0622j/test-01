package part3_object

object Student2_08 {
  def main(args: Array[String]): Unit = {
    val s1 = new Student2_08("laoYang", 18, "male")
    println(s"${s1.gender}")
  }
}

/*
* private 加在主构造器前面标识这个主构造器是私有的, 外部不能访问这个构造器
* */
class Student2_08 private(val name: String, var age: Int) {
  var gender: String = _

  // 辅助构造器, 使用 def this
  // 在辅助构造器中必须先调用类的主构造器
  def this(name: String, age: Int, gender: String) {
    this(name, age)
    this.gender = gender
  }
}

/**
 * 方法的访问权限
 * 通用于主构造器，辅构造器，以及普通方法
 * 默认权限是共有的
 * private 作用域为类和其伴生对象
 * private [this] ，作用域为当前类中，伴生对象中无效
 * private [packageName] 指定包及其子包有效 包名的写法，直接写包名，不需要层级路径主构造器上一样适用于该方法的访问权限
 * private [cn.edu360.day03] 错误的
 * private [day03] 正确的
 */