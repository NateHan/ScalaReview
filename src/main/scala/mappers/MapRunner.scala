package mappers

object MapRunner extends App {

  // immutable
  val states = Map("AL" -> "Alabama", "AK" -> "Alaska")
  states foreach { case (k,v) => println(s"State: $k and Longer: $v") }

  //mutable
  val mutStates = scala.collection.mutable.Map("IL" -> "Illinois", "IN" -> "Indiana")

  mutStates += ("AZ" -> "Arizona")

  println(mutStates.toString())

  mutStates.foreach (x => println (x._1 + "-->" + x._2)) // can also go after them with tuples



}
