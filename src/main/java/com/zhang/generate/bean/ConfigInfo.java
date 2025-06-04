package com.zhang.generate.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description 配置信息
 * @Author Mr.Zhang
 * @Date 2025/5/27 22:56
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class ConfigInfo {

    /**
     * 数据库信息
     */
    private Database database;

    /**
     * 需要生成的表名，默认为 * 代表所有表，多个表名以 , 分割
     */
    private String tableNames;

    /**
     * 作者
     */
    private String author;

    /**
     * 项目根路径
     */
    private String projectPath;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 自定义目录前缀
     */
    private String prefix;

    /**
     * 是否只生成资源层
     */
    private Boolean onlyResource;

    /**
     * 表前缀
     */
    private String tablePrefix;
}
