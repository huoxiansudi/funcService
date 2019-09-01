package com.hospital.out.clinicPayInter;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by jinhs on 2017-11-25.
 */
public class GhsfVo {

    @JSONField(serialize = false)
    private String jzkh;     //就诊卡号
    @JSONField(serialize = false)
    private int jzcs;     //就诊参数
    @JSONField(serialize = false)
    private int ghxh;     //挂号序号
    @JSONField(serialize = false)
    private String jlxh;
    @JSONField(serialize = false)
    private String ghrq;
    @JSONField(serialize = false)
    private String sjlb;

    private String deptCode; //科室代码
    private String regid;          //挂号单编号
    private String deptname;   //科室名称
    private String docname;      //医生名称
    private String docrank; //医生级别
    private Double regfee;     //挂号费
    private Double treatfee;       //诊疗费
    private Double regamt;      //挂号金额
    @JSONField(format = "yyyy-MM-dd")
    private Date visitdate;        //就诊日期
    private String visittime;        //就诊时间
    private String visitaddress;        //就诊地点
    private String seqnum;        //顺序号


    public GhsfVo() {
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getSjlb() {
        return sjlb;
    }

    public void setSjlb(String sjlb) {
        this.sjlb = sjlb;
    }

    public String getGhrq() {
        return ghrq;
    }

    public void setGhrq(String ghrq) {
        this.ghrq = ghrq;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public int getJzcs() {
        return jzcs;
    }

    public void setJzcs(int jzcs) {
        this.jzcs = jzcs;
    }

    public int getGhxh() {
        return ghxh;
    }

    public void setGhxh(int ghxh) {
        this.ghxh = ghxh;
    }

    public String getRegid() {
        return regid;
    }

    public void setRegid(String regid) {
        this.regid = regid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDocrank() {
        return docrank;
    }

    public void setDocrank(String docrank) {
        this.docrank = docrank;
    }

    public Double getRegfee() {
        return regfee;
    }

    public void setRegfee(Double regfee) {
        this.regfee = regfee;
    }

    public Double getTreatfee() {
        return treatfee;
    }

    public void setTreatfee(Double treatfee) {
        this.treatfee = treatfee;
    }

    public Double getRegamt() {
        return regamt;
    }

    public void setRegamt(Double regamt) {
        this.regamt = regamt;
    }

    public Date getVisitdate() {
        return visitdate;
    }

    public void setVisitdate(Date visitdate) {
        this.visitdate = visitdate;
    }

    public String getVisittime() {
        return visittime;
    }

    public void setVisittime(String visittime) {
        this.visittime = visittime;
    }

    public String getVisitaddress() {
        return visitaddress;
    }

    public void setVisitaddress(String visitaddress) {
        this.visitaddress = visitaddress;
    }

    public String getSeqnum() {
        return seqnum;
    }

    public void setSeqnum(String seqnum) {
        this.seqnum = seqnum;
    }

    public String getJlxh() {
        return jlxh;
    }

    public void setJlxh(String jlxh) {
        this.jlxh = jlxh;
    }
}
