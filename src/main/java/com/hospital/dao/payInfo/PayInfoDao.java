package com.hospital.dao.payInfo;

import com.hospital.domain.PaidDetailInVo;
import com.hospital.domain.PayConfirmInVo;
import com.hospital.domain.PayListInVo;
import com.hospital.domain.UnpaidInVo;
import com.hospital.out.clinicPayInter.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jinhs on 2017-10-15.
 */
@Mapper
public interface PayInfoDao {

    //3.5.1.1 待支付列表
    List<UnpaidVo> getUnpaidInfo(@Param("unpaidInVo") UnpaidInVo unpaidInVo);
    List<UnpaidVo> getTotalFee(@Param("jzkh")String jzkh);
    List<UnpaidVo> getYjInfo(@Param("unpaidInVo") UnpaidInVo unpaidInVo);
    List<UnpaidVo> getYjPsInfo(@Param("cfsb") String cfsb);
    List<UnpaidVo> getYjFee(@Param("jzkh")String jzkh);
    Integer updateMzcfk1(@Param("cfsb")String cfsb);
    Integer updateMzyjk1(@Param("yjsb")String yjsb);
    Integer updateSdMzcfk1(@Param("cfsb")String cfsb);
    Integer updateSdMzyjk1(@Param("yjsb")String yjsb);


    //3.5.1.2 支付详情
    CostVo getPaidBasicInfo(@Param("paidDetailInVo") PaidDetailInVo paidDetailInVo);
    CostVo getPaidBasicYjInfo(@Param("paidDetailInVo") PaidDetailInVo paidDetailInVo);

    List<PaidDetailVo> getPaidDetailInfo(@Param("paidDetailInVo") PaidDetailInVo paidDetailInVo);
    List<PaidDetailVo> getPaidDetailYjInfo(@Param("paidDetailInVo") PaidDetailInVo paidDetailInVo);

    //3.5.1.3 诊间支付预结算
    Double preSettleInfo(@Param("sbxh")String sbxh);
    Double preSettleYjInfo(@Param("sbxh")String sbxh);
    String getFphm();

    //3.5.1.4 支付确认
    String getJzxx(@Param("jzkh")String jzkh);

    Integer updateXhb();

    Integer selectXhb();
    String getDqhm(@Param("czgh") String czgh);

    Integer getCfs(@Param("jzkh") String jzkh);
    Integer getYjs(@Param("jzkh") String jzkh);
    Integer getModifyCf(@Param("cfsb") String cfsb);
    Integer getPs(@Param("cfsb") String cfsb);
    Integer getModifyYj(@Param("yjsb") String yjsb);

    Double getCfTotalfee(@Param("jzkh")String jzkh);
    Double getYjTotalfee(@Param("jzkh")String jzkh);

    Integer insertMzsfk1(@Param("payConfirmInVo") PayConfirmInVo payConfirmInVo);

    List<MzsfVo> getCfsf(@Param("sbxh")String sbxh);
    List<MzsfVo> getYjsf(@Param("sbxh")String sbxh);
    MzsfVo selectMzSfk(@Param("mzsfVo")MzsfVo mzsfVo);

    Integer insertMzsfk2(@Param("mzsfVo") MzsfVo mzsfVo);
    Integer updateMzsfk2(@Param("mzsfVo") MzsfVo mzsfVo);
    Integer selectFybh(@Param("sbxh")String sbxh);
    Integer updateCfk1(@Param("sbxh")String sbxh,@Param("sfsb")int sfsb,@Param("jzyf")int jzyf);
    Integer updateCfk2(@Param("sbxh")String sbxh);
    Integer updateYjk1(@Param("sbxh")String sbxh,@Param("sfsb")int sfsb);
    Integer updateYjk2(@Param("sbxh")String sbxh);
    Integer updateYjsqd(@Param("sbxh")String sbxh,@Param("sfsb")int sfsb);

    Integer updateFphm(@Param("czgh") String czgh);

    //3.5.1.5 已支付列表
    List<PayListVo> getPayInfo(@Param("payListInVo")PayListInVo payListInVo);

    //3.6.1.6.已支付费用列表
    List<PaidVo> getPaidInfo(@Param("invoicenumber") String invoicenumber, @Param("patientcode")String patientcode);
    List<PaidVo> getPaidTotalFee(@Param("sbxh")String sbxh,@Param("jzkh")String jzkh);
    List<PaidVo> getYjPaidInfo(@Param("invoicenumber") String invoicenumber, @Param("patientcode")String patientcode);
    List<PaidVo> getPaidYjFee(@Param("sbxh")String sbxh,@Param("jzkh")String jzkh);

    //3.5.1.2 已支付详情
    CostVo getPaidBasicInfo2(@Param("paidDetailInVo") PaidDetailInVo paidDetailInVo);
    CostVo getPaidBasicYjInfo2(@Param("paidDetailInVo") PaidDetailInVo paidDetailInVo);

    List<PaidDetailVo> getPaidDetailInfo2(@Param("paidDetailInVo") PaidDetailInVo paidDetailInVo);
    List<PaidDetailVo> getPaidDetailYjInfo2(@Param("paidDetailInVo") PaidDetailInVo paidDetailInVo);
}
