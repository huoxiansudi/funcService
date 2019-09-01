package com.hospital.domain;

/**
 * User: xiaofu
 * Date: 2017/11/24
 * Time: 14:38
 * Function:当天挂号
 */
public class CurrentGhkVo {
    private String jlxh;
    private String jzkh;
    private String jzcs;
    private String brxm;
    private String brlb;
    private String brxz;
    private String mzlbxh;
    private String pbxh;
    private String ksdm;
    private String ghrq;
    private String ghxh;
    private String ysgh;
    private String zlf;
    private String czgh;
    private String fybh;
    private String jylsh;
    private String sjlb;
    private String czrq;
    private String ksmc; //科室名称

    private String thbz;//退号标识
    private String payModel;//支付方式

    public String getPayModel() {
        return payModel;
    }

    public void setPayModel(String payModel) {
        this.payModel = payModel;
    }

    public String getThbz() {
        return thbz;
    }

    public void setThbz(String thbz) {
        this.thbz = thbz;
    }

    public String getCzrq() {
        return czrq;
    }

    public void setCzrq(String czrq) {
        this.czrq = czrq;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public String getSjlb() {
        return sjlb;
    }

    public void setSjlb(String sjlb) {
        this.sjlb = sjlb;
    }
    public String getJlxh() {
        return jlxh;
    }

    public void setJlxh(String jlxh) {
        this.jlxh = jlxh;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public String getJzcs() {
        return jzcs;
    }

    public void setJzcs(String jzcs) {
        this.jzcs = jzcs;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getBrlb() {
        return brlb;
    }

    public void setBrlb(String brlb) {
        this.brlb = brlb;
    }

    public String getBrxz() {
        return brxz;
    }

    public void setBrxz(String brxz) {
        this.brxz = brxz;
    }

    public String getMzlbxh() {
        return mzlbxh;
    }

    public void setMzlbxh(String mzlbxh) {
        this.mzlbxh = mzlbxh;
    }

    public String getPbxh() {
        return pbxh;
    }

    public void setPbxh(String pbxh) {
        this.pbxh = pbxh;
    }

    public String getKsdm() {
        return ksdm;
    }

    public void setKsdm(String ksdm) {
        this.ksdm = ksdm;
    }

    public String getGhrq() {
        return ghrq;
    }

    public void setGhrq(String ghrq) {
        this.ghrq = ghrq;
    }

    public String getGhxh() {
        return ghxh;
    }

    public void setGhxh(String ghxh) {
        this.ghxh = ghxh;
    }

    public String getYsgh() {
        return ysgh;
    }

    public void setYsgh(String ysgh) {
        this.ysgh = ysgh;
    }

    public String getZlf() {
        return zlf;
    }

    public void setZlf(String zlf) {
        this.zlf = zlf;
    }

    public String getCzgh() {
        return czgh;
    }

    public void setCzgh(String czgh) {
        this.czgh = czgh;
    }

    public String getFybh() {
        return fybh;
    }

    public void setFybh(String fybh) {
        this.fybh = fybh;
    }

    public String getJylsh() {
        return jylsh;
    }

    public void setJylsh(String jylsh) {
        this.jylsh = jylsh;
    }

    @Override
    public String toString() {
        return "CurrentGhkVo{" +
                "jlxh='" + jlxh + '\'' +
                ", jzkh='" + jzkh + '\'' +
                ", jzcs='" + jzcs + '\'' +
                ", brxm='" + brxm + '\'' +
                ", brlb='" + brlb + '\'' +
                ", brxz='" + brxz + '\'' +
                ", mzlbxh='" + mzlbxh + '\'' +
                ", pbxh='" + pbxh + '\'' +
                ", ksdm='" + ksdm + '\'' +
                ", ghrq='" + ghrq + '\'' +
                ", ghxh='" + ghxh + '\'' +
                ", ysgh='" + ysgh + '\'' +
                ", zlf='" + zlf + '\'' +
                ", czgh='" + czgh + '\'' +
                ", fybh='" + fybh + '\'' +
                ", jylsh='" + jylsh + '\'' +
                ", sjlb='" + sjlb + '\'' +
                '}';
    }
}
