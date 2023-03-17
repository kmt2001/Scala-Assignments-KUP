import org.scalatest.funsuite.AnyFunSuite

class SelectionSortTest extends AnyFunSuite {
  test("empty list") {
    assert(SelectionSort.selectionSort(List.empty[Int]) == List.empty[Int])
  }

  test("list with one element") {
    assert(SelectionSort.selectionSort(List(42)) == List(42))
  }

  test("list with multiple elements") {
    assert(SelectionSort.selectionSort(List(5, 1, 4, 2, 8)) == List(1, 2, 4, 5, 8))
  }

  test("list with duplicate elements") {
    assert(SelectionSort.selectionSort(List(5, 1, 4, 2, 8, 1)) == List(1, 1, 2, 4, 5, 8))
  }

  test("already sorted list") {
    assert(SelectionSort.selectionSort(List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4, 5))
  }
  println("Success!")
}
