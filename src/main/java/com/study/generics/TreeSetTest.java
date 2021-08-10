package com.study.generics;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> set=new TreeSet<>(
                new Comparator<Object>() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return o1.hashCode()>o2.hashCode()?1:o1.hashCode()<o2.hashCode()?-1:0;
                    }
                }
        );
        set.add("1");
        set.add("111");
        set.add("11");
        System.out.println(set);
    }
}
