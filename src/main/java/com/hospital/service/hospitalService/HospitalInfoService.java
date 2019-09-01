package com.hospital.service.hospitalService;

import com.hospital.domain.GhInVo;
import com.hospital.domain.PatientInVo;
import com.hospital.domain.YyghInVo;
import com.hospital.out.InHosInter.RegistSettleVo;
import com.hospital.out.clinicPayInter.GhsfVo;
import com.hospital.out.hospital.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fuxf on 2017/8/1.
 */
public interface HospitalInfoService {

    @Transactional
    int updateKsxx();

    List<HospitalVo> getHospitalInfo();

    List<DepartmentVo> getListDepart();

    List<DoctorVo> getListDoc(String ksdm);

    List<PatientVo> selectPatientBySfzh(String idCard);

    PatientVo selectPatientByJzkh(String jzkh);

    List<PatientVo> selectPatient(PatientInVo patientInVo);

    int insertPatient(PatientInVo registInVo);

    int updatePatient(PatientInVo patientInVo);

    String selectNumid(String numid);

    String selectJzkh(String jzkh);

    List getCheckID(String checkid);

    @Transactional
    String insertMzYyk(GhkVo ghkVo);

    @Transactional
    int updateGhk(YyghInVo yyghInVo);

    @Transactional
    int updateYyqx(YyghInVo yyghInVo);

    List<DoctorPbVo> getListDoctorPb(String platdeptid);

    List<NumSourceVo> getCount(String schid,String ampm);

    List<PbHyVo> getPbHyVo(String schid, String ampm);

    @Transactional
    Integer lockNum(String pbmxxh);

    @Transactional
    Integer unLockNum(String pbmxxh);

    NumOrigin getDoctorPbVoByNumId(String pbmxxh);

    Integer selectNumByPbxmxy(String pbmxxh);

    List<DoctorPbVo> selectTheDayPB(String ksdm, String xq);

    int updateXhb(String tableName);
    int selectXhb(String tableName);

    List<PbHyVo> selectCurrentNum(String schid, String ampm);
    @Transactional
    String insertCurrentGHKVo(RegistSettleVo vo);

    GhsfVo getGhxx(String preid);
    GhsfVo getThxx(GhsfVo ghsfVo);
    GhsfVo selectTodayGhsf(GhInVo ghInVo);
    GhsfVo selectGhsf(GhInVo ghInVo);

    String getJzXH(String jlxh);
}
