package practice

import scala.io.Source

case class Player(Year: Int, Name: String, Country: String, Matches: Int, Runs: Int, Wickets: Int)

class Question_2 {
  private def read_data_from_file(): List[Player] = {
    val players = Source.fromFile("//Users//chakradhar//Desktop//runs.txt")
      .getLines()
      .map(line => {
        val Array(year, name, country, matches, runs, wickets) = line.split(", ")
        Player(year.toInt, name, country, matches.toInt, runs.toInt, wickets.toInt)
      })
      .toList
    return players
  }

  private def print_player_info(playerobjects: List[Player]): Unit = {
    var cnt = 1
    for (playerobject <- playerobjects) {
      println("S.NO : " + cnt + "\nName : " + playerobject.Name + "\nCounty : " + playerobject.Country + "\nYear : " + playerobject.Year + "\nRuns : " + playerobject.Runs + "\nMatches : " + playerobject.Matches + "\nWickets : " + playerobject.Wickets)
      println()
      cnt = cnt + 1
    }
  }

  private def print_player_info_with_ranks(playerobjects: List[Player]): Unit = {
    var cnt = 1
    for (playerobject <- playerobjects) {
      println("Name : " + playerobject.Name + "\nRank : " + cnt + "\nCounty : " + playerobject.Country + "\nYear : " + playerobject.Year + "\nRuns : " + playerobject.Runs + "\nMatches : " + playerobject.Matches + "\nWickets : " + playerobject.Wickets + "\nPerformance : " + 5 * playerobject.Wickets + 0.05 * playerobject.Runs)
      cnt = cnt + 1
      println()
    }
  }

}

object Question_2 {
  def main(args: Array[String]): Unit = {
    val obj = new Question_2()
    val players = obj.read_data_from_file()
    println("--------------Question - 1-------------")
    obj.print_player_info(players.sortBy(_.Runs)(Ordering[Int].reverse).take(1))
    println()
    println("--------------Question - 2-------------")
    obj.print_player_info(players.sortBy(_.Runs)(Ordering[Int].reverse).take(5))
    println()
    println("--------------Question - 3-------------")
    obj.print_player_info(players.sortBy(_.Wickets)(Ordering[Int].reverse).take(5))
    println()
    println("--------------Question - 4-------------")
    obj.print_player_info_with_ranks(players.sortBy(r => 5 * r.Wickets + 0.05 * r.Runs)(Ordering[Double].reverse).take(5))
  }
}
