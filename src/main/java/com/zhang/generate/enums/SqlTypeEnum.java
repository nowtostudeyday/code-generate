package com.zhang.generate.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 数据库字段类型映射枚举
 * @Author Mr.Zhang
 * @Date 2025/5/28 23:02
 * @Version 1.0
 */
public enum SqlTypeEnum {
    INT("int", "Integer"),
    CHAR("char", "String"),
    VARCHAR("varchar", "String"),
    DATETIME("datetime", "Date"),
    TIMESTAMP("timestamp", "Date"),
    BIT("bit", "Integer"),
    TINYINT("tinyint", "Integer"),
    SMALLINT("smallint", "Integer"),
    YEAR("year", "Date"),
    DATE("date", "Date"),
    BIGINT("bigint", "Long"),
    DECIMAL("decimal", "BigDecimal"),
    DOUBLE("double", "Double"),
    FLOAT("float", "Float"),
    NUMERIC("numeric", "Integer"),
    TEXT("text", "String"),
    MEDIUMTEXT("mediumtext", "String"),
    LONGTEXT("longtext", "String"),
    TIME("time", "Date");

    private final String dbType;
    private final String javaType;

    SqlTypeEnum(String dbType, String javaType) {
        this.dbType = dbType;
        this.javaType = javaType;
    }

    // 创建一个静态的Map，用于存储枚举值
    private static final Map<String, String> typeMap = new HashMap<>();

    static {
        for (SqlTypeEnum value : values()) {
            typeMap.put(value.dbType, value.javaType);
        }
    }

    public static Map<String, String> getTypeMap() {
        return typeMap;
    }
}
