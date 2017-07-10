package com.chinaredstar.po;


import java.io.Serializable;

/**
 * Created by chinaredstar on 2017/5/22.
 */
public class CommunityRoomPO implements Serializable {
    private static final long serialVersionUID = -6246815290478950001L;

    private String id;

    private String communityName;

    private String title;

    private String downPayment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(String downPayment) {
        this.downPayment = downPayment;
    }

    @Override
    public String toString() {
        return "CommunityRoom{" +
                "id=" + id +
                ", communityName='" + communityName + '\'' +
                ", title='" + title + '\'' +
                ", downPayment=" + downPayment +
                '}';
    }
}
