package com.hospital.dao.HospitalInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * User: xiaofu
 * Date: 2018-5-29
 * Time: 16:53
 * Function:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalInfoDaoTest {


    @Autowired
    private HospitalInfoDao hospitalInfoDao;

    @Test
    public void getHospitalInfo() throws Exception {
      //  List<HospitalVo> hospInfo = hospitalInfoDao.getHospitalInfo();
       //System.out.println(hospInfo.size());
    }


}