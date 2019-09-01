package com.hospital.serviceImpl.prepaidInHospitalServiceImpl;

import com.hospital.common.PayMode;
import com.hospital.dao.prepaidInHospital.PrepaidDao;
import com.hospital.domain.PrepaidVo;
import com.hospital.out.clinicPayInter.*;
import com.hospital.out.hospital.PayDetaileList;
import com.hospital.out.hospital.PaymenTrecordVo;
import com.hospital.service.prepaidInHospitalService.PrepaidInHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * User: xiaofu
 * Date: 2017/11/10
 * Time: 10:33
 * Function:
 */
@Service
public class PrepaidInHospitalServiceImpl implements PrepaidInHospitalService {

    @Autowired
    private PrepaidDao prepaidDao;

    @Override
    public ZYPatientVo getZYPatientVoBySFZH(String sfzh) {
        if (StringUtils.hasText(sfzh)) {
            ZYPatientVo zypatientVo = prepaidDao.getZYPatientVoBySFZH(sfzh);
            if(zypatientVo !=null && StringUtils.hasText(zypatientVo.getPatientcode())){
                String sum = prepaidDao.prepaidFunds(zypatientVo.getPatientcode());
                zypatientVo.setPayamount(sum);
                zypatientVo.setTotalamount("0");
                zypatientVo.setArrearageamount("0");
            }
            return zypatientVo;
        }
        return null;
    }

    @Override
    public TotalCostInventoryVo oneDayItems(String begintime, String endtime, String patientNo) {


        if (StringUtils.hasText(begintime) && StringUtils.hasText(endtime) && StringUtils.hasText(patientNo)) {

            List<CostInventoryVo> maincostlist = prepaidDao.oneDayItems(begintime, endtime, patientNo);
            List<CostMap> costMaps = getCostMap();

            TotalCostInventoryVo totalCostInventoryVo = new TotalCostInventoryVo();

            if (maincostlist != null && !maincostlist.isEmpty()) {
                List<InventoryVo> list = new ArrayList<>();
                for (CostMap costMap : costMaps) {
                    List<CostInventoryVo> costList = new ArrayList<>();
                    InventoryVo invo = new InventoryVo();
                    Double count = 0.0;
                    for (CostInventoryVo vo : maincostlist) {
                        if (costMap.getCostCode().equals(vo.getFygl())) {
                            costList.add(vo);
                            count += Double.valueOf(vo.getCostSubtotal());
                        }
                    }
                    if (!costList.isEmpty()) {
                        invo.setAmount(count + "");
                        invo.setChargeName(costMap.getCostName());
                        invo.setCostList(costList);
                    }
                    list.add(invo);
                }

                List<InventoryVo> listresult = new ArrayList<>();
                if (!list.isEmpty()) {
                    Double countCost = 0.0;
                    for (InventoryVo inventoryVo : list) {
                        if (inventoryVo.getAmount() == null) {
                            continue;
                        }
                        countCost += Double.valueOf(inventoryVo.getAmount());
                        listresult.add(inventoryVo);
                    }
                    totalCostInventoryVo.setMaincostlist(listresult);
                    totalCostInventoryVo.setTotalcost(countCost + "");
                    return totalCostInventoryVo;
                }
            }
        }
        return null;
    }

    @Override
    public List<CostMap> getCostMap() {
        return prepaidDao.getCostMap();
    }

    @Override
    @Transactional
    public String getPrepaidJLXH() {
        Integer temp=prepaidDao.updatePrepaidJLXH();
        Integer id = prepaidDao.selectPrepaidJLXH();
        return id+"";


    }

    @Override
    public Integer insertVo(PrepaidVo prepaidVo) {
        String ljxh = getPrepaidJLXH();
        if (!StringUtils.hasText(ljxh)) {
            return null;
        }
        prepaidVo.setJlxh(ljxh);
        return prepaidDao.insertPrepaidFunds(prepaidVo);
    }

    @Override
    public PayDetaileList selectDetailedList(String sfzh) {
        PayDetaileList payDO = new PayDetaileList();
        List<PaymenTrecordVo> list = prepaidDao.selectDetailedList(sfzh);
        if (list != null && !list.isEmpty()) {
            Double payedamount = 0.0;
            for (PaymenTrecordVo temp : list) {
                temp.setPayMode(PayMode.getCodeName(temp.getPayMode()));
                payedamount += Double.valueOf(temp.getPayAmount());
            }
            payDO.setPayedamount(payedamount + "");
            payDO.setPaymentrecord(list);
            return payDO;
        }
        return null;
    }
}
