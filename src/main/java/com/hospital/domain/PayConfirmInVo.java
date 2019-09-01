package com.hospital.domain;

/**
 * 支付确认
 * Created by jinhs on 2017-10-15.
 */
public class PayConfirmInVo {

    private String hospitalcode;     //医院代码
    private String invoicenumber ;   //发票号
    private String paymode ;      //支付方式
    private String agtordernumber ; //对应收单机构
    private String payamount ;     //付款金额
    private String notify ;       //支付成功时的通知信息
    private String identificationNumbers ;      //识别序号

    private int sfsb ;      //收费识别
    private String fphm ;      //发票号码
    private String jzkh ;      //就诊卡号
    private String brxm ;      //病人姓名
    private Double sxj;        //收现金
    private String czgh ;      //操作工号

    public PayConfirmInVo() {
    }

    public Double getSxj() {
        return sxj;
    }

    public void setSxj(Double sxj) {
        this.sxj = sxj;
    }

    public String getCzgh() {
        return czgh;
    }

    public void setCzgh(String czgh) {
        this.czgh = czgh;
    }

    public int getSfsb() {
        return sfsb;
    }

    public void setSfsb(int sfsb) {
        this.sfsb = sfsb;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getHospitalcode() {
        return hospitalcode;
    }

    public void setHospitalcode(String hospitalcode) {
        this.hospitalcode = hospitalcode;
    }

    public String getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(String invoicenumber) {
        this.invoicenumber = invoicenumber;
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public String getAgtordernumber() {
        return agtordernumber;
    }

    public void setAgtordernumber(String agtordernumber) {
        this.agtordernumber = agtordernumber;
    }

    public String getPayamount() {
        return payamount;
    }

    public void setPayamount(String payamount) {
        this.payamount = payamount;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public String getIdentificationNumbers() {
        return identificationNumbers;
    }

    public void setIdentificationNumbers(String identificationNumbers) {
        this.identificationNumbers = identificationNumbers;
    }

    @Override
    public String toString() {
        return "PayConfirmInVo{" +
                "hospitalcode='" + hospitalcode + '\'' +
                ", invoicenumber='" + invoicenumber + '\'' +
                ", paymode='" + paymode + '\'' +
                ", agtordernumber='" + agtordernumber + '\'' +
                ", payamount='" + payamount + '\'' +
                ", notify='" + notify + '\'' +
                ", identificationNumbers='" + identificationNumbers + '\'' +
                ", sfsb=" + sfsb +
                ", fphm='" + fphm + '\'' +
                ", jzkh='" + jzkh + '\'' +
                ", brxm='" + brxm + '\'' +
                ", sxj=" + sxj +
                ", czgh='" + czgh + '\'' +
                '}';
    }
}
