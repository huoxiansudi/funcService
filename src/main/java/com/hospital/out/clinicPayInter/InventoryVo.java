package com.hospital.out.clinicPayInter;

import java.util.List;

/**
 * User: xiaofu
 * Date: 2017/11/10
 * Time: 11:15
 * Function:
 */
public class InventoryVo {
    private String chargeName;//费用大类名称
    private String amount;//大类费用总金额
    private List<CostInventoryVo> costList;//费用明细

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<CostInventoryVo> getCostList() {
        return costList;
    }

    public void setCostList(List<CostInventoryVo> costList) {
        this.costList = costList;
    }

    @Override
    public String toString() {
        return "InventoryVo{" +
                "chargeName='" + chargeName + '\'' +
                ", amount='" + amount + '\'' +
                ", costList=" + costList +
                '}';
    }
}
