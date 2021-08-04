package part3_object

//抽象类
//在 Scala 中, 使用 abstract 修饰的类称为抽象类. 在抽象类中可以定义属性、未实现的方法（抽象方法）和具体实现的方法。


/*
* abstract 修饰的类是一个抽象类
* */
abstract class Animal_10 {
  println("Animal's constructor ....")
  // 定义一个 name 属性
  val name: String = "animal"

  // 没有任何实现的方法
  def sleep()

  // 带有具体的实现的方法
  def eat(f: String): Unit = {
    println(s"$f")
  }
}

/**
 * 类和对象，该怎么选择？
 * class object
 * 一般情况下，使用 object + 伴生的 class
 * 类和对象，如何选择？
 * 1，优先使用 object，object 本质上拥有了的类的所有特性，object 中没有构造器，也没
 * 有参数 ，必须要有程序入口，object，main 方法，必不可少。
 * 2，如果是单例的，优先选择 object，如果是多例的（封装数据，构造器），必须选择类
 * 3，伴生类和伴生对象都会用到。首先把 object 写上，如果需要有类的功能，就把伴生类写上。
 */