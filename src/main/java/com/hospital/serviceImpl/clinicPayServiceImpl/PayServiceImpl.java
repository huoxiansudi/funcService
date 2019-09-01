package com.hospital.serviceImpl.clinicPayServiceImpl;

import com.hospital.common.DataTransfer;
import com.hospital.common.PayMode;
import com.hospital.dao.payInfo.PayInfoDao;
import com.hospital.domain.PaidDetailInVo;
import com.hospital.domain.PayConfirmInVo;
import com.hospital.domain.PayListInVo;
import com.hospital.domain.UnpaidInVo;
import com.hospital.out.clinicPayInter.*;
import com.hospital.service.clinicPayService.PayService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jinhs on 2017-10-15.
 */
@Service
public class PayServiceImpl implements PayService {

    @Value("${pay.czgh}")
    private String czgh;

    @Autowired
    private PayInfoDao payInfoDao;

    @Override
    public List<UnpaidVo> getUnpaidInfo(UnpaidInVo unpaidInVo) {

        return payInfoDao.getUnpaidInfo(unpaidInVo);
    }

    @Override
    public List<UnpaidVo> getTotalFee(String jzkh) {
        return payInfoDao.getTotalFee(jzkh);
    }

    @Override
    public List<UnpaidVo> getYjInfo(UnpaidInVo unpaidInVo) {
        return payInfoDao.getYjInfo(unpaidInVo);
    }

    @Override
    public List<UnpaidVo> getYjPsInfo(@Param("cfsb") String cfsb) {
        return payInfoDao.getYjPsInfo(cfsb);
    }

    @Override
    public List<UnpaidVo> getYjFee(String jzkh) {
        return payInfoDao.getYjFee(jzkh);
    }

    @Override
    public Integer updateMzcfk1(@Param("cfsb") String cfsb) {
        return payInfoDao.updateMzcfk1(cfsb);
    }

    @Override
    public Integer updateMzyjk1(@Param("yjsb") String yjsb) {
        return payInfoDao.updateMzyjk1(yjsb);
    }

    @Override
    public Integer updateSdMzcfk1(@Param("cfsb") String cfsb) {
        return payInfoDao.updateSdMzcfk1(cfsb);
    }

    @Override
    public Integer updateSdMzyjk1(@Param("yjsb") String yjsb) {
        return payInfoDao.updateSdMzyjk1(yjsb);
    }

    @Override
    public CostVo getPaidBasicInfo(PaidDetailInVo paidDetailInVo) {
        return payInfoDao.getPaidBasicInfo(paidDetailInVo);
    }

    @Override
    public CostVo getPaidBasicYjInfo(PaidDetailInVo paidDetailInVo) {
        return payInfoDao.getPaidBasicYjInfo(paidDetailInVo);
    }

    @Override
    public List<PaidDetailVo> getPaidDetailInfo(PaidDetailInVo paidDetailInVo) {

        return payInfoDao.getPaidDetailInfo(paidDetailInVo);
    }

    @Override
    public List<PaidDetailVo> getPaidDetailYjInfo(PaidDetailInVo paidDetailInVo) {
        return payInfoDao.getPaidDetailYjInfo(paidDetailInVo);
    }

    @Override
    public Integer getCfs(String cfs) {
        return payInfoDao.getCfs(cfs);
    }

    @Override
    public Integer getYjs(String yjs) {
        return payInfoDao.getYjs(yjs);
    }

    @Override
    public Integer getModifyCf(String cfsb) {
        return payInfoDao.getModifyCf(cfsb);
    }

    @Override
    public Integer getPs(String cfsb) {
        return payInfoDao.getPs(cfsb);
    }

    @Override
    public Integer getModifyYj(String yjsb) {
        return payInfoDao.getModifyYj(yjsb);
    }

    @Override
    public Double preSettleInfo(String sbxh) {

        return payInfoDao.preSettleInfo(sbxh);
    }

    @Override
    public Double preSettleYjInfo(String sbxh) {
        return payInfoDao.preSettleYjInfo(sbxh);
    }

    @Override
    public String getFphm() {
        return payInfoDao.getFphm();
    }

