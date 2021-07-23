import org.apache.commons.lang3.time.FastDateFormat
import org.slf4j.{Logger, LoggerFactory}
import until.TimeUtil


object test {
  private val logger: Logger = LoggerFactory.getLogger(TimeUtil.getClass)
  def main(args: Array[String]): Unit = {

    val factInMills: Long = until.TimeUtil.parseTime("aa")
    println(factInMills)



    val timeFormat: String = "yyyy-MM-dd HH:mm:ss"

    //线程安全的
    var time = "2021-07-08a21:00:00"
    val fastDateFormat: FastDateFormat = FastDateFormat.getInstance(timeFormat)

    var timeMills: Long = 0L
//    timeMills = fastDateFormat.parse(time).getTime
    try {
      timeMills = fastDateFormat.parse(time).getTime
    } catch {
      case e: Exception => logger.error("time error: " + time)
    }

    println(timeMills)
  }
}
