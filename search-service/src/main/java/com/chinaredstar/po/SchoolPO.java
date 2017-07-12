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
    /**
     * 区域Code
     */
    private String areaCode;

    /**
     * 板块Code
     */
    private String plateCode;

    /**
     * 类型
     */
    private String type;

    /**
     * 级别
     */
    private String level;

    /**
     * 属性
     */
    private String property;

    /**
     * 特色
     */
    private String feature;

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
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
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
                ", areaCode='" + areaCode + '\'' +
                ", plateCode='" + plateCode + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", property='" + property + '\'' +
                ", feature='" + feature + '\'' +
                '}';
    }
}
