import scala.util.{Failure, Success, Try}

// Define an object called BubbleSort that extends App
object BubbleSort extends App {

  // Define a recursive function to perform one pass of bubble sort
  def sortOnePass(list: List[Int]): List[Int] = list match {
    // If the firstElement element is greater than the secondElement, swap them
    case firstElement :: secondElement :: tail if firstElement > secondElement => secondElement :: sortOnePass(firstElement :: tail)
    // If the list is empty or has only one element, it is already sorted
    case firstElement :: tail => firstElement :: sortOnePass(tail)
    case Nil => Nil
  }

  // Define the main bubbleSort function, which uses sortOnePass to sort the input list
  def bubbleSort(inputList: List[Int]): List[Int] = {
    // Use a Try block to catch any exceptions that occur during the sorting process
    Try {
      inputList match {
        // If the input list is empty, return an empty list
        case Nil => Nil
        // If the input list is not empty, sort it
        case _ => {
          val sortedList = sortOnePass(inputList)
          // If the sorted list is the same as the input list, it is already sorted
          if (sortedList == inputList) sortedList
          // Otherwise, sort the sorted list
          else bubbleSort(sortedList)
        }
      }
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
