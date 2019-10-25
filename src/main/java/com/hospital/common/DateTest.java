package com.hospital.common;

//import org.assertj.core.util.Lists;

import com.hospital.out.hospital.GhkVo;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

        /*Method method = DateTest.class.getMethod( "main", String[].class );
        for( final Parameter parameter: method.getParameters() ) {
            System.out.println( "Parameter: " + parameter.getName() );

        }*/

        GregorianCalendar ca = new GregorianCalendar();
        String a = ca.get(GregorianCalendar.AM_PM)+1+"";
        System.out.println(a);
        System.out.println(DateUtil.getCurrentDate()+" 当天挂号新增一条预约信息成功");

        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");

        List<String> list2 = new ArrayList<String>();
        list2.add("2");
        list2.add("3");
        list2.add("7");
        list2.add("8");

        // 交集
        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(toList());
        System.out.println("---交集 intersection---");
        intersection.parallelStream().forEach(System.out :: println);

        // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
        System.out.println("---差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out :: println);

        // 差集 (list2 - list1)
        List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(toList());
        System.out.println("---差集 reduce2 (list2 - list1)---");
        reduce2.parallelStream().forEach(System.out :: println);

        // 并集
        List<String> listAll = list1.parallelStream().collect(toList());
        List<String> listAll2 = list2.parallelStream().collect(toList());
        listAll.addAll(listAll2);
        System.out.println("---并集 listAll---");
        listAll.parallelStream().forEachOrdered(System.out :: println);

        // 去重并集
        List<String> listAllDistinct = listAll.stream().distinct().collect(toList());
        System.out.println("---得到去重并集 listAllDistinct---");
        listAllDistinct.parallelStream().forEachOrdered(System.out :: println);

        System.out.println("---原来的List1---");
        list1.parallelStream().forEachOrdered(System.out :: println);
        System.out.println("---原来的List2---");
        list2.parallelStream().forEachOrdered(System.out :: println);

        List<GhkVo> list = new ArrayList<GhkVo>();
        GhkVo ghkVo = new GhkVo();
        ghkVo.setGhxh("1");
        list.add(ghkVo);
        ghkVo.setGhxh("2");
        list.add(ghkVo);
        ghkVo.setGhxh("3");
        list.add(ghkVo);
        if(list1.size()>0){
            for(GhkVo temp : list){
                for(String ghxh : list1){
                    if((ghxh+"").equals(temp.getGhxh())){
                        System.out.println("cg");
                    }
                }
            }
        }



    }

    public void testLambda() {
        list.forEach(System.out::println);
        list.forEach(e -> System.out.println("方式二：" + e));
    }



}
