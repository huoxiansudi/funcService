package com.hospital.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hospital.common.*;
import com.hospital.domain.*;
import com.hospital.out.InHosInter.RegistSettleVo;
import com.hospital.out.clinicPayInter.*;
import com.hospital.out.hospital.*;
import com.hospital.out.inspectInter.AssDetailVo;
import com.hospital.out.inspectInter.AssayVo;
import com.hospital.out.inspectInter.InspectVo;
import com.hospital.out.quenCallInter.DeptVo;
import com.hospital.service.clinicPayService.PayService;
import com.hospital.service.hospitalService.HospitalInfoService;
import com.hospital.service.inspectService.AssayService;
import com.hospital.service.prepaidInHospitalService.PrepaidInHospitalService;
import com.hospital.service.quenCallService.DeptInfoService;
import com.hospital.service.visitListHospService.VisitListHospService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by fuxf on 2017/8/3.
 */
@RestController
public class StatusController {

    Logger logger = Logger.getLogger(StatusController.class);

    @Value("${pay.czgh}")
    private String czgh;
    /*
    @Autowired
    private NumidService numidService;*/
    @Autowired
    private HospitalInfoService hospitalInfoService;
    @Autowired
    private DeptInfoService deptInfoService;
    @Autowired
    private AssayService assayService;
    @Autowired
    private PayService payService;
    @Autowired
    private VisitListHospService visitListHospService;
    @Autowired
    private PrepaidInHospitalService prepaidInHospitalService;



    //身份证判断
    private static ResultModel judgeIdCard(String idcard) {
        try {
            String idTemp = IdCardExpUtil.IDCardValidate(idcard);
            if (!"身份证号码正确".equals(idTemp)) {
                return ResultModel.failResultModel(idTemp);
            }
        } catch (ParseException e) {
            return ResultModel.failResultModel("服务器内部错误!!!");
        }
        return null;
    }

    /**
     * 测试接口
     * @return
     */
    @RequestMapping(value = "/100101", method = RequestMethod.POST)
    public ResultModel statusTest() {
        return ResultModel.SuccessResultModel("服务器正常。。。");
    }

