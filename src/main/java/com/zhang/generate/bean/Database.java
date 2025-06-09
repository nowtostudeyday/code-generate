package com.zhang.generate.bean;

import lombok.Data;

/**
 * @Description 数据库信息
 * @Author Mr.Zhang
 * @Date 2025/5/28 0:23
 * @Version 1.0
 */
@Data
public class Database {
    /**
     * 连接地址
     */
    private String url;

    /**
     * 数据库驱动
     */
    private String driver;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
