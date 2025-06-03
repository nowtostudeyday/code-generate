package com.zhang.generate.strategy;

import com.zhang.generate.bean.ClassInfo;

/**
 * @Description
 * @Author Mr.Zhang
 * @Date 2025/6/8 22:08
 * @Version 1.0
 */
public interface MVCBaseCenCode {
    /**
     * 生成控制层 GeneralEngine
     */
    void genController(ClassInfo classInfo);

    /**
     * 生成业务层
     */
    void genService(ClassInfo classInfo);

    /**
     * 生成业务层实现类
     */
    void genServiceImpl(ClassInfo classInfo);

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
}
