// Define a typeclass `Show` that is used to convert a given value of type `A` to a `String`.
trait Show[A] {
  def show(value: A): String
}

// Define a companion object `Show` that provides utility methods and instances for the `Show` typeclass.
object Show {
  def print[A](value: A)(implicit instance: Show[A]): String = instance.show(value)

  implicit val intShow: Show[Int] = new Show[Int] {
    def show(intValue: Int): String = intValue.toString
  }

  // Define an instance of `Show` for the `Long` type.
  val longShow: Show[Long] = new Show[Long] {
    def show(longValue: Long): String = longValue.toString
  }

  // Define an instance of `Show` for the `Double` type.
  val doubleShow: Show[Double] = new Show[Double] {
    def show(doubleValue: Double): String = doubleValue.toString
  }

  // Define a case class `Position` with two `Int` fields, `lattitude` and `longitude`.
  case class Position(lattitude: Int, longitude: Int)

  // Define an instance of `Show` for the `Position` type.
  val positionShow: Show[Position] = new Show[Position] {
    def show(position: Position): String = s"Position(x: ${position.lattitude}, y: ${position.longitude})"
  }
}

//Test Cases are in src/test folder with name ShowTest.scala