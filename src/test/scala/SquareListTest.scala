import org.scalatest.funsuite.AnyFunSuite

class SquareListTest extends AnyFunSuite {

  test("squareListWithPatternMatching should return an empty list for an empty input list") {
    assert(SquareList.squareListWithPatternMatching(List()) === List())
  }

  test("squareListWithPatternMatching should square the elements of the input list") {
    assert(SquareList.squareListWithPatternMatching(List(1, 2, 3)) === List(1, 4, 9))
  }

  test("squareListWithMap should return an empty list for an empty input list") {
    assert(SquareList.squareListWithMap(List()) === List())
  }

  test("squareListWithMap should square the elements of the input list") {
    assert(SquareList.squareListWithMap(List(1, 2, 3)) === List(1, 4, 9))
  }
  println("Success!")
}
