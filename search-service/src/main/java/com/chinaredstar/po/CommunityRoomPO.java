package com.chinaredstar.po;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by chinaredstar on 2017/5/22.
 *
 * 二手房
 */
public class CommunityRoomPO implements Serializable {
    private static final long serialVersionUID = -6246815290478950001L;
    /** 房源id */
    private Integer id;
    /** 小区id */
    private Integer communityId;
    /** 小区名 */
    private String communityName;
    /** 室 */
    private Integer room;
    /** 厅 */
    private Integer hall;
    /** 面积 */
    private BigDecimal buildingArea;
    /** 楼层 */
    private Integer floor;
    /** 总楼层 */
    private Integer totalFloor;
    /** 房源总价 */
    private BigDecimal sumPrice;
    /** 标签 */
    private String tags;
    /** 产证时间 */
    private Integer certificateTime;
    /** 是否唯一 */
    private Integer isOnly;
    /** 置顶排序 */
    private Integer topRank;
    /** 封面图 */
    private String coverImgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public BigDecimal getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(BigDecimal buildingArea) {
        this.buildingArea = buildingArea;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getCertificateTime() {
        return certificateTime;
    }

    public void setCertificateTime(Integer certificateTime) {
        this.certificateTime = certificateTime;
    }

    public Integer getIsOnly() {
        return isOnly;
    }

    public void setIsOnly(Integer isOnly) {
        this.isOnly = isOnly;
    }

    public Integer getTopRank() {
        return topRank;
    }

    public void setTopRank(Integer topRank) {
        this.topRank = topRank;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    @Override
    public String toString() {
        return "CommunityRoomPO{" +
                "id=" + id +
                ", communityId=" + communityId +
                ", communityName='" + communityName + '\'' +
                ", room=" + room +
                ", hall=" + hall +
                ", buildingArea=" + buildingArea +
                ", floor=" + floor +
                ", totalFloor=" + totalFloor +
                ", sumPrice=" + sumPrice +
                ", tags='" + tags + '\'' +
                ", certificateTime=" + certificateTime +
                ", isOnly=" + isOnly +
                ", topRank=" + topRank +
                ", coverImgUrl='" + coverImgUrl + '\'' +
                '}';
    }
}
