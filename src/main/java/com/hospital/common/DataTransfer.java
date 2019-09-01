package com.hospital.common;

import java.math.BigDecimal;

/**
 * Created by jinhs on 2017-11-21.
 */
public class DataTransfer {
    public static String getData(Double data){
        //DecimalFormat df   = new DecimalFormat("######0.000");
        return String.format("%.2f", data);
    }

    public static void main(String[] args) {
        Double var1 = 31.487;
        Double var2 = 14.046;
        BigDecimal b1 = new BigDecimal(Double.toString(var1));
        BigDecimal b2 = new BigDecimal(Double.toString(var2));
        System.out.println((b1.add(b2).doubleValue()));
        Double sum = Double.parseDouble(getData(var1)) + Double.parseDouble(getData(var2));
        System.out.println(sum);
    }
}
