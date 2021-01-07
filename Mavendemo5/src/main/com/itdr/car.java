package main.com.itdr;

import lombok.Data;

@Data
public class car {
    private Integer price;
    private  String color;

    public void show(){

        System.out.println("这是car的方法！");
    }

    public void init(){
        System.out.println("初始化方法执行！");
    }

    public void destory(){
        System.out.println("销毁方法执行！");
    }
}
