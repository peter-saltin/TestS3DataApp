import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import .spark.SparkConf

/**
 * @author Peter
 */
object SimpleS3app {

  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("Simple S3 Data Application")
    val sc = new SparkContext(conf)
    val hadoopConf=sc.hadoopConfiguration;
    hadoopConf.set("fs.s3.impl", "org.apache.hadoop.fs.s3native.NativeS3FileSystem")
    hadoopConf.set("fs.s3n.awsAccessKeyId",sys.env("AWS_ACCESS_KEY_ID"))
    hadoopConf.set("fs.s3n.awsSecretAccessKey",sys.env("AWS_SECRET_ACCESS_KEY"))

    val pathFile = "s3n://saltin1/input/ampcamp/movielens/medium/ratings$
    val dataFile = sc.textFile(pathFile, 2).cache()
    println(dataFile.count() + " <-- number of ratings")
    println("----------------------")
  }
}


