package com.hospital.serviceImpl.quenCallServiceImpl;

import com.hospital.dao.quenCall.DeptInfoDao;
import com.hospital.domain.DeptInVo;
import com.hospital.out.quenCallInter.DeptVo;
import com.hospital.service.quenCallService.DeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by jinhs on 2017/8/3.
 */
@Service
public class DeptServiceImpl implements DeptInfoService {

    @Autowired
    private DeptInfoDao deptInfoDao;

    @Override
    public List<DeptVo> getDeptInfo(DeptInVo deptInVo) {

        List<DeptVo> deptVo = deptInfoDao.getDeptInfo(deptInVo);
        if (deptVo!=null){

        }
        return deptVo;
    }

    @Override
    public Date selectJzrqByKsdm(String ksdm) {

        return deptInfoDao.selectJzrqByKsdm(ksdm);
    }

    @Override
    public DeptVo selectGhxhByJzrq(DeptInVo deptInVo) {
        return deptInfoDao.selectGhxhByJzrq(deptInVo);
    }

    @Override
    public Integer selectZghsBySjlb(DeptInVo deptInVo) {
        return deptInfoDao.selectZghsBySjlb(deptInVo);
    }

    @Override
    public List<DeptVo> getNormalInfo(DeptInVo vo) {
        return deptInfoDao.getNormalInfo(vo);
    }

    @Override
    public List<DeptVo> getDeptSpecialInfo(DeptInVo vo) {
        return deptInfoDao.getDeptSpecialInfo(vo);
    }

    @Override
    public Date selectJzrqByYsgh(String ysgh) {
        return deptInfoDao.selectJzrqByYsgh(ysgh);
    }

    @Override
    public DeptVo selectGhxhByYsgh(DeptInVo deptInVo) {
        return deptInfoDao.selectGhxhByYsgh(deptInVo);
    }

    @Override
    public String getNo(DeptInVo vo) {
        return deptInfoDao.getNo(vo);
    }
}
