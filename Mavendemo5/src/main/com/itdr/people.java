package main.com.itdr;

import lombok.Data;

@Data
public class people {
    private String pname;
    private Integer sex;
    private  Integer ages;
    private  car Cars;
    public void show(){
        System.out.println("展示");
    }
}
