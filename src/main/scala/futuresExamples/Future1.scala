package futuresExampl

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object Future1 extends App {

  // used by 'time' method
  implicit val baseTime = System.currentTimeMillis

  // 2 - create a Future
  val myFut = Future {
    Thread.sleep(500)
    1 + 1
  }

  // 3 - this is blocking (blocking is bad)
  val result = Await.result(myFut, 1 second)
  println("before result")
  println(result)
  println("After result")
  Thread.sleep(1000)
  println("Done sleeping")

}
