package com.hospital.domain;

/**
 * Created by jinhs on 2017-11-22.
 */
public class GhInVo {

    private String preid;          //预约单编号
    private String numid;   //号源编号
    private String patid;      //患者编号
    private String orgid; //医院编号
    private String visitdate;     //就诊日期
    private String ampm;       //上下午标识
    private String schid;      //排班编号
    private String delaypay;        //挂号费是否托收
    private String oper;        //操作员

    public GhInVo() {
    }

    public String getPreid() {
        return preid;
    }

    public void setPreid(String preid) {
        this.preid = preid;
    }

    public String getNumid() {
        return numid;
    }

    public void setNumid(String numid) {
        this.numid = numid;
    }

    public String getPatid() {
        return patid;
    }

    public void setPatid(String patid) {
        this.patid = patid;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getVisitdate() {
        return visitdate;
    }

    public void setVisitdate(String visitdate) {
        this.visitdate = visitdate;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public String getSchid() {
        return schid;
    }

    public void setSchid(String schid) {
        this.schid = schid;
    }

    public String getDelaypay() {
        return delaypay;
    }

    public void setDelaypay(String delaypay) {
        this.delaypay = delaypay;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    @Override
    public String toString() {
        return "GhInVo{" +
                "preid=" + preid +
                ", numid='" + numid + '\'' +
                ", patid='" + patid + '\'' +
                ", orgid='" + orgid + '\'' +
                ", visitdate='" + visitdate + '\'' +
                ", ampm='" + ampm + '\'' +
                ", schid='" + schid + '\'' +
                ", delaypay='" + delaypay + '\'' +
                ", oper='" + oper + '\'' +
                '}';
    }
}
