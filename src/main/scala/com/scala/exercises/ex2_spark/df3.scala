/**
  * Created by Ghazi Naceur on 29/11/2018.
  */

import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header", "true").option("inferSchema", "true").csv("E:\\GitHubRepositories\\scala-tutorials\\src\\main\\resources\\infos.csv")

df.filter("id > 100 AND salary > 3000.0").show()

// Collecting result in Scala Object
val result = df.filter("id > 100 AND salary > 3000.0").collect()

// Count result
val count = df.filter("id > 100 AND salary > 3000.0").count()