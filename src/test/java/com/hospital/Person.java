package com.hospital;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * User: xiaofu
 * Date: 2018-4-5
 * Time: 8:49
 * Function:
 */
public class Person {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {

        double f = 0.305;
        BigDecimal b = new BigDecimal(f);
        double f1 = b.setScale(2, RoundingMode.HALF_UP).doubleValue();
        System.out.println(f1);

        String[] ss = "12115312|2|028497053|4236130|1|028497053".split("\\|");
        for (String s:ss) {
            System.out.println(s);
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}