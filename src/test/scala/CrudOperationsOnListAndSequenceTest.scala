import org.scalatest.funsuite.AnyFunSuite

class CrudOperationsOnListAndSequenceTest extends AnyFunSuite {

  // Test ListCRUDOperations
  test("create, read, update and delete elements in ListCRUDOperations") {
    val listCRUD = new ListCRUDOperations[Int]
    listCRUD.create(1)
    listCRUD.create(2)
    listCRUD.create(3)

    // Test create and read
    assert(listCRUD.read() == Seq(1, 2, 3))

    // Test update
    assert(listCRUD.update(1, 4) == Seq(1, 4, 3))

    // Test delete
    assert(listCRUD.delete(3) == Seq(1, 4))
  }

  // Test SequenceCRUDOperations
test("create, read, update and delete elements in SequenceCRUDOperations") {
  val seqCRUD = new SequenceCRUDOperations[Boolean]
  seqCRUD.create(true)
  seqCRUD.create(false)
  seqCRUD.create(true)

  // Test create and read
  assert(seqCRUD.read() == Seq(true, false, true))

  // Test update
  assert(seqCRUD.update(2, false) == Seq(true, false, false))

  // Test delete
  assert(seqCRUD.delete(false) == Seq(true, true))
}
}
