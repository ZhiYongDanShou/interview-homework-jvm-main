package com.example.demo.xitong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author LinHaojia
 * @create 2022-07-25 23:37
 */
public class shopping {
  goods quanmai = new goods("全麦面包",12.00,50,2);
  goods grains = new goods("杂粮面包",10.00,30,3);
  goods ham = new goods("火腿三明治",8.5,10,1);
  goods Sandwich = new goods("金枪鱼三明治",12.00,12,1);

  public void show(){
    System.out.println("现还有以下商品供您选择：");
    System.out.println("1、"+quanmai.goodsname+ "\t价格：" + quanmai.price+ "\t保质期:"+quanmai.days + "天" + " \t剩余：" + quanmai.number );
    System.out.println("2、"+grains.goodsname+"\t价格："+grains.price+"\t保质期:"+grains.days + "天" + "\t剩余："+grains.number);
    System.out.println("3、"+ham.goodsname+"\t价格："+ham.price+"\t保质期:"+ham.days + "天" + "\t剩余："+ham.number);
    System.out.println("4、"+Sandwich.goodsname+"\t价格："+Sandwich.price+"\t保质期:"+Sandwich.days + "天" + "\t剩余："+Sandwich.number);
    System.out.println("5、退出购物");
    System.out.println("6、一键补货");
  }

  public void show(int i){
    System.out.println("现还有以下商品供您选择：");
    System.out.println("1、"+quanmai.goodsname+ "\t价格：" + quanmai.price+ "\t保质期:"+quanmai.days + "天" + " \t剩余：" + quanmai.number );
    System.out.println("2、"+grains.goodsname+"\t价格："+grains.price+"\t保质期:"+grains.days + "天" + "\t剩余："+grains.number);
    System.out.println("3、"+ham.goodsname+"\t价格："+ham.price+"\t保质期:"+ham.days + "天" + "\t剩余："+ham.number);
    System.out.println("4、"+Sandwich.goodsname+"\t价格："+Sandwich.price+"\t保质期:"+Sandwich.days + "天" + "\t剩余："+Sandwich.number);
    System.out.println("5、一键补货");
  }

