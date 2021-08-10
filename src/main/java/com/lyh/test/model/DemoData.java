package com.lyh.test.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

@AllArgsConstructor
@Data
@ToString
@Builder(toBuilder = true)
//@ApiModel(value = "Excel实体", description = "数据信息")
public class DemoData {
    //设置excel表头名称
    @ExcelProperty(value = "学生编号",index = 0)
    private Integer sno;
    @ExcelProperty(value = "学生姓名",index = 1)
    private String sname;

    public DemoData() {

    }
}