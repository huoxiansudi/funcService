package com.hospital.out.clinicPayInter;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 支付详情
 * Created by jinhs on 2017/8/1.
 */
public class PaidDetailVo {

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date costdate;     //费用日期
    private String costname;   //费用名称
    private String docname;     //医生姓名
    private String deptname;     //科室名称
    private Double totalcost;        //合计金额
    private String costremark;        //费用备注

    private String itemnumber;    //数量
    private Double price;    //单价
    private Double amount;    //金额
    private String unit;    //单位
    private String plasters;    //处方贴数

    public PaidDetailVo() {
    }

    @Override
    public String toString() {
        return "PaidDetailVo{" +
                "costdate=" + costdate +
                ", costname='" + costname + '\'' +
                ", docname='" + docname + '\'' +
                ", deptname='" + deptname + '\'' +
                ", totalcost=" + totalcost +
                ", costremark='" + costremark + '\'' +
                ", itemnumber='" + itemnumber + '\'' +
                ", price=" + price +
                ", amount='" + amount + '\'' +
                ", unit='" + unit + '\'' +
                ", plasters='" + plasters + '\'' +
                '}';
    }

    public Date getCostdate() {
        return costdate;
    }

    public void setCostdate(Date costdate) {
        this.costdate = costdate;
    }

    public String getCostname() {
        return costname;
    }

    public void setCostname(String costname) {
        this.costname = costname;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(Double totalcost) {
        this.totalcost = totalcost;
    }

    public String getCostremark() {
        return costremark;
    }

    public void setCostremark(String costremark) {
        this.costremark = costremark;
    }

    public String getItemnumber() {
        return itemnumber;
    }

    public void setItemnumber(String itemnumber) {
        this.itemnumber = itemnumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPlasters() {
        return plasters;
    }

    public void setPlasters(String plasters) {
        this.plasters = plasters;
    }

}
