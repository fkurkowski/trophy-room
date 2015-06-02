import org.scalatra.sbt._
import org.scalatra.sbt.PluginKeys._
import com.mojolly.scalate.ScalatePlugin._
import ScalateKeys._

lazy val commonSettings = Seq(
  organization := "com.fkurkowski",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.11.6"
)

val ScalaVersion = "2.11.6"
val ScalatraVersion = "2.4.0.RC1"

lazy val TrophyRoom = (project in file("."))
  .settings(ScalatraPlugin.scalatraWithJRebel: _*)
  .settings(commonSettings: _*)
  .settings(
    name := "rowan-api",
    libraryDependencies ++= Seq(
      "org.scalatra" %% "scalatra" % ScalatraVersion,
      "org.scalatra" %% "scalatra-scalate" % ScalatraVersion,
      "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
      "ch.qos.logback" % "logback-classic" % "1.1.2" % "runtime",
      "org.eclipse.jetty" % "jetty-webapp" % "9.1.5.v20140505" % "container",
      "org.eclipse.jetty" % "jetty-plus" % "9.1.5.v20140505" % "container",
      "javax.servlet" % "javax.servlet-api" % "3.1.0",
      "com.typesafe.slick" %% "slick" % "3.0.0-RC1",
      "com.h2database" % "h2" % "1.4.181",
      "c3p0" % "c3p0" % "0.9.1.2"
    ),
    scalateTemplateConfig in Compile <<= (sourceDirectory in Compile) { base =>
      Seq(
        TemplateConfig(
          base / "webapp" / "WEB-INF" / "templates",
          Seq.empty, /* default imports should be added here */
          Seq(
            Binding("context", "_root_.org.scalatra.scalate.ScalatraRenderContext", importMembers = true, isImplicit = true)
          ), /* add extra bindings here */
          Some("templates")
        )
      )
    }
  )
