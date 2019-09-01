package com.hospital.out.clinicPayInter;

import java.util.List;

/**
 * Created by jinhs on 2017-10-15.
 */
public class CostVo {

    private String costname;//费用名称
    private String docname;//医生姓名
    private String deptname;//科室名称
    private Double totalcost;//合计金额
    private String costremark;//费用备注
    private List<PaidDetailVo> list;//费用详情

    public CostVo() {
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

    public List<PaidDetailVo> getList() {
        return list;
    }

    public void setList(List<PaidDetailVo> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "CostVo{" +
                "costname='" + costname + '\'' +
                ", docname='" + docname + '\'' +
                ", deptname='" + deptname + '\'' +
                ", totalcost='" + totalcost + '\'' +
                ", costremark='" + costremark + '\'' +
                ", list=" + list +
                '}';
    }
}
