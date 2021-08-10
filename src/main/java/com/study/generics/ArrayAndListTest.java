package com.study.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayAndListTest {
    public static void main(String[] args) {
        /*{
        //List<String>[] listArray=new ArrayList<String>[10];
        List<String>[] listArray=new ArrayList[10];
        List<Integer> t=new ArrayList<>();
        t.add(11);
        //listArray[0]=t;

        Object o[]=(Object[]) listArray;
        o[0]=t;

        //ClassCastException
        System.out.println(listArray[0].get(0));}

         */

        {
            List<?>[] listArray=new ArrayList<?>[10];
            List<Integer> t=new ArrayList<>();
            t.add(11);

            Object o[]=(Object[]) listArray;
            o[1]=t;

            //ClassCastException
            System.out.println(listArray[1].get(0));}
    }
    //创建元素类型是类型变量的数组对象也将导致编译错误
    /*
    <T> T[] makeArray(Collection<T> collection){
        return new T[3];
    }
     */
}
