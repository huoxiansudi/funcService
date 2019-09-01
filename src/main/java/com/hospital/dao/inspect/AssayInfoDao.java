package com.hospital.dao.inspect;

import com.hospital.domain.AssayInVo;
import com.hospital.domain.InspectInVo;
import com.hospital.out.hospital.PatientVo;
import com.hospital.out.inspectInter.AssDetailVo;
import com.hospital.out.inspectInter.AssayVo;
import com.hospital.out.inspectInter.InspectVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jinhs on 2017-09-05.
 */
@Mapper
public interface AssayInfoDao {

    //3.4.1.1 检查列表查
    List<InspectVo> getInspectVo(@Param("inspectInVo") InspectInVo inspectInVo);

    //获取就诊卡号
    List<PatientVo> getMedcardno(@Param("inspectInVo") InspectInVo inspectInVo);

    //3.4.1.1 检查列表查(病理)
    List<InspectVo> getInspectVo_sqlServer(@Param("inspectInVo") InspectInVo inspectInVo);

    //3.4.1.2.	检验列表查询
    List<AssayVo> getAssayInfo(AssayInVo assayInVo);

    //3.4.1.3.	检验列表查询
    List<AssDetailVo> getAssDetailInfo(@Param("assayno") String assayno);
}
