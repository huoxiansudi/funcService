package com.hospital.out.hospital;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 医院排班查询
 * Created by fuxf on 2017/8/3.
 */
public class DoctorPbVo {

    private String schid;      //排班编号
    private String orgid;      //医院编号
    private String docid;   //医生编号
    private String docname;   //医生姓名
    private String docsex;   //医生性别
    private String title;    //医生职称
    private String deptid;     //科室编号
    private String deptname;     //科室名称
    @JSONField(format = "yyyyMMdd")
    private Date schdate;     //排班日期
    private String ampm;     //上下午标志
    private String numcount;     //号源总数20
    private String numremain;     //可预约数
    private String categor;     //挂号类别
    private String regfee;     //挂号费
    private String fee;     //诊疗费（诊查费）
    private String schstate;     //排班状态 0
    @JSONField(serialize = false)
    private String appdate;

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    public DoctorPbVo() {
    }

    public String getSchid() {
        return schid;
    }

    public void setSchid(String schid) {
        this.schid = schid;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDocsex() {
        return docsex;
    }

    public void setDocsex(String docsex) {
        this.docsex = docsex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Date getSchdate() {
        return schdate;
    }

    public void setSchdate(Date schdate) {
        this.schdate = schdate;
    }


    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public String getNumcount() {
        return numcount;
    }

    public void setNumcount(String numcount) {
        this.numcount = numcount;
    }

    public String getNumremain() {
        return numremain;
    }

    public void setNumremain(String numremain) {
        this.numremain = numremain;
    }

    public String getCategor() {
        return categor;
    }

    public void setCategor(String categor) {
        this.categor = categor;
    }

    public String getRegfee() {
        return regfee;
    }

    public void setRegfee(String regfee) {
        this.regfee = regfee;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getSchstate() {
        return schstate;
    }

    public void setSchstate(String schstate) {
        this.schstate = schstate;
    }

    @Override
    public String toString() {
        return "DoctorPbVo{" +
                "schid='" + schid + '\'' +
                ", orgid='" + orgid + '\'' +
                ", docid='" + docid + '\'' +
                ", docname='" + docname + '\'' +
                ", docsex='" + docsex + '\'' +
                ", title='" + title + '\'' +
                ", deptid='" + deptid + '\'' +
                ", deptname='" + deptname + '\'' +
                ", schdate=" + schdate +
                ", ampm='" + ampm + '\'' +
                ", numcount='" + numcount + '\'' +
                ", numremain='" + numremain + '\'' +
                ", categor='" + categor + '\'' +
                ", regfee='" + regfee + '\'' +
                ", fee='" + fee + '\'' +
                ", schstate='" + schstate + '\'' +
                ", appdate='" + appdate + '\'' +
                '}';
    }
}
