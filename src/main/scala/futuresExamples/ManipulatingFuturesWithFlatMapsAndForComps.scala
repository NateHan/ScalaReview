package futuresExamples

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object ManipulatingFuturesWithFlatMapsAndForComps extends App {

  def sumOfTwoNumbersSequentialMap(): Future[Int] = {
    Future {
      Thread.sleep(1000)
      1
    }.flatMap { oneValue =>
      Future {
        Thread.sleep(2000)
        2
      }.map { twoValue =>
        println(s"adding $oneValue and $twoValue")
        oneValue + twoValue
      }
    }
  }

  println(s"From the first call we got: ${Await.result(sumOfTwoNumbersSequentialMap, 4000 millis)}")

}
