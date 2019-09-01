package com.hospital.service.visitListHospService;

import com.hospital.out.hospital.JzlbVo;
import com.hospital.out.hospital.SubscribeListVo;
import com.hospital.out.hospital.TzlbVo;

import java.util.List;

/**
 * User: xiaofu
 * Date: 2017/9/27
 * Time: 16:30
 * Function:
 */

public interface VisitListHospService {

    List<TzlbVo> findBy(String schid, String begindate, String endate);
    List<JzlbVo> findByOrderId( String orderid, String bdate, String edate);
    List<SubscribeListVo> findAllBySfzh(String sfzh,String zt,String orderid);

}
