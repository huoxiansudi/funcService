package com.hospital.dao.VisitListHosp;

import com.hospital.out.hospital.JzlbVo;
import com.hospital.out.hospital.MzyykJlxhVo;
import com.hospital.out.hospital.SubscribeListVo;
import com.hospital.out.hospital.TzlbVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User: xiaofu
 * Date: 2017/9/27
 * Time: 14:50
 * Function:
 */
@Mapper
public interface VisitListHospDao {

    List<TzlbVo> findBy(@Param(value = "ksdm") String ksdm, @Param(value = "begindate")String begindate, @Param(value ="endate")String endate);

    List<JzlbVo> findByOrderId(@Param(value = "orderid") String orderid,@Param(value = "bdate") String bdate,@Param(value = "edate") String edate);

    List<MzyykJlxhVo> findJlxh(@Param(value = "sfzh") String sfzh);

    List<SubscribeListVo> findAllJlxhBySfzh(@Param(value = "sfzh") String sfzh,@Param(value = "zt") String zt,@Param(value = "orderid") String orderid);

    List<SubscribeListVo> findAllBySfzh(@Param(value = "sfzh") String sfzh,@Param(value = "zt") String zt,@Param(value = "orderid") String orderid);

    int updateJlxh(@Param(value = "sfzh")String sfzh);

}
