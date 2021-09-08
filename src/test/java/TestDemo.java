import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Random;

public class TestDemo {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setAppName("SQLJava");
        conf.setMaster("local[4]");

        SparkSession sess = SparkSession.builder()
                .appName("SQLJava")
                .config("spark.master", "local[4]")
                .getOrCreate();
        String url = "jdbc:mysql://10.130.36.199:3306/bigdata_app?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        String table = "app_jsc_capacity_unilateral_car_detail";

        //查询数据库
        Dataset<Row> df = sess.read()
                .format("jdbc")
                .option("url", url)
                .option("dbtable", table)
                .option("user", "root")
                .option("password", "Cat_Mysql_123")
                .option("driver", "com.mysql.jdbc.Driver")
                .load();
//        df.show();

        Dataset<Row> df2 = df.where(" rpt_date = date'2021-09-06' ").select(df.col("rpt_date"), df.col("id"), df.col("center_name"), df.col("center_name_end"));
//        df2.show(50);
//        df2.javaRDD().flatMap(new FlatMapFunction<String, String>() {
//            public Iterable<String> test(String s) throws Exception {
//                ArrayList<String> list = new ArrayList<>();
//                String[] arr = s.split(",");
//                for (String ss : arr) {
//                    list.add(ss);
//                }
//                return list.iterator();
//            }
//        });
//
//        JavaRDD<Row> rdd = df2.javaRDD();
//        System.out.println(rdd.collect());

        // 第一步，给RDD中的每个key都打上一个随机前缀。
//        JavaPairRDD<String, Long> randomPrefixRdd = rdd.mapToPair(
//                new PairFunction<Tuple2<Long,Long>, String, Long>() {
//                    private static final long serialVersionUID = 1L;
//                    @Override
//                    public Tuple2<String, Long> call(Tuple2<Long, Long> tuple)
//                            throws Exception {
//                        Random random = new Random();
//                        int prefix = random.nextInt(10);
//                        return new Tuple2<String, Long>(prefix + "_" + tuple._1, tuple._2);
//                    }
//                });

//// 第二步，对打上随机前缀的key进行局部聚合。
//        JavaPairRDD<String, Long> localAggrRdd = randomPrefixRdd.reduceByKey(
//                new Function2<Long, Long, Long>() {
//                    private static final long serialVersionUID = 1L;
//                    @Override
//                    public Long call(Long v1, Long v2) throws Exception {
//                        return v1 + v2;
//                    }
//                });
//
//// 第三步，去除RDD中每个key的随机前缀。
//        JavaPairRDD<Long, Long> removedRandomPrefixRdd = localAggrRdd.mapToPair(
//                new PairFunction<Tuple2<String,Long>, Long, Long>() {
//                    private static final long serialVersionUID = 1L;
//                    @Override
//                    public Tuple2<Long, Long> call(Tuple2<String, Long> tuple)
//                            throws Exception {
//                        long originalKey = Long.valueOf(tuple._1.split("_")[1]);
//                        return new Tuple2<Long, Long>(originalKey, tuple._2);
//                    }
//                });
//
//// 第四步，对去除了随机前缀的RDD进行全局聚合。
//        JavaPairRDD<Long, Long> globalAggrRdd = removedRandomPrefixRdd.reduceByKey(
//                new Function2<Long, Long, Long>() {
//                    private static final long serialVersionUID = 1L;
//                    @Override
//                    public Long call(Long v1, Long v2) throws Exception {
//                        return v1 + v2;
//                    }
//                });
    }
}
