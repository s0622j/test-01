package part4_Akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

//两个actor通信案例-模拟下棋对话
object ChineseChess_03 extends App {
  // 创建 actorSystem的工厂，用来生产ActorRef对象！
  private val ChineseChessActorSystem = ActorSystem("Chinese-chess")
  /**
   * 通过actorSystem创建ActorRef
   */
  private val p2 = ChineseChessActorSystem.actorOf(Props[player2Actor], "player2")            //创建player2Actor对象
  private val p1 = ChineseChessActorSystem.actorOf(Props(new player1Actor(p2)), "player1")   //创建player1Actor对象

  p2 ! "start"
  p1 ! "start"
}


/**
 * 定义玩家1
 */
class player1Actor(val p2: ActorRef) extends Actor{
  // receive方法是负责处理消息的
  override def receive: Receive = {
    case "start" => {
      println("棋圣：I'm OK !")
      p2 ! "该你了"
    }
    case "将军" => {
      println("棋圣：你真猛!")
      Thread.sleep(1000)
      p2 ! "该你了"
    }
  }
}


/**
 * 定义玩家2
 */
class player2Actor extends Actor{

  override def receive: Receive = {
    case "start" => println("棋仙说：I'm OK !")
    case "该你了" => {
      println("棋仙：那必须滴！")
      Thread.sleep(1000)
      /**
       * 注意，这个“sender()”，其实就是对ActorRef的一个引用。它指的是给发送"该你了"的这个对象本身！
       */
      sender() ! "将军"
    }
  }
}