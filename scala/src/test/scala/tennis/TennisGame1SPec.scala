package tennis

import org.scalatest.{FlatSpec, Matchers}

case class TennisTestCase(player1Score: Int, player2Score: Int, expectedScore: String)

class TennisGame1SPec extends FlatSpec
  with Matchers {

  val testCases = TennisGame1SPec.getAllScores()
  for (testCase <- testCases) {

    "TennisGame1" should s"return the correct score for ${testCase}" in {
      val game = new TennisGame1("player1", "player2")
      for (i <- 0 until testCase.player1Score) {
        game.wonPoint("player1")
      }
      for (i <- 0 until testCase.player2Score) {
        game.wonPoint("player2")
      }
      game.calculateScore() should equal(testCase.expectedScore)
    }

    "TennisGame2" should s"return the correct score for ${testCase}" in {
      val game = new TennisGame2("player1", "player2")
      for (i <- 0 until testCase.player1Score) {
        game.wonPoint("player1")
      }
      for (i <- 0 until testCase.player2Score) {
        game.wonPoint("player2")
      }
      game.calculateScore() should equal(testCase.expectedScore)
    }

    "TennisGame3" should s"return the correct score for ${testCase}" in {
      val game = new TennisGame3("player1", "player2")
      for (i <- 0 until testCase.player1Score) {
        game.wonPoint("player1")
      }
      for (i <- 0 until testCase.player2Score) {
        game.wonPoint("player2")
      }
      game.calculateScore() should equal(testCase.expectedScore)
    }
  }
}

object TennisGame1SPec {

  def getAllScores(): Seq[TennisTestCase] = {
    Seq(
      TennisTestCase(0, 0, "Love-All"),
      TennisTestCase(1, 1, "Fifteen-All"),
      TennisTestCase(2, 2, "Thirty-All"),
      TennisTestCase(3, 3, "Deuce"),
      TennisTestCase(4, 4, "Deuce"),

      TennisTestCase(1, 0, "Fifteen-Love"),
      TennisTestCase(0, 1, "Love-Fifteen"),
      TennisTestCase(2, 0, "Thirty-Love"),
      TennisTestCase(0, 2, "Love-Thirty"),
      TennisTestCase(3, 0, "Forty-Love"),
      TennisTestCase(0, 3, "Love-Forty"),
      TennisTestCase(4, 0, "Win for player1"),
      TennisTestCase(0, 4, "Win for player2"),

      TennisTestCase(2, 1, "Thirty-Fifteen"),
      TennisTestCase(1, 2, "Fifteen-Thirty"),
      TennisTestCase(3, 1, "Forty-Fifteen"),
      TennisTestCase(1, 3, "Fifteen-Forty"),
      TennisTestCase(4, 1, "Win for player1"),
      TennisTestCase(1, 4, "Win for player2"),

      TennisTestCase(3, 2, "Forty-Thirty"),
      TennisTestCase(2, 3, "Thirty-Forty"),
      TennisTestCase(4, 2, "Win for player1"),
      TennisTestCase(2, 4, "Win for player2"),

      TennisTestCase(4, 3, "Advantage player1"),
      TennisTestCase(3, 4, "Advantage player2"),
      TennisTestCase(5, 4, "Advantage player1"),
      TennisTestCase(4, 5, "Advantage player2"),
      TennisTestCase(15, 14, "Advantage player1"),
      TennisTestCase(14, 15, "Advantage player2"),

      TennisTestCase(6, 4, "Win for player1"),
      TennisTestCase(4, 6, "Win for player2"),
      TennisTestCase(16, 14, "Win for player1"),
      TennisTestCase(14, 16, "Win for player2")
    )
  }
}
