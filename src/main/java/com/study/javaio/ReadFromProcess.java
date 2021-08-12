package com.study.javaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromProcess {
    public static void main(String[] args) throws IOException {
        Process process=Runtime.getRuntime().exec("javac");
        try(
                BufferedReader br=new BufferedReader(new InputStreamReader(process.getErrorStream()))
        ){
            String buffer=null;
            while ((buffer=br.readLine())!=null){
                System.out.println(buffer);
            }
        }
    }
}
