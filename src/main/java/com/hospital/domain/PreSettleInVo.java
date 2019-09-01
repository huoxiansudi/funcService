package com.hospital.domain;

/**
 * Created by jinhs on 2017-10-15.
 */
public class PreSettleInVo {

    private String hospitalcode;   //医院代码
    private String identificationNumbers;   //识别序号

    public PreSettleInVo() {
    }

    public String getIdentificationNumbers() {
        return identificationNumbers;
    }

    public void setIdentificationNumbers(String identificationNumbers) {
        this.identificationNumbers = identificationNumbers;
    }

    public String getHospitalcode() {
        return hospitalcode;
    }

    public void setHospitalcode(String hospitalcode) {
        this.hospitalcode = hospitalcode;
    }

    @Override
    public String toString() {
        return "PreSettleInVo{" +
                "hospitalcode='" + hospitalcode + '\'' +
                ", identificationNumbers='" + identificationNumbers + '\'' +
                '}';
    }
}
