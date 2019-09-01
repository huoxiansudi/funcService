package com.hospital.service.commonService;

import com.hospital.domain.WeekEndVo;
import com.hospital.domain.YyghInVo;
import com.hospital.out.hospital.PbHyVo;

import java.util.List;

/**
 * Created by jinhs on 2017-11-30.
 */
public interface NumidService {

    //100208预约挂号
    PbHyVo getNumid(YyghInVo yyghInVo);

    //更新排班号源的号源标识
    void updateYybz();

    List<WeekEndVo> pdjjr();

    String getMzlbGHF(String mzlb);

    String getMzlbGHFET(String mzlb);

    //获取节假日的（mmdd）
    List<String> getHolidays();

    //获取儿科科室
    List<String> getETksdm();
}
