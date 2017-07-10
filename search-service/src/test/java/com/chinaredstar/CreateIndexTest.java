package com.chinaredstar;

import com.chinaredstar.mapper.CommunityRoomMapper;
import com.chinaredstar.mapper.SchoolMapper;
import com.chinaredstar.po.CommunityRoomPO;

import com.chinaredstar.po.SchoolPO;
import com.chinaredstar.fc.util.json.JsonFormatter;
import junit.framework.TestCase;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuangj on 2017/5/23.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
@EnableWebMvc
@WebAppConfiguration
public class CreateIndexTest extends TestCase{

    @Resource
    private CommunityRoomMapper communityRoomMapper;

    @Resource
    private SchoolMapper schoolMapper;


    private TransportClient client;

   private  String index = "alloutlet";

   private  String type = "details";

    private String schoolType="schoolType";


    /**
     * 链接ES
     * @throws UnknownHostException
     */
    @Before
    public void testEsConnect() throws UnknownHostException {

        //设置集群名称
        Settings settings = Settings.builder()
                .put("client.transport.sniff", true)//启动嗅探功能
                .put("cluster.name", "my-application")//链接集群名称
                .build();
        //创建client
        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    }


    /**
     * 创建索引
     */
    @Test
    public void createIndex() {
        client.admin().indices().create(new CreateIndexRequest(index)).actionGet();
    }

    /**
     * 导入数据
     * @throws IOException
     */
    @Test
    public void insertData() throws IOException {
        Map map=new HashMap();
        map.put("start",30);
        map.put("rows",20);
        List<CommunityRoomPO> list=communityRoomMapper.findByPage(map);

        //核心方法BulkRequestBuilder拼接多个Json
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for(CommunityRoomPO communityRoomPO:list){
            IndexRequestBuilder requestBuilder=client.prepareIndex(index, type,communityRoomPO.getId()).setSource(JsonFormatter.toJsonAsString(communityRoomPO), XContentType.JSON);
            bulkRequest.add(requestBuilder);
        }

        //插入文档至ES, 完成！
        bulkRequest.execute().actionGet();
    }

    /**
     * 导入学校数据
     * @throws IOException
     */
    @Test
    public void insertSchoolData() throws IOException {
        Map map=new HashMap();
        map.put("start",30);
        map.put("rows",20);
        List<SchoolPO> list=schoolMapper.findByPage(map);

        //核心方法BulkRequestBuilder拼接多个Json
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for(SchoolPO schoolPO:list){
            IndexRequestBuilder requestBuilder=client.prepareIndex(index, schoolType,schoolPO.getId()).setSource(JsonFormatter.toJsonAsString(schoolPO), XContentType.JSON);
            bulkRequest.add(requestBuilder);
        }

        //插入文档至ES, 完成！
        bulkRequest.execute().actionGet();

    }

    /**
     * 删除索引
     */
    @Test
    public void deleteIndex(){
        DeleteIndexResponse del=client.admin().indices()
                //这个索引库的名称还必须不包含大写字母
                .prepareDelete(index).execute().actionGet();
    }


    /**
     * 更新数据
     * @throws IOException
     */
    @Test
    public void updateData() throws IOException {
        CommunityRoomPO communityRoomPO=new CommunityRoomPO();
        communityRoomPO.setId("100143");
        communityRoomPO.setTitle("进行修改的数据");
        communityRoomPO.setCommunityName("一个不愿意透露姓名的小区");
        communityRoomPO.setDownPayment("6000000");
        UpdateResponse updateResponse=client.prepareUpdate(index,type,"100143").setDoc(JsonFormatter.toJsonAsString(communityRoomPO)).get();
        System.out.println(updateResponse);
    }


    /**
     * 查询数据
     */
    @Test
    public void queryData(){
        SearchResponse searchResponse = client.prepareSearch(index)
                .setTypes(type)
                .setQuery(QueryBuilders.matchAllQuery()) //查询所有
                //.setQuery(QueryBuilders.matchQuery("name", "tom").operator(Operator.AND)) //根据tom分词查询name,默认or
                .setQuery(QueryBuilders.multiMatchQuery("花园", "communityName", "title")) //指定查询的字段
                //.setQuery(QueryBuilders.queryString("name:to* AND age:[0 TO 19]")) //根据条件查询,支持通配符大于等于0小于等于19
                //.setQuery(QueryBuilders.termQuery("name", "tom"))//查询时不分词
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                .setFrom(0).setSize(10)//分页
                .addSort("downPayment.keyword", SortOrder.DESC)//排序
                .get();

        SearchHits hits = searchResponse.getHits();
        long total = hits.getTotalHits();
        System.out.println(total);
        SearchHit[] searchHits = hits.hits();
        System.out.println("查询ES数据：");
        for(SearchHit s : searchHits) {
            System.out.println(s.getSourceAsString());
        }
    }

    /**
     * 删除数据
     */
    @Test
    public void deleteData(){
        client.prepareDelete(index, type, "100143").execute().actionGet();
    }


    @Test
    public void deleteType(){
        QueryBuilder builder = QueryBuilders.typeQuery(schoolType);//查询整个type
        DeleteByQueryAction.INSTANCE.newRequestBuilder(client).source(index).filter(builder).execute().actionGet();
    }





}
