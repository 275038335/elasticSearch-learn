package com.chinaredstar.common;

/**
 * Created by chaoyue on 2017/7/10.
 */
public enum  TypeEunms {

    SEARCH_TYPE_FY("FY","房源"),
    SEARCH_TYPE_XQ("XQ","小区"),
    SEARCH_TYPE_XX("XX","学校"),
    SEARCH_TYPE_LP("LP","楼盘")
    ;

    private String value;
    private String text;

    TypeEunms(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public static  String getDesc(String code){
        for(TypeEunms item:values()){
            if(item.getValue().equals(code)){
                return item.getText();
            }
        }
        return null;
    }
}
