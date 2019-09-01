package com.hospital.service.clinicPayService;

import com.hospital.domain.PaidDetailInVo;
import com.hospital.domain.PayConfirmInVo;
import com.hospital.domain.PayListInVo;
import com.hospital.domain.UnpaidInVo;
import com.hospital.out.clinicPayInter.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jinhs on 2017-10-15.
 */
public interface PayService {

    //3.5.1.1 待支付列表
    List<UnpaidVo> getUnpaidInfo(UnpaidInVo unpaidInVo);
    List<UnpaidVo> getTotalFee(String jzkh);
    List<UnpaidVo> getYjInfo(UnpaidInVo unpaidInVo);
    List<UnpaidVo> getYjPsInfo(@Param("cfsb")String cfsb);
    List<UnpaidVo> getYjFee(String jzkh);
    Integer updateMzcfk1(@Param("cfsb")String cfsb);
    Integer updateMzyjk1(@Param("yjsb")String yjsb);
    Integer updateSdMzcfk1(@Param("cfsb")String cfsb);
    Integer updateSdMzyjk1(@Param("yjsb")String yjsb);

    //3.5.1.2 支付详情
    CostVo getPaidBasicInfo(PaidDetailInVo paidDetailInVo);
    CostVo getPaidBasicYjInfo(PaidDetailInVo paidDetailInVo);

    List<PaidDetailVo> getPaidDetailInfo(PaidDetailInVo paidDetailInVo);
    List<PaidDetailVo> getPaidDetailYjInfo(PaidDetailInVo paidDetailInVo);

    //3.5.1.3 诊间支付预结算
    Integer getCfs(String cfs);
    Integer getYjs(String yjs);
    Integer getModifyCf(String cfsb);
    Integer getPs(String cfsb);
    Integer getModifyYj(String yjsb);
    Double preSettleInfo(String sbxh);
    Double preSettleYjInfo(String sbxh);
    String getFphm();

    //3.5.1.4 支付确认
    @Transactional
    String payConfirm(PayConfirmInVo payConfirmInVo);

    //3.5.1.5 已支付列表
    List<PayListVo> getPayInfo(PayListInVo payListInVo);

    //3.5.1.6 已支付费用列表
    List<PaidVo> getPaidInfo(String invoicenumber, String patientcode);
    List<PaidVo> getPaidTotalFee(String sbxh,String jzkh);
    List<PaidVo> getYjPaidInfo(String invoicenumber, String patientcode);
    List<PaidVo> getPaidYjFee(String invoicenumber, String patientcode);

    //3.5.1.2 已支付详情
    CostVo getPaidBasicInfo2(PaidDetailInVo paidDetailInVo);
    CostVo getPaidBasicYjInfo2(PaidDetailInVo paidDetailInVo);

    List<PaidDetailVo> getPaidDetailInfo2(PaidDetailInVo paidDetailInVo);
    List<PaidDetailVo> getPaidDetailYjInfo2(PaidDetailInVo paidDetailInVo);

}
