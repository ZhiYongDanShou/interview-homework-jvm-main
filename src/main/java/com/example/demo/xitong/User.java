package com.example.demo.xitong;

import java.util.Scanner;

/**
@author LinHaojia
@create 2022-07-25 23:36
*/public class User {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    shopping shopping = new shopping();
    goods goods = new goods();
    System.out.println("");
    System.out.println("\t欢迎光临面包店");
    System.out.println("*--------------------*----------------*");
    System.out.println("\t商店物品\t\t单价\t保质期/天");
    System.out.println("\t全麦面包\t\t"+ goods.price1+"\t\t"+ goods.day1);
    System.out.println("\t杂粮面包\t\t"+goods.price2+"\t\t"+goods.day2);
    System.out.println("\t火腿三明治\t\t"+goods.price3+"\t\t\t"+goods.day3);
    System.out.println("\t金枪鱼三明治\t"+goods.price4+"\t\t"+goods.day3);

    System.out.println(""); //打印购买之前的清单
    System.out.println("是否进行购买：1、是\t2、否");
    int select = sc.nextInt();
    int zong = 0;
    if (select == 1){
      shopping.show(1);
      System.out.println("请选择相应序号");
      int choose = sc.nextInt();
      while (choose >= 5){
        if (choose == 5){
          System.out.println("库存充足哟。。。");
          System.out.println("请再次选择相应序号");
        }else {
          System.out.println("没有此商品，请重新选择");
        }
        choose = sc.nextInt();
      }
      System.out.println("请输入购买数量");
      int num = sc.nextInt();
      while (true){
        shopping.shop(choose,num);
        System.out.println();
        shopping.show();
        System.out.println("如继续购物，请再次选择相应序号");
        choose = sc.nextInt();
        while (choose >= 6){
          if (choose == 6){
            shopping.shop(6);
            System.out.println("请再次选择相应序号");
          }else {
            System.out.println("没有此商品，请重新选择");
          }
          choose = sc.nextInt();
        }
        if(choose == 5){
          System.out.println("欢迎下次光临！");
          break;
        }
        System.out.println("请输入购买数量");
        num = sc.nextInt();
      }
    }else {
      System.out.println("欢迎下次光临！");
    }
  }

}
