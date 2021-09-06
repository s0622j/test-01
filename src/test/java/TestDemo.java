//public class TestDemo {
//    public static void main(String[] args) {
//        // 第一步，给RDD中的每个key都打上一个随机前缀。
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
//
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
//    }
//}
