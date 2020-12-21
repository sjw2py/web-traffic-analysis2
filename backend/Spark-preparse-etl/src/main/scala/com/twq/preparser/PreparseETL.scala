package com.twq.preparser

import org.apache.spark.sql.{Dataset, Encoders, SaveMode, SparkSession}
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD

object PreparseETL {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    if (args.isEmpty) {
      conf.setMaster("local")
    }
    val spark = SparkSession.builder()
      .appName("PreparseETL")
      .config(conf)
      .enableHiveSupport()
      .getOrCreate()

    val rawdataInputPath = spark.conf.get("rawdata.input.path",
      "hdfs://master:9999/user/hadoop-twq/traffic-analysis/rawlog/20180615")
    val preparseETLnumPartitions = spark.conf.get("spark.preparseETL.numPartitions","2")


    val preparseLogRDD: RDD[PreparsedLog] = spark.sparkContext.textFile(rawdataInputPath)
      .flatMap(line => Option(WebLogPreParser.parse(line)))

    val preparseDS: Dataset[PreparsedLog] = spark.createDataset(preparseLogRDD)(Encoders.bean(classOf[PreparsedLog]))
    preparseDS.coalesce(preparseETLnumPartitions.toInt)
      .write
      .mode(SaveMode.Append)
      .partitionBy("year", "month", "day")
      .saveAsTable("rawdata.web1")

    spark.stop()


  }
}
