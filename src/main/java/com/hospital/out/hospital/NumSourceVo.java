package com.hospital.out.hospital;

/**
 * User: xiaofu
 * Date: 2017/10/30
 * Time: 15:46
 * Function:
 */
public class NumSourceVo {
    private String yybz;
    private String count;

    public String getYybz() {
        return yybz;
    }

    public void setYybz(String yybz) {
        this.yybz = yybz;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "NumSourceVo{" +
                "yybz='" + yybz + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
