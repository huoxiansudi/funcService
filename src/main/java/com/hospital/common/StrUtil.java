package com.hospital.common;

import java.util.regex.Pattern;

/**
 * User: xiaofu
 * Date: 2017/11/27
 * Time: 13:35
 * Function:
 */
public class StrUtil {

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    public static void main(String args[])  {

       /* List<String> abd = Arrays.asList("a", "b", "d");
        abd.forEach(e-> System.out.println(e));*/

        //Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
        try {
            String jmsj = EncipheredData.MD5("abcdefg1234567890  ");
            System.out.println(jmsj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
