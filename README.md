# Scala_Assignment

The assignement has 2 questions, I have used classes and objects to fetch the desired output.

### Question - 1

We need to Bucktize the given values, i.e we need to check in which bucket the value given falls in. Here the buckets are of capacity 0.05. The bucket intervals are as in the manner of (x,x+0.049).

The sample intervals are as below - 

```
0.000 - 0.049
0.050 - 0.099
0.100 - 0.149
0.150 - 0.199
0.200 - 0.249
0.250 - 0.299
0.300 - 0.349
0.350 - 0.399 
...
...
100.000 - 100.049
```
The given code defines a class Question_1 with a single method get_bucket that takes a double value n as input, calculates the bucket range for the given value based on the following rules:

If the value of the last two digits after the decimal point is greater than or equal to 50, then the bucket range is from `n - (last two digits/1000) + 0.050 to n + (99 - last two digits)/1000`.
Otherwise, the bucket range is from `n - (last two digits/1000) to n + (49 - last two digits)/1000`.
```
  def get_bucket(n: Double): Unit = {
    var last_two_digits = (n * 1000) % 100
    print(f"Value :  $n") // Printing the fetched digits
    if (last_two_digits >= 50) {
      val left = n - (last_two_digits / 1000) + 0.050 // Calculating and Storing the left limit
      val right = n + (99 - last_two_digits) / 1000 // Calculating and Storing the right limit
      print(f" Bucket : $left%,.3f" + " - " + f"$right%,.3f\n") // Printing the fetched limits
    }
    else {
      val left = n - (last_two_digits / 1000) // Calculating and Storing the left limit
      val right = n + (49 - last_two_digits) / 1000 // Calculating and Storing the right limit
      print(f" Bucket : $left%,.3f" + " - " + f"$right%,.3f\n") // Printing the fetched limits
    }
  }
}
```
The main method creates an object of the Question_1 class and calls the get_bucket method for an array of double values.
```
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
```
### Test run 

<img width="576" alt="Screenshot 2023-03-13 at 7 43 10 PM" src="https://user-images.githubusercontent.com/123494344/224727494-0520b3f1-5a43-4e85-8124-d588bc17cbff.png">

### Question - 2

We need to answer the given questions(4), in order to work upon players we created a case class called players and declared some attributes to it, and played with them.
#### Note - Please find that data abot the players are taken from .txt file and mapped.

The below is the case class definition for a player object. It has six attributes:

- Year: an integer representing the year in which the player played.
- Name: a string representing the name of the player.
- Country: a string representing the country that the player represents.
- Matches: an integer representing the number of matches that the player played.
- Runs: an integer representing the number of runs that the player scored.
- Wickets: an integer representing the number of wickets that the player took.

```
case class Player(Year: Int, Name: String, Country: String, Matches: Int, Runs: Int, Wickets: Int)
```
The `read_data_from_file` function uses the Source library to read data from the file, runs.txt. It then maps the lines of the file to player objects by splitting each line and creating a new Player object from the extracted values. The function returns a list of Player objects.

```
  private def read_data_from_file(): List[Player] = {
    //Reading data from the file
    val players = Source.fromFile("//Users//chakradhar//Desktop//runs.txt")
      .getLines() //Fecthing the lines from text file
      // Mapping the line and object created
      .map(line => {
        // Storing the values obtained by splitting the fetched line
        val Array(year, name, country, matches, runs, wickets) = line.trim.split(", ")
        // Creating objects from the fecthed values above
        Player(year.toInt, name, country, matches.toInt, runs.toInt, wickets.toInt)
      })
      // Conversion to list
      .toList
    // Returning the created list of player objects
    return players
  }

```

The `print_player_info` function takes a list of Player objects and prints out information such as the name, country, year, runs, matches, and wickets for each player. The function uses a for loop to iterate through each player object in the list and prints out the information using println.

