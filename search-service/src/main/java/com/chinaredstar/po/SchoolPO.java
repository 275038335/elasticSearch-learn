package com.chinaredstar.po;

import java.math.BigDecimal;

/**
 * 学校PO
 * Created by zhuangj on 2017/7/7.
 */
public class SchoolPO {


    /** 学校id */
    private Integer id;
    /** 学校名 */
    private String name;
    /** 对口/附近小区数 */
    private Integer communityAmount;
    /** 对应房源数 */
    private Integer roomAmount;
    /** 对应房源最低售价 */
    private BigDecimal minSumPrice;
    /** 标签 */
    private String tags;
    /** 封面图 */
    private String coverImgUrl;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getCommunityAmount() {
        return communityAmount;
    }
    public void setCommunityAmount(Integer communityAmount) {
        this.communityAmount = communityAmount;
    }
    public Integer getRoomAmount() {
        return roomAmount;
    }
    public void setRoomAmount(Integer roomAmount) {
        this.roomAmount = roomAmount;
    }
    public BigDecimal getMinSumPrice() {
        return minSumPrice;
    }
    public void setMinSumPrice(BigDecimal minSumPrice) {
        this.minSumPrice = minSumPrice;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getCoverImgUrl() {
        return coverImgUrl;
    }
    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    @Override
    public String toString() {
        return "SchoolPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", communityAmount=" + communityAmount +
                ", roomAmount=" + roomAmount +
                ", minSumPrice=" + minSumPrice +
                ", tags='" + tags + '\'' +
                ", coverImgUrl='" + coverImgUrl + '\'' +
                '}';
    }
}
