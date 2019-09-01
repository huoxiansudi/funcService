package com.hospital.out.clinicPayInter;

/**
 * 诊间支付预结算
 * Created by jinhs on 2017/8/1.
 */
public class PreSettleVo {

    private String settlementinstructions;   //结算说明
    private String amount;   //现金金额
    private String invoicenumber;     //发票号码
    private String insuranceparameters;     //医保参数
    private String insurancetype;        //医保类型
    private String insurancetypedes;    //医保类型说明

    public PreSettleVo() {
    }

    public PreSettleVo(String settlementinstructions, String amount, String invoicenumber, String insuranceparameters, String insurancetype, String insurancetypedes) {
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
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

    public String getInsurancetype() {
        return insurancetype;
    }

    public void setInsurancetype(String insurancetype) {
        this.insurancetype = insurancetype;
    }

    public String getInsurancetypedes() {
        return insurancetypedes;
    }

    public void setInsurancetypedes(String insurancetypedes) {
        this.insurancetypedes = insurancetypedes;
    }

    @Override
    public String toString() {
        return "PreSettleVo{" +
                "settlementinstructions='" + settlementinstructions + '\'' +
                ", amount='" + amount + '\'' +
                ", invoicenumber='" + invoicenumber + '\'' +
                ", insuranceparameters='" + insuranceparameters + '\'' +
                ", insurancetype='" + insurancetype + '\'' +
                ", insurancetypedes='" + insurancetypedes + '\'' +
                '}';
    }
}
