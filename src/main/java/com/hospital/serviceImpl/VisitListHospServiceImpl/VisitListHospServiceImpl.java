package com.hospital.serviceImpl.VisitListHospServiceImpl;

import com.hospital.common.DateUtil;
import com.hospital.common.PayMode;
import com.hospital.dao.VisitListHosp.VisitListHospDao;
import com.hospital.domain.WeekEndVo;
import com.hospital.out.hospital.JzlbVo;
import com.hospital.out.hospital.MzyykJlxhVo;
import com.hospital.out.hospital.SubscribeListVo;
import com.hospital.out.hospital.TzlbVo;
import com.hospital.service.commonService.NumidService;
import com.hospital.service.visitListHospService.VisitListHospService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: xiaofu
 * Date: 2017/9/27
 * Time: 16:35
 * Function:
 */
@Service
public class VisitListHospServiceImpl implements VisitListHospService {

    @Autowired
    private VisitListHospDao visitListHospDao;
    @Autowired
    private NumidService numidService;

    @Override
    public List<TzlbVo> findBy(String schid, String begindate, String endate) {


        List<TzlbVo> list = visitListHospDao.findBy(schid, begindate, endate);
        for (TzlbVo temp : list) {

            temp.setAmpm("3");
            temp.setReason("12");
        }
        return list;

    }

    @Override
    public List<JzlbVo> findByOrderId(String orderid, String bdate, String edate) {
        List<JzlbVo> vos = visitListHospDao.findByOrderId(orderid, bdate, edate);
        for (JzlbVo jz : vos) {
            if (jz.getCardno() == null) {
                continue;
            }
            if (jz.getCardno().toUpperCase().startsWith("C")) {
                jz.setCardtype("0");
            } else {
                jz.setCardtype("4");
            }
        }
        return vos;

    }

    @Override
    public List<SubscribeListVo> findAllBySfzh(String sfzh, String zt, String orderid) {
        if (StringUtils.hasText(sfzh)) {
            // PageHelper.startPage(1, 5);
            boolean ztTemp = false;
            if ("2".equals(zt)) {
                ztTemp = true;
                zt = "0";
            }

            //修改 GH_MZYYK jlxh=0 ，查询出错问题2019-08-20
            List<MzyykJlxhVo> jlxhList = visitListHospDao.findJlxh(sfzh); //查出jlxh是否为0
            if (!jlxhList.isEmpty()) {
                for (MzyykJlxhVo mzyykJlxhVo : jlxhList) {

                    Integer jlxh = mzyykJlxhVo.getJlxh();
                    if(null !=jlxh && jlxh == 0){
                        visitListHospDao.updateJlxh(sfzh); //更新为0；
                        break;
                    }
                }
            }
            //修改 GH_MZYYK jlxh=0 ，查询出错问题2019-08-20

            List<SubscribeListVo> list = visitListHospDao.findAllBySfzh(sfzh, zt, orderid);

            if (!list.isEmpty()) {
                for (SubscribeListVo vo : list) {
                    if ("0".equals(vo.getOrderState())) {
                        Boolean dateTemp = DateUtil.compareToday(vo.getNumdate());
                        if (!dateTemp) {
                            vo.setOrderState("2");
                        }
                    }
                    if ("1".equals(vo.getAmpm())) {
                        vo.setNumtime("8:00~11:30");
                    } else {
                        vo.setNumtime("13:00~16:30");
                    }

                    if (vo.getDocid() == null) {
                        Integer isWeek = DateUtil.getWeekOfDateFortmatt(vo.getNumdate());
                        if (isWeek == 7 || isWeek == 6) {
                            String jzFeel = pdWeekEnd(isWeek + "");
                            if (jzFeel != null) {
                                vo.setTreatfee(jzFeel);
                            }
                        }
                    }

                    String payNum = vo.getPaystate();
                    if (StringUtils.hasText(payNum)) {
                        String[] str = payNum.split("0000");
                        if (str.length < 2 || str[1] == null) {
                            vo.setPaystate("4");
                        } else {
                            vo.setPaystate(PayMode.getCodeInt(str[1]));
                        }
                    } else {
                        vo.setPaystate("4");
                    }

                    vo.setNumdate(DateUtil.setyyyyMMddDate(vo.getNumdate()));
                    vo.setHospitalname("义乌復元医院");
                    //umdate

                }
                if (ztTemp) {
                    List<SubscribeListVo> listVo = new ArrayList<>();
                    for (SubscribeListVo vo : list) {
                        vo.setHospitalname("义乌復元医院");
                        if ("2".equals(vo.getOrderState())) {
                            listVo.add(vo);
                        }
                    }
                    return listVo;
                }
            }
            return list;
        }
        return null;
    }


    private String pdWeekEnd(String rqpd) {
        List<WeekEndVo> listTemp = this.numidService.pdjjr();
        Map map = new HashMap();
        for (WeekEndVo week : listTemp) {
            if ("SAT".equals(week.getCsmc()))
                map.put("7", week.getCsz2());
            else if ("SUN".equals(week.getCsmc())) {
                map.put("6", week.getCsz2());
            }
        }
        if ("1".equals(map.get(rqpd))) {
            return this.numidService.getMzlbGHF("2");
        }
        return null;
    }
}
