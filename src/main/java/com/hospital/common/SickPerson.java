package com.hospital.common;

/**
 * User: xiaofu
 * Date: 2017/11/10
 * Time: 9:08
 * Function: 病人类别
 */
public enum SickPerson {

    mode_person_1("1", "自费"),
    mode_person_27("27", "本地医保"),
    mode_person_99("99", "全国医保");

    private String Code;
    private String CodeState;

    public static String getCode(String Code) {
        for (SickPerson c : SickPerson.values()) {
            if (c.Code.equals(Code)) {
                return c.CodeState;
            }
        }
        return null;
    }


    SickPerson(String code, String codeState) {
        Code = code;
        CodeState = codeState;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getCodeState() {
        return CodeState;
    }

    public void setCodeState(String codeState) {
        CodeState = codeState;
    }
}
