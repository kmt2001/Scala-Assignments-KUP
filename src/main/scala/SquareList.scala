//@uthor: Krishna Mohan Tiwari
object SquareList {
  //1st Function:
  def squareListWithPatternMatching(listToSqaureElements: List[Int]): List[Int] = {
    try {
      listToSqaureElements match {
        // If the input list is empty, return an empty list
        case Nil => Nil
        // If the input list is not empty, square the head element and append it to the result of recursively squaring the tail
        case head :: tail => (head * head) :: squareListWithPatternMatching(tail)
      }
    } catch {
      // Handle the case where the input list is null
      case e: NullPointerException => {
        println("Error: Input list cannot be null")
        Nil
      }
      // Handle the case where the input list contains non-integer elements
      case e: NumberFormatException => {
        println("Error: Input list contains non-integer elements")
        Nil
      }
      // Handle the case where the input list is too large and causes a StackOverflowError
      case e: StackOverflowError => {
        println("Error: Input list is too large")
        Nil
      }
      // Handle any other unexpected exceptions
      case e: Exception => {
        println(s"An unexpected error occurred while squaring the list: ${e.getMessage}")
        Nil
      }
    }
  }
  //2nd Function:
  def squareListWithMap(inputListToSqaureElements: List[Int]): List[Int] = {
    try {
      inputListToSqaureElements.map(elementOfList => elementOfList * elementOfList)
    } catch {
      // Handle the case where the input list is null
      case e: NullPointerException => {
        println("Error: Input list cannot be null")
        Nil
      }
      // Handle the case where the input list contains non-integer elements
      case e: NumberFormatException => {
        println("Error: Input list contains non-integer elements")
        Nil
      }
      // Handle any other unexpected exceptions
      case e: Exception => {
        println(s"An unexpected error occurred while squaring the list: ${e.getMessage}")
        Nil
      }
    }
  }


}
//Test cases file in test cases folder with name SquareListTest.scala