package com.hospital.out.signTakenoInter;

import java.util.Date;

/**
 * 获取挂号单
 * Created by jinhs on 2017/8/1.
 */
public class GetRegistformVo {

    private String patientage;     //患者年龄
    private String patientname;   //患者姓名
    private String deptid;      //科室编号
    private String deptname;    //科室名称
    private String docid;      //医生编号
    private String docname;    //医生姓名
    private Date scheduledate;     //号源日期
    private Date begintime;     //分时开始时间
    private Date endtime;     //分时结束时间
    private Date committime;     //登记时间
    private String hospitalcode;        //医院代码
    private String hospitalname;        //医院名称
    private String doctorlevel;        //医生级别
    private String appointmenttype;        //预约类型(1-专家/2-普通)
    private String serialnumber;        //排队号码
    private String departmentlocation;        //就诊位置
    private Double treatfee;        //诊疗费
    private Double regfee;        //挂号费
    private String patientmedicalcardnumber;        //患者诊疗卡号码
    private String patientmedicalcardtype;        //患者诊疗卡类型(1.居民健康卡 2.就诊卡 3.医保卡 4.院内诊疗卡 5.门诊号 6.诊疗卡

    public GetRegistformVo() {
    }

    public GetRegistformVo(String patientage, String patientname, String deptid, String deptname, String docid, String docname, Date scheduledate, Date begintime, Date endtime, Date committime, String hospitalcode, String hospitalname, String doctorlevel, String appointmenttype, String serialnumber, String departmentlocation, Double treatfee, Double regfee, String patientmedicalcardnumber, String patientmedicalcardtype) {
        this.patientage = patientage;
        this.patientname = patientname;
        this.deptid = deptid;
        this.deptname = deptname;
        this.docid = docid;
        this.docname = docname;
        this.scheduledate = scheduledate;
        this.begintime = begintime;
        this.endtime = endtime;
        this.committime = committime;
        this.hospitalcode = hospitalcode;
        this.hospitalname = hospitalname;
        this.doctorlevel = doctorlevel;
        this.appointmenttype = appointmenttype;
        this.serialnumber = serialnumber;
        this.departmentlocation = departmentlocation;
        this.treatfee = treatfee;
        this.regfee = regfee;
        this.patientmedicalcardnumber = patientmedicalcardnumber;
        this.patientmedicalcardtype = patientmedicalcardtype;
    }

    public String getPatientage() {
        return patientage;
    }

    public void setPatientage(String patientage) {
        this.patientage = patientage;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
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

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getDepartmentlocation() {
        return departmentlocation;
    }

    public void setDepartmentlocation(String departmentlocation) {
        this.departmentlocation = departmentlocation;
    }

    public Double getTreatfee() {
        return treatfee;
    }

    public void setTreatfee(Double treatfee) {
        this.treatfee = treatfee;
    }

    public Double getRegfee() {
        return regfee;
    }

    public void setRegfee(Double regfee) {
        this.regfee = regfee;
    }

    public String getPatientmedicalcardnumber() {
        return patientmedicalcardnumber;
    }

    public void setPatientmedicalcardnumber(String patientmedicalcardnumber) {
        this.patientmedicalcardnumber = patientmedicalcardnumber;
    }

    public String getPatientmedicalcardtype() {
        return patientmedicalcardtype;
    }

    public void setPatientmedicalcardtype(String patientmedicalcardtype) {
        this.patientmedicalcardtype = patientmedicalcardtype;
    }

    @Override
    public String toString() {
        return "GetRegistformVo{" +
                "patientage='" + patientage + '\'' +
                ", patientname='" + patientname + '\'' +
                ", deptid='" + deptid + '\'' +
                ", deptname='" + deptname + '\'' +
                ", docid='" + docid + '\'' +
                ", docname='" + docname + '\'' +
                ", scheduledate=" + scheduledate +
                ", begintime=" + begintime +
                ", endtime=" + endtime +
                ", committime=" + committime +
                ", hospitalcode='" + hospitalcode + '\'' +
                ", hospitalname='" + hospitalname + '\'' +
                ", doctorlevel='" + doctorlevel + '\'' +
                ", appointmenttype='" + appointmenttype + '\'' +
                ", serialnumber='" + serialnumber + '\'' +
                ", departmentlocation='" + departmentlocation + '\'' +
                ", treatfee=" + treatfee +
                ", regfee=" + regfee +
                ", patientmedicalcardnumber='" + patientmedicalcardnumber + '\'' +
                ", patientmedicalcardtype='" + patientmedicalcardtype + '\'' +
                '}';
    }
}
