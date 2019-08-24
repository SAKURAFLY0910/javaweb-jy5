package com.itdr.utils;

public class demo2 {
    public static int test5(int c1,int c2) {
        return (int)(c1+Math.random()*(c2-c1+1));
    }

    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            int s=test5(5,60);
            System.out.println(s);
        }
    }
    }

