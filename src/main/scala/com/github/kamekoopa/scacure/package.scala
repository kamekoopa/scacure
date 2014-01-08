package com.github.kamekoopa

import org.joda.time.{Interval, DateTime}
import com.github.kamekoopa.scacure.utils._
import com.github.kamekoopa.scacure.TransformStatus._
import scala.language.implicitConversions

package object scacure extends Object
  with ToShowOps
  with Utils
{
  private val defaultSeries = "Unmarked"

  /** definition of precures */
  trait GirlsDefs extends GirlsOps {

    val girls: Seq[Girl] = Seq(

      "CureBlack" isDefined (
        statuses = Map(
          Human       -> "美墨なぎさ",
          Transformed -> "キュアブラック"
        ),
        transformMessage =
          """
            |デュアル・オーロラ・ウェイブ！！
            |光の使者、キュアブラック！
            |ふたりはプリキュア！
            |闇の力のしもべ達よ！
            |とっととお家に帰りなさい！
            |""".stripMargin
        ,
        createdDate = (2004, 2, 1)
      ),

      "CureWhite" isDefined (
        statuses = Map(
          Human       -> "雪城ほのか",
          Transformed -> "キュアホワイト"
        ),
        transformMessage =
          """
            |デュアル・オーロラ・ウェイブ！！
            |光の使者、キュアホワイト！
            |ふたりはプリキュア！
            |闇の力のしもべ達よ！
            |とっととお家に帰りなさい！
            |""".stripMargin
        ,
        createdDate = (2004, 2, 1)
      ),

      "ShinyLuminous" isDefined (
        statuses = Map(
          Human       -> "九条ひかり",
          Transformed -> "シャイニールミナス"
        ),
        transformMessage =
          """
            |ルミナス・シャイニングストリーム！
            |輝く命、シャイニールミナス！
            |光の心と光の意志、すべてを一つにするために！
            |""".stripMargin
        ,
        createdDate = (2005, 3, 6)
      )
    )
  }


  /** definition of series */
  trait SeriesDefs extends SeriesListOps {

    val series: Seq[Series] = Seq(

      defaultSeries isDefined (
        title = "ふたりはプリキュア",
        broadcast = (2004, 2, 1) ~ (2005, 1, 30),
        girls = Girls (
          "CureBlack",
          "CureWhite"
        )
      ),

      "MaxHeart" isDefined (
        title = "ふたりはプリキュア Max Heart",
        broadcast = (2005, 2, 6) ~ (2006, 1, 29),
        girls = Girls (
          "CureBlack",
          "CureWhite",
          "ShinyLuminous"
        )
      )
    )
  }


  /** Facade */
  object Precure extends SeriesDefs

  object Girls extends GirlsDefs


  /** instance of type class */
  implicit object StringShow extends Show[String] {
    def show(a: String): String = a
  }

  /** instance of type class */
  implicit object DateTimeShow extends Show[DateTime] {
    def show(a: DateTime): String = s"${a.getYear}-${a.getMonthOfYear}-${a.getDayOfMonth}"
  }

  /** instance of type class */
  implicit object IntervalShow extends Show[Interval] {
    def show(a: Interval): String = {
      val start = a.getStart
      val end = a.getEnd
      s"${start.getYear}-${start.getMonthOfYear}-${start.getDayOfMonth} 〜 ${end.getYear}-${end.getMonthOfYear}-${end.getDayOfMonth}"
    }
  }
}
