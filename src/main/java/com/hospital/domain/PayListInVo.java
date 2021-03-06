package com.hospital.domain;

/**
 * Created by jinhs on 2017-10-15.
 */
public class PayListInVo {

    private String hospitalcode ;   //医院代码
    private String medcardtype ;   //诊疗卡类型
    private String medcardno ;     //诊疗卡号
    private String patientcode ;     //患者编号
    private String idcardtype ;        //证件类型
    private String idcard ;    //证件号码

    private String czgh;//操作工号



    public PayListInVo() {
    }

    public String getCzgh() {
        return czgh;
    }

    public void setCzgh(String czgh) {
        this.czgh = czgh;
    }

    public String getHospitalcode() {
        return hospitalcode;
    }

    public void setHospitalcode(String hospitalcode) {
        this.hospitalcode = hospitalcode;
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

    public String getPatientcode() {
        return patientcode;
    }

    public void setPatientcode(String patientcode) {
        this.patientcode = patientcode;
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

    @Override
    public String toString() {
        return "PayListInVo{" +
                "hospitalcode='" + hospitalcode + '\'' +
                ", medcardtype='" + medcardtype + '\'' +
                ", medcardno='" + medcardno + '\'' +
                ", patientcode='" + patientcode + '\'' +
                ", idcardtype='" + idcardtype + '\'' +
                ", idcard='" + idcard + '\'' +
                ", czgh='" + czgh + '\'' +
                '}';
    }
}
