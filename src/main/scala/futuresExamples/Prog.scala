package futuresExamples

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
  * Example from tutorial: https://www.beyondthelines.net/computing/scala-future-and-execution-context/
  */
object Prog {
    def taskA(): Future[Unit] = Future {
      println("Starting taskA")
      Thread.sleep(1000) // wait 1secs
      println("Finished taskA")
    }

    def taskB(): Future[Unit] = Future {
      println("Starting taskB")
      Thread.sleep(2000) // wait 2secs
      println("Finished taskB")
    }

    def main(args: Array[String]): Unit = {
      println("Starting Main")
      val futureA = taskA()
      val futureB = taskB()
      println("Continuing Main")
      // wait for both future to complete before exiting
      Await.result(futureA zip futureB, Duration.Inf)
    }
    // ...

}
