package part3_object

// 类的伴生对象
object Student3_07 {
  def main(args: Array[String]): Unit = {
    // 伴生对象可以访问类的私有方法和属性
    val s3 = new Student3_07("Angelababy", 30)
    s3.age = 29
    println(s"${s3.age}")
    // println(s"${s3.province}") 伴生类不能访问
  }
}


/*
* private var age
* age 在这个类中是有 getter setter 方法的
* 但是前面如果加上了 private 修饰, 也就意味着, age 只能在这个类的内部以及其伴生类对象中可以访问修改
* 其他外部类不能访问
* */
class Student3_07 private(val name: String, private var age: Int) {
  var gender: String = _

  // 辅助构造器, 使用 def this
  // 在辅助构造器中必须先调用类的主构造器
  def this(name: String, age: Int, gender: String) {
    this(name, age)
    this.gender = gender
  }

  // private[this]关键字标识该属性只能在类的内部访问, 伴生类不能访问
  private[this] val province: String = "北京市"

  def getAge = 18
}

/**
 * 访问权限
 * 成员变量的访问权限
 * 默认权限是 public 任何地方都可以访问
 * private 作用域 类和其伴生对象中
 * private [this] ，作用域为当前类中，伴生对象中无效
 * private [packageName] 指定包及其子包有效
 */