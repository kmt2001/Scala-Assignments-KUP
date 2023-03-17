import scala.util.{Failure, Success, Try}

// Define an object called InsertionSort that extends App (to make it runnable)
object InsertionSort extends App {

  // Define a recursive function to insert an list Element in a sorted list
  def insertSorted(listElement: Int, list: List[Int]): List[Int] = list match {
    // If the list is empty, return a new list with the list Element as its only list Element
    case Nil => List(listElement)
    // If the head of the list is greater than the list Element, insert the list Element at the beginning of the list
    case head :: tail if listElement <= head => listElement :: list
    // Otherwise, recursively insert the list Element into the tail of the list
    case head :: tail => head :: insertSorted(listElement, tail)
  }

  // Define the main insertionSort function, which uses insertSorted to sort the input list
  def insertionSort(list: List[Int]): List[Int] = {
    Try {
      // Use foldLeft to apply insertSorted to each list Element in the input list
      list.foldLeft(List.empty[Int])((sorted, listElement) => insertSorted(listElement, sorted))
    } match {
      // If sorting is successful, return the sorted list
      case Success(value) => value
      // If an exception is thrown, print an error message and return an empty list
      case Failure(exception) => {
        println(s"An error occurred: ${exception.getMessage}")
        Nil
      }
    }
  }
}
