package com.hospital.out.InHosInter;

/**
 * 充值记录查询
 * Created by jinhs on 2017/8/1.
 */
public class RecordVo {

    private Double balance;     //账户余额
    private Double payedamount;   //缴费总额
    private String paymentrecord;      //付款明细

    public RecordVo() {
    }

    public RecordVo(Double balance, Double payedamount, String paymentrecord) {
        this.balance = balance;
        this.payedamount = payedamount;
        this.paymentrecord = paymentrecord;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getPayedamount() {
        return payedamount;
    }

    public void setPayedamount(Double payedamount) {
        this.payedamount = payedamount;
    }

    public String getPaymentrecord() {
        return paymentrecord;
    }

    public void setPaymentrecord(String paymentrecord) {
        this.paymentrecord = paymentrecord;
    }

    @Override
    public String toString() {
        return "RecordVo{" +
                "balance=" + balance +
                ", payedamount=" + payedamount +
                ", paymentrecord='" + paymentrecord + '\'' +
                '}';
    }
}
