package com.example.demo4.entity;

import java.math.BigDecimal;

public class Fruit {
    public BigDecimal getApple() {
        return apple;
    }

    public void setApple(BigDecimal apple) {
        this.apple = apple;
    }

    public BigDecimal getStrawberry() {
        return strawberry;
    }

    public void setStrawberry(BigDecimal strawberry) {
        this.strawberry = strawberry;
    }

    public BigDecimal getMango() {
        return mango;
    }

    public void setMango(BigDecimal mango) {
        this.mango = mango;
    }

    public Boolean getDiscount() {
        return discount;
    }

    public void setDiscount(Boolean discount) {
        this.discount = discount;
    }

    public Boolean getBigDiscount() {
        return bigDiscount;
    }

    public void setBigDiscount(Boolean bigDiscount) {
        this.bigDiscount = bigDiscount;
    }

    private BigDecimal apple;

    private BigDecimal strawberry;

    private BigDecimal mango;

    //草莓折扣
    private Boolean discount;
    //满100减10
    private Boolean bigDiscount;

    public Fruit(){
        this.apple = new BigDecimal(8);
        this.strawberry =  new BigDecimal(13);
        this.mango =  new BigDecimal(20);
        this.discount  = false;
        this.bigDiscount = false;
    }

    public Fruit(Integer apple ,Integer strawberry,Integer mango,Boolean isDiscount,Boolean isBigDiscount){
        this.apple = new BigDecimal(apple);
        this.strawberry =  new BigDecimal(strawberry);
        this.mango =  new BigDecimal(mango);
        this.discount  = isDiscount;
        this.bigDiscount = isBigDiscount;
    }

    public BigDecimal camulate(BigDecimal apple,BigDecimal strawberry,BigDecimal mango){
        BigDecimal count = new BigDecimal(0);
        if (apple.compareTo(new BigDecimal(0)) < 0){
            System.out.println("参数错误");
            return new BigDecimal(-1);
        }
        if (strawberry.compareTo(new BigDecimal(0)) < 0){
            System.out.println("参数错误");
            return new BigDecimal(-1);
        }
        if (mango.compareTo(new BigDecimal(0)) < 0){
            System.out.println("参数错误");
            return new BigDecimal(-1);
        }

        //计算折扣
        if(this.discount){
            count = count.add(strawberry.multiply(new BigDecimal("0.8")).multiply(this.strawberry));
        }else{
            count = count.add(strawberry.multiply(this.strawberry));
        }

        count = count.add(apple.multiply(this.apple));
        count = count.add(mango.multiply(this.mango));

        if(this.bigDiscount){
           count = count .subtract(  count.divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_FLOOR));

        }


        return count;
    }



    public static void main(String[] args) {

        Fruit fruit = new Fruit();
        System.out.println(fruit.camulate(new BigDecimal(1),new BigDecimal(1),new BigDecimal(-1)));

        System.out.println(fruit.camulate(new BigDecimal(1),new BigDecimal(1),new BigDecimal(1)));
        fruit.setDiscount(true);
        System.out.println(fruit.camulate(new BigDecimal(10),new BigDecimal(3),new BigDecimal(1)));
        fruit.setBigDiscount(true);
        System.out.println(fruit.camulate(new BigDecimal(20),new BigDecimal(3),new BigDecimal(1)));

    }

}
