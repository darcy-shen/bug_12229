# See https://github.com/scala/bug/issues/12229
```
# SUCCESS
sbt 'set scalaVersion := "2.12.12"' compile

# FAILED
sbt 'set scalaVersion := "2.12.12"' 'set scalacOptions in ThisBuild ++= Seq("-opt:l:method")' compile

# FAILED
sbt 'set scalaVersion := "2.12.11"' 'set scalacOptions in ThisBuild ++= Seq("-opt:l:method")' compile

# FAILED
sbt 'set scalaVersion := "2.12.0"' 'set scalacOptions in ThisBuild ++= Seq("-opt:l:method")' compile

# SUCCESS
sbt 'set scalaVersion := "2.12.12"' 'set scalacOptions in ThisBuild ++= Seq("-opt:unreachable-code")' compile
sbt 'set scalaVersion := "2.12.12"' 'set scalacOptions in ThisBuild ++= Seq("-opt:simplify-jumps")' compile
sbt 'set scalaVersion := "2.12.12"' 'set scalacOptions in ThisBuild ++= Seq("-opt:compact-locals")' compile
sbt 'set scalaVersion := "2.12.12"' 'set scalacOptions in ThisBuild ++= Seq("-opt:copy-propagation")' compile
sbt 'set scalaVersion := "2.12.12"' 'set scalacOptions in ThisBuild ++= Seq("-opt:redundant-casts")' compile
sbt 'set scalaVersion := "2.12.12"' 'set scalacOptions in ThisBuild ++= Seq("-opt:box-unbox")' compile
sbt 'set scalaVersion := "2.12.12"' 'set scalacOptions in ThisBuild ++= Seq("-opt:nullness-tracking")' compile

# FAILED
sbt 'set scalaVersion := "2.12.12"' 'set scalacOptions in ThisBuild ++= Seq("-opt:closure-invocations")' compile

# SUCCESS
sbt 'set scalaVersion := "2.12.12"' 'set scalacOptions in ThisBuild ++= Seq("-opt:l:method", "-opt:-closure-invocations")' compile
```
