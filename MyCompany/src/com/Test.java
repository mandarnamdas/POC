package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {

    public static void main(String[] args) {

        System.out.println(((double) (10000l - 11l) / 1000));

        String str = "003.001.02.02.112.10.34.67.43.23";
        str = returnString("003.001.02.02.112.10.34.67.43.23", 3);
        System.out.println(str);

        List<Employee> list = new ArrayList<Employee>();
        Employee e = new Employee();
        e.setName("mandar");
        Employee e1 = new Employee();
        e1.setName("abhi");
        Employee e2 = new Employee();
        e2.setName("raj");
        Employee e3 = new Employee();
        e3.setName("manda");
        list.add(e);
        list.add(e1);
        list.add(e2);
        list.add(e3);

        Collections.sort(list);

        for (Employee employee : list) {
            System.out.println(employee.getName());
        }

        TreeMap<Integer, String> tree = new TreeMap<Integer, String>();
        tree.put(2, "Two");
        tree.put(7, "Seven");
        tree.put(1, "One");
        tree.put(4, "Four");

        System.out.println(tree.toString());

        Shape s = new Circle();
        s.draw();

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "One");
        map.put("2", "Two");

        Map<String, String> unmoMap = Collections.unmodifiableMap(map);

        map.put("3", "Three");
        System.out.println(unmoMap.get("3"));
    }

    public static String returnString(String str, int count) {
        if (str.replaceAll("[^.]", "").length() <= count) {
            return str;
        }
        str = str.substring(0, str.lastIndexOf("."));
        return returnString(str, count);
    }
}
