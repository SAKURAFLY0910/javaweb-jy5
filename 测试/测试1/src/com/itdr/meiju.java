package com.itdr;

public enum meiju {
FDAY("周一"),SDAY("周二"),WDAY("周三"),TDAY("周四");

private  String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    meiju(String s){
      this.s=s;
    }


}
