package com.hospital.common;

/**
 * User: xiaofu
 * Date: 2017/9/23
 * Time: 14:12
 * Function:专业技术职务代码
 */
public enum PositionTitle {


    CODE_231(231,"主任医师"),
    CODE_232(232,"副主任医师"),
    CODE_233(233,"主治医师"),
    CODE_234(234,"医师"),
    CODE_235(235,"医士"),
    CODE_241(241,"主任药师"),
    CODE_242(242,"副主任药师"),
    CODE_243(243,"主管药师"),
    CODE_244(244,"药师"),
    CODE_245(245,"药士"),
    CODE_251(251,"主任护师"),
    CODE_252(252,"副主任护师"),
    CODE_253(253,"主管护师"),
    CODE_254(254,"护师"),
    CODE_255(255,"护士"),
    CODE_261(261,"主任技师"),
    CODE_262(262,"副主任技师"),
    CODE_263(263,"主管技师"),
    CODE_264(264,"技师"),
    CODE_265(265,"技士"),
    CODE_266(266,"主任中医师"),
    CODE_267(267,"副主任中医师"),
    CODE_000(000,"暂无");


    public static Integer getCode(String codeName) {
        for (PositionTitle c : PositionTitle.values()) {
           if(c.codeName.equals(codeName)){
               return c.code;
           }
        }
        return null;
    }

    public static  void main(String args[]){
        Integer ss = PositionTitle.getCode("主管护师");
        System.out.println(ss);
    }


    PositionTitle(Integer code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    private Integer code;
    private String codeName;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}
