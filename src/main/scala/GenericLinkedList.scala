//author: Krishna Mohan Tiwari
//Date: march 23, 2023

/**
 * A trait representing a linked list.
 *
 * @tparam A The type of the elements in the list.
 */
sealed trait LinkedList[+A] {

  /**
   * Inserts a new element into the list.
   *
   * @tparam B The supertype of A and the type of the new value to be inserted.
   * @param value The value to insert.
   * @return A new linked list with the value inserted.
   */
  def insert[B >: A](value: B): LinkedList[B]

  /**
   * Deletes an element from the list.
   *
   * @tparam B The supertype of A and the type of the value to be deleted.
   * @param value The value to delete.
   * @return A new linked list with the value deleted.
   */
  def delete[B >: A](value: B): LinkedList[B]

  /**
   * Searches for an element in the list.
   *
   * @tparam B The supertype of A and the type of the value to search for.
   * @param value The value to search for.
   * @return An Option containing the value if it was found, otherwise None.
   */
  def search[B >: A](value: B): Option[B]

  /**
   * Traverses the list and returns a list of its elements.
   *
   * @return A List containing the elements of the linked list.
   */
  def traverse(): List[A]
}

/**
 * An object representing an empty linked list.
 */
case object EmptyList extends LinkedList[Nothing] {
  override def insert[B](value: B): LinkedList[B] = Node(value, EmptyList)
  override def delete[B](value: B): LinkedList[B] = EmptyList
  override def search[B](value: B): Option[B] = None
  override def traverse(): List[Nothing] = Nil
}

/**
 * A class representing a non-empty linked list node.
 *
 * @tparam A The type of the element contained in the node.
 * @param value The value contained in the node.
 * @param next The next element in the linked list.
 */
case class Node[+A](value: A, next: LinkedList[A]) extends LinkedList[A] {
  override def insert[B >: A](newValue: B): LinkedList[B] =
    Node(newValue, this)

  override def delete[B >: A](deleteValue: B): LinkedList[B] =
    try {
      if (value == deleteValue) next.delete(deleteValue)
      else Node(value, next.delete(deleteValue))
    } catch {
      case e: NoSuchElementException =>
        throw new NoSuchElementException("Value not found in list.")
    }

  override def search[B >: A](searchValue: B): Option[B] =
    try {
      if (value == searchValue) Some(value)
      else next.search(searchValue)
    } catch {
      case e: NoSuchElementException =>
        throw new NoSuchElementException("Value not found in list.")
    }

  override def traverse(): List[A] = value :: next.traverse()
}

//Test cases are in test folder.