    @Override
    public String payConfirm(PayConfirmInVo payConfirmInVo) {

        //初始化变量
        String jzkh = "";
        int sfsb = 0;
        String dqhm = "";
        String sbxhs = payConfirmInVo.getIdentificationNumbers();
        String[] sbxhList = sbxhs.split("\\|");
        int length = sbxhList.length;
        if (length % 3 == 0) {
            jzkh = sbxhList[2];//获取jzkh
            if (StringUtils.hasText(jzkh)) {
                String brxm = payInfoDao.getJzxx(jzkh);//获取jzxx
                if (!StringUtils.hasText(brxm)) {
                    return "该卡号的病人信息不存在!!!";
                }
                // String invoicenumber = payService.getFphm();
               /* String dqhm = payInfoDao.getDqhm(czgh);
                if(!dqhm.equals(payConfirmInVo.getInvoicenumber())){
                    return "发票号码不一致,收费有问题!!!";
                }*/
                int cfs = payInfoDao.getCfs(jzkh);
                int yjs = payInfoDao.getYjs(jzkh);
                if ((cfs + yjs) != (length / 3)) {
                    return "识别序号不全,请核实";
                }

                Double cffy = payInfoDao.getCfTotalfee(jzkh);//处方的总费用
                Double yjfy = payInfoDao.getYjTotalfee(jzkh);//医技的总费用

                BigDecimal a2 = new BigDecimal(String.valueOf(cffy));
                BigDecimal b2 = new BigDecimal(String.valueOf(yjfy));
                BigDecimal c2 = a2.add(b2);
                Double sxj = c2.doubleValue();

                String data = DataTransfer.getData(sxj);
                //此处还需做判断????收费是否一致,不一致做处理
                if (!data.equals(payConfirmInVo.getPayamount())) {
                    return "所收金额不一致,请核实!!!";
                }

                payInfoDao.updateXhb();//更新gy_xhb
                sfsb = payInfoDao.selectXhb();//获取sfsb
                payInfoDao.updateFphm(czgh);//更新mz_pjgl发票号码
                dqhm = payInfoDao.getDqhm(czgh);
                payConfirmInVo.setSfsb(sfsb);
                payConfirmInVo.setFphm(dqhm);
                payConfirmInVo.setJzkh(jzkh);
                payConfirmInVo.setBrxm(brxm);
                payConfirmInVo.setSxj(sxj);
                payConfirmInVo.setCzgh(czgh);
                payConfirmInVo.setPaymode(PayMode.getCodeInt(payConfirmInVo.getPaymode()));
                int temp = payInfoDao.insertMzsfk1(payConfirmInVo); //添加mz_sfk1
                if (temp < 1) {
                    return "门诊收费失败!!!";
                }

            }
            for (int i = 0; i < sbxhList.length; i = i + 3) {
                String sbxh = sbxhList[i];//获取cfsb
                String lx = sbxhList[i + 1];//获取fygb
                //通过lx查询相关信息
                if (lx.equals("1")) {
                    List<MzsfVo> mzsfVoList = payInfoDao.getCfsf(sbxh);//获取处方费用
                    if (mzsfVoList != null && mzsfVoList.size() > 0) {
                        for (MzsfVo mzsfVo : mzsfVoList) {

                            mzsfVo.setSfsb(sfsb);

                            //判断mz_sfk2是否已经存在(这条数据)
                            MzsfVo sfxxVo = payInfoDao.selectMzSfk(mzsfVo);
                            int temp1 = 0;
                            if (sfxxVo == null || sfxxVo.getSfsb() == 0) { //如果不存在 添加数据
                                temp1 = payInfoDao.insertMzsfk2(mzsfVo);//添加到mz_sfk2
                            } else {
                                Double sfxx = Double.parseDouble(DataTransfer.getData(sfxxVo.getZfje()));
                                Double mzsf = Double.parseDouble(DataTransfer.getData(mzsfVo.getZfje()));
                                Double zje = sfxx + mzsf;
                                mzsfVo.setZfje(zje);
                                temp1 = payInfoDao.updateMzsfk2(mzsfVo);//更新到mz_sfk2
                            }

                            int fybh = payInfoDao.selectFybh(sbxh);//查询fybh 更新jzyf
                            int jzyf = 0;
                            if (fybh == 3) {
                                jzyf = 3;
                            } else if (fybh == 4) {
                                jzyf = 4;
                            }
                            int temp2 = payInfoDao.updateCfk1(sbxh, sfsb, jzyf);//更新mz_cfk1
                            if (temp1 + temp2 < 2) {
                                return "处方收费有问题!!!";
                            }
                        }
                        payInfoDao.updateCfk2(sbxh);//更新mz_cfk2
                    } else {
                        return "没有处方收费信息!!!";
                    }

                    //若医生要取回，先让处方解锁
                    int tt = payInfoDao.updateMzcfk1(sbxh);

                } else if (lx.equals("2")) {
                    List<MzsfVo> yjsfVoList = payInfoDao.getYjsf(sbxh); //获取医技费用
                    if (yjsfVoList != null && yjsfVoList.size() > 0) {
                        for (MzsfVo yjsfVo : yjsfVoList) {
                            yjsfVo.setSfsb(sfsb);
                            //判断mz_sfk2是否已经存在(这条数据)
                            MzsfVo sfxxVo = payInfoDao.selectMzSfk(yjsfVo);
                            int temp1 = 0;
                            if (sfxxVo == null || sfxxVo.getSfsb() == 0) { //如果不存在 添加数据
                                temp1 = payInfoDao.insertMzsfk2(yjsfVo);//添加到mz_sfk2
                            } else {
                                Double zje = sfxxVo.getZfje() + yjsfVo.getZfje();
                                yjsfVo.setZfje(zje);
                                temp1 = payInfoDao.updateMzsfk2(yjsfVo);//更新到mz_sfk2
                            }

                            int temp2 = payInfoDao.updateYjk1(sbxh, sfsb);//更新yj_yjk1
                            if (temp1 + temp2 < 2) {
                                return "医技收费有问题!!!";
                            }
                            int temp4 = payInfoDao.updateYjsqd(sbxh, sfsb);//若有申请单则更新
                        }
                        payInfoDao.updateYjk2(sbxh);//更新yj_yjk2
                    } else {
                        return "没有医技收费信息!!!";
                    }
                    //若医生要取回，先让医技解锁
                    int tt = payInfoDao.updateMzyjk1(sbxh);
                }
            }
        } else {
            return "识别序号格式不正确!!!";
        }
        return dqhm;
    }

