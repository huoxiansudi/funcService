package com.hospital.out.inspectInter;

/**
 * 检验详情查询
 * Created by jinhs on 2017/8/1.
 */
public class AssDetailVo {

    private String assayno;     //检验单号
    private String assayitemcode;   //检验项目代码
    private String assayitemname;   //检验项目名称
    private String unit;     //结果单位
    private String result;     //检验结果
    private String refrange;        //参考范围
    private String resultstate;    //结果状态

    public AssDetailVo() {
    }

    public AssDetailVo(String assayno, String assayitemcode, String assayitemname, String unit, String result, String refrange, String resultstate) {
        this.assayno = assayno;
        this.assayitemcode = assayitemcode;
        this.assayitemname = assayitemname;
        this.unit = unit;
        this.result = result;
        this.refrange = refrange;
        this.resultstate = resultstate;
    }

    public String getAssayno() {
        return assayno;
    }

    public void setAssayno(String assayno) {
        this.assayno = assayno;
    }

    public String getAssayitemcode() {
        return assayitemcode;
    }

    public void setAssayitemcode(String assayitemcode) {
        this.assayitemcode = assayitemcode;
    }

    public String getAssayitemname() {
        return assayitemname;
    }

    public void setAssayitemname(String assayitemname) {
        this.assayitemname = assayitemname;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRefrange() {
        return refrange;
    }

    public void setRefrange(String refrange) {
        this.refrange = refrange;
    }

    public String getResultstate() {
        return resultstate;
    }

    public void setResultstate(String resultstate) {
        this.resultstate = resultstate;
    }

    @Override
    public String toString() {
        return "AssDetailVo{" +
                "assayno='" + assayno + '\'' +
                ", assayitemcode='" + assayitemcode + '\'' +
                ", assayitemname='" + assayitemname + '\'' +
                ", unit='" + unit + '\'' +
                ", result='" + result + '\'' +
                ", refrange='" + refrange + '\'' +
                ", resultstate='" + resultstate + '\'' +
                '}';
    }
}
