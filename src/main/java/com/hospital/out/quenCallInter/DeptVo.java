package com.hospital.out.quenCallInter;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 科室或专家叫号信息
 * Created by jinhs on 2017/8/1.
 */
public class DeptVo {

    private String deptid;     //就诊科室编号
    private String deptname;   //就诊科室名称
    private String docid;      //就诊医生编号
    private String docname;    //就诊医生姓名
    @JSONField(format="yyyy-MM-dd")
    private Date visitdate;     //就诊日期
    private String visittype;   //上下午标志
    private String ghnumber;      //挂号序号
    private String newnumber;     //当前叫到几号
    private String beforenum;        //前面排队几人

    private String jzbs;//就诊标识

    public DeptVo() {
    }

    public String getJzbs() {
        return jzbs;
    }

    public void setJzbs(String jzbs) {
        this.jzbs = jzbs;
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

    public Date getVisitdate() {
        return visitdate;
    }

    public void setVisitdate(Date visitdate) {
        this.visitdate = visitdate;
    }

    public String getVisittype() {
        return visittype;
    }

    public void setVisittype(String visittype) {
        this.visittype = visittype;
    }

    public String getGhnumber() {
        return ghnumber;
    }

    public void setGhnumber(String ghnumber) {
        this.ghnumber = ghnumber;
    }

    public String getNewnumber() {
        return newnumber;
    }

    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getBeforenum() {
        return beforenum;
    }

    public void setBeforenum(String beforenum) {
        this.beforenum = beforenum;
    }

    @Override
    public String toString() {
        return "DeptVo{" +
                "deptid='" + deptid + '\'' +
                ", deptname='" + deptname + '\'' +
                ", docid='" + docid + '\'' +
                ", docname='" + docname + '\'' +
                ", visitdate=" + visitdate +
                ", visittype='" + visittype + '\'' +
                ", ghnumber='" + ghnumber + '\'' +
                ", newnumber='" + newnumber + '\'' +
                ", beforenum='" + beforenum + '\'' +
                ", jzbs='" + jzbs + '\'' +
                '}';
    }
}
