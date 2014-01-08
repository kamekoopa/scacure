package com.github.kamekoopa.scacure.utils

import org.joda.time.{Interval, DateTime}
import com.github.kamekoopa.scacure._
import com.github.kamekoopa.scacure.Series
import scala.language.implicitConversions

trait Utils {

  def tuple2Date(tpl: (Int, Int, Int)): DateTime = tpl match {
    case(y, m, d) => new DateTime(y, m, d, 0, 0)
  }

  implicit def SeriesDefsToSeq(list: SeriesDefs): Seq[Series] = list.series

  implicit def GirlsDefsToSeq(list: GirlsDefs): Seq[Girl] = list.girls

  implicit class StatusRecord(val state: State) {
    def ->(name: String) :(State, String) = (state, name)
  }

  implicit class DateTimeInterval(start: (Int, Int, Int)) {
    def ~(end: (Int, Int, Int)): Interval = new Interval(tuple2Date(start), tuple2Date(end))
  }
}
