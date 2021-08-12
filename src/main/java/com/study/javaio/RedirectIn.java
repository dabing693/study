package com.study.javaio;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {
    public static void main(String[] args) {
        try(FileInputStream fis=new FileInputStream("src/main/java/com/study/javaio/RedirectIn.java")){
            System.setIn(fis);
            Scanner scanner=new Scanner(System.in);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()){
                System.out.println("键盘输入的内容: "+scanner.next());
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
