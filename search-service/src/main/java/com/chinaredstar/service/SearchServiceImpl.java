package com.chinaredstar.service;

import com.chinaredstar.bean.PageBean;
import com.chinaredstar.bean.RoomBean;
import com.chinaredstar.common.TypeEunms;
import com.chinaredstar.fc.utils.JSONUtil;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoyue on 2017/7/11.
 */
@Service("searchService")
public class SearchServiceImpl implements ISearchService {

    private static Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

    private TransportClient client;

    public static final String index = "fangchan";

    SearchServiceImpl() throws UnknownHostException {
        //设置集群名称
        Settings settings = Settings.builder()
                .put("client.transport.sniff", true)//启动嗅探功能
                .put("cluster.name", "application-test")//链接集群名称
                .build();
        //创建client
        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        IndicesExistsRequest request = new IndicesExistsRequest(index);
        IndicesExistsResponse response = client.admin().indices().exists(request).actionGet();
        if (!response.isExists()) {
            client.admin().indices().create(new CreateIndexRequest(index)).actionGet();
        }
    }


    @Override
    public PageBean<RoomBean> queryRoom(String keyword,Integer pageNo,Integer pageSize) {
        List<RoomBean> list = new ArrayList();

        long count = client.prepareSearch(index).setTypes(TypeEunms.SEARCH_TYPE_FY.getValue()).execute().actionGet().getHits().getTotalHits();
        if (count == 0){
            logger.info("=====================");
            logger.info("索引[{}]未查询到记录",TypeEunms.SEARCH_TYPE_FY.getValue());
            logger.info("=====================");
            return null;
        }
        SearchResponse searchResponse = client.prepareSearch(index)
                .setTypes(TypeEunms.SEARCH_TYPE_FY.getValue())
                .setQuery(QueryBuilders.matchAllQuery()) //查询所有
                .setQuery(QueryBuilders.multiMatchQuery(keyword, "communityName","tags")) //指定查询的字段
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                .setFrom(pageNo).setSize(pageSize)//分页
               // .addSort("downPayment.keyword", SortOrder.DESC)//排序
                .get();

        SearchHits hits = searchResponse.getHits();
        long total = hits.getTotalHits();
        System.out.println(total);
        SearchHit[] searchHits = hits.getHits();
        System.out.println("查询ES数据：");
        for (SearchHit s : searchHits) {
            RoomBean roomBean = JSONUtil.toObject(s.getSourceAsString(),RoomBean.class);
            list.add(roomBean);
        }
        System.out.println(list.toString());
        return null;
    }

    @Override
    public PageBean<RoomBean> querySchool(String keyword) {
        return null;
    }
}
