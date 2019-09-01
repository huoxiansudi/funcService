package com.hospital.out.hospital;

/**科室信息
 * Created by fuxf on 2017/8/3.
 */
public class DepartmentVo {

    private String orgid;      //医院编号
    private String deptid;     //科室编号
    private String stanid;     //标准科室编号
    private String deptname;   //科室的名称
    private String description;//科室介绍
    private String age;        //最小年龄限制 0位不限
    private String maxage;     //最大年龄限制 0不限
    private String specialty;  //特色科室
    private String state;      //科室状态
    private String category;   //科室类别

    private String genre; //1 门诊 2 其他


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getStanid() {
        return stanid;
    }

    public void setStanid(String stanid) {
        this.stanid = stanid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMaxage() {
        return maxage;
    }

    public void setMaxage(String maxage) {
        this.maxage = maxage;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "DepartmentVo{" +
                "orgid='" + orgid + '\'' +
                ", deptid='" + deptid + '\'' +
                ", stanid='" + stanid + '\'' +
                ", deptname='" + deptname + '\'' +
                ", description='" + description + '\'' +
                ", age='" + age + '\'' +
                ", maxage='" + maxage + '\'' +
                ", specialty='" + specialty + '\'' +
                ", state='" + state + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
