package com.hospital;

import java.util.Arrays;

/**
 * User: xiaofu
 * Date: 2018-4-23
 * Time: 14:36
 * Function:
 */
public class sortNumber {

    public static void sort(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = arr.length - 1; j >0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tem;
                }
                sum++;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 9, 4, 6, 8};
        sort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
