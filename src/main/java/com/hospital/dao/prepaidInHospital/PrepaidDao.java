package com.hospital.dao.prepaidInHospital;

import com.hospital.domain.PrepaidVo;
import com.hospital.out.clinicPayInter.CostInventoryVo;
import com.hospital.out.clinicPayInter.CostMap;
import com.hospital.out.clinicPayInter.ZYPatientVo;
import com.hospital.out.hospital.PaymenTrecordVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User: xiaofu
 * Date: 2017/11/9
 * Time: 16:48
 * Function:住院预交金
 */
@Mapper
public interface PrepaidDao {

    ZYPatientVo getZYPatientVoBySFZH(String sfzh);

    List<CostInventoryVo> oneDayItems(@Param("begintime") String begintime, @Param("endtime") String endtime, @Param("patientNo")String patientNo);

    List<CostMap> getCostMap();

    Integer insertPrepaidFunds(PrepaidVo prepaidVo);

    Integer updatePrepaidJLXH();

    Integer selectPrepaidJLXH();

    List<PaymenTrecordVo> selectDetailedList(String sfzh);

    String prepaidFunds(String patientNo);
}
