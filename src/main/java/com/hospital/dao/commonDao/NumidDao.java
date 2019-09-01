package com.hospital.dao.commonDao;

import com.hospital.domain.WeekEndVo;
import com.hospital.domain.YyghInVo;
import com.hospital.out.hospital.PbHyVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jinhs on 2017-11-30.
 */
@Mapper
public interface NumidDao {

    //100208预约挂号
    PbHyVo getNumid(@Param("yyghInVo") YyghInVo yyghInVo);

    //获取当天所有的排班编号
    List<String> findTodayPBBH();

    //获取当天预约的排班编号
    List<String> findYyPBBH(String yyToday);

    Integer updateYybz(String pbjx);

    //获取双休日参数 1是需要获取急诊费用，0是不需要
    List<WeekEndVo> getWeekEndParameter();

    //根据参数获取挂号费：1普通  2急诊
    String getMzlbGHF(String mzlb);

    //根据参数获取儿童挂号费：1普通  2急诊
    String getMzlbGHFet(String mzlb);

    //获取节假日
    List<String> getHolidays();

    //获取儿科科室
    List<String> getETksdm();
}