    @RequestMapping(value = "/service")
    public ResultModel funMain(@RequestBody String jsonObject) {
        JSONObject objectJson = JSON.parseObject(jsonObject);
        String funCode = objectJson.getString("funcode");
        logger.info("访问接口:" + funCode);
        logger.info("访问参数:" + objectJson);
        switch (funCode) {
            case "100101"://接口状态监测
                //更新web_ghksxx
                //hospitalInfoService.updateKsxx();

                return ResultModel.SuccessResultModel("服务器正常。。。");
            case "100201"://医院信息查询
                List<HospitalVo> hospitalInfo = hospitalInfoService.getHospitalInfo();
                return ResultModel.SuccessListResultModel(hospitalInfo);
            case "100202"://医院科室查询
                List<DepartmentVo> list = hospitalInfoService.getListDepart();
                return ResultModel.SuccessListResultModel(list);
            case "100203"://医院医生查询
                String deptid = objectJson.getString("deptid");
                List<DoctorVo> doctorlist = hospitalInfoService.getListDoc(deptid);
                return ResultModel.SuccessListResultModel(doctorlist);
            case "100204"://医院排班查询
                String platdeptid = objectJson.getString("platdeptid");
                List<DoctorPbVo> listPb = hospitalInfoService.getListDoctorPb(platdeptid);
                return ResultModel.SuccessListResultModel(listPb);
            case "100205"://排班号源查询
                String schid = objectJson.getString("schid");
                String ampm = objectJson.getString("ampm");
                if (!(StringUtils.hasText(schid) && StringUtils.hasText(ampm))) {
                    return ResultModel.failResultModel("必传参数没有!!!!");
                }
                List<PbHyVo> listPbHyVo = hospitalInfoService.getPbHyVo(schid, ampm);
                return ResultModel.SuccessListResultModel(listPbHyVo);
            case "100206":  //患者注册
                PatientInVo registInVo = objectJson.toJavaObject(PatientInVo.class);
                //判断是否为空
                if (registInVo == null || !StringUtils.hasText(registInVo.getPatid()) || !StringUtils.hasText(registInVo.getPatname())
                        || !StringUtils.hasText(registInVo.getPatsex()) || !StringUtils.hasText(registInVo.getIdcard())
                        || !StringUtils.hasText(registInVo.getMobileno()) || !StringUtils.hasText(registInVo.getAddress())) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                String sfzh = registInVo.getIdcard();
                String birth = IdCardExpUtil.getIdCardByBirth(sfzh);
                Date bir = null;
                if ("false".equals(birth)) {
                    return ResultModel.failResultModel("身份证号码错误");
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    bir = simpleDateFormat.parse(birth);
                } catch (ParseException e) {
                    return ResultModel.failResultModel("出生日期转换出错");
                }
                //是否自费
                registInVo.setCsrq(bir);
                //患者编号+FY做区别
                String patid = "FY" + registInVo.getPatid();
                if (StringUtils.hasText(registInVo.getMedcardno())) {
                    //医保卡号存在
                    patid = registInVo.getMedcardno();
                }
                registInVo.setBrlb("1");
                registInVo.setBrxzdm("1");
                registInVo.setPatid(patid);
                //查询患者是否已存在
                PatientVo patientVo = hospitalInfoService.selectPatientByJzkh(registInVo.getPatid());
                if (patientVo == null) {
                    //添加患者信息
                    int temp = hospitalInfoService.insertPatient(registInVo);
                } else {
                    return ResultModel.failResultModel("添加的患者信息已存在！");
                }

                return ResultModel.SuccessRegistResultModel(registInVo.getPatid());
            case "100207"://患者信息修改
                PatientInVo registInVo2 = objectJson.toJavaObject(PatientInVo.class);
                //判断是否为空
                if (registInVo2 == null || !StringUtils.hasText(registInVo2.getPatid()) || !StringUtils.hasText(registInVo2.getPatname())
                        || !StringUtils.hasText(registInVo2.getPatsex()) || !StringUtils.hasText(registInVo2.getMobileno())) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                int temp2 = hospitalInfoService.updatePatient(registInVo2);
                return ResultModel.SuccessResultModelInfo();
            case "100208": //预约挂号
                YyghInVo yyghInVo = objectJson.toJavaObject(YyghInVo.class);
                //判断是否为空
                if (yyghInVo == null || !StringUtils.hasText(yyghInVo.getRegid()) || !StringUtils.hasText(yyghInVo.getNumid())
                        || !StringUtils.hasText(yyghInVo.getPatid()) || !StringUtils.hasText(yyghInVo.getVisitdate())
                        || !StringUtils.hasText(yyghInVo.getPass()) || !StringUtils.hasText(yyghInVo.getNo())) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                PatientInVo patient = new PatientInVo();

                String yyjzrq = DateUtil.formatToDate(yyghInVo.getVisitdate()); //就诊日期(YYYYMMDD)转换为（yyyy-MM-dd）
                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                String date = fmt.format(new Date()).toString();
                if (yyjzrq.equals(date)) {
                    return ResultModel.failResultModel("不能预约当天号码");
                }
                yyghInVo.setVisitdate(yyjzrq);

                /*//判断号源是否存在
                PbHyVo pbHyVo = numidService.getNumid(yyghInVo);
                //预约
                //挂号*/

                NumOrigin numDo = hospitalInfoService.getDoctorPbVoByNumId(yyghInVo.getNumid());

                //判断用户信息是否存在
                patient.setPatid(yyghInVo.getPatid());
                PatientVo patientInfo = hospitalInfoService.selectPatientByJzkh(yyghInVo.getPatid());
                if (patientInfo == null || patientInfo.getPatid() == null) {
                    return ResultModel.failResultModel(AppointmentCodeState.getCode("CODE_22010002"));
                }

                GhkVo ghkVo = new GhkVo();
                ghkVo.setCheckid(yyghInVo.getPass());
                ghkVo.setGhxh(yyghInVo.getNo());
                ghkVo.setJzkh(yyghInVo.getPatid());
                ghkVo.setYylb("3");//网上预约类型都是3
                ghkVo.setSfzh(patientInfo.getIdcard());
                ghkVo.setXb(patientInfo.getPatsex());
                ghkVo.setXm(patientInfo.getPatname());
                ghkVo.setNumid(yyghInVo.getNumid());
                ghkVo.setZt("0");
                ghkVo.setJtzz(patientInfo.getAddress());
                ghkVo.setThbz("0");
                if (numDo != null) {
                    ghkVo.setKsdm(numDo.getDeptCode());
                    ghkVo.setMzlbxh(numDo.getMzlbxh());
                    ghkVo.setYsgh(numDo.getDocterCode());
                }
                ghkVo.setLxdh(patientInfo.getMobileno());
                ghkVo.setPbxh(yyghInVo.getSchid());
                ghkVo.setYysj(yyghInVo.getAmpm());
                ghkVo.setUserid(yyghInVo.getRegid());
                ghkVo.setXxczid(yyghInVo.getOper());
                ghkVo.setDjrq(DateUtil.getCurrentDate());
                ghkVo.setThbz("0");
                ghkVo.setCzgh(czgh);
                if (StringUtils.hasText(yyghInVo.getVisitdate())) {
                    ghkVo.setYyrq1(yyghInVo.getVisitdate());
                    ghkVo.setYyrq2(yyghInVo.getVisitdate() + " 23:59:59");
                }
                String ghxh = hospitalInfoService.insertMzYyk(ghkVo);
                if (StringUtils.hasText(ghxh)) {
                    if (org.apache.commons.lang3.StringUtils.isNumeric(ghxh)) {
                        return ResultModel.SuccessYyghResultModel(ghxh);
                    }
                    return ResultModel.failResultModel(ghxh);
                }

                return ResultModel.failResultModel("预约失败");

            case "100209":

                return ResultModel.SuccessResultModelInfo();

            case "100210": //号源释放
                YyghInVo yyghInVo2 = objectJson.toJavaObject(YyghInVo.class);

                //判断是否为空
                if (yyghInVo2 == null || !StringUtils.hasText(yyghInVo2.getNumid())) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                if (StringUtils.hasText(yyghInVo2.getRegid())) {
                    Integer unlockDo = hospitalInfoService.unLockNum(yyghInVo2.getNumid());
                    if (unlockDo > 0) {
                        return ResultModel.SuccessResultModelInfo();
                    } else {
                        ResultModel.failResultModel("号源释放失败");
                    }
                }
                if (yyghInVo2.getNumdate() != null) {
                    String yyjzrq2 = DateUtil.formatToDate(yyghInVo2.getNumdate());//预约日期(YYYYMMDD)转换为（yyyy-MM-dd）
                    yyghInVo2.setNumdate(yyjzrq2);
                }

                int updateGhk = hospitalInfoService.updateGhk(yyghInVo2);
                if (updateGhk > 0) {
                    Integer unlockDo = hospitalInfoService.unLockNum(yyghInVo2.getNumid());
                    if (unlockDo > 0) {
                        return ResultModel.SuccessResultModelInfo();
                    } else {
                        ResultModel.failResultModel("挂号库状态取消，但是号源释放失败");
                    }
                }
                return ResultModel.failResultModel("号源释放失败");

            case "100211":
                String schid100211 = objectJson.getString("schid");
                String begindate = objectJson.getString("begindate");
                String endate = objectJson.getString("endate");
                if (StringUtils.hasText(begindate) && StringUtils.hasText(endate)) {
                    List<TzlbVo> visitR = visitListHospService.findBy(schid100211, begindate, endate);
                    return ResultModel.SuccessListResultModel(visitR);
                }
                return ResultModel.failResultModel("必要参数未传");
            case "100212":
                String orderid = objectJson.getString("orderid");
                String bdate = objectJson.getString("bdate");
                String edate = objectJson.getString("edate");
                if (StringUtils.hasText(bdate) && StringUtils.hasText(edate)) {
                    if (bdate.length() != 8 || edate.length() != 8) {
                        return ResultModel.failResultModel("必要参数格式不正确");
                    }
                    List<JzlbVo> ls = visitListHospService.findByOrderId(orderid, bdate, edate);
                    return ResultModel.SuccessListResultModel(ls);
                }
                return ResultModel.failResultModel("必要参数未传");
            case "100213": //查询患者信息
                PatientInVo registInVo3 = objectJson.toJavaObject(PatientInVo.class);
                //判断是否为空 || (!StringUtils.hasText(registInVo3.getPatname()))
                if (!StringUtils.hasText(registInVo3.getIdcard())) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                try {
                    String result = IdCardExpUtil.IDCardValidate(registInVo3.getIdcard());
                    if (!"身份证号码正确".equals(result)){
                        return ResultModel.NullPatientModel("身份证有误");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                    return ResultModel.NullPatientModel("身份证有误");
                }
                List<PatientVo> patientVo2 = hospitalInfoService.selectPatient(registInVo3);
                /*if (patientVo2 == null || patientVo2.isEmpty()) {
                    return ResultModel.NullPatientModel("用户不存在！！！");
                }*/
                return ResultModel.SuccessListResultModel(patientVo2);
            case "100214":
                String ksdm = objectJson.getString("platdeptid");
                if (StringUtils.hasText(ksdm)) {
                    List<DoctorPbVo> listTPb = hospitalInfoService.selectTheDayPB(ksdm, DateUtil.getWeekOfDate() + "");
                    return ResultModel.SuccessListResultModel(listTPb);
                }
                return ResultModel.failResultModel("必要参数未传");
            case "100215":
                String currentSchid = objectJson.getString("schid");
                String currentAmpm = objectJson.getString("ampm");
                if (!StringUtils.hasText(currentSchid) || !StringUtils.hasText(currentAmpm)) {
                    return ResultModel.failResultModel("必传参数没有!!!!");
                }
                List<PbHyVo> listCurrentPbHyVo = hospitalInfoService.selectCurrentNum(currentSchid, currentAmpm);
                return ResultModel.SuccessListResultModel(listCurrentPbHyVo);
            case "100216": //挂号(取号)预结算
                GhInVo ghInVo = objectJson.toJavaObject(GhInVo.class);
                //判断是否为空
                if (ghInVo == null || !StringUtils.hasText(ghInVo.getNumid())
                        || !StringUtils.hasText(ghInVo.getPatid()) || !StringUtils.hasText(ghInVo.getVisitdate())
                        || !StringUtils.hasText(ghInVo.getAmpm()) || !StringUtils.hasText(ghInVo.getSchid())) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                String today = DateUtil.dateToString(new Date());
                String visitdate = DateUtil.formatToDate(ghInVo.getVisitdate());
                if (today.equals(visitdate)) { //当天挂号预结算
                    GhsfVo ghsfVo = hospitalInfoService.selectTodayGhsf(ghInVo);
                    if (ghsfVo != null) {
                        hospitalInfoService.lockNum(ghInVo.getNumid()); //号源锁定
                        //获取挂号库的序号
                        int t = hospitalInfoService.updateXhb("GH_GHK");
                        if (t > 0) {
                            int jlxh = hospitalInfoService.selectXhb("GH_GHK");
                            ghsfVo.setRegid(jlxh + "");
                        } else {
                            return ResultModel.failResultModel("获取挂号库的序号错误!!");
                        }
                        return ResultModel.SuccessRegResultModel(ghsfVo);
                    }
                } else {
                    GhsfVo ghsfVo = hospitalInfoService.selectGhsf(ghInVo);
                    if (ghsfVo != null) {
                        hospitalInfoService.lockNum(ghInVo.getNumid()); //号源锁定
                        return ResultModel.SuccessRegResultModel(ghsfVo);
                    }
                }
                return ResultModel.failResultModel("号源已被预约!!!");

            case "100217":// 挂号结算
                RegistSettleVo rv = objectJson.toJavaObject(RegistSettleVo.class);
                if (rv.getPatid() == null || rv.getNumid() == null || rv.getNumno() == null ||
                        rv.getSchid() == null || rv.getAgtordernumber() == null || rv.getPaymode() == null ||
                        rv.getRegid() == null || rv.getPayamount() == null) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                String votemp = hospitalInfoService.insertCurrentGHKVo(rv);
                if ("true".equals(votemp)) {
                    return ResultModel.SuccessVisitNo(rv.getPatid());
                }
                return ResultModel.failResultModel(votemp);
            case "100218":
                String yyxhid = objectJson.getString("orderid");
                String orderState = objectJson.getString("orderState");
                String idcard218 = objectJson.getString("idcard");
                if (idcard218 == null) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                List<SubscribeListVo> list218l = visitListHospService.findAllBySfzh(idcard218, orderState, yyxhid);
                return ResultModel.SuccessListResultModel(list218l);
            case "100219":// 挂号列表状态查询
                String preid = objectJson.getString("preid");
                if (preid == null || preid.equals("")) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                GhsfVo ghsfVo = hospitalInfoService.getGhxx(preid);//通过jlxh查询挂号库信息
                if (ghsfVo == null) {
                    return ResultModel.failResultModel("该挂号信息不存在");
                }
                String jzbs = hospitalInfoService.getJzXH(ghsfVo.getJlxh());
                if (StringUtils.hasText(jzbs)) {
                    return ResultModel.SuccessGhxxModelInfo("2");//2代表已就诊
                }
                if (StringUtils.hasText(ghsfVo.getGhrq()) && DateUtil.compareDate(ghsfVo.getGhrq()) < 0) {
                    return ResultModel.SuccessGhxxModelInfo("3");//3代表未就诊
                }
                GhsfVo thxxVo = hospitalInfoService.getThxx(ghsfVo);//thbz=1的信息
                if (thxxVo != null) {
                    return ResultModel.SuccessGhxxModelInfo("4");//4代表已退号
                }
                return ResultModel.SuccessGhxxModelInfo("0");//0代表挂号正常
            case "100301": //患者叫号
                DeptInVo deptInVo = objectJson.toJavaObject(DeptInVo.class);

                //判断是否为空
                if (!StringUtils.hasText(deptInVo.getIdcard())) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                //(通过身份证)获取基本信息
                List<DeptVo> deptInfo = deptInfoService.getDeptInfo(deptInVo);

                if (deptInfo.size() == 0) {
                    return ResultModel.failResultModel("此身份证在当天没有叫号信息！！！");
                }

                if (deptInfo != null && deptInfo.size() > 0) {
                    for (DeptVo deptVo : deptInfo) {
                        /** 通过判断 就诊标识 查看是否就诊，若已就诊，不用显示 "当前叫到的号码和排队人数"
                         */
                        /*if (!"1".equals(deptVo.getJzbs())) {
                            //通过ksdm获取已就诊的最大日期(mzlbxh<3)
                            Date jzrq = deptInfoService.selectJzrqByKsdm(deptVo.getDeptid());
                            deptInVo.setJzsj(jzrq);
                            deptInVo.setDeptid(deptVo.getDeptid());
                            //通过日期查询 获取 当前叫到的号码
                            DeptVo deptJzrqVo = deptInfoService.selectGhxhByJzrq(deptInVo);

                            if( deptJzrqVo != null) {
                                deptVo.setNewnumber(deptJzrqVo.getGhnumber());
                                deptInVo.setSjlb(deptJzrqVo.getVisittype());
                            }
                            //通过上下午查询 总叫号数
                            int zs = deptInfoService.selectZghsBySjlb(deptInVo);
                            if(deptVo.getNewnumber() !=null) {
                                int befNum = zs - Integer.parseInt(deptVo.getNewnumber());
                                deptVo.setBeforenum(String.valueOf(befNum));
                            }
                        }*/

                        deptVo.setNewnumber("3");
                        deptVo.setBeforenum("17");
                    }
                }
                return ResultModel.SuccessListResultModel(deptInfo);

            case "100302": //专家科室叫号
                DeptInVo deptInVo2 = objectJson.toJavaObject(DeptInVo.class);

                //判断是否为空
                if (!StringUtils.hasText(deptInVo2.getDeptid())) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                List<DeptVo> deptInfoList = null;
                if (!StringUtils.hasText(deptInVo2.getDocid())) {

                    //(通过科室编号)获取普通叫号的基本信息
                    deptInfoList = deptInfoService.getNormalInfo(deptInVo2);
                } else {
                    //(通过科室编号和医生编号)获取专家号的基本信息
                    deptInfoList = deptInfoService.getDeptSpecialInfo(deptInVo2);
                }

                if (deptInfoList.size() == 0) {
                    return ResultModel.failResultModel("此科室当天没有叫号信息！！！");
                }
                if (deptInfoList != null && deptInfoList.size() > 0) {
                    for (DeptVo deptVo : deptInfoList) {
                        /** 通过判断 就诊标识 查看是否就诊，若已就诊，不用显示 "当前叫到的号码和排队人数"
                         */
                        /*if (!"1".equals(deptVo.getJzbs())) {
                            //获取已就诊的最大日期
                            Date jzrq = deptInfoService.selectJzrqByYsgh(deptVo.getDocid());
                            deptInVo2.setJzsj(jzrq);
                            deptInVo2.setDocid(deptVo.getDocid());
                            //通过日期查询 获取 当前叫到的号码
                            DeptVo deptJzrqVo = deptInfoService.selectGhxhByYsgh(deptInVo2);

                            if( deptJzrqVo != null) {
                                deptVo.setNewnumber(deptJzrqVo.getGhnumber());
                            }
                        }*/
                        deptVo.setNewnumber("3");
                    }
                }

                return ResultModel.SuccessListResultModel(deptInfoList);
            case "100401":
                InspectInVo inspectInVo = objectJson.toJavaObject(InspectInVo.class);
                if (StringUtils.hasText(inspectInVo.getIdcard())  &&
                        inspectInVo.getBdate() != null &&
                        inspectInVo.getEdate() != null) {
                    inspectInVo.setEdate(DateUtil.setDate(inspectInVo.getEdate()));
                    List<InspectVo> inspectVo = assayService.getInspectVo(inspectInVo);
                    if (inspectVo != null && inspectVo.size() > 0) {
                        return ResultModel.SuccessListResultModel(inspectVo);
                    } else {
                        return ResultModel.SuccessResultModel("数据为空");
                    }
                }
                return ResultModel.failResultModel("必要参数未传!!!");
            case "100402": //检验列表查询
                AssayInVo assayInVo = objectJson.toJavaObject(AssayInVo.class);
                //判断是否为空
                if (!StringUtils.hasText(assayInVo.getIdcard()) ||
                        assayInVo.getBdate() == null ||
                        assayInVo.getEdate() == null) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                assayInVo.setEdate(DateUtil.setDate(assayInVo.getEdate()));
                List<AssayVo> assayInfo = assayService.getAssayInfo(assayInVo);
                if (assayInfo != null && assayInfo.size() > 0) {
                    return ResultModel.SuccessListResultModel(assayInfo);
                }
                return ResultModel.SuccessResultModel("数据为空");
            case "100403":
                String assayno = objectJson.getString("assayno");
                //判断是否为空
                if (!StringUtils.hasText(assayno)) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                List<AssDetailVo> assayInfo2 = assayService.getAssDetailInfo(assayno);
                for (AssDetailVo detailVo : assayInfo2) {
                    String resultstate = detailVo.getResultstate();
                    //判断是否为空
                    if (!StringUtils.hasText(resultstate)) {
                        detailVo.setResultstate("无检验结果");
                    } else {
                        resultstate = resultstate.substring(0, 1);
                        if ("A".equals(resultstate)) {
                            detailVo.setResultstate("0");
                        } else if ("B".equals(resultstate)) {
                            detailVo.setResultstate("1");
                        } else if ("C".equals(resultstate)) {
                            detailVo.setResultstate("3");
                        }
                    }
                }
                return ResultModel.SuccessAssayResultModel(assayInfo2);
            case "100501":
                UnpaidInVo unpaidInVo = objectJson.toJavaObject(UnpaidInVo.class);
                //判断是否为空
                if (!StringUtils.hasText(unpaidInVo.getIdcard())) {
                    return ResultModel.failResultModel("身份证不能为空");
                }
                //总费用
                List<UnpaidVo> zfyInfo = new ArrayList<UnpaidVo>();
                //处方费用
                List<UnpaidVo> unpaidInfo = payService.getUnpaidInfo(unpaidInVo);
                String jzkh = "";
                if (unpaidInfo != null && unpaidInfo.size() > 0) {
                    jzkh = unpaidInfo.get(0).getPatientcode();//获取就诊卡号
                }

                List<UnpaidVo> totalCfFee = payService.getTotalFee(jzkh);
                //判断费用属于哪个归别
                for (int i = 0; i < totalCfFee.size(); i++) {
                    String fygb = totalCfFee.get(i).getFygb();
                    String cfsb = totalCfFee.get(i).getIdentificationnumber();
                    Double fee = Double.parseDouble(DataTransfer.getData(totalCfFee.get(i).getTotalcost()));

                    for (int j = 0; j < unpaidInfo.size(); j++) {
                        String listFygb = unpaidInfo.get(j).getFygb();
                        String listCfsb = unpaidInfo.get(j).getIdentificationnumber();
                        if (fygb.equals(listFygb) && cfsb.equals(listCfsb)) { //通过fygb和yjsb判断是哪个费用
                            unpaidInfo.get(j).setTotalcost(fee);
                        }
                    }
                }
                zfyInfo.addAll(unpaidInfo);
                //(不含皮试)医技费用
                List<UnpaidVo> yjInfo = payService.getYjInfo(unpaidInVo);
                String jzkh2 = "";//获取就诊卡号
                if (yjInfo != null && yjInfo.size() > 0) {
                    jzkh2 = yjInfo.get(0).getPatientcode();
                }

                //(含皮试）医技费用
                for (int j = 0; j < unpaidInfo.size(); j++) {
                    String listCfsb = unpaidInfo.get(j).getIdentificationnumber();
                    List<UnpaidVo> yjPsInfo = payService.getYjPsInfo(listCfsb);
                    if(yjPsInfo != null && yjPsInfo.size()>0){
                        yjInfo.addAll(yjPsInfo);
                    }
                }

                List<UnpaidVo> totalYjFee = payService.getYjFee(jzkh2);
                //判断费用属于哪个归别
                for (int i = 0; i < totalYjFee.size(); i++) {
                    String fygb = totalYjFee.get(i).getFygb();
                    String yjsb = totalYjFee.get(i).getIdentificationnumber();
                    Double fee = Double.parseDouble(DataTransfer.getData(totalYjFee.get(i).getTotalcost()));

                    for (int j = 0; j < yjInfo.size(); j++) {
                        String listFygb = yjInfo.get(j).getFygb();
                        String listYjsb = yjInfo.get(j).getIdentificationnumber();
                        if (fygb.equals(listFygb) && yjsb.equals(listYjsb)) { //通过fygb和yjsb判断是哪个费用
                            yjInfo.get(j).setTotalcost(fee);
                        }
                    }
                }
                zfyInfo.addAll(yjInfo);

                if (zfyInfo == null || zfyInfo.size() == 0) {
                    return ResultModel.NullPatientModel("未查到该患者的待支付信息");
                }
                //若医生要取回，先让处方和医技解锁
                if (unpaidInfo != null && unpaidInfo.size() > 0) {
                    for(UnpaidVo unpaidVo:unpaidInfo){
                        int tt = payService.updateMzcfk1(unpaidVo.getIdentificationnumber());
                    }
                    for(UnpaidVo unpaidVo:yjInfo){
                        int tt2 = payService.updateMzyjk1(unpaidVo.getIdentificationnumber());
                    }
                }

                return ResultModel.SuccessListResultModel(zfyInfo);
            case "100502":
                PaidDetailInVo paidDetailInVo = objectJson.toJavaObject(PaidDetailInVo.class);
                //判断是否为空
                if (!StringUtils.hasText(paidDetailInVo.getIdentificationnumber()) || !StringUtils.hasText(paidDetailInVo.getMedicalprescription())) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                //获取费用基本信息null
                CostVo costVo = null;
                List<PaidDetailVo> paidDetailInfo = null;
                if (paidDetailInVo.getMedicalprescription().equals("1")) {
                    //"1"  处方费用信息
                    costVo = payService.getPaidBasicInfo(paidDetailInVo);
                    costVo.setTotalcost(Double.parseDouble(DataTransfer.getData(costVo.getTotalcost())));
                    //获取费用详细信息
                    paidDetailInfo = payService.getPaidDetailInfo(paidDetailInVo);
                } else if (paidDetailInVo.getMedicalprescription().equals("2")) {
                    costVo = payService.getPaidBasicYjInfo(paidDetailInVo);
                    costVo.setTotalcost(Double.parseDouble(DataTransfer.getData(costVo.getTotalcost())));
                    paidDetailInfo = payService.getPaidDetailYjInfo(paidDetailInVo);
                }

                //将结果赋值到costVo中
                if (costVo != null && paidDetailInfo != null && paidDetailInfo.size() > 0) {
                    costVo.setList(paidDetailInfo);
                }
                if (costVo == null) {
                    return ResultModel.failResultModel("未查到支付详情");
                }

                return ResultModel.SuccessCostResultModel(costVo);
            case "100503":
                PreSettleInVo preSettleInVo = objectJson.toJavaObject(PreSettleInVo.class);
                //判断是否为空
                if (!StringUtils.hasText(preSettleInVo.getIdentificationNumbers())) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                String sbxhs = preSettleInVo.getIdentificationNumbers();
                String[] sbxhList = sbxhs.split("\\|");
                int length = sbxhList.length;
                if (length % 3 != 0) {
                    return ResultModel.failResultModel("识别序号数量不对,请核实");
                }
                jzkh = sbxhList[2];//获取jzkh
                int cfs = payService.getCfs(jzkh);
                int yjs = payService.getYjs(jzkh);
                if ((cfs + yjs) != (length / 3)) {
                    return ResultModel.failResultModel("识别序号匹配不一致,请核实");
                }

                Double totalFee = 0.0;//总费用
                for (int i = 0; i < length; i = i + 3) {
                    String sbxh = sbxhList[i];
                    String lx = sbxhList[i + 1];
                    //通过lx查询相关信息
                    if (lx.equals("1")) {
                        //判断医生是否修改处方
                        int count = payService.getModifyCf(sbxh);
                        if (count == 0) {
                            return ResultModel.failResultModel("医生正在取回处理，请稍后再试");
                        }
                        //判断是否有皮试
                        Integer ps = payService.getPs(sbxh);
                        if(ps > 0){
                            return ResultModel.failResultModel("有皮试药品未做皮试，请先去输液室做皮试");
                        }

                        //处方的费用信息
                        Double totalcost = payService.preSettleInfo(sbxh);

                        BigDecimal a1 = new BigDecimal(String.valueOf(totalFee));
                        BigDecimal b1 = new BigDecimal(String.valueOf(totalcost));
                        BigDecimal c = a1.add(b1);

                        totalFee = c.doubleValue();

                        //医生不能取回，让处方锁定
                        int tt = payService.updateSdMzcfk1(sbxh);

                    } else if (lx.equals("2")) {
                        //判断医生是否修改医技
                        int count = payService.getModifyYj(sbxh);
                        if (count == 0) {
                            return ResultModel.failResultModel("医生正在取回处理，请稍后再试");
                        }
                        //医技的费用信息
                        Double totalcost2 = payService.preSettleYjInfo(sbxh);

                        BigDecimal a2 = new BigDecimal(String.valueOf(totalFee));
                        BigDecimal b2 = new BigDecimal(String.valueOf(totalcost2));
                        BigDecimal c2 = a2.add(b2);

                        totalFee = c2.doubleValue();
                        //医生不能取回，让医技锁定
                        int tt2 = payService.updateSdMzyjk1(sbxh);
                    }
                }
                String data = DataTransfer.getData(totalFee);
                if (data.equals("0.00")) {
                    return ResultModel.failResultModel("没有预结算信息!");
                }

                String settlementinstructions = "费用总额:" + data + "|现金金额:" + data + "账户支付:0.00|统筹基金支付:0.00";//结算说明;
                // String invoicenumber = payService.getFphm();

                ZYPatientVo obj = new ZYPatientVo();
                obj.setSettlementinstructions(settlementinstructions);
                obj.setAmount(data);
                // obj.setInvoicenumber(invoicenumber);

                return ResultModel.SuccessObjResultModel(obj);
            case "100504":
                PayConfirmInVo payConfirmInVo = objectJson.toJavaObject(PayConfirmInVo.class);
                //判断是否为空
                if (!StringUtils.hasText(payConfirmInVo.getIdentificationNumbers()) || !StringUtils.hasText(payConfirmInVo.getAgtordernumber())
                        || !StringUtils.hasText(payConfirmInVo.getPaymode()) /*|| !StringUtils.hasText(payConfirmInVo.getInvoicenumber())*/
                        || !StringUtils.hasText(payConfirmInVo.getPayamount())) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                //支付确认后 新增和更新 操作
                String result = payService.payConfirm(payConfirmInVo);
                if (DateUtil.isNumeric(result)) {
                    return ResultModel.SuccessInvoicenumber(result);
                }
                return ResultModel.failResultModel(result);
            case "100505":
                PayListInVo payListInVo = objectJson.toJavaObject(PayListInVo.class);
                //判断是否为空
                if (!StringUtils.hasText(payListInVo.getIdcard()) ||
                        !StringUtils.hasText(payListInVo.getPatientcode())) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                //查询已支付列表
                List<PayListVo> payListInfo = payService.getPayInfo(payListInVo);

                return ResultModel.SuccessListResultModel(payListInfo);
            case "100506":
                String invoicenumber = objectJson.getString("invoicenumber");
                String patientcode = objectJson.getString("patientcode");
                String idcard1 = objectJson.getString("idcard");
                if (!StringUtils.hasText(invoicenumber) ||
                        !StringUtils.hasText(patientcode)) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                //总费用
                List<PaidVo> zfyPaidInfo = new ArrayList<PaidVo>();
                //处方费用详细信息
                List<PaidVo> paidInfo = payService.getPaidInfo(invoicenumber, patientcode);
                String paidJzkh = "";
                String sbxh = "";
                if (paidInfo != null && paidInfo.size() > 0) {
                    paidJzkh = paidInfo.get(0).getPatientcode();//获取就诊卡号
                    sbxh = paidInfo.get(0).getSfsb();//获取收费识别序号
                }
                List<PaidVo> paidTotalCfFee = payService.getPaidTotalFee(sbxh, paidJzkh);
                //判断费用属于哪个归别
                for (int i = 0; i < paidTotalCfFee.size(); i++) {
                    String fygb = paidTotalCfFee.get(i).getFygb();
                    String cfsb = paidTotalCfFee.get(i).getIdentificationnumber();
                    Double fee = Double.parseDouble(DataTransfer.getData(paidTotalCfFee.get(i).getTotalcost()));
                    for (int j = 0; j < paidInfo.size(); j++) {
                        String listFygb = paidInfo.get(j).getFygb();
                        String listCfsb = paidInfo.get(j).getIdentificationnumber();
                        if (fygb.equals(listFygb) && cfsb.equals(listCfsb)) { //通过fygb和cfsb判断是哪个费用
                            paidInfo.get(j).setTotalcost(fee);
                        }
                    }
                }
                zfyPaidInfo.addAll(paidInfo);
                //医技费用详细信息
                List<PaidVo> yjPaidInfo = payService.getYjPaidInfo(invoicenumber, patientcode);
                if (yjPaidInfo != null && yjPaidInfo.size() > 0) {
                    paidJzkh = yjPaidInfo.get(0).getPatientcode();//获取就诊卡号
                    sbxh = yjPaidInfo.get(0).getSfsb();//获取收费识别序号
                }
                List<PaidVo> paidTotalYjFee = payService.getPaidYjFee(sbxh, paidJzkh);
                //判断费用属于哪个归别
                for (int i = 0; i < paidTotalYjFee.size(); i++) {
                    String fygb = paidTotalYjFee.get(i).getFygb();
                    String yjsb = paidTotalYjFee.get(i).getIdentificationnumber();
                    Double fee = Double.parseDouble(DataTransfer.getData(paidTotalYjFee.get(i).getTotalcost()));
                    for (int j = 0; j < yjPaidInfo.size(); j++) {
                        String listFygb = yjPaidInfo.get(j).getFygb();
                        String listYjsb = yjPaidInfo.get(j).getIdentificationnumber();
                        if (fygb.equals(listFygb) && yjsb.equals(listYjsb)) { //通过fygb和yjsb判断是哪个费用
                            yjPaidInfo.get(j).setTotalcost(fee);
                        }
                    }
                }
                zfyPaidInfo.addAll(yjPaidInfo);

                if (zfyPaidInfo == null || zfyPaidInfo.size() == 0) {
                    return ResultModel.NullPatientModel("未查到该患者的已支付信息");
                }
                return ResultModel.SuccessListResultModel(zfyPaidInfo);

            case "100507":
                PaidDetailInVo paidDetailInVo2 = objectJson.toJavaObject(PaidDetailInVo.class);
                //判断是否为空
                if (!StringUtils.hasText(paidDetailInVo2.getIdentificationnumber()) ||
                        !StringUtils.hasText(paidDetailInVo2.getMedicalprescription())) {
                    return ResultModel.failResultModel("必要参数未传");
                }
                //获取费用基本信息null
                CostVo costVo2 = null;
                List<PaidDetailVo> paidDetailInfo2 = null;
                if (paidDetailInVo2.getMedicalprescription().equals("1")) {
                    //"1"  处方费用信息
                    costVo2 = payService.getPaidBasicInfo2(paidDetailInVo2);
                    //获取费用详细信息
                    paidDetailInfo2 = payService.getPaidDetailInfo2(paidDetailInVo2);
                } else if (paidDetailInVo2.getMedicalprescription().equals("2")) {
                    costVo2 = payService.getPaidBasicYjInfo2(paidDetailInVo2);
                    paidDetailInfo2 = payService.getPaidDetailYjInfo2(paidDetailInVo2);
                }

                //将结果赋值到costVo中
                if (costVo2 != null && paidDetailInfo2 != null && paidDetailInfo2.size() > 0) {
                    /*Double fee = Double.parseDouble(DataTransfer.getData(costVo2.getTotalcost()));
                    costVo2.setTotalcost(fee);*/
                    Double fee = 0.00;
                    for (PaidDetailVo temp : paidDetailInfo2) {
                        //fee += Double.parseDouble(temp.getAmount());
                        fee += temp.getAmount();
                    }
                    costVo2.setTotalcost(Double.parseDouble(DataTransfer.getData(fee)));
                    costVo2.setList(paidDetailInfo2);
                }
                if (costVo2 == null) {
                    return ResultModel.failResultModel("未查到三个月内的已支付详情");
                }

                return ResultModel.SuccessCostResultModel(costVo2);
            case "100701":
                String idcard701 = objectJson.getString("patientidentitycardnumber");
                String paymode = objectJson.getString("paymode");
                String payamount = objectJson.getString("payamount");
                String agtOrderNumber = objectJson.getString("agtOrderNumber");
                if (StringUtils.hasText(idcard701) && StringUtils.hasText(paymode) &&
                        StringUtils.hasText(payamount) && StringUtils.hasText(agtOrderNumber)) {
                    PrepaidVo prepaidVo = new PrepaidVo();
                    if (StringUtils.hasText(idcard701)) {
                        ResultModel objectIdcard = judgeIdCard(idcard701);
                        if (objectIdcard != null) {
                            return objectIdcard;
                        }
                        ZYPatientVo zfvo = prepaidInHospitalService.getZYPatientVoBySFZH(idcard701);
                        prepaidVo.setAgtOrderNumber(agtOrderNumber);
                        prepaidVo.setDepoDate(DateUtil.getCurrentDate());
                        prepaidVo.setIdCard(idcard701);
                        prepaidVo.setName(zfvo.getPatientname());
                        prepaidVo.setPatientNo(zfvo.getPatientcode());
                        if ("1".equals(paymode)) {
                            prepaidVo.setPaymode("99");
                        } else if ("2".equals(paymode)) {
                            prepaidVo.setPaymode("98");
                        } else {
                            prepaidVo.setPaymode("4");
                        }
                        prepaidVo.setPayamount(Double.parseDouble(payamount));
                        prepaidVo.setDeptCode(zfvo.getDeptcode());
                        Integer prepaidTemp = prepaidInHospitalService.insertVo(prepaidVo);
                        if (prepaidTemp > 0) {
                            return ResultModel.SuccessResultModelInfo();
                        }
                        return ResultModel.failResultModel("操作失败");
                    }
                }
                return ResultModel.failResultModel("必要参数未传!!!!");
            case "100702":
                String idcard702 = objectJson.getString("patientidentitycardnumber");
                if (StringUtils.hasText(idcard702)) {
                    ResultModel objectIdcard = judgeIdCard(idcard702);
                    if (objectIdcard != null) {
                        return objectIdcard;
                    }
                    if (StringUtils.hasText(idcard702)) {
                        PayDetaileList detailList = prepaidInHospitalService.selectDetailedList(idcard702);
                        return ResultModel.SuccessPayDetaileList(detailList);
                    }
                }
                return ResultModel.failResultModel("必要参数未传!!!");
            case "100703":
                String patientidentitycardnumber = objectJson.getString("patientidentitycardnumber");
                String costdate = objectJson.getString("costdate");
                if (StringUtils.hasText(patientidentitycardnumber)) {
                    ResultModel objectIdcard = judgeIdCard(patientidentitycardnumber);
                    if (objectIdcard != null) {
                        return objectIdcard;
                    }
                    ZYPatientVo vo = prepaidInHospitalService.getZYPatientVoBySFZH(patientidentitycardnumber);
                    if (vo == null) {
                        return ResultModel.failResultModel("该身份证没有住院信息或者就诊卡没有绑定!!!");
                    }
                    TotalCostInventoryVo voMap = prepaidInHospitalService.oneDayItems(costdate, costdate + " 23:59:59", vo.getPatientcode());
                    if (voMap == null) {
                        return ResultModel.SuccessResultModel("该日期没有住院费用");
                    }
                    return ResultModel.SuccessOneResultModel(voMap);
                }
            case "100704":
                String idcard = objectJson.getString("idcard");
                if (StringUtils.hasText(idcard)) {
                    ResultModel objectIdcard = judgeIdCard(idcard);
                    if (objectIdcard != null) {
                        return objectIdcard;
                    }
                    ZYPatientVo vo = prepaidInHospitalService.getZYPatientVoBySFZH(idcard);
                    if (vo == null) {
                        return ResultModel.failResultModel("没有住院病人信息或者该病人已经出院了!!!!");
                    }
                    return ResultModel.SuccessObjResultModel(vo);
                } else {
                    return ResultModel.failResultModel("必要参数未传");
                }
        }
        return ResultModel.SuccessResultModel("接口编码传送异常！！！");

    }
}
