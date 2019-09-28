package com.hospital.serviceImpl.hospitalServiceImpl;

import com.hospital.common.*;
import com.hospital.dao.HospitalInfo.HospitalInfoDao;
import com.hospital.domain.*;
import com.hospital.out.InHosInter.RegistSettleVo;
import com.hospital.out.clinicPayInter.GhsfVo;
import com.hospital.out.hospital.*;
import com.hospital.service.commonService.NumidService;
import com.hospital.service.hospitalService.HospitalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by fuxf on 2017/8/1.
 */
@Service
public class HospitalInfoServiceImpl implements HospitalInfoService {

    @Value("${hospital.yylx}")
    private String yylx;

    @Value("${doctor.url}")
    private String doctorUrl;

    @Value("${pay.czgh}")
    private String czgh;

    @Value("${hospital.hytfybh}")
    private String hytfybh;

    @Value("${hospital.hdfybh}")
    private String hdfybh;

    @Value("${hospital.xkfybh}")
    private String xkfybh;

    @Value("${hospital.mchyt}")
    private String mchyt;

    @Value("${hospital.mchd}")
    private String mchd;

    @Value("${hospital.mcxk}")
    private String mcxk;


    @Autowired
    private HospitalInfoDao hospitalInfoDao;

    @Autowired
    private NumidService numidService;

    @Override
    public int updateKsxx() {

        List<KsxxVo> ksxxVoList = hospitalInfoDao.selectKsxx();
        for (KsxxVo ksxxVo : ksxxVoList) {

            //判断web_ghksxx是否有信息
            int aa = hospitalInfoDao.selectWebKsxx(ksxxVo.getKsdm());
            if (aa == 0) {
                //添加信息到web_ghksxx中
                int bb = hospitalInfoDao.insertWebKsxx(ksxxVo);
            }
        }

        return 0;
    }

    @Override
    public List<HospitalVo> getHospitalInfo() {

        List<HospitalVo> hospitalInfos = hospitalInfoDao.getHospitalInfo();
        for (HospitalVo hospitalInfo : hospitalInfos) {
            if (hospitalInfo != null) {
                hospitalInfo.setLevel(hospitalInfo.getRank());
                hospitalInfo.setTime("00:00");
                hospitalInfo.setPicture("www.yw-hospital.com/upload/editor/ext_jpg/201411180836259281.jpg");
            }
        }
        return hospitalInfos;
    }

    @Override
    public List<DepartmentVo> getListDepart() {

        List<DepartmentVo> list = hospitalInfoDao.getListDepart();
        return list;
    }

    @Override
    public List<DoctorVo> getListDoc(String ksdm) {

        List<DoctorVo> list = hospitalInfoDao.getListDoc(ksdm);
        for (DoctorVo doctorVo : list) {
            String pic = doctorUrl + doctorVo.getDocid() + ".JPG";
            String pdbs = ValidatorUtil.isConnect(pic);
            if ("ok".equals(pdbs)) {
                doctorVo.setPicture(pic);
            }
        }
        return list;
    }

    @Override
    public List<PatientVo> selectPatientBySfzh(String idCard) {
        return hospitalInfoDao.selectPatientBySfzh(idCard);
    }

    @Override
    public PatientVo selectPatientByJzkh(String jzkh) {
        return hospitalInfoDao.selectPatientByJzkh(jzkh);
    }


    @Override
    public List<PatientVo> selectPatient(PatientInVo patientInVo) {

        List<PatientVo> list = hospitalInfoDao.selectPatient(patientInVo);
        for (PatientVo vo : list) {
            if (vo.getMobileno() == null) {
                vo.setMobileno("");
            }
        }
        return list;
    }


    @Override
    public int insertPatient(PatientInVo registInVo) {
        int temp = hospitalInfoDao.insertPatient(registInVo);
        return temp;
    }

    @Override
    public int updatePatient(PatientInVo patientInVo) {
        int temp = hospitalInfoDao.updatePatient(patientInVo);
        return temp;
    }

