package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Java8 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 7);
        List<Integer> res1 = MyStream.myMap(list, o -> o * 3);
        System.out.println(res1);
        List<Integer> res2 = MyStream.myFilter(list, o -> o > 4);
        System.out.println(res2);

        String test = "walabcwalexywalxzsfwalmx";
        String replaceResult = test.replaceAll("(?i)wal", "sams");
        // will break when input string ends with wal
        System.out.println(replaceResult);
        String streamResult = Arrays
                .stream(test.split("(?i)wal"))
                .collect(Collectors.joining("sams"));
        System.out.println(streamResult);

        String test2 = "Eclipse eclipse Eclipse eclipse amc clip ECLIPSE";
        Map<String, Integer> counter = Arrays
                .stream(test2.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(o->o, Collectors.summingInt(o->1)));
        System.out.println(counter.get("eclipse"));
    }
}


@FunctionalInterface
interface MyFunctionalInterface {
    int apply(int num);
}

@FunctionalInterface
interface MyFunctionalInterface2 {
    boolean filter(int num);
}

class MyStream {
    public static List<Integer> myMap (List<Integer> list, MyFunctionalInterface fi) {
        List<Integer> res = new ArrayList<>();
        for (int i: list) {
            res.add(fi.apply(i));
        }
        return res;
    }

    public static List<Integer> myFilter (List<Integer> list, MyFunctionalInterface2 fi) {
        List<Integer> res = new ArrayList<>();
        for (int i : list) {
            if (fi.filter(i))
                res.add(i);
        }
        return res;
    }
}




