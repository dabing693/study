package com.study.javaio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RedirectOut {
    public static void main(String[] args){
        try(PrintStream ps=new PrintStream(new FileOutputStream("out.txt"))){
            System.setOut(ps);
            System.out.println("普通字符串");
            System.out.println(new RedirectOut());
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
