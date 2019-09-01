package com.hospital.service.quenCallService;

import com.hospital.domain.DeptInVo;
import com.hospital.out.quenCallInter.DeptVo;

import java.util.Date;
import java.util.List;

/**
 * Created by jinhs on 2017/8/3.
 */
public interface DeptInfoService {

    //普通门诊
    List<DeptVo> getDeptInfo(DeptInVo vo);

    Date selectJzrqByKsdm(String ksdm);

    DeptVo selectGhxhByJzrq(DeptInVo deptInVo);

    Integer selectZghsBySjlb(DeptInVo deptInVo);

    //专家门诊

    List<DeptVo> getNormalInfo(DeptInVo vo);

    List<DeptVo> getDeptSpecialInfo(DeptInVo vo);

    Date selectJzrqByYsgh(String ysgh);

    DeptVo selectGhxhByYsgh(DeptInVo deptInVo);

    String getNo(DeptInVo vo);
}