    @Override
    public String selectNumid(String numid) {
        return hospitalInfoDao.selectNumid(numid);
    }

    @Override
    public String selectJzkh(String jzkh) {
        return hospitalInfoDao.selectJzkh(jzkh);
    }

    @Override
    public List getCheckID(String checkid) {
        return hospitalInfoDao.getCheckID(checkid);
    }

    @Override
    public String insertMzYyk(GhkVo ghkVo) {

        Integer numState = hospitalInfoDao.selectNumByPbxmxy(ghkVo.getNumid());
        if (numState == null) {
            return "号源无效！！！";
        }
        if (numState == 1) {
            return "号源已经被锁定！！！";
        }

        //判断取号密码是否重复
        List pass = hospitalInfoDao.getCheckID(ghkVo.getCheckid());
        if (pass != null && pass.size() > 0) {
            return "取号密码有重复！！！";
        }

        int t = hospitalInfoDao.updateXhb("GH_MZYYK");
        if (t > 0) {
            int yyxh = hospitalInfoDao.selectXhb("GH_MZYYK");
            ghkVo.setYyxh(yyxh + "");
        }


        int temp = hospitalInfoDao.insertMzYyk(ghkVo);
        if (temp > 0) {
            Integer numTemp = hospitalInfoDao.lockNum(ghkVo.getNumid());
            if (numTemp > 0) {
                return ghkVo.getYyxh();
            }
        }

        return null;
    }

    @Override
    public int updateGhk(YyghInVo yyghInVo) {
        return hospitalInfoDao.updateGhk(yyghInVo);
    }

    @Override
    public int updateYyqx(YyghInVo yyghInVo) {
        int temp = hospitalInfoDao.updateYyqx(yyghInVo);

        return temp;
    }

