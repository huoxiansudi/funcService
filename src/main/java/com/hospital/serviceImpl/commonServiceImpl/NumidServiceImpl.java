package com.hospital.serviceImpl.commonServiceImpl;

import com.hospital.dao.commonDao.NumidDao;
import com.hospital.domain.WeekEndVo;
import com.hospital.domain.YyghInVo;
import com.hospital.out.hospital.PbHyVo;
import com.hospital.service.commonService.NumidService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jinhs on 2017-11-30.
 */
@Service
public class NumidServiceImpl implements NumidService {

    Logger logger = Logger.getLogger(NumidService.class);

    @Autowired
    private NumidDao numidDao;

    @Override
    public PbHyVo getNumid(YyghInVo yyghInVo) {
        return numidDao.getNumid(yyghInVo);
    }

    @Override
    public void updateYybz() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String today = df.format(new Date());
        List<String> list = numidDao.findTodayPBBH();
        List<String> listyy = numidDao.findYyPBBH(today);
        if (listyy.isEmpty()) {
            logger.info("没有要更新的预约排班数量");
        } else {
            logger.info("更新的预约排班数量：" + listyy.size());
            logger.info("更新的预约排班编号：" + listyy.toString());
            Integer sumyy = 0;
            List<String> sumStryy = new ArrayList<>();
            for (String stry : listyy) {
                if (StringUtils.hasText(stry)) {
                    Integer tempyy = numidDao.updateYybz(stry);
                    if (tempyy > 0) {
                        sumStryy.add(stry);
                        sumyy++;
                    }
                }
            }
            logger.info("更新完的预约排班数量：" + sumyy);
            logger.info("更新完的预约排班编号：" + sumStryy.toString());
        }
        if (list.isEmpty()) {
            logger.info("没有要更新的当天排班数量");
        } else {
            logger.info("更新的当天排班数量：" + list.size());
            logger.info("更新的当天排班编号：" + list.toString());
            Integer sum = 0;
            List<String> sumStr = new ArrayList<>();
            for (String str : list) {
                if (StringUtils.hasText(str)) {
                    Integer temp = numidDao.updateYybz(str);
                    if (temp > 0) {
                        sumStr.add(str);
                        sum++;
                    }
                }
            }
            logger.info("更新完的当天排班数量：" + sum);
            logger.info("更新完的当天排班编号：" + sumStr.toString());


        }
    }


    @Override
    public List<WeekEndVo> pdjjr() {
        return numidDao.getWeekEndParameter();
    }

    @Override
    public String getMzlbGHF(String mzlb) {
        return numidDao.getMzlbGHF(mzlb);
    }

    @Override
    public List<String> getHolidays() {
        return numidDao.getHolidays();
    }


    @Override
    public String getMzlbGHFET(String mzlb) {
        return numidDao.getMzlbGHFet(mzlb);
    }

    @Override
    public List<String> getETksdm() {
        return numidDao.getETksdm();
    }
}
