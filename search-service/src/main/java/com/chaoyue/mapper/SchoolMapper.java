package com.chaoyue.mapper;

import com.chaoyue.po.SchoolPO;

import java.util.List;
import java.util.Map;

/**
 * Created by zhuanj on 2017/7/7.
 */
public interface SchoolMapper {

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
    List<SchoolPO> findByPage(Map<String, Object> params);
}
