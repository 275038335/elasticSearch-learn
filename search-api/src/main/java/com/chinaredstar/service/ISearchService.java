package com.chinaredstar.service;

import com.chinaredstar.bean.PageBean;
import com.chinaredstar.bean.RoomBean;

/**
 * Created by chaoyue on 2017/7/11.
 */
public interface ISearchService {

    /**
     * 根据关键词查询房源信息列表
     * @param keyword
     * @return
     */
    PageBean<RoomBean> queryRoom(String keyword,Integer pageNo,Integer pageSize);

    /**
     * 根据关键词查询学校列表
     * @param keyword
     * @return
     */
    PageBean<RoomBean> querySchool(String keyword);
}
