// Define a case class for Tests with a string value and a boolean indicating whether the value is even
case class Test(value: String, isEven: Boolean)

// Define a class for processing lists of Tests
class TestProcessor {

  // Method to filter even values from a list of Tests
  def filterEvenValues(tests: List[Test]): List[Test] = {
    tests.filter(_.isEven)
  }

  // Method to filter odd values from a list of Tests
  def filterOddValues(tests: List[Test]): List[Test] = {
    tests.filterNot(_.isEven)
  }

  // Method to partition a list of Tests into even and odd lists
  def partitionTestsByEvenOdd(tests: List[Test]): (List[Test], List[Test]) = {
    tests.partition(_.isEven)
  }

  // Method to extract the value of the first field from a list of even Tests
  def extractFirstFieldValueFromEvenTests(tests: List[Test]): List[String] = {
    filterEvenValues(tests).map(_.value)
  }
}

// Define an object to run the code
object Main extends App {

  // Define a list of Tests to use in the processing
  private val testList = List(Test("1", isEven = false), Test("2", isEven = true), Test("3", isEven = false), Test("4", isEven = true), Test("5", isEven = false))

  // Create an instance of the TestProcessor class
  private val testProcessor = new TestProcessor

  // Filter even values from the list of tests
  private val evenValues = testProcessor.filterEvenValues(testList)
  println(s"Even values: $evenValues")

  // Filter odd values from the list of tests
  private val oddValues = testProcessor.filterOddValues(testList)
  println(s"Odd values: $oddValues")

  // Partition the list of tests into even and odd lists
  private val (evenList, oddList) = testProcessor.partitionTestsByEvenOdd(testList)
  println(s"Even list: $evenList")
  println(s"Odd list: $oddList")

  // Extract the value of the first field from the list of even Tests
  private val firstFieldValues = testProcessor.extractFirstFieldValueFromEvenTests(testList)
  println(s"First field values from even tests: $firstFieldValues")
}
