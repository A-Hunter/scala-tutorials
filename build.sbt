name := "scala-tutorials"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.0",
  "org.apache.spark" %% "spark-sql" % "2.4.0",
  "org.scalaz" %% "scalaz-concurrent" % "7.2.16",
  "org.typelevel" %% "cats-effect" % "1.0.0",
)