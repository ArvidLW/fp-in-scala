#!/usr/bin/env scala

case class Player(name: String, score: Double) {
  override def toString(): String = name
}

def declareWinner(players: List[Player]): Unit =
  printWinner(players.reduceLeft(winner))

def declareWinner(p1: Player, p2: Player): Unit =
  printWinner(winner(p1, p2))

def printWinner(p1: Player): Unit =
  println(p1 + " is the winner")

def winner(p1: Player, p2: Player): Player = {
  println(p1 + ":" + p2)
  if (p1.score > p2.score) p1 else p2
}

val players = List(Player("Sue", 70), Player("Bob", 18), Player("Joe", 11), Player("Bill", 100))
declareWinner(players)

val sue = Player("Sue", 7.9999999999999999)
val bob = Player("Bob", 8.0)
declareWinner(sue, bob)