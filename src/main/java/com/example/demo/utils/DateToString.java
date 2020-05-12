package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateToString {
    /**
     * 将日期类型转成格式化后的时间字符串
     * @param date 日期
     * @return 返回格式化后的时间字符串
     */
    public static String format(Date date){
        //传入的时间为空直接返回null
        if (date == null){
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);//返回格式化后的时间字符串
    }

}