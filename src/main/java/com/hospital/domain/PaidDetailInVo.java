package com.hospital.domain;

/**
 * Created by jinhs on 2017-10-15.
 */
public class PaidDetailInVo {

    private String hospitalcode;   //医院代码
    private String identificationnumber;   //识别序号
    private String medicalprescription;    //处方医技
    private String fygb; //费用归类

    public String getFygb() {
        return fygb;
    }

    public void setFygb(String fygb) {
        this.fygb = fygb;
    }

    public PaidDetailInVo() {
    }

    public String getHospitalcode() {
        return hospitalcode;
    }

    public void setHospitalcode(String hospitalcode) {
        this.hospitalcode = hospitalcode;
    }

    public String getIdentificationnumber() {
        return identificationnumber;
    }

    public void setIdentificationnumber(String identificationnumber) {
        this.identificationnumber = identificationnumber;
    }

    public String getMedicalprescription() {
        return medicalprescription;
    }

    public void setMedicalprescription(String medicalprescription) {
        this.medicalprescription = medicalprescription;
    }

    @Override
    public String toString() {
        return "PaidDetailInVo{" +
                "hospitalcode='" + hospitalcode + '\'' +
                ", identificationnumber='" + identificationnumber + '\'' +
                ", medicalprescription='" + medicalprescription + '\'' +
                '}';
    }
}
