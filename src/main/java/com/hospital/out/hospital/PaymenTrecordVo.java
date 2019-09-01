package com.hospital.out.hospital;

/**
 * User: xiaofu
 * Date: 2017/11/14
 * Time: 16:57
 * Function:
 */
public class PaymenTrecordVo {

    private String payAmount;//payAmount
    private String payMode;//付款方式（1-支付宝/2-微信/3-银联）
    private String payedTime;//付款时间
    private String inHospitalRecordNumber;//住院号

    public String getInHospitalRecordNumber() {
        return inHospitalRecordNumber;
    }

    public void setInHospitalRecordNumber(String inHospitalRecordNumber) {
        this.inHospitalRecordNumber = inHospitalRecordNumber;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getPayedTime() {
        return payedTime;
    }

    public void setPayedTime(String payedTime) {
        this.payedTime = payedTime;
    }

    @Override
    public String toString() {
        return "PaymenTrecordVo{" +
                "payAmount='" + payAmount + '\'' +
                ", payMode='" + payMode + '\'' +
                ", payedTime='" + payedTime + '\'' +
                ", inHospitalRecordNumber='" + inHospitalRecordNumber + '\'' +
                '}';
    }
}
