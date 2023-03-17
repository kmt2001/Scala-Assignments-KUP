import org.scalatest.funsuite.AnyFunSuite
import InsertionSort.insertionSort

class InsertionSortTest extends AnyFunSuite {

  test("empty list should return empty list") {
    assert(insertionSort(List.empty[Int]) == List.empty[Int])
  }

  test("list with one element should return same list") {
    assert(insertionSort(List(1)) == List(1))
  }

  test("list with multiple elements should return sorted list") {
    assert(insertionSort(List(3, 2, 1)) == List(1, 2, 3))
    assert(insertionSort(List(5, 9, 1, 3, 7)) == List(1, 3, 5, 7, 9))
    assert(insertionSort(List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4, 5))
  }

  test("list with duplicates should return sorted list with duplicates") {
    assert(insertionSort(List(3, 1, 2, 1, 3)) == List(1, 1, 2, 3, 3))
  }

  println("Success!")

}
