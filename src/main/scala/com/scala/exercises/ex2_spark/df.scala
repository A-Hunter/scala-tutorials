

/**
  * Created by Ghazi Naceur on 26/11/2018.
  */
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.csv("E:\\GitHubRepositories\\scala-tutorials\\src\\main\\resources\\MOCK_DATA.csv")

df.head(5)
