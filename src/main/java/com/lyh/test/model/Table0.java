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
public class Table0 extends BaseRowModel {
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
        String ext[][]={{"col0","col1","col2","col3","col4"},
                {"99","0","9","8","0"},
                {"col5","col6","col7","col8","col9"},
                {"199","0","0","8","0"}};

        Arrays.stream(col).forEach(i->{
            data.add(new Table0(i));
        });
        Arrays.stream(ext).forEach(i->{
            data.add(new Table0(i[0],i[1],i[2],i[3],i[4]));
        });
        return data;
    }
}