package com.hospital.out.clinicPayInter;

import java.util.List;

/**
 * User: xiaofu
 * Date: 2017/11/10
 * Time: 13:59
 * Function:
 */
public class TotalCostInventoryVo {
    private String totalcost;
    private List<InventoryVo> maincostlist;

    public String getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(String totalcost) {
        this.totalcost = totalcost;
    }

    public List<InventoryVo> getMaincostlist() {
        return maincostlist;
    }

    public void setMaincostlist(List<InventoryVo> maincostlist) {
        this.maincostlist = maincostlist;
    }

    @Override
    public String toString() {
        return "TotalCostInventoryVo{" +
                "totalcost='" + totalcost + '\'' +
                ", maincostlist=" + maincostlist +
                '}';
    }
}
