package com.study.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUtils {
    public static <T> T copy(Collection<? super T> dest,Collection<T> src){
        T last=null;
        for(T t:src){
            last=t;
            dest.add(t);
        }
        return last;
    }
    //泛型方法与方法重载 ...
    public static void main(String[] args) {
        List<Number> ln=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        li.add(5);
        int r=copy(ln,li);
        System.out.println(r);
    }
}
