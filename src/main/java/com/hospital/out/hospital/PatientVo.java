package com.hospital.out.hospital;

/**
 * Created by jinhs on 2017-09-19.
 */
public class PatientVo {

    private String patid;       //编号
    private String patname;     //姓名
    private String patsex;      //患者性别
    //private String idcardtype;  //证件类型 jzcs,brlb,brxzdm
    private String idcard;      //证件号码
    private String medcardtype; //医保卡类型
    private String medcardno;   //医保卡号
    private String mobileno;    //手机号码
    private String address;     //联系地址
    //-------------------------------
    private String jzcs; //就诊次数
    private String brlb;//病人类别
    private String brxzdm;//病人性质编码

    public String getJzcs() {
        return jzcs;
    }

    public void setJzcs(String jzcs) {
        this.jzcs = jzcs;
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

    public PatientVo() {
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

    @Override
    public String toString() {
        return "PatientVo{" +
                "patid='" + patid + '\'' +
                ", patname='" + patname + '\'' +
                ", patsex='" + patsex + '\'' +
                ", idcard='" + idcard + '\'' +
                ", medcardtype='" + medcardtype + '\'' +
                ", medcardno='" + medcardno + '\'' +
                ", mobileno='" + mobileno + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
