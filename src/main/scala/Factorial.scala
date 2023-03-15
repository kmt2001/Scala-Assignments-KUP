object Factorial {

  /**
   * Calculates the factorial of a non-negative integer using recursion.
   *
   * @param number the non-negative integer to calculate the factorial for
   * @param accumulator the accumulator for the intermediate result, initialized to 1
   * @return the factorial of the input integer
   * @throws IllegalArgumentException if the input value is negative
   */
  def factorial(number: Int, accumulator: BigInt = 1): BigInt = {
    // Check if the input value is negative, and throw an exception if it is
    if (number < 0) {
      throw new IllegalArgumentException("Input value must be non-negative")
    }
    // Base case: if the input value is 0, return the accumulator
    else if (number == 0) {
      accumulator
    }
    // Recursive case: call the factorial function with the input value decremented by 1,
    // and the accumulator multiplied by the current input value
    else {
      factorial(number - 1, accumulator * number)
    }
  }
}
