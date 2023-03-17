object SelectionSort {
  // Define a helper function to find the minimum element list element in a list and return it along with the rest of the list

  def findminimum (list: List[Int]): Option[(Int, List[Int])] = list match {
    case Nil => None // if the list is empty, return None
    case head :: tail =>
      val (minElement, rest) = tail.foldLeft((head, List.empty[Int])) {
        case ((currentminElement, accumulator), listElemet) if listElemet < currentminElement => (listElemet, currentminElement :: accumulator) // if an list element is smaller than the current minimum element, update the minimum element and add the previous minimum element to the accumulator
        case ((currentminElement, accumulator), listElemet) => (currentminElement, listElemet :: accumulator) // otherwise, add the list element to the accumulator
      }
      Some(minElement, rest) // return the minimum element list element and the rest of the list as Some((minElement, rest))
  }

  // Define the main sorting function that recursively finds the minimum element list element and adds it to a sorted list
  def selectionSort(list: List[Int]): List[Int] = {
    def sortHelper(unsorted: List[Int], sorted: List[Int]): List[Int] = {
      findminimum (unsorted) match {
        case None => sorted.reverse // if there are no list elements left in the unsorted list, return the sorted list in reverse order because list elements were added to the front
        case Some((minElement, rest)) => sortHelper(rest, minElement :: sorted) // otherwise, add the minimum element list element to the sorted list and continue sorting the rest of the list
      }
    }

    sortHelper(list, Nil) // start sorting with an empty sorted list
  }
}
