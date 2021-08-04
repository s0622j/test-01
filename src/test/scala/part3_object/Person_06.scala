package part3_object

object Person_06 {
  def main(args: Array[String]): Unit = {
    val s = new Person("laoduan", 38)
    println(s"${s.name} ${s.age}")
    val s1 = new Person("dingding", 18, "female")
    println(s"${s1.gender}")
    val p2 = new Person("xx2", 12, "female", "9527")
    println(s"${p2.age},${p2.account1}")
  }
}

/**
 * 每个类都有主构造器，主构造器的参数直接放置类名后面，与类交织在一起
 */
class Person(val name: String, val age: Int) {
  //主构造器会执行类定义中的所有语句
  println("执行主构造器")
  //  private var gender = "male"  // 伴生对象中用
  var gender = "male"
  var account1: String = _

  //用 this 关键字定义辅助构造器
  def this(name: String, age: Int, gender: String) {
    //每个辅助构造器必须以主构造器或其他的辅助构造器的调用开始
    this(name, age)
    println("执行辅助构造器")
    this.gender = gender
  }

  def this(name: String, age: Int, gender: String, account: String) {
    this(name, age, gender)
    this.account1 = account
  }

  println("尼玛,这里还是主构造器")
}

/**
 * 构造器
 * 同 java 中的构造方法
 * 构造器分为两类：主构造器，辅助构造器
 * 主构造器直接在类名后面定义。
 * 每个类都有主构造器，主构造器的参数直接放置类名后面，与类交织在一起。
 * 如果没有定义构造器, 类会有一个默认的空参构造器
 * 辅助构造器自定义，使用 def this 关键字，而且必须调用主构造器，或者其他的辅助构造器
 * 注意：主构造器会执行类定义中的所有语句
 */
/**
 * scala 的构造器：
 * 1，有两类构造器：主构造器，辅助构造器
 * 2，构造器的定义位置，
 * 主构造器和类交织在一起，class Student2(val name: String, var age: Int)
 * 3， 辅助构造器是一个特殊的方法，定义在类中 def this(name:String,age:Int,gender:String)
 * 4，辅助构造器，第一行必须调用主构造器（或者其他的辅助构造器）
 * 5，辅助构造器的参数不能和主构造器的参数完全一致（参数个数，参数类型，参数顺序）
 * 6，可以定义空参的辅助构造器，但是主构造器的参数必须进行初始化赋值
 * 7，作用域：辅助构造器的作用域，只在方法中，主构造器的作用域是类中除了成员属性和成员方法之外的所有范围（可以通过反编译查看源码）
 */