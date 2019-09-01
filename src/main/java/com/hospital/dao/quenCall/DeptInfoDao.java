package com.hospital.dao.quenCall;

import com.hospital.domain.DeptInVo;
import com.hospital.out.quenCallInter.DeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by jinhs on 2017/8/22.
 */
@Mapper
public interface DeptInfoDao {

    //普通门诊
    List<DeptVo> getDeptInfo(@Param("deptInVo") DeptInVo deptInVo);

    Date selectJzrqByKsdm(@Param("deptid")String deptid);

    DeptVo selectGhxhByJzrq(DeptInVo deptInVo);

    Integer selectZghsBySjlb(DeptInVo deptInVo);
    //专家门诊
    List<DeptVo> getNormalInfo(DeptInVo deptInVo);

    List<DeptVo> getDeptSpecialInfo(DeptInVo deptInVo);

    Date selectJzrqByYsgh(@Param("docid")String docid);

    DeptVo selectGhxhByYsgh(DeptInVo deptInVo);

    String getNo(DeptInVo deptInVo);
}
