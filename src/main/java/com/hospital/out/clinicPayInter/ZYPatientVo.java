package com.hospital.out.clinicPayInter;

/**
 * User: xiaofu
 * Date: 2017/11/9
 * Time: 16:37
 * Function:住院人员信息
 */
public class ZYPatientVo {
    private String medcardno; //诊疗卡号
    private String medcardtype;//诊疗卡类型
    private String idcardtype;//证件类型
    private String idcard;//证件号码
    private String patientcode;//患者编号
    private String patientname;//患者姓名
    private String patientsex;//患者性别
    private String address;//家庭住址
    private String begintime;//入院时间
    private String endtime;//出院时间
    private String inhospitalstatus;//住院状态
    private String inhospitalrecordnumber;//住院号
    private String wardname;//病区
    private String deptcode;//住院科室编号
    private String deptname;//住院科室名称
    private String totalamount;//费用金额
    private String arrearageamount;//欠费金额
    private String payamount;//总预缴金额

    private String bedid;//床位号
    private String settlementinstructions;   //结算说明
    private String amount;   //现金金额
    private String invoicenumber;     //发票号码
    private String insuranceparameters;     //医保参数
    private String insurancetype;        //医保类型
    private String insurancetypedes;    //医保类型说明

    public String getBedid() {
        return bedid;
    }

    public void setBedid(String bedid) {
        this.bedid = bedid;
    }

    public String getSettlementinstructions() {
        return settlementinstructions;
    }

    public void setSettlementinstructions(String settlementinstructions) {
        this.settlementinstructions = settlementinstructions;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(String invoicenumber) {
        this.invoicenumber = invoicenumber;
    }

    public String getInsuranceparameters() {
        return insuranceparameters;
    }

    public void setInsuranceparameters(String insuranceparameters) {
        this.insuranceparameters = insuranceparameters;
    }

    public String getInsurancetype() {
        return insurancetype;
    }

    public void setInsurancetype(String insurancetype) {
        this.insurancetype = insurancetype;
    }

    public String getInsurancetypedes() {
        return insurancetypedes;
    }

    public void setInsurancetypedes(String insurancetypedes) {
        this.insurancetypedes = insurancetypedes;
    }

    public String getMedcardno() {
        return medcardno;
    }

    public void setMedcardno(String medcardno) {
        this.medcardno = medcardno;
    }

    public String getMedcardtype() {
        return medcardtype;
    }

    public void setMedcardtype(String medcardtype) {
        this.medcardtype = medcardtype;
    }

    public String getIdcardtype() {
        return idcardtype;
    }

    public void setIdcardtype(String idcardtype) {
        this.idcardtype = idcardtype;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPatientcode() {
        return patientcode;
    }

    public void setPatientcode(String patientcode) {
        this.patientcode = patientcode;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getPatientsex() {
        return patientsex;
    }

    public void setPatientsex(String patientsex) {
        this.patientsex = patientsex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getInhospitalstatus() {
        return inhospitalstatus;
    }

    public void setInhospitalstatus(String inhospitalstatus) {
        this.inhospitalstatus = inhospitalstatus;
    }

    public String getInhospitalrecordnumber() {
        return inhospitalrecordnumber;
    }

    public void setInhospitalrecordnumber(String inhospitalrecordnumber) {
        this.inhospitalrecordnumber = inhospitalrecordnumber;
    }

    public String getWardname() {
        return wardname;
    }

    public void setWardname(String wardname) {
        this.wardname = wardname;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getArrearageamount() {
        return arrearageamount;
    }

    public void setArrearageamount(String arrearageamount) {
        this.arrearageamount = arrearageamount;
    }

    public String getPayamount() {
        return payamount;
    }

    public void setPayamount(String payamount) {
        this.payamount = payamount;
    }

    @Override
    public String toString() {
        return "ZYPatientVo{" +
                "medcardno='" + medcardno + '\'' +
                ", medcardtype='" + medcardtype + '\'' +
                ", idcardtype='" + idcardtype + '\'' +
                ", idcard='" + idcard + '\'' +
                ", patientcode='" + patientcode + '\'' +
                ", patientname='" + patientname + '\'' +
                ", patientsex='" + patientsex + '\'' +
                ", address='" + address + '\'' +
                ", begintime='" + begintime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", inhospitalstatus='" + inhospitalstatus + '\'' +
                ", inhospitalrecordnumber='" + inhospitalrecordnumber + '\'' +
                ", wardname='" + wardname + '\'' +
                ", deptcode='" + deptcode + '\'' +
                ", deptname='" + deptname + '\'' +
                ", totalamount='" + totalamount + '\'' +
                ", arrearageamount='" + arrearageamount + '\'' +
                ", payamount='" + payamount + '\'' +
                ", settlementinstructions='" + settlementinstructions + '\'' +
                ", amount='" + amount + '\'' +
                ", invoicenumber='" + invoicenumber + '\'' +
                ", insuranceparameters='" + insuranceparameters + '\'' +
                ", insurancetype='" + insurancetype + '\'' +
                ", insurancetypedes='" + insurancetypedes + '\'' +
                '}';
    }
}
