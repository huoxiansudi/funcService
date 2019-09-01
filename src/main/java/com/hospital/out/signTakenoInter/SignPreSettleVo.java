package com.hospital.out.signTakenoInter;

import java.util.Date;

/**
 * 签到取号预结算
 * Created by jinhs on 2017/8/1.
 */
public class SignPreSettleVo {

    private String settlementinstructions;     //结算说明
    private Double amount;   //现金金额
    private String invoicenumber;      //发票号码
    private String insuranceparameters;    //医保参数
    private Date insurancetype;     //医保类型
    private Date insurancetypedes;     //医保类型说明

    public SignPreSettleVo() {
    }

    public SignPreSettleVo(String settlementinstructions, Double amount, String invoicenumber, String insuranceparameters, Date insurancetype, Date insurancetypedes) {
        this.settlementinstructions = settlementinstructions;
        this.amount = amount;
        this.invoicenumber = invoicenumber;
        this.insuranceparameters = insuranceparameters;
        this.insurancetype = insurancetype;
        this.insurancetypedes = insurancetypedes;
    }

    public String getSettlementinstructions() {
        return settlementinstructions;
    }

    public void setSettlementinstructions(String settlementinstructions) {
        this.settlementinstructions = settlementinstructions;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(String invoicenumber) {
        this.invoicenumber = invoicenumber;
    }

    public String getInsuranceparameters() {
        return insuranceparameters;
    }

    public void setInsuranceparameters(String insuranceparameters) {
        this.insuranceparameters = insuranceparameters;
    }

    public Date getInsurancetype() {
        return insurancetype;
    }

    public void setInsurancetype(Date insurancetype) {
        this.insurancetype = insurancetype;
    }

    public Date getInsurancetypedes() {
        return insurancetypedes;
    }

    public void setInsurancetypedes(Date insurancetypedes) {
        this.insurancetypedes = insurancetypedes;
    }

    @Override
    public String toString() {
        return "SignPreSettleVo{" +
                "settlementinstructions='" + settlementinstructions + '\'' +
                ", amount=" + amount +
                ", invoicenumber='" + invoicenumber + '\'' +
                ", insuranceparameters='" + insuranceparameters + '\'' +
                ", insurancetype=" + insurancetype +
                ", insurancetypedes=" + insurancetypedes +
                '}';
    }
}
