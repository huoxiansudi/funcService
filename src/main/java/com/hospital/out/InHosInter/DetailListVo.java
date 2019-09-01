package com.hospital.out.InHosInter;

/**
 * 住院一日清单
 * Created by jinhs on 2017/8/1.
 */
public class DetailListVo {

    private Double totalcost ;   //费用总计
    private String maincostlist;      //大类费用集合

    public DetailListVo() {
    }

    public DetailListVo(Double totalcost, String maincostlist) {
        this.totalcost = totalcost;
        this.maincostlist = maincostlist;
    }

    public Double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(Double totalcost) {
        this.totalcost = totalcost;
    }

    public String getMaincostlist() {
        return maincostlist;
    }

    public void setMaincostlist(String maincostlist) {
        this.maincostlist = maincostlist;
    }

    @Override
    public String toString() {
        return "DetailListVo{" +
                "totalcost=" + totalcost +
                ", maincostlist='" + maincostlist + '\'' +
                '}';
    }
}
