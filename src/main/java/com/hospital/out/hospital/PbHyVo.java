package com.hospital.out.hospital;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**排班号源列表查询
 * Created by fuxf on 2017/8/3.
 */
public class PbHyVo {

    private String numid;      //号源编号
    private String numno;     //号源序号
    @JSONField(format = "yyyyMMdd")
    private Date numdate;   //号源日期
    private String numtime;   //号源时间
    private String numstate;    //号源状态

    @JSONField(serialize = false)
    private String appdate;//

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    public PbHyVo() {
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

    public Date getNumdate() {
        return numdate;
    }

    public void setNumdate(Date numdate) {
        this.numdate = numdate;
    }

    public String getNumtime() {
        return numtime;
    }

    public void setNumtime(String numtime) {
        this.numtime = numtime;
    }

    public String getNumstate() {
        return numstate;
    }

    public void setNumstate(String numstate) {
        this.numstate = numstate;
    }

    @Override
    public String toString() {
        return "PbHyVo{" +
                "numid='" + numid + '\'' +
                ", numno='" + numno + '\'' +
                ", numdate=" + numdate +
                ", numtime='" + numtime + '\'' +
                ", numstate='" + numstate + '\'' +
                ", appdate='" + appdate + '\'' +
                '}';
    }
}
