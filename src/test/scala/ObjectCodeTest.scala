import org.scalatest.funsuite.AnyFunSuite

class ObjectCodeTest extends AnyFunSuite {

  test("add should return the sum of two integers") {
    assert(ObjectCode.addIntegers(2, 3) == 5)
    assert(ObjectCode.addIntegers(-1, 1) == 0)
    assert(ObjectCode.addIntegers(0, 0) == 0)
  }

  test("sumOfList should return the sum of all elements in a list of integers") {
    assert(ObjectCode.sumOfList(List(1, 2, 3)) == 6)
    assert(ObjectCode.sumOfList(List(-1, 0, 1)) == 0)
    assert(ObjectCode.sumOfList(List(0, 0, 0)) == 0)
  }

  test("higherOrderFunction should apply a given function to a given integer and return the result") {
    val square: Int => Int = num => num * num
    assert(ObjectCode.higherOrderFunction(square, 2) == 4)
    assert(ObjectCode.higherOrderFunction(square, -3) == 9)
    assert(ObjectCode.higherOrderFunction(square, 0) == 0)

    val double: Int => Int = num => num * 2
    assert(ObjectCode.higherOrderFunction(double, 4) == 8)
    assert(ObjectCode.higherOrderFunction(double, -5) == -10)
    assert(ObjectCode.higherOrderFunction(double, 0) == 0)
  }

  println("Success!")

}
