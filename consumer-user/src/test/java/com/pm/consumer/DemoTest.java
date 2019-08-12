package com.pm.consumer;

import java.util.*;

/**
 * @author Yu
 */
public class DemoTest {

    public static void main(String[] args) {
        String str1 = "a,b>c>>d";
        String[] ary = str1.split(">");
        // 预期大于 3，结果是 3
        System.out.println(Arrays.toString(ary));
        System.out.println(ary.length);


        String[] str2 = new String[]{"you", "wu"};
        List list = Arrays.asList(str2);//后台的数据仍是数组。

//        list.add("a");//java.lang.UnsupportedOperationException
        System.out.println(list.toString());
        str2[0] = "aa";
        System.out.println(Arrays.toString(str2));
        System.out.println(list.toString());


        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        System.out.println("---------");
        System.out.println(list1.toString());
        for (String item : list1) {
            System.out.println(item);
            if ("2".equals(item)) {
                list1.remove(item);//ConcurrentModificationException
                System.out.println(list1.toString());
            }
        }


        Map<String,String> map = new HashMap<>(16);
        map.put("1","a");
        map.put("2","b");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
        }
    }
}
