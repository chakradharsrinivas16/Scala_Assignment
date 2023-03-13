class Question_1() {
  /**
   * @param-1 : n:Double Given value
   * @Return : Unit
   * The given code defines a class Question_1 with a single method get_bucket that takes a double value n
   * as input, calculates the bucket range for the given value based on the given rules
   */
  def get_bucket(n: Double): Unit = {
    // Fetching the last two digits
    var last_two_digits = (String.format("%.2f", (n * 1000) % 100))
    print(f"Value :  $n%,.2f") // Printing the fetched digits
    /*
    * If the value of the last two digits after the decimal point is greater than or equal to 50,
    * then the bucket range is from `n - (last two digits/1000) + 0.050 to n + (99 - last two digits)/1000`.
    * */
    if (last_two_digits.toDouble >= 50) {
      val left = n - (last_two_digits.toDouble / 1000) + 0.050 // Calculating and Storing the left limit
      val right = n + (99 - last_two_digits.toDouble) / 1000 // Calculating and Storing the right limit
      print(f" Bucket : $left%,.3f" + " - " + f"$right%,.3f\n") // Printing the fetched limits
    }
      /*
      *Otherwise, the bucket range is from `n - (last two digits/1000) to n + (49 - last two digits)/1000`.
      */
    else {
      val left = n - (last_two_digits.toDouble / 1000) // Calculating and Storing the left limit
      val right = n + (49 - last_two_digits.toDouble) / 1000 // Calculating and Storing the right limit
      print(f" Bucket : $left%,.3f" + " - " + f"$right%,.3f\n") // Printing the fetched limits
    }
  }
}

// Creating object to run
object Question_1 {
  /*
  * @param1 : args: Array[String]  Arguments
  * @Return : Unit
  * The main method creates an object of the Question_1 class and calls the
  *  get_bucket method for an array of double values.
  * */
  def main(args: Array[String]): Unit = {
    val obj = new Question_1() // Creation of object for above created class
    //Storing the values in an Array and fetching the bucket related to the given values. 
    val values = Array(12.05,
      12.99,
      10.33,
      11.45,
      13.50)
    for (i <- values) {
      //calling the get_bucket function to fetch the bucket details
      obj.get_bucket(i)
    }
  }
}
