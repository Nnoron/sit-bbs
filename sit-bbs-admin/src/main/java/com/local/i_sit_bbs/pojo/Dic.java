package com.local.i_sit_bbs.pojo;

public class Dic {
    private String type;

    private Integer key;

    private String value;

    public Dic(String type, Integer key, String value) {
        this.type = type;
        this.key = key;
        this.value = value;
    }

    public Dic() {
        super();
    }

    public String getType() {
        return type;
    }

    public void setClass(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}