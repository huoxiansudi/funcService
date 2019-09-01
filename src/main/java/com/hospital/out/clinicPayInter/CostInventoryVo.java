package com.hospital.out.clinicPayInter;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * User: xiaofu
 * Date: 2017/11/10
 * Time: 11:17
 * Function:
 */
public class CostInventoryVo {
    private String costName; //费用名称
    private String costUnit; //单位
    private String costQuantity;//数量
    private Double costUnitPrice;//单价
    private Double costSubtotal;//小计
    @JSONField(serialize=false)
    private String fygl;

    public String getFygl() {
        return fygl;
    }

    public void setFygl(String fygl) {
        this.fygl = fygl;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostUnit() {
        return costUnit;
    }

    public void setCostUnit(String costUnit) {
        this.costUnit = costUnit;
    }

    public String getCostQuantity() {
        return costQuantity;
    }

    public void setCostQuantity(String costQuantity) {
        this.costQuantity = costQuantity;
    }

    public Double getCostUnitPrice() {
        return costUnitPrice;
    }

    public void setCostUnitPrice(Double costUnitPrice) {
        this.costUnitPrice = costUnitPrice;
    }

    public Double getCostSubtotal() {
        return costSubtotal;
    }

    public void setCostSubtotal(Double costSubtotal) {
        this.costSubtotal = costSubtotal;
    }

    @Override
    public String toString() {
        return "CostInventoryVo{" +
                "costName='" + costName + '\'' +
                ", costUnit='" + costUnit + '\'' +
                ", costQuantity='" + costQuantity + '\'' +
                ", costUnitPrice=" + costUnitPrice +
                ", costSubtotal=" + costSubtotal +
                ", fygl='" + fygl + '\'' +
                '}';
    }
}
