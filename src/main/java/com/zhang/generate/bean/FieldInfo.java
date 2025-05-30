package com.zhang.generate.bean;

import lombok.Data;

/**
 * @Description 字段信息
 * @Author Mr.Zhang
 * @Date 2025/5/28 0:23
 * @Version 1.0
 */
@Data
public class FieldInfo {

    /**
     * 字段名
     */
    private String columnName;

    /**
     * Model 名
     */
    private String fieldName;

    /**
     * 所属类
     */
    private String fieldClass;

    /**
     * 字段注释
     */
    private String fieldComment;

    // ***************************** 以下内容作为表结构文件映射内容

    /**
     * 数据库中字段类型
     */
    private String dataType;

    /**
     * 字段长度
     */
    private String maxLength;

    /**
     * 是否允许为空
     */
    private Integer nullAble;
}
