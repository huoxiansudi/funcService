package com.hospital.domain;

/**
 * User: xiaofu
 * Date: 2017/11/14
 * Time: 13:53
 * Function:
 */
public class PrepaidVo {
    private String idCard;
    private String paymode;
    private double payamount;  //付款金额
    private String agtOrderNumber;//

    private String depoDate;//缴费时间
    private String name;
    private String deptCode;
    private String patientNo;
    private String jlxh;

    public String getDepoDate() {
        return depoDate;
    }

    public void setDepoDate(String depoDate) {
        this.depoDate = depoDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public String getJlxh() {
        return jlxh;
    }

    public void setJlxh(String jlxh) {
        this.jlxh = jlxh;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public double getPayamount() {
        return payamount;
    }

    public void setPayamount(double payamount) {
        this.payamount = payamount;
    }

    public String getAgtOrderNumber() {
        return agtOrderNumber;
    }

    public void setAgtOrderNumber(String agtOrderNumber) {
        this.agtOrderNumber = agtOrderNumber;
    }
}
