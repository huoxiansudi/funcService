package com.hospital.out.hospital;

/**
 * User: xiaofu
 * Date: 2017/11/30
 * Time: 10:59
 * Function:预约列表
 */
public class SubscribeListVo {
    private String deptid; //科室编号
    private String deptname;//科室名称
    private String docid;//医生编号
    private String docname;//医生姓名
    private String patid;//患者编号
    private String patname;//患者姓名
    private String orderid;//订单编号
    private String orderState;//订单状态
    private String schid;//排班编号
    private String numid;//号源编号
    private String numno;//号源序号
    private String numdate;//号源日期
    private String numtime;//号源时间
    private String ampm;//上下午标志
    private String visittime;//就诊日期
    private String regfee;//挂号费
    private String treatfee;//诊疗费
    private String paystate;//支付方式
    private String mobileno;//手机号码
    private String idcard;//身份证
    private String qhmm;//取号密码
    private String djrq;
    private String hospitalname;

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getDjrq() {
        return djrq;
    }

    public void setDjrq(String djrq) {
        this.djrq = djrq;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getQhmm() {
        return qhmm;
    }

    public void setQhmm(String qhmm) {
        this.qhmm = qhmm;
    }

    public String getPaystate() {
        return paystate;
    }

    public void setPaystate(String paystate) {
        this.paystate = paystate;
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

    public String getPatid() {
        return patid;
    }

    public void setPatid(String patid) {
        this.patid = patid;
    }

    public String getPatname() {
        return patname;
    }

    public void setPatname(String patname) {
        this.patname = patname;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getSchid() {
        return schid;
    }

    public void setSchid(String schid) {
        this.schid = schid;
    }

    public String getNumid() {
        return numid;
    }

    public void setNumid(String numid) {
        this.numid = numid;
    }

    public String getNumno() {
        return numno;
    }

    public void setNumno(String numno) {
        this.numno = numno;
    }

    public String getNumdate() {
        return numdate;
    }

    public void setNumdate(String numdate) {
        this.numdate = numdate;
    }

    public String getNumtime() {
        return numtime;
    }

    public void setNumtime(String numtime) {
        this.numtime = numtime;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public String getVisittime() {
        return visittime;
    }

    public void setVisittime(String visittime) {
        this.visittime = visittime;
    }

    public String getRegfee() {
        return regfee;
    }

    public void setRegfee(String regfee) {
        this.regfee = regfee;
    }

    public String getTreatfee() {
        return treatfee;
    }

    public void setTreatfee(String treatfee) {
        this.treatfee = treatfee;
    }
}
