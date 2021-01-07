package com.itdr;

public final class HomeCar extends Car{

    Integer num;


    HomeCar(String color, String uname,Integer num) {
        super(color, uname);
        this.num=num;
    }

    public void display(String uname,String color,Integer num){
       //**拥有的**颜色的私家车有**座位
        System.out.println(uname+"拥有的"+color+"颜色的私家车有"+num+"座位");
    }

    public void display(Integer num){
        //家用汽车大多有**个座位
        System.out.println("家用汽车有"+num+"座位");
    }

    @Override
    public String toString() {
        return "HomeCar{" +
                "num=" + num +
                ", color='" + color + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }
}
