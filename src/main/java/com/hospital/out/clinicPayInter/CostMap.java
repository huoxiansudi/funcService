package com.hospital.out.clinicPayInter;

/**
 * User: xiaofu
 * Date: 2017/11/11
 * Time: 14:19
 * Function:
 */
public class CostMap {

    private String costName;

    private String costCode;

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostCode() {
        return costCode;
    }

    public void setCostCode(String costCode) {
        this.costCode = costCode;
    }

    @Override
    public String toString() {
        return "CostMap{" +
                "costName='" + costName + '\'' +
                ", costCode='" + costCode + '\'' +
                '}';
    }
}
