package com.lyh.test;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.lyh.test.model.DemoData;
import com.lyh.test.model.DemoData2;
import com.lyh.test.model.Table0;
import com.lyh.test.register.MyMergeStrategy;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.ArrayList;
import java.util.List;

public class Excel {
    public static void main(String[] args) {
        String filename = "D:\\test.xlsx";
        ExcelWriter excelWriter=null;
        try{
            excelWriter= EasyExcel.write(filename).build();
            WriteSheet writeSheet=EasyExcel.writerSheet("test").build();

            //定义合并单元格的坐标范围
            List<CellRangeAddress> cellRangeAddresss = getCellRangeAddresss();
            //定义合并单元格策略
            MyMergeStrategy myMergeStrategy = new MyMergeStrategy(cellRangeAddresss);

            WriteTable writeTable1=EasyExcel.writerTable(0).head(Table0.class).registerWriteHandler(myMergeStrategy).needHead(true).build();
            excelWriter.write(getTable1(),writeSheet,writeTable1);
        }finally {
            if (excelWriter!=null){
                excelWriter.finish();
            }
        }

        /*
        ExcelWriter excelWriter = null;
        try{
            excelWriter = EasyExcel.write().build();

            WriteSheet writeSheet = EasyExcel.writerSheet("test-table-name").build();
            WriteTable writeTable = EasyExcel.writerTable(0).head(DemoData.class).needHead(true).build();
            WriteTable writeTable2 = EasyExcel.writerTable(1).head(DemoData2.class).needHead(true).build();
            List<DemoData> stu=getData();
            System.out.println(stu.get(0).getSname());
            System.out.println(stu.get(1).getSname());
            //excelWriter.write(ImmutableList.of(stu), writeSheet, writeTable);
            //excelWriter.write(getData2(), writeSheet, writeTable2);
            System.out.println(excelWriter);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (excelWriter!=null){
                excelWriter.finish();
            }
        }*/

    }

    private static List<Table0> getTable1() {
        List<Table0> list = new ArrayList<>();
        list.add(new Table0("制表日期："));
        list.add(new Table0("增值税普通发票统计表"));
        list.add(new Table0("增值税发票汇总表年月本月累计"));
        list.add(new Table0("纳税人识别号："));
        list.add(new Table0("企业名称："));
        list.add(new Table0("地址电话："));
        list.add(new Table0(""));
        list.add(new Table0("* 发票领用存情况 *"));
        return list;
    }
    private static List<CellRangeAddress> getCellRangeAddresss() {
        List<CellRangeAddress> list = new ArrayList<>();
        int rows[]=new int[7];
        for(int i=0;i<rows.length;i++){
            rows[i]=i+1;
        }
        rows[6]=8;

        for(int ri:rows){
            CellRangeAddress item1 = new CellRangeAddress(ri, ri, 0, 4);
            list.add(item1);
        }
        return list;
    }
    //创建方法返回list集合
    private static List<DemoData> getData() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setSno(i);
            data.setSname("lucy"+i);
            list.add(data);
        }
        return list;
    }

    private static List<DemoData2> getData2() {
        List<DemoData2> list = new ArrayList<>();
        for (int i = 21; i < 30; i++) {
            DemoData2 data = new DemoData2();
            data.setSno(i);
            data.setSname("teacher"+i);
            list.add(data);
        }
        return list;
    }
}
