package com.github.kamekoopa.scacure

import org.joda.time.DateTime
import TransformStatus._

case class Girl(
  identifier: String,
  statuses: Map[State, String],
  transformMessage: String,
  currentState: State = Human,
  createdDate: DateTime
) {

  def name: String = {
    statuses.get(currentState) match {
      case Some(name) => name
      case None => throw new Exception("name is undefined in current status")
    }
  }

  def transform: Girl = {
    currentState match {
      case Human       if statuses.get(Transformed).isDefined => this.copy(currentState = Transformed)
      case Transformed if statuses.get(Extra).isDefined       => this.copy(currentState = Extra)
      case _                                                  => this.copy(currentState = Human)
    }
  }

  def humanize: Girl = this.copy(currentState = Human)
}


abstract sealed class State
object TransformStatus {
  case object Human extends State
  case object Transformed extends State
  case object Extra extends State
}
