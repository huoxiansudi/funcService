package com.hospital.common;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by fuxf on 2017/7/31.
 */
public class DateUtil {
   // private static String pattern = "yyyy-MM-dd HH:mm:ss";

    // 第一次调用get将返回null
    private static ThreadLocal threadLocal = new ThreadLocal();

    // 获取线程的变量副本，如果不覆盖initialValue，第一次get返回null，
    // 故需要初始化一个SimpleDateFormat，
    // 并set到threadLocal中
    public static DateFormat getDateFormat(String DATE_FORMAT) {
        DateFormat df = (DateFormat) threadLocal.get();
        if (df == null) {
            df = new SimpleDateFormat(DATE_FORMAT);
            threadLocal.set(df);
        }
        return df;
    }


    /**
     * 时间转换字符串
     *
     * @param date
     * @return
     */
    public static String formatDateString(Date date) {
        return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    }




    public static void main(String[] args) {
       // Date date = new Date();
        //String str1 = formatDateString(date);
        //String str2 = formatDateString1(date);
        Date str1 = formatStringDate("2018-09-26");
        System.out.println(str1);
        //System.out.println(str2);
    }

    /**
     * 时间转换字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        return DateFormatUtils.format(date, "yyyy-MM-dd");
    }

    /**
     * 字符串转换时间
     *
     * @param date
     * @return
     */
    public static Date formatStringDate(String date) {
        if (!StringUtils.hasText(date)) {
            return null;
        }
        try {
            Date str = DateUtils.parseDate(date, "yyyy-MM-dd");
            return str;
        } catch (ParseException e) {

        }
        return null;
    }

    /**
     * 采用 ThreadLocal 避免 SimpleDateFormat 非线程安全的问题
     * Key —— 时间格式
     * Value —— 解析特定时间格式的 SimpleDateFormat
     */
    private static ThreadLocal<Map<String, SimpleDateFormat>> sThreadLocal = new ThreadLocal<>();
    /**
     * 时间格式化
     *
     * @param date：要格式化的时间
     * @param pattern：要格式化的类型
     */
    public static String formatDateM(Date date, String pattern) {
        if (date == null || pattern == null) {
            return null;
        }
        return getDateFormat(pattern).format(date);
    }

    private static SimpleDateFormat getDateFormatM(String pattern) {
        Map<String, SimpleDateFormat> strDateFormatMap = sThreadLocal.get();
        if (strDateFormatMap == null) {
            strDateFormatMap = new HashMap<>();
        }
        SimpleDateFormat simpleDateFormat = strDateFormatMap.get(pattern);
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
            strDateFormatMap.put(pattern, simpleDateFormat);
            sThreadLocal.set(strDateFormatMap);
        }
        return simpleDateFormat;
    }

    /**
     * 时间格式化
     *
     * @param date：要格式化的时间
     * @param pattern：要格式化的类型
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null || pattern == null) {
            return null;
        }
        return getDateFormat(pattern).format(date);
    }

    /**
     * 字符串转换时间
     *
     * @return
     */
    public static String formatToDate(String str) {
        SimpleDateFormat sdf1 = getDateFormatM("yyyyMMdd");
                //new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf2 = getDateFormatM("yyyy-MM-dd");
        //new SimpleDateFormat("yyyy-MM-dd");
        String sfstr = "";
        try {
            sfstr = sdf2.format(sdf1.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sfstr;
    }


    public static String formatToDateStr(String str) {
        SimpleDateFormat temp = getDateFormatM("yyyyMMdd");
        SimpleDateFormat yyyymmdd = getDateFormatM("yyyy-MM-dd");
        String strFor = "";
        try {
            strFor = temp.format(yyyymmdd.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strFor;
    }

    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());
    }

    public static String formatCurrent(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }

    public static Boolean compareToday(String numDate) {
        DateFormat df = getDateFormatM("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(numDate);
            String dt2 = df.format(new Date());
            Date dt3 = df.parse(dt2);
            if (dt1.getTime() > dt3.getTime()) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Date setDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        String temp = df.format(date);
        temp = temp + " 23:59:59";
        try {
            return df2.parse(temp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String setyyyyMMddDate(String date) {
        if (StringUtils.hasText(date)) {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
            SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            try {
                Date date1 = df2.parse(date);
                return df.format(date1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // 1是星期日、2是星期一、3是星期二、4是星期三、5是星期四、6是星期五、7是星期六
    public static Integer getWeekOfDate() {
        Calendar c = Calendar.getInstance();
        int temp = c.get(Calendar.DAY_OF_WEEK);
        if (temp == 1) {
            return 7;
        }
        return temp - 1;

    }

    public static Integer getWeekOfDate(String datetime) {
        SimpleDateFormat f = getDateFormatM("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        Date datet = null;
        try {
            datet = f.parse(datetime);
            c.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int temp = c.get(Calendar.DAY_OF_WEEK);
        if (temp == 1) {
            return 7;
        }
        return temp - 1;

    }

    public static Integer getWeekOfDateFortmatt(String datetime) {
        SimpleDateFormat f = getDateFormatM("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date datet = null;
        try {
            datet = f.parse(datetime);
            c.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int temp = c.get(Calendar.DAY_OF_WEEK);
        if (temp == 1) {
            return 7;
        }
        return temp - 1;

    }

    public static int compareDate(String DATE1) {
        DateFormat df = getDateFormatM("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            String dt3 = dateToString(new Date());
            Date dt2 = df.parse(dt3);
            if (dt1.getTime() < dt2.getTime()) {
                return -1;//已过时
            } else {
                return 1;//未过时
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    // 获取当天时间的字符串
    public static String getDayStr() {
        SimpleDateFormat f =getDateFormatM("yyyyMMdd");
        return f.format(new Date());
    }

    public static boolean isNumeric(String str) {
        str = str.replace(" ", "");
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

}
