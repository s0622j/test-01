package part4_Akka

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
 * 1.Actor并发编程模型，是scala提供给程序员的一种与Java并发编程完全不一样的并发编程模型，是一种基于事件模型的并发机制。
 * 2.Actor并发编程模型，是一种不共享数据，依赖消息传递的一种并发编程模式，有效避免资源争夺、死锁等情况。
 * 如果Actor A和 Actor B要相互沟通的话，首先A要给B传递一个消息，B会有一个收件箱，然后B会不断的循环自己的收件箱， 若看见A发过来的消息，B就会解析A的消息并执行，处理完之后就有可能将处理的结果通过邮件的方式发送给A
 */

/**
 * 案例 1：Actor 入门案例
 * 一个 Actor 就是一个类，要想实现 actor 功能，需要实现 Actor 特质
 * 需要重写 receive 方法，进行消息匹配接收
 * 程序运行需要执行入口，所以需要有 main 方法。
 * actor 必须通过 ActorSystem 来创建
 */
object AkkaTest_01 extends App {

  // 通过字符串添加配置信息
  val str =
    """
      |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
      |akka.remote.netty.tcp.hostname = "127.0.0.1"
      |akka.remote.netty.tcp.port = "8888"
 """.stripMargin
  // 创建配置工厂
  val conf = ConfigFactory.parseString(str)
  // 创建 actorsystem
  val as: ActorSystem = ActorSystem.create("actorsystem-test", conf)
  // 通过类型反射创建 actor 的引用对象
  val actor: ActorRef = as.actorOf(Props[AkkaTest_01], "actor-test")
  // 向 actor 引用对象发送异步消息
  actor ! "hello"

/*
 //新建一个ActorSystem
 val system = ActorSystem("HelloSystem")
 //创建Actor
 val helloActor = system.actorOf(Props[AkkaTest_01], name = "helloactor")
 //  helloActor ! "hello"
 helloActor ! "aaaaaa"

 */
}

class AkkaTest_01 extends Actor {
 override def receive: Receive = {
   /**
    * 使用case来处理不同的情况-不同类型的信息
    */
   case "hello" => println("您好！")
   case _ => println("您是？")
 }
}

/**
* 并发编程模型 Akka
* 1.1. Akka 介绍
* 多线程开发因为有共享数据，要处理并发，锁，线程同步等一系列问题，容易产生线程不同步，死锁等问题。
* 能不能换一种思路，可以不可以搞一种更高级的抽象模型，让我们需要实现多线程应用的时候，不用再考虑这些底层问题呢？
* Akka 是 JVM 平台上构建高并发、分布式和容错应用的框架。
* Akka 是用 Scala 语言编程，该框架基于 Actor 编程模型。
* Akka 实现并发，基于 Actor 模式，相当于 Java 实现并发，基于 Thread。
* 1.2. Akka 中 Actor 模型
* 与 java 的基于共享数据和锁的线程模型不同，scala 的 actor 包则提供了另外一种不共享任何数据、依赖消息传递的模型。
* 在基于 Actor 的系统里，所有的事物都是 Actor，就好像在面向对象设计里面所有的事物都是对象一样。Actor 与 Actor 之间只能通过消息通信。
* 可以将 Actor 当作是一群人，他们互相之间不会面对面地交流，而只是通过邮件的方式进行沟通。传递消息是 actor 模型的基础。
*
* 必须有多个相同业务逻辑的 Actor 才可以实现并发编程，一个 Actor 相当于一个实例（老师/学生），消息是发送的数据（邮件）
* Actor 和 Actor 之间可以相互发送消息
* 每一个 Actor 中都有相应的业务逻辑，如果使用编程，定义一个类，在类中定义方法，通过 new 一个实例，即可得到一个 Actor
* Actor 是 ActorSystem 创建的，ActorSystem 的职责是负责创建并管理自己创建的 Actor，
* ActorSystem 的单例的，一个 JVM 进程中有一个即可，而 Acotr 是多例的。ActorSystem
* 相当于老大，Actor 相当于干活的小弟
* 1.3.使用 Actor 模型的好处：
* 事件模型驱动--Actor 之间的通信是异步的，即使 Actor 在发送消息后也无需阻塞或者等待
* 就能够处理其他事情；
* 强隔离性--Actor 中的方法不能由外部直接调用，所有的一切都通过消息传递进行的，从而
* 避免了 Actor 之间的数据共享，想要观察到另一个 Actor 的状态变化只能通过消息传递进行询问；
* 轻量性--Actor 是非常轻量的计算单机，单个 Actor 仅占 400 多字节，只需少量内存就能达到高并发；
* 1.4. maven 工程：
* 如果本地仓库的 jar 包没有下载成功，就有一个.lastUpdate 为后缀的文件，删除该文件，然后重新下载。
* 配置 maven 创建 maven 工程
* Pom 依赖：完整配置参考 pom.xml 文件
*/