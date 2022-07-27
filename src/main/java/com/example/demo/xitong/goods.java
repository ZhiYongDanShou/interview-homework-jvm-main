package com.example.demo.xitong;

/**
 * @author LinHaojia
 * @create 2022-07-25 23:37
 */
public class goods {

  String goodsname;   //商品名
  double price;          //价格
  double price1 = 12.00;
  double price2 = 10.00;
  double price3 = 8.5;
  double price4 = 12.00;
  int day1 = 2;
  int day2 = 3;
  int day3 = 1;



  int number;     //剩余数量
  int days;      //保质期


  public goods() {
  }

  public goods(String goodsname, double price, int number,int days) {
    this.goodsname = goodsname;
    this.price = price;
    this.number = number;
    this.days = days;
  }


}
