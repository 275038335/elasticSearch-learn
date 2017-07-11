package com.chinaredstar.po;

import java.math.BigDecimal;
import java.util.List;

/**
 * 楼盘基本信息对象
 *
 * Created by zhuangj on 2017/4/11.
 */
public class LoupanPO {

    /** 楼盘id */
    private Integer id;

    /** 楼盘名称 */
    private String name;

    /** 销售状态 */
    private Integer saleStatus;

    /** 区 */
    private String area;

    /** 区code */
    private String areaCode;

    /** 板块 */
    private String plate;

    /** 板块code */
    private String plateCode;

    /** 环线 */
    private String loop;

    /** 环线loopCode */
    private String loopCode;

    /** 地址 */
    private String address;

    /** 开发商报价（单位：元） */
    private BigDecimal developersOffer;

    /** 最小参考总价（单位：元） */
    private BigDecimal minReferenceSumPrice;

    /** 最大参考总价（单位：元） */
    private BigDecimal maxReferenceSumPrice;

    /** 房型建筑面积 */
    private BigDecimal minUnitBuildingArea;

    /** 房型建筑面积 */
    private BigDecimal maxUnitBuildingArea;

    /** 标签 */
    private String tags;

    /** 封面图 */
    private String coverImgUrl;

    /**房间数*/
    private List<Integer> roomNumList;


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

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }

    public String getLoop() {
        return loop;
    }

    public void setLoop(String loop) {
        this.loop = loop;
    }

    public String getLoopCode() {
        return loopCode;
    }

    public void setLoopCode(String loopCode) {
        this.loopCode = loopCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getDevelopersOffer() {
        return developersOffer;
    }

    public void setDevelopersOffer(BigDecimal developersOffer) {
        this.developersOffer = developersOffer;
    }

    public BigDecimal getMinReferenceSumPrice() {
        return minReferenceSumPrice;
    }

    public void setMinReferenceSumPrice(BigDecimal minReferenceSumPrice) {
        this.minReferenceSumPrice = minReferenceSumPrice;
    }

    public BigDecimal getMaxReferenceSumPrice() {
        return maxReferenceSumPrice;
    }

    public void setMaxReferenceSumPrice(BigDecimal maxReferenceSumPrice) {
        this.maxReferenceSumPrice = maxReferenceSumPrice;
    }

    public BigDecimal getMinUnitBuildingArea() {
        return minUnitBuildingArea;
    }

    public void setMinUnitBuildingArea(BigDecimal minUnitBuildingArea) {
        this.minUnitBuildingArea = minUnitBuildingArea;
    }

    public BigDecimal getMaxUnitBuildingArea() {
        return maxUnitBuildingArea;
    }

    public void setMaxUnitBuildingArea(BigDecimal maxUnitBuildingArea) {
        this.maxUnitBuildingArea = maxUnitBuildingArea;
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

    public List<Integer> getRoomNumList() {
        return roomNumList;
    }

    public void setRoomNumList(List<Integer> roomNumList) {
        this.roomNumList = roomNumList;
    }
}
