package com.study.javaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyInTest {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(reader);
        String buffer=null;
        while ((buffer=bufferedReader.readLine())!=null){
            if(buffer.equals("exit")){
                break;
            }
            System.out.println(buffer);
        }
        String s="lengyinhui";
        System.out.println(s.indexOf("yin"));
    }
}
