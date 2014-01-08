package com.github.kamekoopa.scacure

trait GirlsOps {

  val girls: Seq[Girl]

  def apply(id: String): Option[Girl] = {
    girls.find(_.identifier == id)
  }

  def apply(ids: String * ): Seq[Girl] = {
    ids.map({id => girls.find({g => g.identifier == id })}).collect({ case Some(g) => g })
  }

  implicit class GirlBuilder(val id: String) {
    def isDefined(statuses: Map[State, String], transformMessage: String, createdDate: (Int, Int, Int)): Girl = {
      Girl(
        identifier = id,
        statuses = statuses,
        transformMessage = transformMessage,
        createdDate = tuple2Date(createdDate)
      )
    }
  }
}
