package com.hospital.common;

import org.assertj.core.util.Lists;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * User: xiaofu
 * Date: 2018-9-26
 * Time: 14:00
 * Function:
 */
public class DateTest {


    public List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) throws NoSuchMethodException {
        /*ZonedDateTime beijingOlympicOpenning = ZonedDateTime.of(2008, 8, 8, 20, 0, 0, 0, ZoneId.of("Asia/Shanghai"));
        String formattered = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(beijingOlympicOpenning);
        System.out.println(formattered);*/

       /* Optional< String > fullName = Optional.ofNullable( null );
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );*/

        Method method = DateTest.class.getMethod( "main", String[].class );
        for( final Parameter parameter: method.getParameters() ) {
            System.out.println( "Parameter: " + parameter.getName() );

        }


    }

    public void testLambda() {
        list.forEach(System.out::println);
        list.forEach(e -> System.out.println("方式二：" + e));
    }

}
