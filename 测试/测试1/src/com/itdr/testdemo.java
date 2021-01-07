package com.itdr;

public class testdemo {
    public static void main(String[] args) {
        Car s=new Car("red","大众1");
        s.use();
        HomeCar a=new HomeCar("blue","小众",6);
        taxi b=new taxi("black","大众","福特");
        boolean es = a.equals(b);
        System.out.println("car1和car2的应用比较："+es);

        b.ride(b.uname,b.company);
        b.use();
        a.display(a.uname,a.color,a.num);
        a.display(8);





    }
}
