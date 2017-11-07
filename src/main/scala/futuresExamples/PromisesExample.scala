package futuresExamples

import scala.concurrent.ExecutionContext.Implicits.global
import concurrent.{Future, Promise}
import scala.util.{Failure, Success}

/**
  * Borrowed/Modified from http://danielwestheide.com/blog/2013/01/16/the-neophytes-guide-to-scala-part-9-promises-and-futures-in-practice.html
  */
object PromisesExample extends App {


  case class TaxCut(reduction: Int)
  case class NewError(msg:String ="Argh") extends Exception(msg)

  // either give the type as a type parameter to the factory method:
  val taxcutPromise = Promise[TaxCut]()
  // or give the compiler a hint by specifying the type of your val:
  val taxcut2: Promise[TaxCut] = Promise()

  taxcutPromise.success(TaxCut(20))
  //  can only have one or the other
  //  taxcutPromise.failure(NewError())

  //can also use the .complete() method, similar to success() method.
  taxcut2.complete(Success(TaxCut(15)))

  val taxcutF: Future[TaxCut] = taxcutPromise.future

  println("Here we go")
  taxcutF.onComplete {
    case Success(myValue) => println(s"Got the callback of ${myValue.toString}")
    case Failure(e) => e.printStackTrace
  }


}

