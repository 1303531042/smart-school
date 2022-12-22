package com.kun.util;

import sun.java2d.pipe.SpanIterator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author KUN
 * @date 2022/12/19
 **/
public class DateUtils {

    /**
     *根据时间范围获得月份集
     * @return
     */
    public static List<String> getRangeByMonth(Date begin_date,Date end_date){
        List<String> rangeSet =null;
        SimpleDateFormat sdf = null;
        rangeSet = new java.util.ArrayList<String>();
        sdf = new SimpleDateFormat("yyyy-MM");
        Calendar dd = Calendar.getInstance();//定义日期实例
        dd.setTime(begin_date);//设置日期起始时间
        while(!dd.getTime().after(end_date)){//判断是否到结束日期
            rangeSet.add(sdf.format(dd.getTime()));
            dd.add(Calendar.MONTH, 1);//进行当前日期月份加1
        }
        return rangeSet;
    }

    /**
     * 获取指定范围内的日期时间
     */
    public static List<String> getDateByTimeRange(Date startTime, Date stopTime) {
        List<String> dateList = new ArrayList<>();
        Date d = new Date();
        Date date = getMonthStart(d);
        Date monthEnd = getMonthEnd(d);
        while (!date.after(monthEnd)) {
            dateList.add(sdf.format(date));
            date = getNext(date);
        }
        return dateList;
    }

    public static List<String> getDateByWholePoint() {

        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm");
        String s = df.format(day);
        Date date = null;
        try {
            date = df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> dates = new ArrayList<String>();
        for (int i = 0; i < 24; i++) {
            String s1 = format1.format(date);
            dates.add(s1);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.HOUR, 1);
            date = cal.getTime();
        }
        return dates;
    }
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String args[]) {
        Date d = new Date();

        Date date = getMonthStart(d);
        Date monthEnd = getMonthEnd(d);
        while (!date.after(monthEnd)) {
            System.out.println(sdf.format(date));
            date = getNext(date);
        }

    }

    private static Date getMonthStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int index = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, (1 - index));
        return calendar.getTime();
    }

    private static Date getMonthEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        int index = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, (-index));
        return calendar.getTime();
    }

    private static Date getNext(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }


}