    @Override
    public List<PayListVo> getPayInfo(PayListInVo payListInVo) {
        List<PayListVo> listVos = payInfoDao.getPayInfo(payListInVo);
        if (!listVos.isEmpty()) {
            for (PayListVo payListVo : listVos) {
                payListVo.setCashierclerk(PayMode.getCodeIntName(payListVo.getCashierclerk()));
                if (payListVo.getTotalcost() != null && payListVo.getTotalcost() < 0) {
                    payListVo.setCostname("门诊已退费");
                    payListVo.setTotalcost(Math.abs(payListVo.getTotalcost()));
                }
            }
        }
        return listVos;
    }

    @Override
    public List<PaidVo> getPaidInfo(String invoicenumber, String patientcode) {
        return payInfoDao.getPaidInfo(invoicenumber, patientcode);
    }

    @Override
    public List<PaidVo> getPaidTotalFee(String sbxh, String jzkh) {
        return payInfoDao.getPaidTotalFee(sbxh, jzkh);
    }

    @Override
    public List<PaidVo> getYjPaidInfo(String invoicenumber, String patientcode) {
        return payInfoDao.getYjPaidInfo(invoicenumber, patientcode);
    }

    @Override
    public List<PaidVo> getPaidYjFee(String sbxh, String jzkh) {
        return payInfoDao.getPaidYjFee(sbxh, jzkh);
    }

    @Override
    public CostVo getPaidBasicInfo2(PaidDetailInVo paidDetailInVo) {
        return payInfoDao.getPaidBasicInfo2(paidDetailInVo);
    }

    @Override
    public CostVo getPaidBasicYjInfo2(PaidDetailInVo paidDetailInVo) {
        return payInfoDao.getPaidBasicYjInfo2(paidDetailInVo);
    }

    @Override
    public List<PaidDetailVo> getPaidDetailInfo2(PaidDetailInVo paidDetailInVo) {
        return payInfoDao.getPaidDetailInfo2(paidDetailInVo);
    }

    @Override
    public List<PaidDetailVo> getPaidDetailYjInfo2(PaidDetailInVo paidDetailInVo) {
        return payInfoDao.getPaidDetailYjInfo2(paidDetailInVo);
    }
}
