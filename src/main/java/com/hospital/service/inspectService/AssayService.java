package com.hospital.service.inspectService;

import com.hospital.domain.AssayInVo;
import com.hospital.domain.InspectInVo;
import com.hospital.out.inspectInter.AssDetailVo;
import com.hospital.out.inspectInter.AssayVo;
import com.hospital.out.inspectInter.InspectVo;

import java.util.List;

/**
 * Created by jinhs on 2017-09-05.
 */
public interface AssayService {

    //3.4.1.1 检查列表查
    List<InspectVo> getInspectVo(InspectInVo inspectInVo);

    //3.4.1.2.	检验列表查询
    List<AssayVo> getAssayInfo(AssayInVo assayInVo);

    //3.4.1.3.	检验列表查询
    List<AssDetailVo> getAssDetailInfo(String assayno);
}
