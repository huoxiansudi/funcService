package com.hospital.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * User: xiaofu
 * Date: 2017/9/6
 * Time: 18:09
 */
public class InspectInVo {

    private String medcardno; //就诊卡号

    private String idcard; //身份证

    private String medcardsource; //就诊来源 1,门诊；2，住院; 不传就是全部

    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date bdate;   //开始时间

    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date edate;  //结束时间

    private String page; //第几页

    private String pagesize;//一页多少条

    public String getMedcardno() {
        return medcardno;
    }

    public void setMedcardno(String medcardno) {
        this.medcardno = medcardno;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getMedcardsource() {
        return medcardsource;
    }

    public void setMedcardsource(String medcardsource) {
        this.medcardsource = medcardsource;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPagesize() {
        return pagesize;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }

    @Override
    public String toString() {
        return "InspectInVo{" +
                "medcardno='" + medcardno + '\'' +
                ", idcard='" + idcard + '\'' +
                ", medcardsource='" + medcardsource + '\'' +
                ", bdate=" + bdate +
                ", edate=" + edate +
                ", page='" + page + '\'' +
                ", pagesize='" + pagesize + '\'' +
                '}';
    }
}
