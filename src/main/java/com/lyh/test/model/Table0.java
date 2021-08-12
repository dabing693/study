package com.lyh.test.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
//@HeadRowHeight(24)
@AllArgsConstructor
public class Table0{
    @ExcelProperty(value = " ",index = 0)
    private String col0;

    @ExcelProperty(value = " ",index = 1)
    private String col1;

    @ExcelProperty(value = " ",index = 2)
    private String col2;

    @ExcelProperty(value = " ",index = 3)
    private String col3;

    @ExcelProperty(value = " ",index = 4)
    private String col4;

    public Table0(String col0){
        this.col0=col0;
        this.col1="";
        this.col2="";
        this.col2="";
        this.col4="";
    }
    public static List<List<String>> getHead(){
        List<List<String>> head=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<String> t=new ArrayList<>();
            t.add("普通电子发票汇总表");
            head.add(t);
        }
        return head;
    }
    public static List<Table0> getData(){
        List<Table0> data=new ArrayList<>();
        String[] col={
                "普通电子发票汇总表",
                "制表日期：",
                "所属期间：",
                "declareTaxInfo.getSubTitle()",
                "declareTaxInfo.getSubTitle2()",
                "纳税人登记号：",
                "企业名称：",
                "地址电话：",
                "",
                "★ 发票领用存情况 ★"
        };
        String ext[][]={{"分配发票份数","分配发票份数","分配发票份数","分配发票份数","分配发票份数"},
                {"99","0","9","8","0"},
                {"分配发票份数","分配发票份数","分配发票份数","分配发票份数","分配发票份数"},
                {"199","0","0","8","0"}};

        Arrays.stream(col).forEach(i->{
            data.add(new Table0(i));
        });
        Arrays.stream(ext).forEach(i->{
            data.add(new Table0(i[0],i[1],i[2],i[3],i[4]));
        });
        return data;
    }

    public static List<List<String>> getData2(){
        List<List<String>> data=new ArrayList<>();
        String[] col={
                "普通电子发票汇总表",
                "制表日期：",
                "所属期间：",
                "declareTaxInfo.getSubTitle()",
                "declareTaxInfo.getSubTitle2()",
                "纳税人登记号：",
                "企业名称：",
                "地址电话：",
                "",
                "★ 发票领用存情况 ★"
        };
        String ext[][]={{"分配发票份数","分配发票份数","分配发票份数","分配发票份数","分配发票份数"},
                {"99","0","9","8","0"},
                {"分配发票份数","分配发票份数","分配发票份数","分配发票份数","分配发票份数"},
                {"199","0","0","8","0"}};

        Arrays.stream(col).forEach(i->{
            List<String> t=new ArrayList<>();
            t.add(i);
//            for(int j=0;j<4;j++){
//                t.add(j+"00000");
//            }
            data.add(t);
        });
        Arrays.stream(ext).forEach(i->{
            List<String> t=new ArrayList<>();
            for(String s:i){
                t.add(s);
            }
            data.add(t);
        });
        return data;
    }
}