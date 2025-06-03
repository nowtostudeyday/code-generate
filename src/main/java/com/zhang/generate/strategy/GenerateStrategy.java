package com.zhang.generate.strategy;

import com.zhang.generate.config.GlobalConfig;
import freemarker.template.Configuration;

/**
 * @Description 生成代码策略接口
 * @Author Mr.Zhang
 * @Date 2025/5/28 8:43
 * @Version 1.0
 */
public interface GenerateStrategy {

    /**
     * 获取策略类型
     *
     * @return
     */
    Integer getType();

    /**
     * 获取配 FreeMarker 模板配置信息
     *
     * @return
     */
    static Configuration getConfiguration() {
        return GlobalConfig.getConfiguration();
    }

    /**
     * 执行器执行
     */
    void execute();
}
