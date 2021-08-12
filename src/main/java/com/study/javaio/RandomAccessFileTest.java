package com.study.javaio;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        try(
                RandomAccessFile raf=new RandomAccessFile("src/main/java/com/study/javaio/RandomAccessFileTest.java","r")
        )
        {
            System.out.println("文件的初始指针位置: "+raf.getFilePointer());
            raf.seek(300);
            byte buffer[]=new byte[1024];
            int hasRead=0;
            while ((hasRead=raf.read(buffer))>0){
                System.out.println(new String(buffer,0,hasRead));
            }
            System.out.println("文件的初始指针位置: "+raf.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }
        appendContent();
        insertContent("out.txt",16,"追加的内容\r\n");
        System.out.println("原来的内容\r\n".getBytes().length);
    }
    public static void appendContent() throws FileNotFoundException {
        try(RandomAccessFile raf=new RandomAccessFile("out.txt","rw")){
            raf.seek(raf.length());
            raf.write("原来的内容:hello world!\r\n".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void insertContent(String filename,long pos,String content) throws IOException {
        File tmp=File.createTempFile("tmp",null);
        tmp.deleteOnExit();
        try(RandomAccessFile raf=new RandomAccessFile(filename,"rw")){
            FileOutputStream tmpOut=new FileOutputStream(tmp);
            FileInputStream tmpIn=new FileInputStream(tmp);
            raf.seek(pos);
            byte[] buffer=new byte[1024];
            int hasRead=0;
            while ((hasRead=raf.read(buffer))>0){
                tmpOut.write(buffer,0,hasRead);
            }
            raf.seek(pos);
            raf.write(content.getBytes(StandardCharsets.UTF_8));
            while ((hasRead=tmpIn.read(buffer))>0){
                raf.write(buffer,0,hasRead);
            }
        }
    }
}
