package com.zhang.generate.factory;

import com.zhang.generate.bean.ConfigInfo;
import com.zhang.generate.config.GlobalConfig;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Description
 * @Author Mr.Zhang
 * @Date 2025/5/27 23:03
 * @Version 1.0
 */
@Slf4j
public class PropertiesFactory {

    /**
     * 加载配置文件
     */
    public static void loadProperties() throws IOException {
        // 1.加载 yml 文件
        String filePath = System.getProperty("user.dir") + File.separator + "application.yml";

        InputStream inputStream;
        if (new File(filePath).exists()) {
            inputStream = Files.newInputStream(Paths.get(filePath));
        } else {
            inputStream = PropertiesFactory.class.getClassLoader().getResourceAsStream("application.yml");
        }

        // 2.解析 yml 文件
        Yaml yml = new Yaml();
        ConfigInfo configInfo = yml.loadAs(inputStream, ConfigInfo.class);
        // 解析项目目录地址
        String projectPath = System.getProperty("user.dir");
        configInfo.setProjectPath(projectPath);
        GlobalConfig.setConfigInfo(configInfo);
        log.info("YML load Successful, configInfo is [{}]", configInfo);
    }

    public static void main(String[] args) throws IOException {
        // 查看当前项目类路径
        System.out.println(PropertiesFactory.class.getResource("/"));

        loadProperties();
    }
}
