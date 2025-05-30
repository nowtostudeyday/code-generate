package com.zhang.generate.bean;

import freemarker.template.Configuration;
import lombok.Data;

/**
 * @Description 模板配置信息
 * @Author Mr.Zhang
 * @Date 2025/5/28 21:14
 * @Version 1.0
 */
@Data
public class TemplateConfigInfo {

    /**
     * 模板配置
     */
    private Configuration configuration;
}
