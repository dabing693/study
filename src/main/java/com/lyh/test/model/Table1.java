package com.lyh.test.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Table1 {
    /**
     * 期末库存份数
     */
    @ExcelProperty(value = "期末库存份数",index = 0)
    private String periodEndStockNum;
    /**
     * 收回发票份数
     */
    @ExcelProperty(value = "收回发票份数",index = 1)
    private String reclaimStockNum;
    /**
     * 退回发票份数
     */
    @ExcelProperty(value = "退回发票份数",index = 2)
    private String returnInvNum;
    /**
     * 正数发票份数
     */
    @ExcelProperty(value = "正数发票份数",index = 3)
    private String plusInvoiceNum;
    /**
     * 正数废票份数
     */
    @ExcelProperty(value = "正数废票份数",index = 4)
    private String plusInvWasteNum;
    public Table1(String str){
        this.periodEndStockNum=str;
        this.reclaimStockNum="";
        this.returnInvNum="";
        this.plusInvoiceNum="";
        this.plusInvWasteNum="";
    }
}
