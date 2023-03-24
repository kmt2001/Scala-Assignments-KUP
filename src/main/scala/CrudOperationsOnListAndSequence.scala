//author: Krishna Mohan Tiwari
//Date: March 24, 2023
//----------------------------------------------------------------------------------//
abstract class CRUDOperations[T] {

  // Create a new element of type T
  def create(element: T): Seq[T]

  // Read all elements of type T
  def read(): Seq[T]

  // Update an element at a given index with a new element of type T
  def update(index: Int, element: T): Seq[T]

  // Delete an element of type T
  def delete(element: T): Seq[T]
}

// Implement the CRUDOperations class for List elements
class ListCRUDOperations[T] extends CRUDOperations[T] {

  // Define an empty list of elements of type T
  private var elements: List[T] = List.empty[T]

  // Create a new element of type T and add it to the list
  override def create(newElement: T): Seq[T] = {
    elements = elements :+ newElement
    elements
  }

  // Read all elements of type T in the list
  override def read(): Seq[T] = {
    elements
  }

  // Update an element at a given index with a new element of type T
override def update(index: Int, newElement: T): Seq[T] = {
  if (index < 0 || index >= elements.length) {
    throw new IndexOutOfBoundsException("Invalid index")
  }
  elements = elements.zipWithIndex.map { case (currentElement, currentIndex) =>
    if (currentIndex == index) newElement else currentElement
  }
  elements
}

  // Delete an element of type T from the list
  override def delete(elementToDelete: T): Seq[T] = {
    elements.filterNot(_ == elementToDelete)
  }
}



//----------------------------------------------------------------------------------//
// Implement the CRUDOperations class for Seq elements
class SequenceCRUDOperations[T] extends CRUDOperations[T] {

  // Define an empty sequence of elements of type T
  private var elements: Seq[T] = Seq.empty[T]

  // Create a new element of type T and add it to the sequence
override def create(newElement: T): Seq[T] = {
  elements = elements :+ newElement
  elements
}

  // Read all elements of type T in the sequence
  override def read(): Seq[T] = {
    elements
  }

  // Update an element at a given index with a new element of type T
  override def update(index: Int, newElement: T): Seq[T] = {
    if (index < 0 || index >= elements.length) {
      throw new IndexOutOfBoundsException("Invalid index")
    }
    elements.zipWithIndex.map { case (currentElement, currentIndex) =>
      if (currentIndex == index) newElement else currentElement
    }
  }

  // Delete an element of type T from the sequence
  override def delete(elementToDelete: T): Seq[T] = {
    val index = elements.indexOf(elementToDelete)
    if (index >= 0) {
      elements.take(index) ++ elements.drop(index + 1)
    } else {
      elements
    }
  }
}
//-----------------------------------------------------------------------------------------//
//test cases are in test folder