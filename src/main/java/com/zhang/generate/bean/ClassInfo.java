package com.zhang.generate.bean;

import lombok.Data;

import java.util.List;

/**
 * @Description 类信息
 * @Author Mr.Zhang
 * @Date 2025/5/27 22:56
 * @Version 1.0
 */
@Data
public class ClassInfo {

    /**
     * 表名
     */
    private String tableName;

    /**
     * class 类名
     */
    private String className;

    /**
     * class 对应的实体类名
     */
    private String modelName;

    /**
     * class 注释
     */
    private String classComment;

    /**
     * 主键字段及值 (默认以持有字段的 index=0 为主键)
     */
    private FieldInfo key;

    /**
     * 持有字段
     */
    private List<FieldInfo> fieldList;
}