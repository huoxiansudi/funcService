package com.hospital.common;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fuxf on 2017/7/31.
 */
public class ValidatorUtil {


    /**
     * 功能：手机号验证
     *
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {
        String rgx = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

        return isCorrect(rgx, str);
    }

    //正则验证
    public static boolean isCorrect(String rgx, String res) {
        Pattern p = Pattern.compile(rgx);

        Matcher m = p.matcher(res);

        return m.matches();
    }


    public synchronized static String isConnect(String urlStr) {
        int counts = 0;
        String retu = "fail";
        if (urlStr == null || urlStr.length() <= 0) {
            return retu;
        }
        HttpURLConnection con = null;
        while (counts < 2) {
            try {
                URL url = new URL(urlStr);
                con = (HttpURLConnection) url.openConnection();
                con.setUseCaches(false);
                con.setConnectTimeout(3000);
                con.setReadTimeout(3000);
                int state = con.getResponseCode();
                if (state == 200) {
                    con.disconnect();
                    retu = "ok";
                }
                return retu;
            } catch (Exception ex) {
                counts++;
                if (con != null) {
                    con.disconnect();
                }
                return retu;
            }
        }
        return retu;
    }
}
