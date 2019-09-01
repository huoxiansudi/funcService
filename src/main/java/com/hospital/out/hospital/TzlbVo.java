package com.hospital.out.hospital;

/**停诊列表查询
 * Created by fuxf on 2017/8/3.
 */
public class TzlbVo {

    private String schid;      //排班编号
    private String orgid;     //医院编号
    private String ampm;   //上下午标志
    private String reason;   //停诊原因
    private String begindate;
    private String enddate;

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public TzlbVo() {
    }

    public String getSchid() {
        return schid;
    }

    public void setSchid(String schid) {
        this.schid = schid;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "TzlbVo{" +
                "schid='" + schid + '\'' +
                ", orgid='" + orgid + '\'' +
                ", ampm='" + ampm + '\'' +
                ", reason='" + reason + '\'' +
                ", begindate='" + begindate + '\'' +
                ", enddate='" + enddate + '\'' +
                '}';
    }
}
