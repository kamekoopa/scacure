package com.github.kamekoopa.scacure

import org.joda.time.{Interval, DateTime}

case class Series(
  identifier: String,
  title: String,
  broadcast: Interval,
  girls: Seq[Girl]
) {

  val started: DateTime = broadcast.getStart

  val ended: DateTime = broadcast.getEnd

  def nowOnAir: Boolean = broadcast.containsNow()

  def onAir(date: DateTime): Boolean = broadcast.contains(date)

  def onAir(date: (Int, Int, Int)): Boolean = onAir(tuple2Date(date))
}
