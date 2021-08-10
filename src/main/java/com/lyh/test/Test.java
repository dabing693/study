package com.lyh.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.lyh.test.model.Table0;
import com.lyh.test.model.Table1;
import com.lyh.test.register.CustomCellWriteHandler;
import com.lyh.test.register.MyCellWriteHandler;
import com.lyh.test.register.MyMergeStrategy;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {
    private static final String write_path="D:\\test2.xlsx";
    public static void write() throws IOException {

        ExcelWriter excelWriter=null;
        try{
            excelWriter= EasyExcel.write(write_path).build();

            WriteSheet writeSheet=EasyExcel.writerSheet("test").build();

            List<CellRangeAddress> cellRangeAddresses=getCellRangeAddressList();
            MyMergeStrategy myMergeStrategy = new MyMergeStrategy(cellRangeAddresses);

            WriteTable writeTable=EasyExcel.writerTable(0)
                    .head(Table0.getHead())
                    .registerWriteHandler(myMergeStrategy)
                    //.registerWriteHandler(getWriteCellStyleOfTable0())
                    .registerWriteHandler(new MyCellWriteHandler())
                    .needHead(true)
                    .build();

            WriteTable writeTable1=EasyExcel.writerTable(1).head(Table1.class)
                    .registerWriteHandler(getWriteCellStyle())
                    .registerWriteHandler(new CustomCellWriteHandler()).needHead(true).build();

            excelWriter.write(Table0.getData(),writeSheet,writeTable);
            //excelWriter.write(getTable1(),writeSheet,writeTable1);
        }finally {
            if (excelWriter!=null){
                excelWriter.finish();
            }
        }
        /*
        StyleExcelHandler handler = new StyleExcelHandler();
        OutputStream outputStream = new FileOutputStream("D://2007.xlsx");
        // 这里要把上面创建的样式类通过构造函数传入
        ExcelWriter writer = new ExcelWriter(null, outputStream, ExcelTypeEnum.XLSX, true, (WriteHandler) handler);
        Sheet sheet1 = new Sheet(1, 1, Table0.class, "含供应商和地区", null);
        //设置列宽 设置每列的宽度
        Map columnWidth = new HashMap();
        columnWidth.put(0,10000);columnWidth.put(1,10000);columnWidth.put(2,10000);columnWidth.put(3,10000);
        sheet1.setColumnWidthMap(columnWidth);
        //或自适应宽度
        //sheet1.setAutoWidth(true);

        writer.write(Table0.getData(), sheet1);
        writer.finish();
        outputStream.close();

         */
    }
    private static  List<CellRangeAddress> getCellRangeAddressList(){
        List<CellRangeAddress> cellRangeAddress = new ArrayList<>();

        for(int i=0;i<7;i++){
            CellRangeAddress item = new CellRangeAddress(i+1, i+1, 0, 4);
            cellRangeAddress.add(item);
        }
        cellRangeAddress.add(new CellRangeAddress(9, 9, 0, 4));
        return cellRangeAddress;
    }
    private static HorizontalCellStyleStrategy getWriteCellStyleOfTable0(){
        System.out.println("getWriteCellStyleOfTable0...");
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        headWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());

//        BorderStyle borderStyle=BorderStyle.valueOf((short) 0);
//        headWriteCellStyle.setBorderTop(borderStyle);
//        headWriteCellStyle.setBorderBottom(borderStyle);
//        headWriteCellStyle.setBorderLeft(borderStyle);
//        headWriteCellStyle.setBorderRight(borderStyle);

        return new HorizontalCellStyleStrategy(headWriteCellStyle, (WriteCellStyle) null);
    }
    private static HorizontalCellStyleStrategy getWriteCellStyle(){
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        //headWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 11);
        headWriteCellStyle.setWriteFont(headWriteFont);
        //headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);

        return new HorizontalCellStyleStrategy(headWriteCellStyle, (WriteCellStyle) null);
    }
    static <T> void test(Collection<? extends T> from,Collection<T> to){
        for(T t:from){
            to.add(t);
        }
    }
    public static void main(String[] args) {
        try {
            write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}