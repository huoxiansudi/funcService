package com.hospital.out.hospital;

/**医生列表查询
 * Created by fuxf on 2017/8/3.
 */
public class DoctorVo {

    private String orgid;      //医院编号
    private String deptid;     //科室编号
    private String hisdocid;   //签约医生编号
    private String docname;   //医生姓名
    private String docsex;    //医生性别
    private String title;     //医生职称
    private String docid;//医生编号
    private String description;     //医生介绍
    private String goodat;  //擅长
    private String state;  //医生状态
    private String picture;   //照片

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public DoctorVo() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getHisdocid() {
        return hisdocid;
    }

    public void setHisdocid(String hisdocid) {
        this.hisdocid = hisdocid;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDocsex() {
        return docsex;
    }

    public void setDocsex(String docsex) {
        this.docsex = docsex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoodat() {
        return goodat;
    }

    public void setGoodat(String goodat) {
        this.goodat = goodat;
    }

    @Override
    public String toString() {
        return "DoctorVo{" +
                "orgid='" + orgid + '\'' +
                ", deptid='" + deptid + '\'' +
                ", hisdocid='" + hisdocid + '\'' +
                ", docname='" + docname + '\'' +
                ", docsex='" + docsex + '\'' +
                ", title='" + title + '\'' +
                ", docid='" + docid + '\'' +
                ", description='" + description + '\'' +
                ", goodat='" + goodat + '\'' +
                ", state='" + state + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
