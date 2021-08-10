package com.lyh.test.register;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;

import java.util.List;

public class MyCellWriteHandler implements CellWriteHandler {

    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer integer, Integer integer1, Boolean aBoolean) {

    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer integer, Boolean aBoolean) {
        Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        if(cell.getRowIndex()==0){
            System.out.println("afterCellCreate: "+cell.getRowIndex());
            Font cellFont = workbook.createFont();
            cellFont.setFontHeight((short) 24);
            cellFont.setBold(true);
            cellStyle.setFont(cellFont);

            cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            cell.setCellStyle(cellStyle);
        }
        if (cell.getRowIndex() == 10) {
            System.out.println("afterCellCreate: "+cell.getRowIndex());
            Font cellFont = workbook.createFont();
            cellFont.setBold(true);
            cellStyle.setFont(cellFont);
            cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cell.setCellStyle(cellStyle);
        }
    }

    @Override
    public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, Cell cell, Head head, Integer integer, Boolean aBoolean) {

    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> list, Cell cell, Head head, Integer integer, Boolean aBoolean) {

    }
}