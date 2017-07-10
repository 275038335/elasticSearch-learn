package com.chinaredstar.service;

/**
 * Created by chaoyue on 2017/7/10.
 */
public interface ICreateIndexService {
    /**
     * 创建全量索引
     *
     * @return Boolean
     */
    Boolean createFullIndex();

    /**
     * 根据类型创建索引
     * @param type
     * @return
     */
    Boolean createFullIndex(String... types);


    /**
     * 根据ids 创建增量索引
     * @param ids
     * @return
     */
    Boolean createPartIndex(String... ids);
}
