package com.hospital.service.prepaidInHospitalService;

import com.hospital.domain.PrepaidVo;
import com.hospital.out.clinicPayInter.CostMap;
import com.hospital.out.clinicPayInter.TotalCostInventoryVo;
import com.hospital.out.clinicPayInter.ZYPatientVo;
import com.hospital.out.hospital.PayDetaileList;

import java.util.List;

/**
 * User: xiaofu
 * Date: 2017/11/10
 * Time: 10:32
 * Function:
 */
public interface PrepaidInHospitalService {

    ZYPatientVo getZYPatientVoBySFZH(String sfzh);

    TotalCostInventoryVo oneDayItems(String begintime, String endtime, String patientNo);

    List<CostMap> getCostMap();

    String getPrepaidJLXH();

    Integer insertVo(PrepaidVo prepaidVo);

    PayDetaileList selectDetailedList(String sfzh);
}
