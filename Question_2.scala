//Importing required libraries
import scala.io.Source
/*
* Creating a case class for storing the player objects and the attributes of the player are as follows
* Year: Int
* Name: String
* Country: String
* Matches: Int
* Runs: Int
* Wickets: Int
* */
case class Player(Year: Int, Name: String, Country: String, Matches: Int, Runs: Int, Wickets: Int)
class Question_2 {
  /*
  * Return : List[Player] A list of player(case class created) objects.
  * Declaring a function for reading the input from the file
  * */


  private def read_data_from_file(): List[Player] = {
    //Reading data from the file
    val players = Source.fromFile("//Users//chakradhar//Desktop//runs.txt")
      .getLines() //Fecthing the lines from text file
      // Mapping the line and object created
      .map(line => {
        // Storing the values obtained by splitting the fetched line
        val Array(year, name, country, matches, runs, wickets) = line.split(", ")
        // Creating objects from the fecthed values above
        Player(year.toInt, name, country, matches.toInt, runs.toInt, wickets.toInt)
      })
      // Conversion to list
      .toList
    // Returning the created list of player objects
    return players
  }
/*
* @param1 : playerobjects: List[Player] A list of player(case class created) objects.
* Return : Unit
* This method takes a list of Player objects and prints out their information such as name, country, year, runs, matches, and wickets.
* */
  private def print_player_info(playerobjects: List[Player]): Unit = {
    var cnt = 1 // For Serial No
    // For loop for traversing through the objects in the list
    for (playerobject <- playerobjects) {
      // Printing the data in the object
      println("S.NO : " + cnt + "\nName : " + playerobject.Name + "\nCounty : " + playerobject.Country + "\nYear : " + playerobject.Year + "\nRuns : " + playerobject.Runs + "\nMatches : " + playerobject.Matches + "\nWickets : " + playerobject.Wickets)
      println()
      cnt = cnt + 1 // Incrementing the counter for serial NO
    }
  }

  /*
  * @param1 : playerobjects: List[Player] A list of player(case class created) objects.
  * Return : Unit
  * This method takes a list of Player objects and prints out their information such as name, country, year, runs, matches, wickets, and Performance.
  * */
  private def print_player_info_with_ranks(playerobjects: List[Player]): Unit = {
    var cnt = 1 // For Serial No
    // For loop for traversing through the objects in the list
    for (playerobject <- playerobjects) {
      // Printing the data in the object
      println("Name : " + playerobject.Name + "\nRank : " + cnt + "\nCounty : " + playerobject.Country + "\nYear : " + playerobject.Year + "\nRuns : " + playerobject.Runs + "\nMatches : " + playerobject.Matches + "\nWickets : " + playerobject.Wickets + "\nPerformance : " + (5 * playerobject.Wickets + 0.05 * playerobject.Runs))
      cnt = cnt + 1 // Incrementing the counter for serial NO
      println()
    }
  }

}

// Creating object to run
object Question_2 {
  /*
  * @param1 : args: Array[String]  Arguments
  * @Return : Unit
  * The main method creates an object of the Question_2 class and calls the
  *  desired methods for the desired activities.
  * */
  def main(args: Array[String]): Unit = {
    val obj = new Question_2() // Creation of Object
    val players = obj.read_data_from_file() // Reading Data from the file
    println("--------------Question - 1-------------")
    // Sorting the players using sortby function by using runs as metric in reverse order and picking the top element.
    obj.print_player_info(players.sortBy(_.Runs)(Ordering[Int].reverse).take(1))
    println()
    println("--------------Question - 2-------------")
    // Sorting the players using sortby function by using runs as metric in reverse order and picking the top 5 elements.
    obj.print_player_info(players.sortBy(_.Runs)(Ordering[Int].reverse).take(5))
    println()
    println("--------------Question - 3-------------")
    // Sorting the players using sortby function by using no of wickets as metric in reverse order and picking the top 5 elements.
    obj.print_player_info(players.sortBy(_.Wickets)(Ordering[Int].reverse).take(5))
    println()
    println("--------------Question - 4-------------")
    // Sorting the players using sortby function by using 5 * r.Wickets + 0.05 * r.Runs as metric in reverse order and picking the top 5 elements.
    obj.print_player_info_with_ranks(players.sortBy(r => 5 * r.Wickets + 0.05 * r.Runs)(Ordering[Double].reverse).take(5))
  }
}
