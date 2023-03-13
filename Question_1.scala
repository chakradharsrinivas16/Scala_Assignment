class Question_1() {
  def get_bucket(n: Double): Unit = {
    var temp = (String.format("%.2f", (n * 1000) % 100))
    print(f"Value :  $n%,.2f")
    if (temp.toDouble >= 50) {
      val left = n - (temp.toDouble / 1000) + 0.050
      val right = n + (99 - temp.toDouble) / 1000
      print(f" Bucket : $left%,.3f" + " - " + f"$right%,.3f\n")
    }
    else {
      val left = n - (temp.toDouble / 1000)
      val right = n + (49 - temp.toDouble) / 1000
      print(f" Bucket : $left%,.3f" + " - " + f"$right%,.3f\n")
    }
  }
}

object Question_1 {
  def main(args: Array[String]): Unit = {
    val obj = new Question_1()
    val values = Array(12.05,
      12.99,
      10.33,
      11.45,
      13.50)
    for (i <- values) {
      obj.get_bucket(i)
    }
  }
}