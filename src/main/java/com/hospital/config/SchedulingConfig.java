package com.hospital.config;

import com.hospital.service.commonService.NumidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * Created by fuxf on 2017/8/4.
 */

@Component
public class SchedulingConfig {

    @Autowired
    private NumidService numidService;

    @Scheduled(cron = "0 50 14 * * ?")
    public void scheduler() {
        System.out.println("14:50分钟执行！！！！！！！");
        numidService.updateYybz();
    }

}
