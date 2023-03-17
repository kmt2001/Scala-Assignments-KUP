import org.scalatest.funsuite.AnyFunSuite

class BubbleSortTest extends AnyFunSuite {

  test("bubbleSort should return an empty list when given an empty list") {
    assert(BubbleSort.bubbleSort(List()) == List())
  }

  test("bubbleSort should return the same list when given a list with one element") {
    assert(BubbleSort.bubbleSort(List(1)) == List(1))
  }

  test("bubbleSort should sort a list of integers in ascending order") {
    assert(BubbleSort.bubbleSort(List(5, 2, 4, 6, 1, 3)) == List(1, 2, 3, 4, 5, 6))
  }

  test("bubbleSort should return the same list when given a list that is already sorted") {
    assert(BubbleSort.bubbleSort(List(1, 2, 3, 4, 5, 6)) == List(1, 2, 3, 4, 5, 6))
  }

  test("bubbleSort should sort a list of integers in descending order") {
    assert(BubbleSort.bubbleSort(List(6, 5, 4, 3, 2, 1)) == List(1, 2, 3, 4, 5, 6))
  }
  println("Success")
}
