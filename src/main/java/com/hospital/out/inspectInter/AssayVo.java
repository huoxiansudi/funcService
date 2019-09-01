package com.hospital.out.inspectInter;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 检查列表查询
 * Created by jinhs on 2017/8/1.
 */
public class AssayVo {

    private String assayno;     //检验单号
    private String assaycode;   //诊断代码
    private String assayname;   //诊断名称
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date assaydate;     //诊断时间
    private String medcardno;     //就诊卡号
    private String name;        //病人姓名
    private String sex;    //病人性别
    private String age;   //病人年齡
    private String deptname;   //科室名称

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date collectiondate;     //采集时间
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date checkdate;     //检验时间
    private String assayitemno;     //检验项目编号
    private String assayitemname;        //检验项目名称
    private String sjdocname;    //送检医生名称
    private String inspectdocname;   //检验医生名称
    private String checkdocname;   //审核医生名称

    public AssayVo() {
    }

    public Date getCollectiondate() {
        return collectiondate;
    }

    public void setCollectiondate(Date collectiondate) {
        this.collectiondate = collectiondate;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getAssayitemno() {
        return assayitemno;
    }

    public void setAssayitemno(String assayitemno) {
        this.assayitemno = assayitemno;
    }

    public String getAssayitemname() {
        return assayitemname;
    }

    public void setAssayitemname(String assayitemname) {
        this.assayitemname = assayitemname;
    }

    public String getSjdocname() {
        return sjdocname;
    }

    public void setSjdocname(String sjdocname) {
        this.sjdocname = sjdocname;
    }

    public String getInspectdocname() {
        return inspectdocname;
    }

    public void setInspectdocname(String inspectdocname) {
        this.inspectdocname = inspectdocname;
    }

    public String getCheckdocname() {
        return checkdocname;
    }

    public void setCheckdocname(String checkdocname) {
        this.checkdocname = checkdocname;
    }

    public String getAssayno() {
        return assayno;
    }

    public void setAssayno(String assayno) {
        this.assayno = assayno;
    }

    public String getAssaycode() {
        return assaycode;
    }

    public void setAssaycode(String assaycode) {
        this.assaycode = assaycode;
    }

    public String getAssayname() {
        return assayname;
    }

    public void setAssayname(String assayname) {
        this.assayname = assayname;
    }

    public Date getAssaydate() {
        return assaydate;
    }

    public void setAssaydate(Date assaydate) {
        this.assaydate = assaydate;
    }

    public String getMedcardno() {
        return medcardno;
    }

    public void setMedcardno(String medcardno) {
        this.medcardno = medcardno;
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

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "AssayVo{" +
                "assayno='" + assayno + '\'' +
                ", assaycode='" + assaycode + '\'' +
                ", assayname='" + assayname + '\'' +
                ", assaydate=" + assaydate +
                ", medcardno='" + medcardno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", deptname='" + deptname + '\'' +
                ", collectiondate=" + collectiondate +
                ", checkdate=" + checkdate +
                ", assayitemno='" + assayitemno + '\'' +
                ", assayitemname='" + assayitemname + '\'' +
                ", sjdocname='" + sjdocname + '\'' +
                ", inspectdocname='" + inspectdocname + '\'' +
                ", checkdocname='" + checkdocname + '\'' +
                '}';
    }
}
