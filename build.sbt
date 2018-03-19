name := """scala-project"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += "Artifactory-Sbt" at "https://artifactory.insuranceinbox.com/artifactory/inbox-all-sbt/"

scalaVersion := "2.11.11"
val foo = disablePlugins(JavaServerAppPackaging)

libraryDependencies ++= Seq(
  ws,
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
  "com.h2database" % "h2" % "1.4.196",
  "net.codingwell" %% "scala-guice" % "4.0.1",
  "com.github.tminglei" %% "slick-pg" % "0.15.0-M3",
  "com.github.tminglei" %% "slick-pg_play-json" % "0.15.0-M3",
  "org.apache.poi" % "poi" % "3.8",
  "org.apache.poi" % "poi-ooxml" % "3.8")
