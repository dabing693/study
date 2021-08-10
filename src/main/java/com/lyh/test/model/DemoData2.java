package com.lyh.test.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData2 {
    //设置excel表头名称
    @ExcelProperty(value = "教师编号",index = 0)
    private Integer sno;
    @ExcelProperty(value = "教师姓名",index = 1)
    private String sname;
}
