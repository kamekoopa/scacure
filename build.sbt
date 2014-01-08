name := "scacure"

version := "1.0"

scalacOptions += "-deprecation"

scalacOptions += "-feature"

libraryDependencies += "joda-time" % "joda-time" % "2.3"

libraryDependencies += "org.joda" % "joda-convert" % "1.5"

initialCommands := """import com.github.kamekoopa.scacure._"""