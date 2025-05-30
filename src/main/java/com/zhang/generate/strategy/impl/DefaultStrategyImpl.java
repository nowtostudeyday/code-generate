package com.zhang.generate.strategy.impl;

import com.zhang.generate.bean.ClassInfo;
import com.zhang.generate.bean.ConfigInfo;
import com.zhang.generate.config.GlobalConfig;
import com.zhang.generate.constant.PathConstant;
import com.zhang.generate.enums.StrategyTypeEnum;
import com.zhang.generate.factory.ClassInfoFactory;
import com.zhang.generate.strategy.BaseGenCode;
import com.zhang.generate.strategy.GenerateStrategy;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 默认 DDD 领域驱动架构生成引擎实现类
 * @Author Mr.Zhang
 * @Date 2025/5/28 8:47
 * @Version 1.0
 */
@Slf4j
@Data
public class DefaultStrategyImpl implements GenerateStrategy, BaseGenCode {

    /**
     * 配置文件信息
     */
    private ConfigInfo configInfo;

    /**
     * 模板配置信息
     */
    private Configuration configuration;

    /**
     * 构造方法内部初始化配置信息
     */
    public DefaultStrategyImpl() {
        configInfo = GlobalConfig.getConfigInfo();
        configuration = GenerateStrategy.getConfiguration();
    }

    /**
     * 获取策略类型
     *
     * @return
     */
    @Override
    public Integer getType() {
        return StrategyTypeEnum.DDD.getType();
    }

    /**
     * 生成代码
     */
    @Override
    public void execute() {
        List<ClassInfo> classInfos = ClassInfoFactory.getClassInfoList();

        for (ClassInfo classInfo : classInfos) {
            // 生成代码
            genController(classInfo);
        }
    }

    @Override
    public void generateConfig() {

    }

    @Override
    public void genFix() {

    }

    @Override
    public void genController(ClassInfo classInfo) {
        this.genCode(classInfo, "generate-code/controller.ftl", "web", "Controller.java");
    }

    @Override
    public void genSceneService(ClassInfo classInfo) {

    }

    @Override
    public void genDomainService(ClassInfo classInfo) {

    }

    @Override
    public void genResourceService(ClassInfo classInfo) {

    }

    @Override
    public void genMapper(ClassInfo classInfo) {

    }

    @Override
    public void genMapperXml(ClassInfo classInfo) {

    }

    @Override
    public void genEntity(ClassInfo classInfo) {

    }

    @Override
    public void genConfig() {

    }

    /**
     * 生成代码 class 文件
     *
     * @param classInfo     类信息
     * @param templatePath  模板地址
     * @param parentPackage 父包名
     * @param classSuffix   文件后缀
     */
    private void genCode(ClassInfo classInfo, String templatePath, String parentPackage, String classSuffix) {
        // 1.转换格式
        String urlPath = configInfo.getPackageName().replace(".", File.separator);

        // 2.生成文件路径
        // D:\download\project\tools\code-generate  \src\main\java  \com\zhang  \base (\basic)\addressController\AddressController.java
        String filePath = configInfo.getProjectPath() + PathConstant.SRC_MAIN_JAVA + urlPath + File.separator
                + parentPackage.replace(".", File.separator) + File.separator
                + classInfo.getModelName() + File.separator + classInfo.getClassName() + classSuffix;
        log.info("controller filePath : [{}]", filePath);

        // 3.生成
        this.process(classInfo, templatePath, filePath);
    }

    /**
     * FreeMarker 模板固定写法
     *
     * @param classInfo
     * @param templatePath
     * @param filePath
     */
    private void process(ClassInfo classInfo, String templatePath, String filePath) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();

            Writer writer = new FileWriter(filePath);

            Template template = configuration.getTemplate(templatePath);

            Map<String, Object> params = new HashMap<>(16);
            params.put("classInfo", classInfo);
            params.put("authorName", configInfo.getAuthor());
            params.put("packageName", configInfo.getPackageName());
//            params.put("projectName", configInfo.get());
            params.put("genConfig", configInfo);
            template.process(params, writer);
            writer.flush();
            writer.close();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
