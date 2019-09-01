package com.hospital.out.hospital;

import java.util.List;

/**
 * User: xiaofu
 * Date: 2017/11/16
 * Time: 9:23
 * Function:
 */
public class PayDetaileList {
    private String payedamount;
    private List<PaymenTrecordVo> paymentrecord;

    public String getPayedamount() {
        return payedamount;
    }

    public void setPayedamount(String payedamount) {
        this.payedamount = payedamount;
    }

    public List<PaymenTrecordVo> getPaymentrecord() {
        return paymentrecord;
    }

    public void setPaymentrecord(List<PaymenTrecordVo> paymentrecord) {
        this.paymentrecord = paymentrecord;
    }

    @Override
    public String toString() {
        return "PayDetaileList{" +
                "payedamount='" + payedamount + '\'' +
                ", paymentrecord=" + paymentrecord +
                '}';
    }
}
