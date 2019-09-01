package com.hospital.common;

import org.springframework.util.StringUtils;

/**
 * User: xiaofu
 * Date: 2017/11/16
 * Time: 9:00
 * Function:
 */
public enum PayMode {

    PAY_MODE_1("1", "现金"),
    PAY_MODE_2("2", "支票"),
    PAY_MODE_3("3", "汇款"),
    PAY_MODE_4("4", "信用卡"),
    PAY_MODE_5("5", "会员卡"),
    PAY_MODE_6("6", "活动优惠"),
    PAY_MODE_10("10", "市名卡"),
    PAY_MODE_11("11", "市名卡(自费)"),
    PAY_MODE_26("26", "市名卡APP"),
    PAY_MODE_98("98", "微信"),
    PAY_MODE_99("99", "支付宝");

    public static String getCodeName(String code) {
        for (PayMode c : PayMode.values()) {
            if (c.getPayModeCode().equals(code)) {
                return c.PayModeName;
            }
        }
        return null;
    }

    public static String getCodeInt(String code) {
        if (StringUtils.hasText(code)) {
            if ("1".equals(code)) {
                return "99";
            } else if ("2".equals(code)) {
                return "98";
            } else {
                return "4";
            }
        }
        {
            return "1";
        }

    }

    public static String getCodeIntName(String code) {
        if (StringUtils.hasText(code)) {
            if ("99".equals(code)) {
                return "支付宝支付";
            } else if ("98".equals(code)) {
                return "微信支付";
            } else if("4".equals(code)){
                return "银联支付";
            }
        }

            return "线下支付";


    }

    PayMode(String payModeCode, String payModeName) {
        PayModeCode = payModeCode;
        PayModeName = payModeName;
    }

    private String PayModeCode;

    private String PayModeName;

    public String getPayModeCode() {
        return PayModeCode;
    }

    public void setPayModeCode(String payModeCode) {
        PayModeCode = payModeCode;
    }

    public String getPayModeName() {
        return PayModeName;
    }

    public void setPayModeName(String payModeName) {
        PayModeName = payModeName;
    }
}
