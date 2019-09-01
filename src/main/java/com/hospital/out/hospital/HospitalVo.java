package com.hospital.out.hospital;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 医院的基本信息
 * Created by fuxf on 2017/7/31.
 */
public class HospitalVo {

    private String orgid;     //医院编号
    private String orgname;   //医院名称
    private String alias;      //医院别名
    private String description; //医院介绍
    private String address;     //医院地址
    private String level;       //医院等级
    private String nature;      //医院性质
    private String category;     //医院类别
    private String tel;        //联系电话
    private String web;        //医院网站
    private String state;      //医院状态
    private String time; //医院放号时间
    private String picture;
    @JSONField(serialize = false)
    private String rank;//医院等级

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public HospitalVo() {
    }

    public HospitalVo(String orgid, String orgname, String alias, String description, String address, String level, String nature, String category, String tel, String web, String state) {
        this.orgid = orgid;
        this.orgname = orgname;
        this.alias = alias;
        this.description = description;
        this.address = address;
        this.level = level;
        this.nature = nature;
        this.category = category;
        this.tel = tel;
        this.web = web;
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "HospitalVo{" +
                "orgid='" + orgid + '\'' +
                ", orgname='" + orgname + '\'' +
                ", alias='" + alias + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", level='" + level + '\'' +
                ", nature='" + nature + '\'' +
                ", category='" + category + '\'' +
                ", tel='" + tel + '\'' +
                ", web='" + web + '\'' +
                ", state='" + state + '\'' +
                ", time='" + time + '\'' +
                ", picture='" + picture + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