    @Override
    public List<DoctorPbVo> getListDoctorPb(String platdeptid) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.hasText(platdeptid)) {
            List<DoctorPbVo> newList = new ArrayList<>();
            List<DoctorPbVo> list = hospitalInfoDao.getListDoctorPb(platdeptid);//获取还有预约的排班信息
            List<String> holidaysList = this.numidService.getHolidays();
            for (DoctorPbVo tem : list) {
                if (tem == null) {
                    continue;
                }
                List<NumSourceVo> numSourceVos = getCount(tem.getSchid(), tem.getAmpm());
                if (numSourceVos == null) {
                    continue;
                }
                try {
                    Integer sourceNum = 0;
                    for (NumSourceVo numSourceVotemp : numSourceVos) {
                        if ("0".equals(numSourceVotemp.getYybz())) {
                            tem.setNumremain(numSourceVotemp.getCount());
                            sourceNum += Integer.parseInt(numSourceVotemp.getCount());
                        }
                        if ("1".equals(numSourceVotemp.getYybz())) {
                            sourceNum += Integer.parseInt(numSourceVotemp.getCount());
                        }
                    }
                    tem.setSchdate(sdf.parse(tem.getAppdate())); //排班日期转换
                    tem.setNumcount(sourceNum + "");
                    if (tem.getNumremain() == null || "0".equals(tem.getNumremain())) {
                        continue;
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // -------------------2019-09-16 添加 停诊 状态信息-------------------------------
                if (null != tem.getDocid()) {
                    int aa = 0;
                    if (tem.getAmpm().equals("1")) { //如果是早上

                        aa = hospitalInfoDao.getSwSfTz(tem);
                    } else if (tem.getAmpm().equals("2")) {
                        aa = hospitalInfoDao.getXwSfTz(tem);
                    }
                    if (aa > 0) { //停诊
                        tem.setSchstate("1");
                    } else { //正常
                        tem.setSchstate("0");
                    }

                }
                // -------------------2019-09-16 添加 停诊 状态信息--------------------------------


                if (tem.getDocid() == null) {
                    tem.setDocname("普通医生");
                    tem.setDocid("0");
                    tem.setSchstate("0");
                    List<String> etList = numidService.getETksdm();
                    String holidayFee = "";
                    if (etList != null && etList.contains(platdeptid)) {
                        holidayFee = getHolidaysCostET(DateUtil.formatToDateStr(tem.getAppdate()), holidaysList);
                    } else {
                        holidayFee = getHolidaysCost(DateUtil.formatToDateStr(tem.getAppdate()), holidaysList);
                    }
                    if (StringUtils.hasText(holidayFee)) {
                        tem.setFee(holidayFee);
                    }
                    Integer rqpd = DateUtil.getWeekOfDateFortmatt(tem.getAppdate());
                    if ((rqpd == 7) || (rqpd == 6)) {
                        String jzFeel = pdWeekEnd(rqpd + "", platdeptid);
                        if (jzFeel != null) {
                            tem.setFee(jzFeel);
                        }
                    }
                } else {
                    tem.setTitle(PositionTitle.getCode(tem.getTitle()) + "");
                }
                newList.add(tem);
            }


            // -------------------2019-09-02 添加 号源已挂满 的专家信息--------------------------------
            List<DoctorPbVo> numIDIsNullList = new ArrayList<>();
            List<JlxhVo> jlxhList = hospitalInfoDao.getSpeYzPbk(platdeptid); //获取专家一周排班库
            if (jlxhList != null && !jlxhList.isEmpty()) {
                for (JlxhVo jlxhVo : jlxhList) {
                    int aa = hospitalInfoDao.getSpeYyPbmx(jlxhVo.getJlxh()); //先判断是否有该排班
                    if (aa > 0) {
                        //有排班再判断yybz=0的数据，0条数据说明已全部预约，则要查出提示“已挂满”
                        int bb = hospitalInfoDao.getSpeYybz(jlxhVo.getJlxh());
                        if (bb == 0) {
                            DoctorPbVo doctorPbVo = hospitalInfoDao.getSpeYsxx(jlxhVo.getJlxh());//获取被全部预约的专家信息唯一的
                            doctorPbVo.setTitle(PositionTitle.getCode(doctorPbVo.getTitle()) + "");
                            try {
                                doctorPbVo.setSchdate(sdf.parse(doctorPbVo.getAppdate())); //排班日期转换
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            List<NumSourceVo> numSourceVos = getCount(doctorPbVo.getSchid(), doctorPbVo.getAmpm());
                            Integer sourceNum = 0;
                            for (NumSourceVo numSourceVotemp : numSourceVos) {
                                if ("0".equals(numSourceVotemp.getYybz())) {
                                    doctorPbVo.setNumremain(numSourceVotemp.getCount());
                                    sourceNum += Integer.parseInt(numSourceVotemp.getCount());
                                }
                                if ("1".equals(numSourceVotemp.getYybz())) {
                                    sourceNum += Integer.parseInt(numSourceVotemp.getCount());
                                }
                            }
                            doctorPbVo.setNumcount(sourceNum + "");
                            doctorPbVo.setNumremain("0");
                            doctorPbVo.setSchstate("0");

                            numIDIsNullList.add(doctorPbVo);
                        }

                    }
                }
            }
            //------------------- 2019-09-02 添加 号源已挂满 的专家信息------------------------

            newList.addAll(numIDIsNullList);

            return newList;
        }
        return null;
    }

    @Override
    public List<DoctorPbVo> selectTheDayPB(String ksdm, String xq) {
        if (StringUtils.hasText(ksdm) && StringUtils.hasText(xq)) {
            List<DoctorPbVo> listPb = new ArrayList<>();
            List<DoctorPbVo> list = hospitalInfoDao.selectTheDayPB(ksdm);
            List<String> holidaysList = this.numidService.getHolidays();
            for (DoctorPbVo temp : list) {
                if (temp == null) {
                    continue;
                }
                List<NumSourceVo> numSourceVos = getCount(temp.getSchid(), temp.getAmpm());
                if (numSourceVos == null) {
                    continue;
                }
                Integer sourceNum = 0;
                for (NumSourceVo numSourceVotemp : numSourceVos) {
                    if ("0".equals(numSourceVotemp.getYybz())) {
                        temp.setNumremain(numSourceVotemp.getCount());
                        sourceNum += Integer.parseInt(numSourceVotemp.getCount());
                    }
                    if ("1".equals(numSourceVotemp.getYybz())) {
                        sourceNum += Integer.parseInt(numSourceVotemp.getCount());
                    }
                }
                temp.setSchdate(new Date());
                temp.setAppdate(DateUtil.dateToString(new Date()));
                temp.setNumcount(sourceNum + "");
                if (temp.getNumremain() == null) {
                    temp.setNumremain(0 + "");
                    continue;
                }

                // -------------------2019-09-16 添加 停诊 状态信息-------------------------------
                if (null != temp.getDocid()) {
                    int aa = 0;
                    if (temp.getAmpm().equals("1")) { //如果是早上

                        aa = hospitalInfoDao.getSwSfTz(temp);
                    } else if (temp.getAmpm().equals("2")) {
                        aa = hospitalInfoDao.getXwSfTz(temp);
                    }
                    if (aa > 0) { //停诊
                        temp.setSchstate("1");
                    } else { //正常
                        temp.setSchstate("0");
                    }

                }
                // -------------------2019-09-16 添加 停诊 状态信息--------------------------------

                if (temp.getDocid() == null) {

                    temp.setSchstate("0");

                    List<String> etList = numidService.getETksdm();
                    String holidayFee = "";
                    if (etList != null && etList.contains(ksdm)) {
                        holidayFee = getHolidaysCostET(DateUtil.getDayStr(), holidaysList);
                    } else {
                        holidayFee = getHolidaysCost(DateUtil.getDayStr(), holidaysList);
                    }
                    if (StringUtils.hasText(holidayFee)) {
                        temp.setFee(holidayFee);
                    }
                    Integer rqpd = DateUtil.getWeekOfDate();
                    if ((rqpd == 7) || (rqpd == 6)) {
                        String jzFeel = pdWeekEnd(rqpd + "", ksdm);
                        if (jzFeel != null)
                            temp.setFee(jzFeel);
                    }
                }
                listPb.add(temp);
            }

            // -------------------2019-09-02 添加号源已挂满的专家信息--------------------------------
            List<DoctorPbVo> numIDIsNullList = new ArrayList<>();
            List<JlxhVo> jlxhList = hospitalInfoDao.getSpeYzPbk(ksdm); //获取专家当天排班库
            if (jlxhList != null && !jlxhList.isEmpty()) {
                for (JlxhVo jlxhVo : jlxhList) {

                    if (jlxhVo.getXq() != DateUtil.getWeekOfDate()) {  //判断是否当天
                        continue;
                    }

                    int aa = hospitalInfoDao.getSpeYyPbmx(jlxhVo.getJlxh()); //先判断是否有该排班
                    if (aa > 0) {
                        //有排班再判断yybz=0的数据，0条数据说明已全部预约，则要查出提示“已挂满”
                        int bb = hospitalInfoDao.getSpeYybz(jlxhVo.getJlxh());
                        if (bb == 0) {
                            DoctorPbVo doctorPbVo = hospitalInfoDao.getSpeYsxx(jlxhVo.getJlxh());//获取被全部预约的专家信息唯一的
                            doctorPbVo.setTitle(PositionTitle.getCode(doctorPbVo.getTitle()) + "");
                            doctorPbVo.setSchdate(new Date()); //排班日期转换
                            List<NumSourceVo> numSourceVos = getCount(doctorPbVo.getSchid(), doctorPbVo.getAmpm());
                            Integer sourceNum = 0;
                            for (NumSourceVo numSourceVotemp : numSourceVos) {
                                if ("0".equals(numSourceVotemp.getYybz())) {
                                    doctorPbVo.setNumremain(numSourceVotemp.getCount());
                                    sourceNum += Integer.parseInt(numSourceVotemp.getCount());
                                }
                                if ("1".equals(numSourceVotemp.getYybz())) {
                                    sourceNum += Integer.parseInt(numSourceVotemp.getCount());
                                }
                            }
                            doctorPbVo.setNumcount(sourceNum + "");
                            doctorPbVo.setNumremain("0");
                            doctorPbVo.setSchstate("0");

                            numIDIsNullList.add(doctorPbVo);
                        }

                    }
                }
            }
            //------------------- 2019-09-02 添加号源已挂满的专家信息------------------------

            listPb.addAll(numIDIsNullList);

            return listPb;
        }
        return null;
    }

    @Override
    @Transactional
    public int updateXhb(String tableName) {
        return hospitalInfoDao.updateXhb(tableName);
    }

    @Override
    public int selectXhb(String tableName) {
        return hospitalInfoDao.selectXhb(tableName);
    }


    @Override
    public List<NumSourceVo> getCount(String schid, String ampm) {
        if (StringUtils.hasText(schid) && StringUtils.hasText(ampm)) {
            return hospitalInfoDao.getCount(schid, ampm);
        }
        return null;
    }

    @Override
    public List<PbHyVo> getPbHyVo(String schid, String ampm) {
        if (StringUtils.hasText(schid) && StringUtils.hasText(ampm)) {
            List<PbHyVo> list = hospitalInfoDao.getPbHyVo(schid, ampm);
            for (PbHyVo temp : list) {
                temp.setNumdate(DateUtil.formatStringDate(temp.getAppdate()));
            }
            return list;
        }
        return null;
    }

    @Override
    public List<PbHyVo> selectCurrentNum(String schid, String ampm) {
        if (StringUtils.hasText(schid) && StringUtils.hasText(ampm)) {
            List<PbHyVo> list = hospitalInfoDao.selectCurrentNum(schid, ampm);
            for (PbHyVo temp : list) {
                temp.setNumdate(new Date());
            }
            return list;
        }
        return null;
    }

    @Override
    public GhsfVo selectGhsf(GhInVo ghInVo) {
        return hospitalInfoDao.selectGhsf(ghInVo);
    }

    @Override
    public Integer lockNum(String pbmxxh) {
        if (StringUtils.hasText(pbmxxh)) {
            return hospitalInfoDao.lockNum(pbmxxh);
        }
        return -1;
    }

    @Override
    public Integer unLockNum(String pbmxxh) {
        if (StringUtils.hasText(pbmxxh)) {
            return hospitalInfoDao.unLockNum(pbmxxh);
        }
        return -1;
    }

    @Override
    public NumOrigin getDoctorPbVoByNumId(String pbmxxh) {
        if (StringUtils.hasText(pbmxxh)) {
            return hospitalInfoDao.getDoctorPbVoByNumId(pbmxxh);
        }
        return null;
    }

    @Override
    public Integer selectNumByPbxmxy(String pbmxxh) {
        if (StringUtils.hasText(pbmxxh)) {
            return hospitalInfoDao.selectNumByPbxmxy(pbmxxh);
        }
        return null;
    }

    @Override
    @Transactional
    public String insertCurrentGHKVo(RegistSettleVo vo) {
        if (vo != null) {
            CurrentGhkVo currentGhkvo = hospitalInfoDao.selectCurrentByPBXH(vo.getNumid());
            if (currentGhkvo == null) {
                return "获取不到当天号源信息";
            }

            CurrentGhkVo clincVo = hospitalInfoDao.selectClinicByPBXH(currentGhkvo.getKsdm(), currentGhkvo.getSjlb(), currentGhkvo.getYsgh());
            if (clincVo == null) {
                return "获取不到当天排班信息";
            }

            currentGhkvo.setZlf(vo.getPayamount());
            currentGhkvo.setPbxh(clincVo.getPbxh());
            if (currentGhkvo.getKsmc() != null) {
                if (currentGhkvo.getKsmc().indexOf(mchd) != -1) {
                    currentGhkvo.setFybh(hdfybh);
                } else if (currentGhkvo.getKsmc().indexOf(mchyt) != -1) {
                    currentGhkvo.setFybh(hytfybh);
                } else {
                    currentGhkvo.setFybh(xkfybh);
                }
            }
            /*int t = hospitalInfoDao.updateXhb("GH_GHK");
            if (t > 0) {
                int jlxh = hospitalInfoDao.selectXhb("GH_GHK");
                currentGhkvo.setJlxh(jlxh + "");
            } else {
                return "获取挂号库的序号错误!!";
            }*/
            currentGhkvo.setJlxh(vo.getRegid());
            currentGhkvo.setGhxh(vo.getNumno());
            currentGhkvo.setJzkh(vo.getPatid());
            currentGhkvo.setJylsh(vo.getAgtordernumber());//+ "0000" + PayMode.getCodeInt(vo.getPaymode())
            currentGhkvo.setPayModel(PayMode.getCodeInt(vo.getPaymode()));
            currentGhkvo.setGhrq(DateUtil.formatDateString(new Date()));
            PatientVo patVo = hospitalInfoDao.selectPatientByJzkh(vo.getPatid());
            if (patVo == null) {
                return "病人信息获取不到!!!";
            }
            currentGhkvo.setBrlb("1");//(patVo.getBrlb() == null ? "1" : patVo.getBrlb());
            currentGhkvo.setBrxm(patVo.getPatname());
            currentGhkvo.setBrxz("1");//(patVo.getBrxzdm() == null ? "1" : patVo.getBrxzdm());
            currentGhkvo.setJzcs(((patVo.getJzcs() == null ? 0 : Integer.valueOf(patVo.getJzcs())) + 1) + "");
            currentGhkvo.setCzgh(czgh);
            currentGhkvo.setCzrq(DateUtil.formatDateString(new Date()));
            currentGhkvo.setThbz("0");

            //如果有传入预约单编号，则把该预约单状态改成已取号
            if (StringUtils.hasText(vo.getPreid()) && StrUtil.isInteger(vo.getPreid())) {
                Integer intUP = hospitalInfoDao.updateSucceGhk(vo.getPreid(), vo.getRegid());
                if (intUP < 0) {
                    return "状态更新失败!!!!";
                }
            } else {

                //--------------------------2019-09-25 若没有传入预约单编号 则新增一条 预约信息----------------------
                NumOrigin numDo = hospitalInfoDao.getDoctorPbVoByNumId(vo.getNumid());

                GhkVo ghkVo = new GhkVo();
                //ghkVo.setCheckid(yyghInVo.getPass());
                ghkVo.setGhxh(vo.getNumno());
                ghkVo.setJzkh(vo.getPatid());
                ghkVo.setYylb(yylx);//网上预约类型都是3
                ghkVo.setSfzh(patVo.getIdcard());
                ghkVo.setXb(patVo.getPatsex());
                ghkVo.setXm(patVo.getPatname());
                ghkVo.setNumid(vo.getNumid());
                ghkVo.setZt("0");
                ghkVo.setJtzz(patVo.getAddress());
                ghkVo.setThbz("0");
                if (numDo != null) {
                    ghkVo.setKsdm(numDo.getDeptCode());
                    ghkVo.setMzlbxh(numDo.getMzlbxh());
                    ghkVo.setYsgh(numDo.getDocterCode());

                }
                ghkVo.setLxdh(patVo.getMobileno());
                ghkVo.setPbxh(vo.getSchid());
                GregorianCalendar ca = new GregorianCalendar();
                ghkVo.setYysj(ca.get(GregorianCalendar.AM_PM) + 1 + "");
                ghkVo.setUserid(vo.getRegid());
                ghkVo.setXxczid(vo.getOper());
                ghkVo.setDjrq(DateUtil.getCurrentDate());
                ghkVo.setThbz("0");
                ghkVo.setCzgh(czgh);
                ghkVo.setYyrq1(DateUtil.formatCurrent());
                ghkVo.setYyrq2(DateUtil.getCurrentDate());

                int t = hospitalInfoDao.updateXhb("GH_MZYYK");
                if (t > 0) {
                    int yyxh = hospitalInfoDao.selectXhb("GH_MZYYK");
                    ghkVo.setYyxh(yyxh + "");
                }

                int temp = hospitalInfoDao.insertMzYyk(ghkVo);
                if (temp > 0) {
                    System.out.println("加入预约库成功");
                }
                //--------------------------2019-09-25 若没有传入预约单编号 则新增一条 预约信息----------------------

            }

            Integer voip = hospitalInfoDao.insertGHKByCurrentGhkVo(currentGhkvo);
            if (voip > 0) {
                //  hospitalInfoDao.lockNum(vo.getNumid());
                return "true";
            }
        }
        return "入参转换有问题！！！";
    }

    @Override
    public GhsfVo getGhxx(String preid) {
        return hospitalInfoDao.getGhxx(preid);
    }

    @Override
    public GhsfVo getThxx(GhsfVo ghsfVo) {
        return hospitalInfoDao.getThxx(ghsfVo);
    }

    //双休日挂号费
    private String pdWeekEnd(String rqpd, String deptCode) {
        List<String> etList = numidService.getETksdm();
        List<WeekEndVo> listTemp = this.numidService.pdjjr();
        Map map = new HashMap();
        for (WeekEndVo week : listTemp) {
            if ("SAT".equals(week.getCsmc()))
                map.put("6", week.getCsz2());
            else if ("SUN".equals(week.getCsmc())) {
                map.put("7", week.getCsz2());
            }
        }
        if (etList != null && etList.contains(deptCode)) {
            if ("1".equals(map.get(rqpd))) {
                return this.numidService.getMzlbGHFET("2");
            } else {
                return this.numidService.getMzlbGHFET("1");
            }
        } else {
            if ("1".equals(map.get(rqpd))) {
                return this.numidService.getMzlbGHF("2");
            } else {
                return this.numidService.getMzlbGHF("1");
            }
        }
    }


    //节假日挂号费
    private String getHolidaysCost(String holiday, List<String> list) {
        if (StringUtils.hasText(holiday)) {
            String holidayStr = holiday.substring(4, 8);
            if ((!list.isEmpty()) && list.contains(holidayStr)) {
                return this.numidService.getMzlbGHF("2");
            }
        }
        return null;
    }

    //节假日获取儿童的挂号费
    private String getHolidaysCostET(String holiday, List<String> list) {
        if (StringUtils.hasText(holiday)) {
            String holidayStr = holiday.substring(4, 8);
            if ((!list.isEmpty()) && list.contains(holidayStr)) {
                return this.numidService.getMzlbGHFET("2");
            }
        }
        return null;
    }

    @Override
    public GhsfVo selectTodayGhsf(GhInVo ghInVo) {
        GhsfVo temp = hospitalInfoDao.selectTodayGhsf(ghInVo);
        if (temp != null && temp.getDocname() == null) {
            List<String> holidaysList = this.numidService.getHolidays();
            List<String> etList = numidService.getETksdm();
            String holidayFee = "";
            if (etList != null && etList.contains(temp.getDeptCode())) {
                holidayFee = getHolidaysCostET(DateUtil.getDayStr(), holidaysList);
            } else {
                holidayFee = getHolidaysCost(DateUtil.getDayStr(), holidaysList);
            }
            if (StringUtils.hasText(holidayFee)) {
                temp.setTreatfee(Double.parseDouble(holidayFee));
            }

            //判断双休日的普通门诊的挂号费
            Integer rqpd = DateUtil.getWeekOfDate();
            if (rqpd == 7 || rqpd == 6) {
                String jzFeel = pdWeekEnd(rqpd + "", temp.getDeptCode());
                if (jzFeel != null) {
                    temp.setTreatfee(Double.parseDouble(jzFeel));
                }
            }
        }
        return temp;
    }

    @Override
    public String getJzXH(String jlxh) {
        return hospitalInfoDao.getJzXH(jlxh);
    }

}
