//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.apache.lucene.analysis.compound.hyphenation.TernaryTree.Iterator;
//import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
//import org.elasticsearch.action.bulk.BulkRequestBuilder;
//import org.elasticsearch.action.bulk.BulkResponse;
//import org.elasticsearch.action.delete.DeleteResponse;
//import org.elasticsearch.action.get.GetResponse;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.action.search.SearchRequestBuilder;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.action.search.SearchType;
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.common.unit.TimeValue;
//import org.elasticsearch.common.xcontent.XContentFactory;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.search.SearchHits;
//import org.elasticsearch.search.aggregations.Aggregation;
//import org.elasticsearch.search.aggregations.AggregationBuilders;
//import org.elasticsearch.search.aggregations.bucket.filters.Filters.Bucket;
//import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
//import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder;
//import org.elasticsearch.search.sort.FieldSortBuilder;
//import org.elasticsearch.search.sort.SortOrder;
//import org.junit.After;
//import org.junit.Before;
//
///**
// * @author joey
// *
// */
//public class ESClient {
//
//    private Client client;
//    /**
//     * 初始化客户端连接
//     */
//    @Before
//    public Client initESClient() {
//        // 配置你的es,如果你的集群名称不是默认的elasticsearch，需要以下这步
//        Settings settings = Settings.settingsBuilder().put("cluster.name","elasticsearch").build();
//        // 这里可以同时连接集群的服务器,可以多个,并且连接服务是可访问的
//        try {
//            // on startup，因为是默认的集群名，所以不需要setting
//            client = TransportClient.builder().build()
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }finally
//        {
//            if(client != null)
//            {
//                System.out.println("连接成功！");
//            }
//        }
//        return client;
//    }
//
//    @After
//    public void closeESClient() {
//        client.close();
//        System.out.println("连接关闭！");
//    }
//
//    /**
//     * 创建索引、类型、文档并插入ID为1文档内容
//     */
//    @SuppressWarnings("unused")
//    private void createIndex() {
//        IndexResponse response = null;
//        try {
//            response = client.prepareIndex("customertest", "joey", "1")
//                    .setSource(XContentFactory.jsonBuilder().startObject()
//                            .field("name", "joey")
//                            .field("time", new Date())
//                            .endObject()
//                    )
//                    .get();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally
//        {
//            if(response != null)
//            {
//                System.out.println("索引创建成功！");
//            }
//        }
//    }
//    /**
//     * 获取文档
//     */
//    public void get(){
//        GetResponse response = client.prepareGet("customer", "external", "1").get();
//        Set<String> headers = response.getHeaders();
//        System.out.println(headers);//获取请求头
//        boolean exists = response.isExists();
//        System.out.println(exists);//判断索引是否存在
//        String sourceString = response.getSourceAsString();
//        System.out.println(sourceString);//获取索引，并打印出索引内容
//        String id = response.getId();
//        System.out.println(id);//获取索引id
//        boolean sourceEmpty = response.isSourceEmpty();
//        System.out.println(sourceEmpty);//获取索引的内容是否为空
//    }
//
//    /**
//     * 删除
//     */
//    public void delete(){
//        //DeleteResponse response = client.prepareDelete("customertest", "joey", "1").get();  //删除文档
//        //删除索引
//        DeleteIndexResponse deleteIndexResponse = client.admin().indices()
//                .prepareDelete("s2")
//                .execute().actionGet();
//        boolean isFound = deleteIndexResponse.isAcknowledged();
//        System.out.println(isFound);//返回文档是否存在，存在删除
//    }
//
//
//    /**
//     * 搜索索引
//     */
//    public void search(){
//        //创建查询索引
//        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("s2");
//        //设置查询索引类型
//        searchRequestBuilder.setTypes("o_user");
//        //设置查询类型
//        searchRequestBuilder.setSearchType(SearchType.DEFAULT);
//        //设置查询关键字
//        searchRequestBuilder.setQuery(QueryBuilders.commonTermsQuery("name", "宁波"));
//        // 设置查询数据的位置,分页用吧
//        searchRequestBuilder.setFrom(0);
//        // 设置查询结果集的最大条数
//        searchRequestBuilder.setSize(10);
//        // 设置是否按查询匹配度排序
//        searchRequestBuilder.setExplain(true);
//        // 最后就是返回搜索响应信息
//        SearchResponse response = searchRequestBuilder.execute().actionGet();
//        //System.out.println("响应结果："+response);
//
//        //获取搜索文档的结果
//        SearchHits searchHits = response.getHits();
//        SearchHit[] hits = searchHits.getHits();
//        System.out.println("数量："+hits.length);
//        for (int i = 0; i < hits.length; i++) {
//            SearchHit hit = hits[i];
//            Map<String, Object> result = hit.getSource();
//            System.out.println("文档结果："+result);
//        }
//        System.out.println("查询索引完毕!");
//    }
//    /**
//     * 批量新增
//     */
//    public void bulkdoc(List<User> list)
//    {
//        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
//        BulkRequestBuilder bulkRequest = client.prepareBulk();
//        long b = System.currentTimeMillis();
//        try {
//            for(User user:list)
//            {
//                String _id = user.getId();
//                bulkRequest.add(client.prepareIndex("s2", "o_user", _id)
//                        .setSource(XContentFactory.jsonBuilder()
//                                .startObject()
//                                .field("name", user.getName())
//                                .field("address",user.getAddress())
//                                .field("etype",user.getE_type())
//                                .field("e_industry",user.getE_industry())
//                                .field("empirical_scope",user.getEmpirical_scope())
//                                .field("checkdate",dateFormater.format(user.getCheck_date()))
//                                .field("create_time",dateFormater.format(user.getCreate_time()))
//                                .field("legal_person",user.getLegal_person())
//                                .field("registration_unit",user.getRegistration_unit())
//                                .field("jurisdiction_unit",user.getJurisdiction_unit())
//                                .field("phone_no",user.getPhone_no())
//                                .field("bar_id",user.getBar_id())
//                                .field("build_id",user.getBuild_id())
//                                .field("floor_id",user.getFloor_id())
//                                .field("room_id",user.getRoom_id())
//                                .field("bar_lng",user.getBar_lng())
//                                .field("bar_lat",user.getBar_lat())
//                                .field("build_lng",user.getBuild_lng())
//                                .field("build_lat",user.getBuild_lng())
//                                .field("room_lng",user.getRoom_lng())
//                                .field("room_lat",user.getRoom_lat())
//                                .endObject()
//                        )
//                );
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        BulkResponse bulkResponse = bulkRequest.execute().actionGet();
//        if (bulkResponse.hasFailures()) {
//            System.out.println(bulkResponse.buildFailureMessage());
//        }
//        long useTime = System.currentTimeMillis()-b;
//        System.out.println("useTime:" + useTime);
//    }
//    /**
//     * 聚合查询
//     */
//    public void aggSearch()
//    {
//        SearchRequestBuilder srb = client.prepareSearch("s2");
//        srb.setSize(0);
//        srb.setTypes("o_user");
//        srb.setHighlighterType("o_user");
//        srb.setSearchType(SearchType.QUERY_THEN_FETCH);
//        TermsBuilder typeTermsBuilder = AggregationBuilders.terms("etypeAgg").field("etype");
//        typeTermsBuilder.size(100);
//        srb.addAggregation(typeTermsBuilder);
//        SearchResponse sr = srb.execute().actionGet();
//        System.out.println(sr);
//    }
//
//    public void useScrolls()
//    {
//        QueryBuilder qb = QueryBuilders.multiMatchQuery("工厂", "name");
//        SearchResponse scrollResp = client.prepareSearch("s2")
//                .addSort("name", SortOrder.ASC)
//                .setScroll(new TimeValue(60000))
//                .setQuery(qb)
//                .setSize(100).execute().actionGet(); //100 hits per shard will be returned for each scroll
//        while (true) {
//            for (SearchHit hit : scrollResp.getHits().getHits()) {
//                System.out.println(hit.getScore());
//            }
//            scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
//            if (scrollResp.getHits().getHits().length == 0) {
//                break;
//            }
//        }
//    }
//
//    public static void main(String args[]){
//        System.out.println("ES集群连接测试");
//        ESClient esc = new ESClient();
//        esc.initESClient();
//        //esc.createIndex();
//        //esc.get();
//        //esc.delete();
//        //esc.search();
//        //esc.bulkdoc();
//        //  esc.closeESClient();
//        esc.aggSearch();
//        //esc.useScrolls();
//    }
//}