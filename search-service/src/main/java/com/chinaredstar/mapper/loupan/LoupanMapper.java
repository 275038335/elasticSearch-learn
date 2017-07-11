package com.chinaredstar.mapper.loupan;

import com.chinaredstar.po.LoupanPO;

import java.util.List;

/**
 * 楼盘新房的数据类
 * Created by zhuangj on 2017/7/11.
 */
public interface LoupanMapper {

    /**
     * 查询楼盘数据
     * @param start
     * @param count
     * @return
     */
    List<LoupanPO> queryLoupanData(Integer start, Integer count);
}
