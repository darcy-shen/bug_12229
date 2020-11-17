import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf

object Inc {
  def evaluate(x: Int): Int = x + 1
}

object UDF {
  val all = Map(
    "test" ->
      udf(Inc.evaluate _).asNonNullable().withName("inc")
  )

  def register(spark: SparkSession): Unit = {
    all.foreach {
      case (name, udf) =>
        spark.udf.register(name, udf)
    }
  }
}

