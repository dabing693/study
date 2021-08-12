package com.study.javaio;

import java.io.*;
import java.util.Scanner;

public class WriteToProcess {
    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("java ReadStandard");
        try (PrintStream ps = new PrintStream(p.getOutputStream())) {
            ps.println("普通字符串222");
            ps.println(new WriteToProcess());
        }
    }
}
class ReadStandard{
    public static void main(String[] args) throws FileNotFoundException {
        try(
                Scanner scanner=new Scanner(System.in);
                PrintStream ps=new PrintStream(new FileOutputStream("out2.txt"))
        ){
            scanner.useDelimiter("\n");
            while (scanner.hasNext()){
                ps.println("键盘输入的内容是:"+scanner.hasNext());
            }
        }
    }
}
