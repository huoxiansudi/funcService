package com.hospital.out.signTakenoInter;

import java.util.Date;

/**
 * 签到取号列表
 * Created by jinhs on 2017/8/1.
 */
public class SignListVo {

    private String deptid;     //科室编号
    private String deptname;   //科室名称
    private String docid;      //医生编号
    private String docname;    //医生姓名
    private Date scheduledate;     //号源日期

    private Date begintime;     //分时开始时间
    private Date endtime;     //分时结束时间
    private String hisordernumber;   //预约流水号
    private String orderstatus;      //预约状态(1预约、2取消、3爽约、4已取号、5未支付（锁号）、6已支付)
    private Date committime;     //登记时间
    private String hospitalcode;        //医院代码
    private String hospitalname;        //医院名称
    private String doctorlevel;        //医生级别
    private String appointmenttype;        //预约类型(1-专家/2-普通)
    private Date currentdate;        //当前日期(yyyy-MM-dd)
    private Date outordernumber;        //外部流水号（与提交预约时候的值相同）
    private Date invoicenumber;        //发票号码

    public SignListVo() {
    }

    public SignListVo(String deptid, String deptname, String docid, String docname, Date scheduledate, Date begintime, Date endtime, String hisordernumber, String orderstatus, Date committime, String hospitalcode, String hospitalname, String doctorlevel, String appointmenttype, Date currentdate, Date outordernumber, Date invoicenumber) {
        this.deptid = deptid;
        this.deptname = deptname;
        this.docid = docid;
        this.docname = docname;
        this.scheduledate = scheduledate;
        this.begintime = begintime;
        this.endtime = endtime;
        this.hisordernumber = hisordernumber;
        this.orderstatus = orderstatus;
        this.committime = committime;
        this.hospitalcode = hospitalcode;
        this.hospitalname = hospitalname;
        this.doctorlevel = doctorlevel;
        this.appointmenttype = appointmenttype;
        this.currentdate = currentdate;
        this.outordernumber = outordernumber;
        this.invoicenumber = invoicenumber;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public Date getScheduledate() {
        return scheduledate;
    }

    public void setScheduledate(Date scheduledate) {
        this.scheduledate = scheduledate;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getHisordernumber() {
        return hisordernumber;
    }

    public void setHisordernumber(String hisordernumber) {
        this.hisordernumber = hisordernumber;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Date getCommittime() {
        return committime;
    }

    public void setCommittime(Date committime) {
        this.committime = committime;
    }

    public String getHospitalcode() {
        return hospitalcode;
    }

    public void setHospitalcode(String hospitalcode) {
        this.hospitalcode = hospitalcode;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getDoctorlevel() {
        return doctorlevel;
    }

    public void setDoctorlevel(String doctorlevel) {
        this.doctorlevel = doctorlevel;
    }

    public String getAppointmenttype() {
        return appointmenttype;
    }

    public void setAppointmenttype(String appointmenttype) {
        this.appointmenttype = appointmenttype;
    }

    public Date getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(Date currentdate) {
        this.currentdate = currentdate;
    }

    public Date getOutordernumber() {
        return outordernumber;
    }

    public void setOutordernumber(Date outordernumber) {
        this.outordernumber = outordernumber;
    }

    public Date getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(Date invoicenumber) {
        this.invoicenumber = invoicenumber;
    }

    @Override
    public String toString() {
        return "SignListVo{" +
                "deptid='" + deptid + '\'' +
                ", deptname='" + deptname + '\'' +
                ", docid='" + docid + '\'' +
                ", docname='" + docname + '\'' +
                ", scheduledate=" + scheduledate +
                ", begintime=" + begintime +
                ", endtime=" + endtime +
                ", hisordernumber='" + hisordernumber + '\'' +
                ", orderstatus='" + orderstatus + '\'' +
                ", committime=" + committime +
                ", hospitalcode='" + hospitalcode + '\'' +
                ", hospitalname='" + hospitalname + '\'' +
                ", doctorlevel='" + doctorlevel + '\'' +
                ", appointmenttype='" + appointmenttype + '\'' +
                ", currentdate=" + currentdate +
                ", outordernumber=" + outordernumber +
                ", invoicenumber=" + invoicenumber +
                '}';
    }
}
