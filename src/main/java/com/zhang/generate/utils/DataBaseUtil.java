package com.zhang.generate.utils;

import cn.hutool.core.collection.CollectionUtil;
import com.zhang.generate.bean.ClassInfo;
import com.zhang.generate.bean.FieldInfo;
import com.zhang.generate.enums.NullAbleEnum;
import com.zhang.generate.enums.SqlTypeEnum;
import org.apache.commons.lang3.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.zhang.generate.factory.ClassInfoFactory.WILDCARD;

/**
 * @Description 数据库解析工具类 -> 解析表和字段
 * @Author Mr.Zhang
 * @Date 2025/5/28 22:39
 * @Version 1.0
 */
public class DataBaseUtil {

    private static final Map<String, String> TYPE_MAP = SqlTypeEnum.getTypeMap();


    /**
     * 根据指定库获取单表相关参数
     *
     * @param tableName 表名
     * @param dataBaseName 数据库名
     */
    public static ClassInfo parseClassInfo(String tableName, String dataBaseName, String tablePrefix) throws SQLException {
        Statement statement = ConnectManager.getConnection().createStatement();

        // 获取表字段执行 SQL
        String tableInfoSql = getTableInfoSql(tableName, dataBaseName);
        ResultSet tableResult = statement.executeQuery(tableInfoSql);

        // 构建 ClassInfo 信息
        ClassInfo classInfo = new ClassInfo();
        tableName = WILDCARD.equals(tablePrefix) ? tableName : tableName.split(tablePrefix)[1];
        classInfo.setTableName(tableName);

        // className 信息
        String className = StringUtil.upperCaseFirst(StringUtil.underlineToCamelCase(tableName));
        classInfo.setClassName(className);
        classInfo.setModelName(StringUtil.lowerCaseFirst(className));
        classInfo.setClassComment(className);

        List<FieldInfo> fieldList = new ArrayList<>();

        while (tableResult.next()) {
            FieldInfo fieldInfo = new FieldInfo();
            fieldInfo.setColumnName(tableResult.getString(1));
            fieldInfo.setFieldClass(TYPE_MAP.get(tableResult.getString(2)));

            String fieldName = StringUtil.underlineToCamelCase(tableResult.getString(1));
            fieldInfo.setFieldName(fieldName);
            fieldInfo.setFieldComment(tableResult.getString(3));

            // 维护表结构字段
            fieldInfo.setDataType(tableResult.getString(2));
            // 如果是数值类型，则第四列 numeric_precision 有值；如果是字符串类型，则第六列 character_maximum_length 有值
            fieldInfo.setMaxLength(StringUtils.defaultIfBlank(tableResult.getString(4), tableResult.getString(6)));
            fieldInfo.setNullAble(NullAbleEnum.getType(tableResult.getString(7)));
            fieldList.add(fieldInfo);
        }

        classInfo.setFieldList(fieldList);

        // 设置主键字段
        if (CollectionUtil.isEmpty(fieldList)) {
            classInfo.setKey(new FieldInfo());
        } else {
            classInfo.setKey(fieldList.get(0));
        }

        tableResult.close();
        statement.close();
        return classInfo;
    }

    /***
     * 根据指定库获取所有表名
     */
    public static List<String> getAllTableNames(String dataBaseName) throws SQLException {
        Statement statement = ConnectManager.getConnection().createStatement();
        List<String> result = new ArrayList<>();

        // 获取表名执行 sql
        String sql = getTables(dataBaseName);
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            result.add(rs.getString(1));
        }
        return result;
    }

    /**
     * 数据指定数据库指定表的字段数据数据
     *
     * @param tableName tableName
     * @param dataBaseName dataBaseName
     */
    private static String getTableInfoSql(String tableName, String dataBaseName) {
        return String.format("SELECT column_name, data_type, column_comment, " +
                        "numeric_precision, numeric_scale, character_maximum_length, is_nullable " +
                        "FROM information_schema.columns " +
                        "WHERE table_name = '%s' AND table_schema = '%s'",
                tableName, dataBaseName);
    }

    /**
     * 获取所有Tables SQL
     */
    private static String getTables(String dataBaseName) {
        return String.format("SELECT table_name FROM information_schema.tables " +
                        "WHERE table_schema = '%s' AND (table_type = 'base table' OR table_type = 'BASE TABLE')",
                dataBaseName);
    }
}
