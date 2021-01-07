package com.itdr;

public class taxi extends Car{



   String company;

    public taxi(String color, String uname, String company) {
        super(color, uname);
        this.color=color;
        this.uname=uname;
        this.company = company;
    }



    public final void ride(String uname,String commpany){
        //**出租车是所属于在***公司的。
        System.out.println(uname+"出租车是属于"+commpany+"公司的");
    }

    @Override
    public void use() {
        System.out.println("出租车是提高市民生活质量的重要条件之一");
    }

    @Override
    public String toString() {
        return "taxi{" +
                "company='" + company + '\'' +
                ", color='" + color + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }


}
