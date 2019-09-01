package com.hospital.out.inspectInter;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 检查列表查询
 * Created by jinhs on 2017/8/1.
 */
public class InspectVo {

    private String inspectno;     //检查单号
    private String inspecttate;   //检查状态
    private String inspectdes;   //检查描述
    private String inspectresult;   //检查结果
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date inspectdate;     //检查时间
    private String name;        //病人姓名
    private String sex;    //病人性别
    private String age;   //病人年齡
    private String medcardno;   //就诊卡号
    private String sjdeptid;        //送检科室编号
    private String sjdeptname;    //送检科室名称
    private String sjdocid;   //送检医生编号
    private String sjdocname;   //送检医生名称
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date sjdate;     //送检时间
    private String checkdocid;   //审核医生编号
    private String checkdocname;   //审核医生名称
    private String inspectitemno; //检查项目编号
    private String inspectitemname; //检查项目名称
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date checkdate;     //审核时间

    public InspectVo() {
    }

    public String getInspectitemno() {
        return inspectitemno;
    }

    public void setInspectitemno(String inspectitemno) {
        this.inspectitemno = inspectitemno;
    }

    public String getInspectitemname() {
        return inspectitemname;
    }

    public void setInspectitemname(String inspectitemname) {
        this.inspectitemname = inspectitemname;
    }

    public InspectVo(String inspectno, String inspecttate, String inspectdes, String inspectresult, Date inspectdate, String name, String sex, String age, String medcardno, String sjdeptid, String sjdeptname, String sjdocid, String sjdocname, Date sjdate, String checkdocid, String checkdocname, Date checkdate) {
        this.inspectno = inspectno;
        this.inspecttate = inspecttate;
        this.inspectdes = inspectdes;
        this.inspectresult = inspectresult;
        this.inspectdate = inspectdate;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.medcardno = medcardno;
        this.sjdeptid = sjdeptid;
        this.sjdeptname = sjdeptname;
        this.sjdocid = sjdocid;
        this.sjdocname = sjdocname;
        this.sjdate = sjdate;
        this.checkdocid = checkdocid;
        this.checkdocname = checkdocname;
        this.checkdate = checkdate;
    }

    public String getInspectno() {
        return inspectno;
    }

    public void setInspectno(String inspectno) {
        this.inspectno = inspectno;
    }

    public String getInspecttate() {
        return inspecttate;
    }

    public void setInspecttate(String inspecttate) {
        this.inspecttate = inspecttate;
    }

    public String getInspectdes() {
        return inspectdes;
    }

    public void setInspectdes(String inspectdes) {
        this.inspectdes = inspectdes;
    }

    public String getInspectresult() {
        return inspectresult;
    }

    public void setInspectresult(String inspectresult) {
        this.inspectresult = inspectresult;
    }

    public Date getInspectdate() {
        return inspectdate;
    }

    public void setInspectdate(Date inspectdate) {
        this.inspectdate = inspectdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMedcardno() {
        return medcardno;
    }

    public void setMedcardno(String medcardno) {
        this.medcardno = medcardno;
    }

    public String getSjdeptid() {
        return sjdeptid;
    }

    public void setSjdeptid(String sjdeptid) {
        this.sjdeptid = sjdeptid;
    }

    public String getSjdeptname() {
        return sjdeptname;
    }

    public void setSjdeptname(String sjdeptname) {
        this.sjdeptname = sjdeptname;
    }

    public String getSjdocid() {
        return sjdocid;
    }

    public void setSjdocid(String sjdocid) {
        this.sjdocid = sjdocid;
    }

    public String getSjdocname() {
        return sjdocname;
    }

    public void setSjdocname(String sjdocname) {
        this.sjdocname = sjdocname;
    }

    public Date getSjdate() {
        return sjdate;
    }

    public void setSjdate(Date sjdate) {
        this.sjdate = sjdate;
    }

    public String getCheckdocid() {
        return checkdocid;
    }

    public void setCheckdocid(String checkdocid) {
        this.checkdocid = checkdocid;
    }

    public String getCheckdocname() {
        return checkdocname;
    }

    public void setCheckdocname(String checkdocname) {
        this.checkdocname = checkdocname;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    @Override
    public String toString() {
        return "InspectVo{" +
                "inspectno='" + inspectno + '\'' +
                ", inspecttate='" + inspecttate + '\'' +
                ", inspectdes='" + inspectdes + '\'' +
                ", inspectresult='" + inspectresult + '\'' +
                ", inspectdate=" + inspectdate +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", medcardno='" + medcardno + '\'' +
                ", sjdeptid='" + sjdeptid + '\'' +
                ", sjdeptname='" + sjdeptname + '\'' +
                ", sjdocid='" + sjdocid + '\'' +
                ", sjdocname='" + sjdocname + '\'' +
                ", sjdate=" + sjdate +
                ", checkdocid='" + checkdocid + '\'' +
                ", checkdocname='" + checkdocname + '\'' +
                ", inspectitemno='" + inspectitemno + '\'' +
                ", inspectitemname='" + inspectitemname + '\'' +
                ", checkdate=" + checkdate +
                '}';
    }
}
