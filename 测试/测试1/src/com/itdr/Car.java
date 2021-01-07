package com.itdr;

import java.util.Objects;

public class Car {

 public String color;
 public String uname;



     Car(String color, String uname) {
        this.color = color;
        this.uname = uname;
    }

    public void use(){
        System.out.println("我是机动车");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(color, car.color) &&
                Objects.equals(uname, car.uname);
    }


}