```
  private def print_player_info(playerobjects: List[Player]): Unit = {
    var cnt = 1 // For Serial No
    // For loop for traversing through the objects in the list
    for (playerobject <- playerobjects) {
      // Printing the data in the object
      println("S.NO : " + cnt + "\nName : " + playerobject.Name + "\nCounty : " + playerobject.Country + "\nYear : " + playerobject.Year + "\nRuns : " + playerobject.Runs + "\nMatches : " + playerobject.Matches + "\nWickets : " + playerobject.Wickets)
      println()
      cnt = cnt + 1 // Incrementing the counter for serial NO
    }

```

The `print_player_info_with_ranks` function is similar to print_player_info, but it also calculates and prints out a performance metric based on the player's runs and wickets. The performance metric is calculated as 5 times the number of wickets plus 0.05 times the number of runs. The function takes a list of Player objects and prints out the same information as print_player_info, but also includes the rank of the player based on their performance metric.

```
  private def print_player_info_with_ranks(playerobjects: List[Player]): Unit = {
    var cnt = 1 // For Serial No
    // For loop for traversing through the objects in the list
    for (playerobject <- playerobjects) {
      // Printing the data in the object
      println("Name : " + playerobject.Name + "\nRank : " + cnt + "\nCounty : " + playerobject.Country + "\nYear : " + playerobject.Year + "\nRuns : " + playerobject.Runs + "\nMatches : " + playerobject.Matches + "\nWickets : " + playerobject.Wickets + "\nPerformance : " + 5 * playerobject.Wickets + (0.05 * playerobject.Runs))
      cnt = cnt + 1 // Incrementing the counter for serial NO
      println()
    }
  }

```

The main function creates an instance of Question_2 and uses it to call the other functions to answer four questions.

#### Question 2.1
The operation is finding the player with the highest number of runs, using the sortBy method with the Runs attribute and a reverse ordering and below is snippet of code.

```
obj.print_player_info(players.sortBy(_.Runs)(Ordering[Int].reverse).take(1))
```

#### Question 2.2
The operation is finding the top 5 players by runs, again using the sortBy method with the Runs attribute and a reverse ordering, and then taking the first five elements of the resulting collection.

```
obj.print_player_info(players.sortBy(_.Runs)(Ordering[Int].reverse).take(5))
``` 

#### Question 2.3
The operation is finding the top 5 players by wickets, using the sortBy method with the Wickets attribute and a reverse ordering, and again taking the first five elements of the resulting collection.

```
obj.print_player_info(players.sortBy(_.Wickets)(Ordering[Int].reverse).take(5))
```

#### Question 2.4
The operation is computing a composite ranking score for each player as 5 times their number of wickets plus 0.05 times their number of runs, sorting the players by this metric in reverse order, and selecting the top 5 players. The sortBy method is used here again, but with a custom function that computes the ranking score for each player.

```
obj.print_player_info_with_ranks(players.sortBy(r => 5 * r.Wickets + 0.05 * r.Runs)(Ordering[Double].reverse).take(5))
```

After sorting and selecting the relevant players in each operation, the print_player_info method is called to print out a formatted string with the player's information, including their name, country, matches played, runs scored, and wickets taken.

### Test run - 

<img width="714" alt="Screenshot 2023-03-13 at 10 30 46 PM" src="https://user-images.githubusercontent.com/123494344/224773053-9a9dd665-b5ab-42f9-8bc3-a7eb7828dd3d.png">

<img width="401" alt="Screenshot 2023-03-13 at 10 31 00 PM" src="https://user-images.githubusercontent.com/123494344/224773192-14e845a6-130c-45e8-a7ff-eaeec5473a79.png">

<img width="381" alt="Screenshot 2023-03-14 at 1 56 48 AM" src="https://user-images.githubusercontent.com/123494344/224824539-0b2d0811-e497-48e1-9320-c1b56f5cabdd.png">
