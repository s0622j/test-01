package part3_object

class Dog_02 {
  val id = 1
  private var name = "xiaoqing"

  def printName(): Unit = {
    //在 Dog 类中可以访问伴生对象 Dog 的私有属性
    println(Dog_02.CONSTANT + name)
  }
}

/**
 * 伴生对象
 */
object Dog_02 {
  //伴生对象中的私有属性
  private val CONSTANT = "汪汪汪 : "

  def main(args: Array[String]) {
    val p = new Dog_02()
    //访问私有的字段 name
    p.name = "123"
    p.printName()
  }
}


/*
*
伴生对象
伴生对象是一种特殊的单例对象。是一种相对概念，需要满足两个条件：
条件 1：在同一个源文件中,
条件 2：对象名和类名相同
这样的单例对象，被称作是这个类的伴生对象。类被称为是这个单例对象的伴生类。
结论：类和伴生对象之间可以相互访问私有的方法和属性
 */