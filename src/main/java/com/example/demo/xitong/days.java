package com.example.demo.xitong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author LinHaojia
 * @create 2022-07-26 21:53
 */
public class days {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入生产日期（yyyy-MM-dd）");
        Scanner sc=new Scanner(System.in);
        String d=sc.next();//键盘获取时间2022-01-10
        System.out.println("请输入保质期(天)");
        int day=sc.nextInt();//获取时间

        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");//转换格式
        Date date =sDateFormat.parse(d);//键盘获取的时间字符转换为时间
        Calendar c =Calendar.getInstance();
        c.setTime(date);//设置时间
        c.add(Calendar.DATE, day);//设置保质期时间
        String str = sDateFormat.format(c.getTime());//转换时间

        System.out.println("今天日期为："+sDateFormat.format(new Date()));//当前时间
        //当前日期毫秒数与想加天数后的毫秒数相比较，如果小于想加天数后的，则商品已经过期
        if(c.getTimeInMillis()<new Date().getTime()) {
            System.out.println("已经过期了");
        }else {
            //想加后天数毫秒值减去当前时间毫秒数
            long g=c.getTimeInMillis()-new Date().getTime();
            long t=g/(3600*24*1000);//格式天数
            System.out.println("商品还有"+t+"天过期");
        }
    }

}
