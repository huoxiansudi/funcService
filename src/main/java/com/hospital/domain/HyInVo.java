package com.hospital.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jinhs on 2017-09-27.
 */
@XmlRootElement
public class HyInVo {
    private String numdate ; //号源日期
    private String numid;     //号源编号
    private String schid;      //排班编号
    private String ampm;       //上下午标志
    private String numno;//号源序号

    public HyInVo() {
    }

    public String getNumdate() {
        return numdate;
    }

    public void setNumdate(String numdate) {
        this.numdate = numdate;
    }

    public String getNumid() {
        return numid;
    }

    public void setNumid(String numid) {
        this.numid = numid;
    }

    public String getSchid() {
        return schid;
    }

    public void setSchid(String schid) {
        this.schid = schid;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public String getNumno() {
        return numno;
    }

    public void setNumno(String numno) {
        this.numno = numno;
    }

    @Override
    public String toString() {
        return "HyInVo{" +
                "numdate='" + numdate + '\'' +
                ", numid='" + numid + '\'' +
                ", schid='" + schid + '\'' +
                ", ampm='" + ampm + '\'' +
                ", numno='" + numno + '\'' +
                '}';
    }
}
