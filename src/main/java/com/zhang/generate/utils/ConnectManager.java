package com.zhang.generate.utils;

import com.zhang.generate.bean.Database;
import com.zhang.generate.config.GlobalConfig;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Description 数据库连接管理
 * @Author Mr.Zhang
 * @Date 2025/5/28 22:41
 * @Version 1.0
 */
@Slf4j
public class ConnectManager {

    private static volatile Connection CONNECTION = null;

    // 初始化数据库连接驱动
    static {
        try {
            Class.forName(GlobalConfig.getConfigInfo().getDatabase().getDriver());
            log.info("DataBase Driver init finish");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * <p>
     * 双重校验保证线程安全
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        if (CONNECTION == null) {
            synchronized (ConnectManager.class) {
                if (CONNECTION == null) {
                    // 获取数据库连接
                    Database database = GlobalConfig.getConfigInfo().getDatabase();
                    CONNECTION = DriverManager.getConnection(database.getUrl(), database.getUsername(), database.getPassword());
                    log.info("DataBase Connection is ready");
                }
            }
        }
        return CONNECTION;
    }
}
