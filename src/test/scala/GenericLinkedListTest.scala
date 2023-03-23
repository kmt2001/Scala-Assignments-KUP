import org.scalatest.funsuite.AnyFunSuite

class GenericLinkedListTest extends AnyFunSuite {
  test("insert") {
    val emptyList = EmptyList
    val list1 = emptyList.insert(1)
    val list2 = list1.insert(2.0)
    val list3 = list2.insert("three")
    assert(list1.traverse() === List(1))
    assert(list2.traverse() === List(2.0, 1))
    assert(list3.traverse() === List("three", 2.0, 1))
  }

  test("delete") {
    val emptyList = EmptyList
    val list1 = emptyList.insert(1).insert(2).insert(3)
    val list2 = list1.delete(2)
    val list3 = list2.delete(1)
    assert(list1.traverse() === List(3, 2, 1))
    assert(list2.traverse() === List(3, 1))
    assert(list3.traverse() === List(3))
  }

  test("search") {
    val emptyList = EmptyList
    val list1 = emptyList.insert(1).insert(2.0).insert("three")
    assert(list1.search(1) === Some(1))
    assert(list1.search(2.0) === Some(2.0))
    assert(list1.search("three") === Some("three"))
    assert(list1.search("four") === None)
  }

  test("traverse") {
    val emptyList = EmptyList
    val list1 = emptyList.insert(1).insert(2).insert(3)
    assert(list1.traverse() === List(3, 2, 1))
    val list2 = list1.delete(2)
    assert(list2.traverse() === List(3, 1))
    val list3 = list2.delete(1)
    assert(list3.traverse() === List(3))
  }
}
