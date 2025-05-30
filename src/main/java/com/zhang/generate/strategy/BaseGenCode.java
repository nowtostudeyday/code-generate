package com.zhang.generate.strategy;

import com.zhang.generate.bean.ClassInfo;

/**
 * @Description 生成代码所需方法基类
 * @Author Mr.Zhang
 * @Date 2025/5/29 21:48
 * @Version 1.0
 */
public interface BaseGenCode {

    /**
     * 生成固有的文件
     */
    void genFix();

    /**
     * 生成控制层 GeneralEngine
     */
    void genController(ClassInfo classInfo);

    /**
     * 生成场景层
     */
    void genSceneService(ClassInfo classInfo);

    /**
     * 生成领域层
     */
    void genDomainService(ClassInfo classInfo);

    /**
     * 生成资源层
     */
    void genResourceService(ClassInfo classInfo);

    /**
     * 生成持久层
     */
    void genMapper(ClassInfo classInfo);

    /**
     * 生成持久层 xml
     */
    void genMapperXml(ClassInfo classInfo);

    /**
     * 生成实体
     */
    void genEntity(ClassInfo classInfo);

    /**
     * 生成配置文件(包括pom.xml,application.yml,application.properties)
     */
    void genConfig();
}
