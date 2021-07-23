package until

import org.apache.commons.lang3.time.FastDateFormat
import org.slf4j.{Logger, LoggerFactory}

import scala.collection.mutable.ListBuffer

object TimeUtil {

  private val logger: Logger = LoggerFactory.getLogger(TimeUtil.getClass)

  // 将实际路由的时间转换为与规划路由一致
  def parseTime(currentTime: String, takeTime: String) = {

    // 时间格式
    val timeFormat: String = "yyyy-MM-dd"

    //线程安全的
    val fastDateFormat: FastDateFormat = FastDateFormat.getInstance(timeFormat)
    //时间格式化
    var startTime: Long = 0L
    var endTime: Long = 0L
    try {
      startTime = fastDateFormat.parse(takeTime.substring(0, 10)).getTime
    } catch {
      case e: Exception => {
        logger.error("takeTime format error: " + takeTime)
      }
    }
    try {
      endTime = fastDateFormat.parse(currentTime.substring(0, 10)).getTime
    } catch {
      case e: Exception => {
        logger.error("currentTime format error: " + currentTime)
      }
    }

    val day: Long = (endTime - startTime) / 1000 / 3600 / 24
    day + "," + currentTime.substring(11, 16)
  }

  // 将时间转为毫秒，进行比较
  def parseTime(time: String) = {

    // 时间格式
    val timeFormat: String = "yyyy-MM-dd HH:mm:ss"

    //线程安全的
    val fastDateFormat: FastDateFormat = FastDateFormat.getInstance(timeFormat)

    var timeMills: Long = 0L

    try {
      timeMills = fastDateFormat.parse(time).getTime
    } catch {
      case e: Exception => logger.error("time error: " + time)
    }

    timeMills

  }

//
//  // 规划路由时间加一天
//  def parseTime(planRouteList: List[PlanOrg]) = {
//
//    // 时间格式
//    val timeFormat: String = "yyyy-MM-dd HH:mm:ss"
//
//    val planRouteAddOneList: ListBuffer[PlanOrg] = ListBuffer[PlanOrg]()
//
//    //线程安全的
//    val fastDateFormat: FastDateFormat = FastDateFormat.getInstance(timeFormat)
//
//    for (planOrg <- planRouteList) {
//
//      // 将规划路由时间加上一天的毫秒值
//      var planArriveAddOneMills: Long = 0L
//      var planLeaveAddOneMills: Long = 0L
//      try {
//        planArriveAddOneMills = fastDateFormat.parse(planOrg.arriveTime)
//          .getTime + 24 * 60 * 60 * 1000
//        planLeaveAddOneMills = fastDateFormat.parse(planOrg.leaveTime)
//          .getTime + 24 * 60 * 60 * 1000
//      } catch {
//        case e: Exception => logger.error(planRouteList.toString())
//      }
//
//      // 将加了一天毫秒值的规划路由时间转为日期格式
//      val planArriveAddOneTime: String = fastDateFormat.format(planArriveAddOneMills)
//      val planLeaveAddOneTime: String = fastDateFormat.format(planLeaveAddOneMills)
//
//      planOrg.arriveTime = planArriveAddOneTime
//      planOrg.leaveTime = planLeaveAddOneTime
//
//      planRouteAddOneList += planOrg
//
//    }
//
//    planRouteAddOneList.toList
//
//  }

  // 将规划路径中的时间转为：日期+时间
  // {"0":["200159","0,20:50","0,21:50"],"1":["200901","0,23:00","1,08:20"],"2":["825901","2,07:40","2,11:00"],"3":["817006","2,15:00","2,16:00"]}
  def planTimeToDate(planTime: String, take_time: String) = {

    // 时间格式
    val timeFormat: String = "yyyy-MM-dd"

    var planymd: String = null

    try {
      val planDay: Int = planTime.split(",")(0).trim.toInt
      val planHourAndMinute: String = planTime.split(",").last.trim

      // 线程安全的
      val fastDateFormat: FastDateFormat = FastDateFormat.getInstance(timeFormat)

      // 将揽收日期（yyyy-MM-dd）转为毫秒值
      val takeTimeMills: Long = fastDateFormat.parse(take_time).getTime

      // 当前节点毫秒值 = 揽收日期毫秒值 + 当前节点天数 * 一天的毫秒值
      val planDateMills: Long = takeTimeMills + planDay * 24 * 60 * 60 * 1000

      // 将当前节点毫秒值转为日期格式（yyyy-MM-dd）
      val planDate: String = fastDateFormat.format(planDateMills)

      // 最终时间格式为：日期+时间，如：2019-10-21 18:40
      planymd = planDate + " " + planHourAndMinute + ":00"
    } catch {
      case e: Exception => logger.error(s"plantime to date error: ${planTime}")
    }

    planymd

  }

  def getPreDate(args: Array[String], num: Int) = {

    val timeFormat: String = "yyyyMMdd"

    val oneDayMills: Long = 24 * 60 * 60 * 1000

    val fastDateFormat: FastDateFormat = FastDateFormat.getInstance(timeFormat)

    val numDaysAgoMills: Long = fastDateFormat.parse(args(0)).getTime + num * oneDayMills

    val numDaysAgo: String = fastDateFormat.format(numDaysAgoMills)

    numDaysAgo

  }

  //  def main(args: Array[String]): Unit = {
  //
  //    val args = Array("20200526")
  //
  //    val str = getPreDate(args, -1)
  //
  //    println(str)
  //
  //  }


}