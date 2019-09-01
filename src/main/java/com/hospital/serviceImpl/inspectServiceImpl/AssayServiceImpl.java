package com.hospital.serviceImpl.inspectServiceImpl;

import com.hospital.common.IdCardExpUtil;
import com.hospital.config.DatabaseContextHolder;
import com.hospital.dao.inspect.AssayInfoDao;
import com.hospital.domain.AssayInVo;
import com.hospital.domain.InspectInVo;
import com.hospital.out.hospital.PatientVo;
import com.hospital.out.inspectInter.AssDetailVo;
import com.hospital.out.inspectInter.AssayVo;
import com.hospital.out.inspectInter.InspectVo;
import com.hospital.service.inspectService.AssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinhs on 2017-09-05.
 */
@Service
public class AssayServiceImpl implements AssayService {

    @Autowired
    private AssayInfoDao assayDao;

    @Override
    public List<AssayVo> getAssayInfo(AssayInVo assayInVo) {

        if (StringUtils.hasText(assayInVo.getIdcard()) &&
                assayInVo.getBdate() != null &&
                assayInVo.getEdate() != null) {
            List<AssayVo> list = assayDao.getAssayInfo(assayInVo);
            for (AssayVo temp : list) {
                temp.setAge(IdCardExpUtil.IdNOToAge(assayInVo.getIdcard()));
            }
            return list;
        }
        return null;
    }

    @Override
    public List<AssDetailVo> getAssDetailInfo(String assayno) {

        return assayDao.getAssDetailInfo(assayno);
    }

    @Override
    public List<InspectVo> getInspectVo(InspectInVo inspectInVo) {
        List<InspectVo> inspectList= new ArrayList<>();


        //一般检查结果
        DatabaseContextHolder.setDBKey("ds1_w");
        inspectList.addAll(assayDao.getInspectVo(inspectInVo));
        //通过身份证查询就诊卡号
        List<PatientVo> medcardnoList = assayDao.getMedcardno(inspectInVo);
        DatabaseContextHolder.clearDBKey();
        //病理结果
        DatabaseContextHolder.setDBKey("eWorldPIS");
        for (PatientVo temp: medcardnoList) {
            String jzkh = temp.getPatid();
            if(StringUtils.hasText(jzkh)){
                inspectInVo.setMedcardno(jzkh);
                inspectList.addAll(assayDao.getInspectVo_sqlServer(inspectInVo));
            }
        }

        DatabaseContextHolder.clearDBKey();

        return inspectList;
    }
}
