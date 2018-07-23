name := """todoapi"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.12.6"

//crossScalaVersions := Seq("2.11.12", "2.12.6")

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test


// libraryDependencies ++= Seq(
//   "com.typesafe.play" %% "play-slick" % "3.0.1",
//   "com.typesafe.play" %% "play-slick-evolutions" % "3.0.1"
// )

// libraryDependencies ++= Seq(
//   "com.typesafe.slick" %% "slick" % "3.2.0",
//   "org.slf4j" % "slf4j-nop" % "1.6.4",
//   "com.typesafe.slick" %% "slick-hikaricp" % "3.2.0"
// )

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
