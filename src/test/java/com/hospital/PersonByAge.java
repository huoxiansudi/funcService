package com.hospital;

import java.util.Comparator;

/**
 * User: xiaofu
 * Date: 2018-4-5
 * Time: 8:50
 * Function:
 */
public class PersonByAge implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() -o2.getAge();
    }
}
