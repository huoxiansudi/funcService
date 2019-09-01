package com.hospital.common;

/**
 * User: xiaofu
 * Date: 2017/9/20
 * Time: 9:05
 * Function:状态码
 */
public enum AppointmentCodeState {
    /*----预约挂号错误代码----*/
    CODE_22010001(22010001, "号源已被预约，平台删除号源"),
    CODE_22010002(22010002, "用户信息不存在，平台删除用户与医院关联"),
    CODE_22010003(22010003, "医院已经停诊，平台将排班做标记为停诊"),
    CODE_22010004(22010004, "医院已经删除排班，平台将排班标记未删除");



    private Integer errorCode;

    private String errorState;

    public static Integer getCode(String codeError) {
        for (AppointmentCodeState c : AppointmentCodeState.values()) {
            if (c.name().equals(codeError)) {
                return c.errorCode;
            }
        }
        return null;
    }


    AppointmentCodeState(Integer errorCode, String errorState) {
        this.errorCode = errorCode;
        this.errorState = errorState;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorState() {
        return errorState;
    }

    public void setErrorState(String errorState) {
        this.errorState = errorState;
    }
}
