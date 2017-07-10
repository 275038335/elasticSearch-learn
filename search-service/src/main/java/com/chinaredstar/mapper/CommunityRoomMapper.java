package com.chinaredstar.mapper;

import com.chinaredstar.po.CommunityRoomPO;

import java.util.List;
import java.util.Map;

/**
 * Created by chinaredstar on 2017/5/23.
 */
public interface CommunityRoomMapper {

    /**
     * 统计创建索引房源数
     * @return
     */
    Long countNum();

    /**
     * 分页查询需要创建索引的信息
     * @param params
     * @return List<ProductInfo>
     */
    List<CommunityRoomPO> findByPage(Map<String, Object> params);

    /**
     * 根据IDs 获取房源信息
     * @param params
     * @return
     */
    List<CommunityRoomPO> findByIds(Map<String, Object> params);
}
