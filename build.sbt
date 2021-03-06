import sbtrelease.ReleaseStateTransformations._

resolvers += Resolver.bintrayRepo("liquid-armour", "maven")

lazy val root = (project in file(".")).
settings(
    inThisBuild(List(
        organization    := "liquidarmour",
        scalaVersion    := "2.12.3"
    )),
    name := "ct-calculations",
    libraryDependencies ++= Seq(
      "joda-time" % "joda-time" % "2.9.9",
      "liquidarmour" %% "play-time" % "1.0.41",
      "org.scalatest" %% "scalatest" % "3.0.1" % Test,
      "org.mockito" % "mockito-all" % "1.9.5" % Test,
      "org.pegdown" % "pegdown" % "1.5.0" % Test,
      "org.hamcrest" % "hamcrest-all" % "1.3" % Test
    )
)

licenses += ("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

bintrayOrganization := Some("liquid-armour")
