package com.hospital.out.hospital;

/**患者注册查询
 * Created by fuxf on 2017/8/3.
 */
public class ZcVo {

    private String patientid;      //医院用户编号

    public ZcVo() {
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    @Override
    public String toString() {
        return "ZcVo{" +
                "patientid='" + patientid + '\'' +
                '}';
    }
}
