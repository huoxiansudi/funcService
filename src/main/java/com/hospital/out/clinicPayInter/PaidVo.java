package com.hospital.out.clinicPayInter;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by jinhs on 2018-03-19.
 */
public class PaidVo {

   // @JSONField(serialize=false)  //希望动态过滤掉的属性
    private String fygb;
    @JSONField(serialize=false)
    private String sfsb;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date costdate;     //费用日期
    private String projecttype;   //缴费项名称（草药方、西药方）
    //private String docname;     //医生姓名
    private String deptname;     //科室名称
    private Double totalcost;        //合计金额
    private String identificationnumber;    //识别序号
    private String groupnumber;    //组号
    private String medicalprescription;    //处方医技(1.处方2.医技3.挂号）
    private String medcardtype;    //诊疗卡类型
    private String medcardno;    //诊疗卡号
    private String patientname;    //病人姓名
    private String patientcode;    //病人编号
    //private String patientnature;    //人员性质
    //private String patientnaturedes;    //人员性质说明(自费、医保)


    public PaidVo() {
    }

    public String getSfsb() {
        return sfsb;
    }

    public void setSfsb(String sfsb) {
        this.sfsb = sfsb;
    }

    public String getFygb() {
        return fygb;
    }

    public void setFygb(String fygb) {
        this.fygb = fygb;
    }

    public Date getCostdate() {
        return costdate;
    }

    public void setCostdate(Date costdate) {
        this.costdate = costdate;
    }

    public String getProjecttype() {
        return projecttype;
    }

    public void setProjecttype(String projecttype) {
        this.projecttype = projecttype;
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

    public String getIdentificationnumber() {
        return identificationnumber;
    }

    public void setIdentificationnumber(String identificationnumber) {
        this.identificationnumber = identificationnumber;
    }

    public String getGroupnumber() {
        return groupnumber;
    }

    public void setGroupnumber(String groupnumber) {
        this.groupnumber = groupnumber;
    }

    public String getMedicalprescription() {
        return medicalprescription;
    }

    public void setMedicalprescription(String medicalprescription) {
        this.medicalprescription = medicalprescription;
    }

    public String getMedcardtype() {
        return medcardtype;
    }

    public void setMedcardtype(String medcardtype) {
        this.medcardtype = medcardtype;
    }

    public String getMedcardno() {
        return medcardno;
    }

    public void setMedcardno(String medcardno) {
        this.medcardno = medcardno;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getPatientcode() {
        return patientcode;
    }

    public void setPatientcode(String patientcode) {
        this.patientcode = patientcode;
    }
}
