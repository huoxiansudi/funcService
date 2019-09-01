package com.hospital.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * User: xiaofu
 * Date: 2018-1-23
 * Time: 9:08
 * Function:
 */
@XmlRootElement
public class XmlDome {
    private int id;
    private String name;
    private int age;
    private List<XmlList> items;

    public XmlDome(int id, String name, int age, List<XmlList> items) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.items = items;
    }


    public List<XmlList> getItems() {
        return items;
    }

    public void setItems(List<XmlList> items) {
        this.items = items;
    }

    public XmlDome() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
