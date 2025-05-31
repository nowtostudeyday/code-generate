package com.zhang.generate.config;

import com.zhang.generate.bean.ConfigInfo;
import com.zhang.generate.exception.BizException;
import com.zhang.generate.factory.PropertiesFactory;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Locale;

/**
 * @Description 全局配置类
 * @Author Mr.Zhang
 * @Date 2025/5/27 22:59
 * @Version 1.0
 */
@Slf4j
public class GlobalConfig {

    private static volatile ConfigInfo INSTANCE = null;

    private static volatile Configuration CONFIGURATION = null;

    /**
     * 单例实现获取配置基本信息
     *
     * @return 全局配置
     */
    public static ConfigInfo getConfigInfo() {
        if (INSTANCE == null) {
            synchronized (GlobalConfig.class) {
                if (INSTANCE == null) {
                    try {
                        PropertiesFactory.loadProperties();
                    } catch (IOException e) {
                        throw new BizException(200, e.getMessage());
                    }
                }
            }
        }
        return INSTANCE;
    }

    public static void setConfigInfo(ConfigInfo configInfo) {
        GlobalConfig.INSTANCE = configInfo;
    }

    /**
     * 获取模板配置信息
     *
     * @return 配置信息
     */
    public static Configuration getConfiguration() {
        if (CONFIGURATION == null) {
            synchronized (GlobalConfig.class) {
                if (CONFIGURATION == null) {
                    CONFIGURATION = new Configuration(Configuration.VERSION_2_3_34);

                    CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(GlobalConfig.class, "/templates"));
                    CONFIGURATION.setDefaultEncoding("UTF-8");
                    CONFIGURATION.setNumberFormat("#");  // 设置数字格式化方式，# 代表直接输出数字原始值
                    CONFIGURATION.setClassicCompatible(true);
                    CONFIGURATION.setLocale(Locale.CHINA);
                    CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);  // 抛出异常，中断执行
                }
            }
        }
        return CONFIGURATION;
    }
}
