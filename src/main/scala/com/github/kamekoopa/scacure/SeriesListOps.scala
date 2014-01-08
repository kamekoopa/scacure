package com.github.kamekoopa.scacure

import org.joda.time.Interval

trait SeriesListOps {

  val series: Seq[Series]

  def apply(id: String): Series = {
    series.find({s => s.identifier == id}).getOrElse(series.head)
  }

  def now: Option[Series] = {
    series.find(s => s.nowOnAir)
  }

  implicit class SeriesBuilder(val id: String) {
    def isDefined(title: String, broadcast: Interval, girls: Seq[Girl]): Series = {
      Series(id, title, broadcast, girls)
    }
  }
}
