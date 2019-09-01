package com.hospital.out.hospital;

/**
 * User: xiaofu
 * Date: 2017/9/28
 * Time: 13:44
 * Function: gh_mzyyk字段zt 0:预约未挂号1:挂号 -1:病人取消-2:过期 -3:
 */
public class JzlbVo {

    private String orderid; //订单编号
    private String takecode; //取号时间 0违约未取1正常取号2取号后退号3未取号但不违约
    private String taketime;//取号时间
    private String visittime;//就诊时间
    private String doctime;  //医嘱时间
    private String paytime;  //付费时间

    private String medtime; //取药时间
    private String cardtype;//医保卡类型0医保1市医保2市民卡3农保
    private String cardno;//医保卡号


    public String getTaketime() {
        return taketime;
    }

    public void setTaketime(String taketime) {
        this.taketime = taketime;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getTakecode() {
        return takecode;
    }

    public void setTakecode(String takecode) {
        this.takecode = takecode;
    }

    public String getVisittime() {
        return visittime;
    }

    public void setVisittime(String visittime) {
        this.visittime = visittime;
    }

    public String getDoctime() {
        return doctime;
    }

    public void setDoctime(String doctime) {
        this.doctime = doctime;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getMedtime() {
        return medtime;
    }

    public void setMedtime(String medtime) {
        this.medtime = medtime;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    @Override
    public String toString() {
        return "JzlbVo{" +
                "orderid='" + orderid + '\'' +
                ", takecode='" + takecode + '\'' +
                ", taketime='" + taketime + '\'' +
                ", visittime='" + visittime + '\'' +
                ", doctime='" + doctime + '\'' +
                ", paytime='" + paytime + '\'' +
                ", medtime='" + medtime + '\'' +
                ", cardtype='" + cardtype + '\'' +
                ", cardno='" + cardno + '\'' +
                '}';
    }
}
