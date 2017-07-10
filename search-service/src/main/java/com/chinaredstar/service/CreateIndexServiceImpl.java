package com.chinaredstar.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.chinaredstar.common.TypeEunms;
import com.chinaredstar.mapper.CommunityRoomMapper;
import com.chinaredstar.po.CommunityRoomPO;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import com.chinaredstar.fc.util.json.JsonFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chaoyue on 2017/7/10.
 */

@Service("createIndexService")
public class CreateIndexServiceImpl implements ICreateIndexService {

    private static Logger logger = LoggerFactory.getLogger(CreateIndexServiceImpl.class);

    private static final Long DEFAULT_PAGE_SIZE = 10000L;//默认每页大小

    private TransportClient client;

    private String index;


    @Resource
    private CommunityRoomMapper communityRoomMapper;

    CreateIndexServiceImpl() throws UnknownHostException{
        //设置集群名称
        Settings settings = Settings.builder()
                .put("client.transport.sniff", true)//启动嗅探功能
                .put("cluster.name", "application-test")//链接集群名称
                .build();
        //创建client
        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    }

    @Override
    public Boolean createFullIndex() {
        try{
            createFYIndex(TypeEunms.SEARCH_TYPE_FY.getValue());
            createXXIndex(TypeEunms.SEARCH_TYPE_XX.getValue());
            createLPIndex(TypeEunms.SEARCH_TYPE_LP.getValue());
            createXQIndex(TypeEunms.SEARCH_TYPE_XQ.getValue());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean createFullIndex(String... types) {
        List<String> list = Arrays.asList(types);
        try{
            if (CollectionUtils.isNotEmpty(list)){
                for (String type: types) {
                    client.admin().indices().create(new CreateIndexRequest(type)).actionGet();
                    if (type.equals(TypeEunms.SEARCH_TYPE_FY.getValue())){
                        createFYIndex(type);
                    }else if (type.equals(TypeEunms.SEARCH_TYPE_XX.getValue())){
                        createXXIndex(type);
                    }else if (type.equals(TypeEunms.SEARCH_TYPE_LP.getValue())){
                        createLPIndex(type);
                    }else if (type.equals(TypeEunms.SEARCH_TYPE_XQ.getValue())){
                        createXQIndex(type);
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean createPartIndex(String... ids) {
        return null;
    }

    /**
     * 创建房源索引
     * @param type
     * @return
     * @throws Exception
     */
    public Boolean createFYIndex(String type) throws Exception{

        deleteType(type);

        Map map=new HashMap();
        map.put("start",30);
        map.put("rows",20);
        List<CommunityRoomPO> communityRoomPOS=communityRoomMapper.findByPage(map);

        //核心方法BulkRequestBuilder拼接多个Json
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for(CommunityRoomPO communityRoomPO:communityRoomPOS){
            IndexRequestBuilder requestBuilder=client.prepareIndex(type, type,communityRoomPO.getId()).setSource(JsonFormatter.toJsonAsString(communityRoomPO), XContentType.JSON);
            bulkRequest.add(requestBuilder);
        }

        //插入文档至ES, 完成！
        bulkRequest.execute().actionGet();
        logger.info("==========================================");
        logger.info("房源索引创建完毕");
        logger.info("==========================================");
        return null;
    }

    /**
     * 创建小区索引
     * @param type
     * @return
     * @throws Exception
     */
    public Boolean createXQIndex(String type) throws Exception{

        deleteType(type);

        Map map=new HashMap();
        map.put("start",30);
        map.put("rows",20);
        List<CommunityRoomPO> communityRoomPOS=communityRoomMapper.findByPage(map);

        //核心方法BulkRequestBuilder拼接多个Json
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for(CommunityRoomPO communityRoomPO:communityRoomPOS){
            IndexRequestBuilder requestBuilder=client.prepareIndex(type, type,communityRoomPO.getId()).setSource(JsonFormatter.toJsonAsString(communityRoomPO), XContentType.JSON);
            bulkRequest.add(requestBuilder);
        }

        //插入文档至ES, 完成！
        bulkRequest.execute().actionGet();

        logger.info("==========================================");
        logger.info("小区索引创建完成");
        logger.info("==========================================");
        return null;
    }

    /**
     * 创建学校索引
     * @param type
     * @return
     * @throws Exception
     */
    public Boolean createXXIndex(String type) throws Exception{
        deleteType(type);

        Map map=new HashMap();
        map.put("start",30);
        map.put("rows",20);
        List<CommunityRoomPO> communityRoomPOS=communityRoomMapper.findByPage(map);

        //核心方法BulkRequestBuilder拼接多个Json
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for(CommunityRoomPO communityRoomPO:communityRoomPOS){
            IndexRequestBuilder requestBuilder=client.prepareIndex(type, type,communityRoomPO.getId()).setSource(JsonFormatter.toJsonAsString(communityRoomPO), XContentType.JSON);
            bulkRequest.add(requestBuilder);
        }

        //插入文档至ES, 完成！
        bulkRequest.execute().actionGet();

        logger.info("==========================================");
        logger.info("学校索引创建完成");
        logger.info("==========================================");
        return null;
    }

    /**
     * 创建楼盘索引
     * @param type
     * @return
     * @throws Exception
     */
    public Boolean createLPIndex(String type) throws Exception{
        deleteType(type);

        Map map=new HashMap();
        map.put("start",30);
        map.put("rows",20);
        List<CommunityRoomPO> communityRoomPOS=communityRoomMapper.findByPage(map);

        //核心方法BulkRequestBuilder拼接多个Json
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for(CommunityRoomPO communityRoomPO:communityRoomPOS){
            IndexRequestBuilder requestBuilder=client.prepareIndex(type, type,communityRoomPO.getId()).setSource(JsonFormatter.toJsonAsString(communityRoomPO), XContentType.JSON);
            bulkRequest.add(requestBuilder);
        }

        //插入文档至ES, 完成！
        bulkRequest.execute().actionGet();

        logger.info("==========================================");
        logger.info("楼盘索引创建完成");
        logger.info("==========================================");
        return null;
    }


    /**
     * 根据type删除索引
     * @param type
     * @return
     */
    public  Boolean deleteType(String type){
        try{
            QueryBuilder builder = QueryBuilders.typeQuery(type);//查询整个type
            DeleteByQueryAction.INSTANCE.newRequestBuilder(client).source(index).filter(builder).execute().actionGet();
        }catch (Exception e){
            logger.error("删除[{}]索引失败:[{}]",type,e);
        }
        return null;
    }
}
