package com.hospital.domain;

/**
 * 预约挂号
 * Created by jinhs on 2017-09-20.
 */
public class YyghInVo {

    private int yyxh;          //预约序号
    private int zt;        //预约状态
    private int yylxdm;        //预约类型代码

    private String regid;     //预约编号（对方）
    private String numid;   //号源编号
    private String patid;      //患者编号
    private String orgid; //医院编号
    private String visitdate;     //就诊日期
    private String ampm;       //上下午标识
    private String schid;      //排班编号
    private String pass;     //取号密码
    private String no;        //预约序号
    private String spid;        //服务商编号
    private String spname;      //服务商名称
    private String oper;        //操作员

    private String numdate;   //号源日期



    public YyghInVo() {
    }

    public int getYyxh() {
        return yyxh;
    }

    public void setYyxh(int yyxh) {
        this.yyxh = yyxh;
    }

    public int getZt() {
        return zt;
    }

    public void setZt(int zt) {
        this.zt = zt;
    }

    public int getYylxdm() {
        return yylxdm;
    }

    public void setYylxdm(int yylxdm) {
        this.yylxdm = yylxdm;
    }

    public String getRegid() {
        return regid;
    }

    public void setRegid(String regid) {
        this.regid = regid;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getNumdate() {
        return numdate;
    }

    public void setNumdate(String numdate) {
        this.numdate = numdate;
    }

    @Override
    public String toString() {
        return "YyghInVo{" +
                "yyxh=" + yyxh +
                ", zt=" + zt +
                ", yylxdm=" + yylxdm +
                ", regid='" + regid + '\'' +
                ", numid='" + numid + '\'' +
                ", patid='" + patid + '\'' +
                ", orgid='" + orgid + '\'' +
                ", visitdate='" + visitdate + '\'' +
                ", ampm='" + ampm + '\'' +
                ", schid='" + schid + '\'' +
                ", pass='" + pass + '\'' +
                ", no='" + no + '\'' +
                ", spid='" + spid + '\'' +
                ", spname='" + spname + '\'' +
                ", oper='" + oper + '\'' +
                ", numdate='" + numdate + '\'' +
                '}';
    }
}
