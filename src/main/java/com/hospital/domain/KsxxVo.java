package com.hospital.domain;

/**
 * Created by jinhs on 2019-08-24.
 */
public class KsxxVo {

    private String ksdm;      //科室编号
    private String ksmc;   //科室的名称
    private String wdksdm;     //标准科室编号
    private String wdksjs;//科室介绍
    private String wz;        //位置

    public String getKsdm() {
        return ksdm;
    }

    public void setKsdm(String ksdm) {
        this.ksdm = ksdm;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public String getWdksdm() {
        return wdksdm;
    }

    public void setWdksdm(String wdksdm) {
        this.wdksdm = wdksdm;
    }

    public String getWdksjs() {
        return wdksjs;
    }

    public void setWdksjs(String wdksjs) {
        this.wdksjs = wdksjs;
    }

    public String getWz() {
        return wz;
    }

    public void setWz(String wz) {
        this.wz = wz;
    }
}
