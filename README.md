# See https://github.com/scala/bug/issues/12229
```
# Scala 2.12.12
sbt 'set scalaVersion := "2.12.12"' compile

# FAILED Scala 2.12.12 -opt:l:method
sbt 'set scalaVersion := "2.12.12"' 'set scalacOptions in ThisBuild ++= Seq("-opt:l:method")' compile

# FAILED Scala 2.12.11 -opt:l:method
sbt 'set scalaVersion := "2.12.11"' 'set scalacOptions in ThisBuild ++= Seq("-opt:l:method")' compile

# FAILED Scala 2.12.0 -opt:l:method
sbt 'set scalaVersion := "2.12.0"' 'set scalacOptions in ThisBuild ++= Seq("-opt:l:method")' compile
```
