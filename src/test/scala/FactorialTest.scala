// Define an object named FactorialTest that extends App
object FactorialTest extends App{

  // Define some unit test cases using the assert method, which checks if the
  // factorial function returns the expected results for several input values
  assert(Factorial.factorial(0) == 1)
  assert(Factorial.factorial(1) == 1)
  assert(Factorial.factorial(5) == 120)
  assert(Factorial.factorial(10) == 3628800)
  assert(Factorial.factorial(1000).toString.length == 2568)
  assert(Factorial.factorial(20) == BigInt("2432902008176640000"))

  // Print a success message if all the tests pass
  println("All Test Cases Passed Successfully!")
}
