import org.scalatest.funsuite.AnyFunSuite

class ShowTest extends AnyFunSuite {

  test("printing an Int using print method should return its string representation") {
    assert(Show.print(42) === "42")
  }

  test("showing a Position using positionShow instance should return its string representation") {
    val position = Show.Position(0, 1)
    assert(Show.positionShow.show(position) === "Position(x: 0, y: 1)")
  }

  test("an implicit instance of Show[Int] should be available in the scope") {
    assert(implicitly[Show[Int]] === Show.intShow)
  }

  test("an instance of Show[Long] should be available in the scope") {
    assert(Show.longShow.show(9876543210L) === "9876543210")
  }

  test("an instance of Show[Double] should be available in the scope") {
    assert(Show.doubleShow.show(2.71828) === "2.71828")
  }

  println("All Test Cases Passed Successfully!")

}
