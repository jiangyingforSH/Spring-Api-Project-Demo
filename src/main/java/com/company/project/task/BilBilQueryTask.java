package com.company.project.task;

import com.company.project.utils.DateTimUtil;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jiangying
 * @title: BilBilQueryTask
 * @projectName spring-boot-api-project-seed
 * @description: TODO
 * @date 2020/8/910:05 下午
 */

@Component
public class BilBilQueryTask {
    DateTimUtil dateUtil = new DateTimUtil();

    @Scheduled(cron = "0/2 * * * * ?")
    public void TaskJob(){
        System.out.println("定时任务开始执行,当前时间："+dateUtil.getDateTimeToString());
    }
}
