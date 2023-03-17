//@uthor: Krishna Mohan Tiwari
object ObjectCode {

  // Expanded code of addIntegers
  val addIntegers: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
    def apply(integer1: Int, integer2: Int): Int = {
      if (integer1 > Int.MaxValue - integer2) throw new ArithmeticException("Integer overflow")
      else integer1 + integer2
    }
  }

  // Expanded code of sum of list
  val sumOfList: Function1[List[Int], Int] = new Function1[List[Int], Int] {
    def apply(list: List[Int]): Int = {
      if (list.isEmpty) throw new IllegalArgumentException("List is empty")
      else list.sum
    }
  }

  // Expanded code of higher order function
  val higherOrderFunction: Function2[Int => Int, Int, Int] = new Function2[Int => Int, Int, Int] {
    def apply(function: Int => Int, integer: Int): Int = {
      try {
        function(integer)
      } catch {
        case e: Exception => throw new RuntimeException("Error occurred in higherOrderFunction", e)
      }
    }
  }
}

//Test cases are in test file with name ObjectCodeTest.scala