package com.hospital.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 科室或专家叫号 输入 信息
 * Created by jinhs on 2017/8/1.
 */
public class DeptInVo {

    private String idcard;      //身份证号
    private String deptid;     //就诊科室编号
    private String docid;      //就诊医生编号
    private String ysgh;       //医生工号
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date jzsj;     //就诊日期
    private String sjlb;

    public DeptInVo() {
    }

    public String getYsgh() {
        return ysgh;
    }

    public void setYsgh(String ysgh) {
        this.ysgh = ysgh;
    }

    public String getSjlb() {
        return sjlb;
    }

    public void setSjlb(String sjlb) {
        this.sjlb = sjlb;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public Date getJzsj() {
        return jzsj;
    }

    public void setJzsj(Date jzsj) {
        this.jzsj = jzsj;
    }

    @Override
    public String toString() {
        return "DeptInVo{" +
                "idcard='" + idcard + '\'' +
                ", deptid='" + deptid + '\'' +
                ", docid='" + docid + '\'' +
                ", ysgh='" + ysgh + '\'' +
                ", jzsj=" + jzsj +
                ", sjlb='" + sjlb + '\'' +
                '}';
    }
}
