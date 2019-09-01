package com.hospital.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by jinhs on 2017-09-19.
 */
public class PatientInVo {

    private String patid;       //编号
    private String patname;     //姓名
    private String patsex;      //患者性别
    private String idcardtype;  //证件类型
    private String idcard;      //证件号码
    private String medcardtype; //医保卡类型
    private String medcardno;   //医保卡号
    private String mobileno;    //手机号码
    private String address;     //联系地址
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date djxtrq;        //登记系统日期

    private String brlb;
    private String brxzdm;
    @JSONField(format = "yyyy-MM-dd")
    private Date csrq;

    private String patientname; //患者姓名

    public PatientInVo() {
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getBrlb() {
        return brlb;
    }

    public void setBrlb(String brlb) {
        this.brlb = brlb;
    }

    public String getBrxzdm() {
        return brxzdm;
    }

    public void setBrxzdm(String brxzdm) {
        this.brxzdm = brxzdm;
    }

    public Date getDjxtrq() {
        return djxtrq;
    }

    public void setDjxtrq(Date djxtrq) {
        this.djxtrq = djxtrq;
    }

    public String getPatid() {
        return patid;
    }

    public void setPatid(String patid) {
        this.patid = patid;
    }

    public String getPatname() {
        return patname;
    }

    public void setPatname(String patname) {
        this.patname = patname;
    }

    public String getPatsex() {
        return patsex;
    }

    public void setPatsex(String patsex) {
        this.patsex = patsex;
    }

    public String getIdcardtype() {
        return idcardtype;
    }

    public void setIdcardtype(String idcardtype) {
        this.idcardtype = idcardtype;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getMedcardtype() {
        return medcardtype;
    }

    public void setMedcardtype(String medcardtype) {
        this.medcardtype = medcardtype;
    }

    public String getMedcardno() {
        return medcardno;
    }

    public void setMedcardno(String medcardno) {
        this.medcardno = medcardno;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    @Override
    public String toString() {
        return "PatientInVo{" +
                "patid='" + patid + '\'' +
                ", patname='" + patname + '\'' +
                ", patsex='" + patsex + '\'' +
                ", idcardtype='" + idcardtype + '\'' +
                ", idcard='" + idcard + '\'' +
                ", medcardtype='" + medcardtype + '\'' +
                ", medcardno='" + medcardno + '\'' +
                ", mobileno='" + mobileno + '\'' +
                ", address='" + address + '\'' +
                ", djxtrq=" + djxtrq +
                ", brlb='" + brlb + '\'' +
                ", brxzdm='" + brxzdm + '\'' +
                ", csrq=" + csrq +
                '}';
    }
}
