package part1_2_collection

import scala.collection.mutable.ArrayBuffer

object ArrayTest {
  def main(args: Array[String]) {
    //初始化一个长度为 8 的定长数组，其所有元素均为 0
    val arr1 = new Array[Int](8)
    //直接打印定长数组，内容为数组的 hashcode 值
    println(arr1)
    //将数组转换成数组缓冲，就可以看到原数组中的内容了
    //toBuffer 会将数组转换长数组缓冲
    println(arr1.toBuffer)
    //注意：如果不是 new，相当于调用了数组的 apply 方法，直接为数组赋值
    //初始化一个长度为 1 的定长数组
    val arr2 = Array[Int](10)
    println(arr2.toBuffer)
    //定义一个长度为 3 的定长数组
    val arr3 = Array("hadoop", "storm", "spark")
    //使用()来访问元素
    println(arr3(2))
    //////////////////////////////////////////////////
    //变长数组（数组缓冲）
    //如果想使用数组缓冲，需要导入 import scala.collection.mutable.ArrayBuffer 包
    val ab = ArrayBuffer[Int](1, 3, 4)
    val ab2 = new ArrayBuffer[Int]()
    //向数组缓冲的尾部追加一个元素
    //+=尾部追加元素
    ab += 1
    //追加多个元素
    ab += (2, 3, 4, 5)
    ab -= (3, 4)
    println(ab)
    println(ab.length)
    //追加一个数组++=
    ab ++= Array(6, 7)
    //追加一个数组缓冲
    ab ++= ArrayBuffer(8, 9)
    println(ab)
    //减少一个数组--=
    ab --= Array(6, 7)
    //在数组某个位置插入元素用 insert,第一个参数为插入元素的位置，后面的可变参数为插入的元素
    ab.insert(0, -1, 0)
    println(ab)
    //删除数组某个位置的元素用 remove，第一个参数为要删除的元素位置，第二个参数为删除几个元素
    ab.remove(8, 2)
    println(ab)
    // 清空
    ab.clear()
    println(ab)
  }
}
