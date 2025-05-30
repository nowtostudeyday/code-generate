package com.zhang.generate.factory;

import cn.hutool.core.collection.CollectionUtil;
import com.zhang.generate.bean.ClassInfo;
import com.zhang.generate.bean.ConfigInfo;
import com.zhang.generate.config.GlobalConfig;
import com.zhang.generate.exception.BizException;
import com.zhang.generate.utils.DataBaseUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author Mr.Zhang
 * @Date 2025/5/28 22:03
 * @Version 1.0
 */
@Slf4j
public class ClassInfoFactory {

    private static final List<ClassInfo> CLASS_INFO_LIST = new ArrayList<>();

    private static final String REGEX = "jdbc:mysql://[^/]+/([^?]+)";
    private static final String WILDCARD = "*";
    private static final String COMMA = ",";

    /**
     * 获取所有表信息
     *
     * @return
     */
    public static List<ClassInfo> getClassInfoList() {
        if (CollectionUtil.isEmpty(CLASS_INFO_LIST)) {
            synchronized (ClassInfoFactory.class) {
                if (CollectionUtil.isEmpty(CLASS_INFO_LIST)) {
                    // 获取配置项
                    ConfigInfo configInfo = GlobalConfig.getConfigInfo();
                    String dataBaseName = getDataBaseName(configInfo.getDatabase().getUrl());

                    try {
                        List<String> tableNames = DataBaseUtil.getAllTableNames(dataBaseName);
                        String tableName = configInfo.getTableNames();
                        if (!WILDCARD.equalsIgnoreCase(tableName)) {
                            // 加载指定表
                            String[] tableArray = tableName.split(COMMA);
                            for (String table : tableArray) {
                                if (!tableNames.contains(table)) {
                                    log.error("tableName [{}] does not find in the database", table);
                                    throw new BizException(200, "配置文件中配置的 [" + table + "] 在数据库中未找到");
                                }
                                ClassInfo classInfo = DataBaseUtil.parseClassInfo(table, dataBaseName);
                                CLASS_INFO_LIST.add(classInfo);
                            }
                        } else {
                            for (String table : tableNames) {
                                ClassInfo classInfo = DataBaseUtil.parseClassInfo(table, dataBaseName);
                                CLASS_INFO_LIST.add(classInfo);
                            }
                        }
                    } catch (SQLException e) {
                        throw new BizException(200, e.getMessage());
                    }
                }
            }
        }
        return CLASS_INFO_LIST;
    }

    /**
     * 获取数据库名称
     *
     * @param url
     * @return
     */
    private static String getDataBaseName(String url) {
        String dataBaseName;
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
           dataBaseName = matcher.group(1);
        } else {
            log.error("获取数据库名称失败");
            throw new BizException(200, "获取数据库名称失败");
        }
        return dataBaseName;
    }
}
