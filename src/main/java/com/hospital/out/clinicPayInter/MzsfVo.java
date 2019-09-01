package com.hospital.out.clinicPayInter;

/**
 * Created by jinhs on 2017-11-14.
 */
public class MzsfVo {

    private int sfsb; //收费识别
    private int sfxm; //收费项目
    private double zfje; //资费金额
    private double fyhj; //费用合计

    public MzsfVo() {
    }

    public int getSfsb() {
        return sfsb;
    }

    public void setSfsb(int sfsb) {
        this.sfsb = sfsb;
    }

    public int getSfxm() {
        return sfxm;
    }

    public void setSfxm(int sfxm) {
        this.sfxm = sfxm;
    }

    public double getZfje() {
        return zfje;
    }

    public void setZfje(double zfje) {
        this.zfje = zfje;
    }

    public double getFyhj() {
        return fyhj;
    }

    public void setFyhj(double fyhj) {
        this.fyhj = fyhj;
    }

    @Override
    public String toString() {
        return "MzsfVo{" +
                "sfsb=" + sfsb +
                ", sfxm=" + sfxm +
                ", zfje=" + zfje +
                ", fyhj=" + fyhj +
                '}';
    }
}
