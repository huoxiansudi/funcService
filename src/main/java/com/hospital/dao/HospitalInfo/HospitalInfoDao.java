package com.hospital.dao.HospitalInfo;

import com.hospital.domain.*;
import com.hospital.out.clinicPayInter.GhsfVo;
import com.hospital.out.hospital.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fuxf on 2017/8/1.
 */
@Mapper
public interface HospitalInfoDao {


    List<HospitalVo> getHospitalInfo();

    List<DepartmentVo> getListDepart();

    List<DoctorVo> getListDoc(@Param(value = "ksdm") String ksdm);

    int insertPatient(PatientInVo registInVo);

    List<PatientVo> selectPatientBySfzh(String idCard);

    PatientVo selectPatientByJzkh(String jzkh);

    List<PatientVo> selectPatient(PatientInVo patientInVo);

    int updatePatient(PatientInVo patientInVo);

    int updateXhb(String tableName);

    int selectXhb(String tableName);

    String selectNumid(String numid);

    String selectJzkh(String jzkh);

    List getCheckID(String checkid);

    int insertMzYyk(GhkVo ghkVo);

    int updateGhk(YyghInVo yyghInVo);

    Integer updateSucceGhk (@Param(value = "yyxh")String yyxh,@Param(value = "jlxh")String jlxh);

    int insertYypb(YyghInVo yyghInVo);

    int updateYyqx(YyghInVo yyghInVo);

    List<DoctorPbVo> getListDoctorPb(@Param(value = "platdeptid") String platdeptid);

    List<JlxhVo> getSpeYzPbk(@Param(value = "platdeptid") String platdeptid);

    int getSpeYyPbmx(@Param(value = "jlxh") String jlxh);

    int getSpeYybz(@Param(value = "jlxh") String jlxh);

    List<NumSourceVo> getCount(@Param(value = "pbjlxh") String pbjlxh,@Param(value = "ampm") String ampm);

    List<PbHyVo> getPbHyVo(@Param(value = "schid") String schid, @Param(value = "ampm") String ampm);

    GhsfVo selectTodayGhsf(@Param("ghInVo") GhInVo ghInVo);
    GhsfVo selectGhsf(@Param("ghInVo") GhInVo ghInVo);
    GhsfVo getGhxx(@Param("preid")String preid);
    GhsfVo getThxx(@Param("ghsfVo")GhsfVo ghsfVo);

    String getJzXH(String jlxh);

    Integer lockNum(String pbmxxh);

    Integer unLockNum(String pbmxxh);

    NumOrigin getDoctorPbVoByNumId(String pbmxxh);

    Integer selectNumByPbxmxy(String pbmxxh);

    //获取当天排班
    List<DoctorPbVo> selectTheDayPB( String ksdm);
    //获取当日号源
    List<PbHyVo> selectCurrentNum(@Param(value = "schid") String schid, @Param(value = "ampm") String ampm);
      //根据号源编号查询当前号源参数
    CurrentGhkVo selectCurrentByPBXH(String numid);

    CurrentGhkVo selectClinicByPBXH(@Param(value = "ksdm")String ksdm,@Param(value = "ghsjlb")String ghsjlb,@Param(value = "ysgh")String ysgh);
    //插入gh_ghk
    Integer insertGHKByCurrentGhkVo(CurrentGhkVo currentGhkVo);


    //查询科室信息
    List<KsxxVo> selectKsxx();

    int selectWebKsxx(String ksdm);

    int insertWebKsxx(KsxxVo ksxxVo);

    DoctorPbVo getSpeYsxx(String jlxh);

    int getSwSfTz(DoctorPbVo doctorPbVo);
    int getXwSfTz(DoctorPbVo doctorPbVo);
}
