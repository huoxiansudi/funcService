package com.hospital.out.hospital;

/**
 * User: xiaofu
 * Date: 2017/10/28
 * Time: 9:38
 * Function:
 */
public class NumOrigin {
    private String deptCode;
    private String docterCode;
    private String mzlbxh;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDocterCode() {
        return docterCode;
    }

    public void setDocterCode(String docterCode) {
        this.docterCode = docterCode;
    }

    public String getMzlbxh() {
        return mzlbxh;
    }

    public void setMzlbxh(String mzlbxh) {
        this.mzlbxh = mzlbxh;
    }

    @Override
    public String toString() {
        return "NumOrigin{" +
                "deptCode='" + deptCode + '\'' +
                ", docterCode='" + docterCode + '\'' +
                ", mzlbxh='" + mzlbxh + '\'' +
                '}';
    }
}
