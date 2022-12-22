package com.kun.util;

import sun.java2d.pipe.SpanIterator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author KUN
 * @date 2022/12/19
 **/
public class DateUtils {
    public static void main(String args[]) {

    }

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

    public static List<String> getCurrentWeekDate(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        String imptimeBegin = sdf.format(cal.getTime());
        // System.out.println("所在周星期一的日期：" + imptimeBegin);
        cal.add(Calendar.DATE, 6);
        String imptimeEnd = sdf.format(cal.getTime());
        // System.out.println("所在周星期日的日期：" + imptimeEnd);

        //获取本周时间
        String yz_time =imptimeBegin + "," + imptimeEnd;
        String array[] = yz_time.split(",");
        //本周第一天
        String start_time = array[0];
        //本周最后一天
        String end_time = array[1];
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dBegin = null;
        Date dEnd = null;
        try {
            dBegin = sdf.parse(start_time);
            dEnd = sdf.parse(end_time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //获取这周所有date
        List<Date> lDate = findDates(dBegin, dEnd);
        List<String> list = new ArrayList<>();
        for (Date date : lDate) {
            list.add(sdf.format(date));
        }
        return list;
    }
    public static List<Date> findDates(Date dBegin, Date dEnd)
    {
        List lDate = new ArrayList();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime()))
        {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
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