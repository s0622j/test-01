package part3_object

object Bird_12 {
  def main(args: Array[String]): Unit = {
    val b = new Bird
    b.fly()
  }
}


//定义一个 bird 类,实现多个特质
//在 scala 中，不论是继承还是实现特质，第一个都用 extends 关键字
class Bird extends Flyable with Fightable {
  override def fly(): Unit = {
    println("用翅膀飞")
  }
}

// 定义一个抽象类
abstract class Animal(val age: Int) {
  println("Animal`s main constructor invoked" + age)

  //定义一个抽象方法
  def run()

  def breath(): Unit = {
    println("呼吸氧气")
  }
}

// 定义一个特质，定义一个普通方法
trait Fightable {
  def fight(): Unit = {
    println("用嘴咬")
  }
}

// 定义一个特质，一个抽象方法
trait Flyable {
  // 定义一个抽象方法
  def fly()
}

//**********************************************************************//
object Monkey {
  def main(args: Array[String]): Unit = {
    val a: Animal = new Monkey(100)
    a.breath()
  }
}

//定义一个类，继承类，并实现多个 trait
class Monkey(age: Int) extends Animal(age) with Flyable with Fightable {
  //重写抽象的方法, 可以不加 override 关键字
  def run(): Unit = {
    // super()
    println("跳着跑")
  }

  //重写非抽象的方法，必须加 override 关键字
  override def breath(): Unit = {
    println("猴子呼吸")
  }

  override def fly(): Unit = {
    println("乘着筋斗云飞")
  }

  override def fight(): Unit = {
    println("用棒子打")
  }

  println("monkey`s main constructor invoked" + age)
}

/**
 * 总结
 * 特质和抽象类的总结：
 * 1，单继承，多实现
 * 2，继承父类，使用 extends，实现（混入）特质 使用 with 和 extends
 * 3，当类没有父类，那么实现的第一个特质，使用 extends 关键字，其他地方都使用 with
 * 4，不论是继承父类，还是实现特质，都必须实现抽象方法，实现抽象方法可以不用 override 关键字，但是如果要重写一个普通方法，必须加上 override 关键字
 * 5，scala 的面向对象，具备了面向对象的封装继承 和多态 三大特性。
 * 6，特质可以在类实例化的时候动态混入，使用的关键字是 with，如果有抽象方法必须实现。
 * 动态混入了特质的对象，
 * // 在类实例化的时候，混入特质
 * val t: Teachers with TraitDemo with TraitDemo2 = new Teachers() with TraitDemo with
 * TraitDemo2 {
 * override def say(): Unit = {
 * println("明天放假，so happy")
 * }
 * }
 * 三大特性 封装 继承 多态
 * 多态的满足条件？
 * 1，继承父类 或者实现接口
 * 2，重写父类或者接口的方法
 * 3，父类引用指向子类对象，或者接口引用指向实现类
 * scala 的面向 对象
 * val a:Animal = new Dog()
 * a.eat()
 * a.weap("xxoo")
 */