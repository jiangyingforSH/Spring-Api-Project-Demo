package com.company.project.utils;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiangying
 * @title: DateTimUtil
 * @projectName spring-boot-api-project-seed
 * @description: TODO
 * @date 2020/8/910:14 下午
 */
public class DateTimUtil {
    private static SimpleDateFormat sdf;

    public String getDateTimeToString(){
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    @Test
    public void test(){
        System.out.println(getDateTimeToString());
    }
}