  public void shop(int choose,int num){
    switch (choose){
      case 1:
        if(quanmai.number == 0){
          System.out.println("已售罄，等待补货！");
        }else if (num>quanmai.number){
          System.out.println("库存不足，请重新选择");
        }else {
          quanmai.number = quanmai.number - num;
          System.out.println("请输入生产日期（yyyy-MM-dd）");
          Scanner sc=new Scanner(System.in);
          String d=sc.next();//键盘获取时间2022-01-10
          System.out.println("请输入保质期(天)");
          int day=sc.nextInt();//获取时间

          SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");//转换格式
          Date date = null;//键盘获取的时间字符转换为时间
          try {
            date = sDateFormat.parse(d);
          } catch (ParseException e) {
            e.printStackTrace();
          }
          Calendar c =Calendar.getInstance();
          c.setTime(date);//设置时间
          c.add(Calendar.DATE, day);//设置保质期时间
          String str = sDateFormat.format(c.getTime());//转换时间

          System.out.println("今天日期为："+sDateFormat.format(new Date()));//当前时间
          //当前日期毫秒数与想加天数后的毫秒数相比较，如果小于想加天数后的，则商品已经过期
          if(c.getTimeInMillis()<new Date().getTime()) {
            System.out.println("已经过期了");
            guoqi();
          }else {
            //想加后天数毫秒值减去当前时间毫秒数
            long g=c.getTimeInMillis()-new Date().getTime();
            long t=g/(3600*24*1000);//格式天数
            System.out.println("商品还有"+t+"天过期");
            System.out.println("正在处理。。。");
            System.out.println("需要支付总金额为："+ (quanmai.price * num));
          }
        }
        break;
      case 2:
        if(grains.number == 0){
          System.out.println("已售罄，等待补货！");
        }else if (num>grains.number){
          System.out.println("库存不足，请重新选择");
        }else {
          grains.number = grains.number - num;
          System.out.println("请输入生产日期（yyyy-MM-dd）");
          Scanner sc=new Scanner(System.in);
          String d=sc.next();//键盘获取时间2022-01-10
          System.out.println("请输入保质期(天)");
          int day=sc.nextInt();//获取时间

          SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");//转换格式
          Date date = null;//键盘获取的时间字符转换为时间
          try {
            date = sDateFormat.parse(d);
          } catch (ParseException e) {
            e.printStackTrace();
          }
          Calendar c =Calendar.getInstance();
          c.setTime(date);//设置时间
          c.add(Calendar.DATE, day);//设置保质期时间
          String str = sDateFormat.format(c.getTime());//转换时间

          System.out.println("今天日期为："+sDateFormat.format(new Date()));//当前时间
          //当前日期毫秒数与想加天数后的毫秒数相比较，如果小于想加天数后的，则商品已经过期
          if(c.getTimeInMillis()<new Date().getTime()) {
            System.out.println("已经过期了");
            zaLiangGuoQi();
          }else {
            //想加后天数毫秒值减去当前时间毫秒数
            long g=c.getTimeInMillis()-new Date().getTime();
            long t=g/(3600*24*1000);//格式天数
            System.out.println("商品还有"+t+"天过期");
            System.out.println("正在处理。。。");
            System.out.println("需要支付总金额为："+ (grains.price * num));          }
        }
        break;
      case 3:
        if(ham.number == 0){
          System.out.println("已售罄，等待补货！");
        }else if (num>ham.number){
          System.out.println("库存不足，请重新选择");
        }else {
          ham.number = ham.number - num;
          System.out.println("请输入生产日期（yyyy-MM-dd）");
          Scanner sc=new Scanner(System.in);
          String d=sc.next();//键盘获取时间2022-01-10
          System.out.println("请输入保质期(天)");
          int day=sc.nextInt();//获取时间

          SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");//转换格式
          Date date = null;//键盘获取的时间字符转换为时间
          try {
            date = sDateFormat.parse(d);
          } catch (ParseException e) {
            e.printStackTrace();
          }
          Calendar c =Calendar.getInstance();
          c.setTime(date);//设置时间
          c.add(Calendar.DATE, day);//设置保质期时间
          String str = sDateFormat.format(c.getTime());//转换时间

          System.out.println("今天日期为："+sDateFormat.format(new Date()));//当前时间
          //当前日期毫秒数与想加天数后的毫秒数相比较，如果小于想加天数后的，则商品已经过期
          if(c.getTimeInMillis()<new Date().getTime()) {
            System.out.println("已经过期了,无法进行购买");
            rou();

          }else {
            //想加后天数毫秒值减去当前时间毫秒数
            long g=c.getTimeInMillis()-new Date().getTime();
            long t=g/(3600*24*1000);//格式天数
            System.out.println("商品还有"+t+"天过期");
            System.out.println("正在处理。。。");
            System.out.println("需要支付总金额为："+ (ham.price * num));          }
        }
        break;
      case 4:
        if(Sandwich.number == 0){
          System.out.println("已售罄，等待补货！");
        }else if (num>Sandwich.number){
          System.out.println("库存不足，请重新选择");
        }else {
          Sandwich.number = Sandwich.number - num;
          System.out.println("请输入生产日期（yyyy-MM-dd）");
          Scanner sc=new Scanner(System.in);
          String d=sc.next();//键盘获取时间2022-01-10
          System.out.println("请输入保质期(天)");
          int day=sc.nextInt();//获取时间

          SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");//转换格式
          Date date = null;//键盘获取的时间字符转换为时间
          try {
            date = sDateFormat.parse(d);
          } catch (ParseException e) {
            e.printStackTrace();
          }
          Calendar c =Calendar.getInstance();
          c.setTime(date);//设置时间
          c.add(Calendar.DATE, day);//设置保质期时间
          String str = sDateFormat.format(c.getTime());//转换时间

          System.out.println("今天日期为："+sDateFormat.format(new Date()));//当前时间
          //当前日期毫秒数与想加天数后的毫秒数相比较，如果小于想加天数后的，则商品已经过期
          if(c.getTimeInMillis()<new Date().getTime()) {
            System.out.println("已经过期了,无法进行购买");
            rou();
          }else {
            //想加后天数毫秒值减去当前时间毫秒数
            long g=c.getTimeInMillis()-new Date().getTime();
            long t=g/(3600*24*1000);//格式天数
            System.out.println("商品还有"+t+"天过期");
            System.out.println("正在处理。。。");
            System.out.println("需要支付总金额为："+ (Sandwich.price * num));          }
        }
        break;
      case 5:
        System.out.println("欢迎下次光临！");
        break;
      case 6:
        System.out.println("补货ing......");
        this.quanmai.number = 66;
        this.grains.number = 77;
        this.ham.number = 88;
        this.Sandwich.number = 99;
        break;
      default:
        System.out.println("没有此商品，请重新选择");
        break;
    }
  }

  public void shop(int choose){
    switch (choose){
      case 5:
        System.out.println("欢迎下次光临！");
        break;
      case 6:
        System.out.println("补货ing......");
        System.out.println("补货完毕");
        System.out.println();
        this.quanmai.number = 10;
        this.grains.number = 10;
        this.ham.number = 10;
        this.Sandwich.number = 100;
        break;
      default:
        System.out.println("没有此商品，请重新选择");
        break;
    }
  }

  public void success(){
    System.out.println("正在处理。。。");
    System.out.println("购买成功！");
  }

  public void guoqi(){
  double banjia = 0.5;
  double zong = (quanmai.number * quanmai.price);
    System.out.println("全麦面包过期当天折扣出售(半价)");
    System.out.println("半价折扣后价格:" + zong * banjia);
  }

  public void zaLiangGuoQi(){
    double banjia2 = 0;
    double zong2 = (grains.number * grains.price);
    System.out.println("杂粮面包过期当天的早上07:00-09:00免费领取");
    System.out.println("需要支付金额:" + zong2 * banjia2);
  }

  public void rou(){
    System.out.println("有肉的面包过期之后，需要立刻销毁");
  }
}
