package com.hospital.out.clinicPayInter;


import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;

/**
 * 已支付列表
 * Created by jinhs on 2017/8/1.
 */
public class PayListVo {

    private String invoicenumber;   //发票号码
    private String costname;   //收费项目
    private Double totalcost;     //合计金额
   @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp costdate;     //日期
    private String cashierclerk;        //收款人
    private String patientname;    //患者姓名
    private String executionstatus;    //执行判别（0、已付款，1、表示已取药2、表示已执行）
    private String remark;    //备注
    private String jzkh;//返回就诊卡号

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public PayListVo() {
    }

    public Timestamp getCostdate() {
        return costdate;
    }

    public void setCostdate(Timestamp costdate) {
        this.costdate = costdate;
    }

    public PayListVo(String invoicenumber, String costname, Double totalcost, Timestamp costdate, String cashierclerk, String patientname, String executionstatus, String remark) {
        this.invoicenumber = invoicenumber;
        this.costname = costname;
        this.totalcost = totalcost;
        this.costdate = costdate;
        this.cashierclerk = cashierclerk;
        this.patientname = patientname;
        this.executionstatus = executionstatus;
        this.remark = remark;
    }

    public String getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(String invoicenumber) {
        this.invoicenumber = invoicenumber;
    }

    public String getCostname() {
        return costname;
    }

    public void setCostname(String costname) {
        this.costname = costname;
    }

    public Double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(Double totalcost) {
        this.totalcost = totalcost;
    }



    public String getCashierclerk() {
        return cashierclerk;
    }

    public void setCashierclerk(String cashierclerk) {
        this.cashierclerk = cashierclerk;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getExecutionstatus() {
        return executionstatus;
    }

    public void setExecutionstatus(String executionstatus) {
        this.executionstatus = executionstatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "PayListVo{" +
                "invoicenumber='" + invoicenumber + '\'' +
                ", costname='" + costname + '\'' +
                ", totalcost=" + totalcost +
                ", costdate=" + costdate +
                ", cashierclerk='" + cashierclerk + '\'' +
                ", patientname='" + patientname + '\'' +
                ", executionstatus='" + executionstatus + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
